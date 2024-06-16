package org.zerock.b01.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.zerock.b01.domain.Member;
import org.zerock.b01.domain.MemberRole;
import org.zerock.b01.dto.MemberSecurityDTO;
import org.zerock.b01.repository.MemberRepository;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class CustomOAuthUserService extends DefaultOAuth2UserService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        log.info("userReuqest");
        log.info(userRequest);

        ClientRegistration clientRegistration = userRequest.getClientRegistration();
        String clientName = clientRegistration.getClientName();

        log.info("name: " + clientName);
        OAuth2User oAuth2User = super.loadUser(userRequest);
        Map<String, Object> paramMap = oAuth2User.getAttributes();

        String email = null;

        switch (clientName) {
            case "kakao" :
                email = getKakaoEmail(paramMap);
                break;
        }

        log.info("================================");
        log.info(email);
        log.info("================================");

        /*paramMap.forEach((k,v) -> {
            log.info("--------------------------------");
            log.info(k + ":" + v);
        });*/
        return oAuth2User;
    }

    private MemberSecurityDTO generateDTO(String email, Map<String, Object> params) {
        Optional<Member> result = memberRepository.findByEmail(email);

        if (result.isEmpty()) {
            Member member = Member.builder()
                    .mid(email)
                    .mpw(passwordEncoder.encode("1111"))
                    .email(email)
                    .social(true)
                    .build();

            member.addRole(MemberRole.USER);
            memberRepository.save(member);

            MemberSecurityDTO memberSecurityDTO =
                    new MemberSecurityDTO(email, "1111", email, false, true, Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));

            memberSecurityDTO.setProps(params);

            return memberSecurityDTO;
        } else {
            Member member = result.get();
            MemberSecurityDTO memberSecurityDTO
                    = new MemberSecurityDTO(
                            member.getMid(),
                            member.getMpw(),
                            member.getEmail(),
                            member.isDel(),
                            member.isSocial(),
                            member.getRoleSet()
                                    .stream().map(memberRole -> new SimpleGrantedAuthority("ROLE_" + memberRole.name()))
                                    .toList()

            );

            return memberSecurityDTO;
        }
    }

    private String getKakaoEmail(Map<String, Object> paramMap) {
        log.info("KAKAO---------------------");
        Object value = paramMap.get("kakao_account");

        log.info(value);

        LinkedHashMap accountMap = (LinkedHashMap) value;

        String email = (String)accountMap.get("email");

        log.info("email.." + email);

        return email;
    }

    /*@Override
    public void setAttributesConverter(Converter<OAuth2UserRequest, Converter<Map<String, Object>, Map<String, Object>>> attributesConverter) {
        super.setAttributesConverter(attributesConverter);
    }*/

//    private final MemberRepository memberRepository;

//    private PasswordEncoder passwordEncoder;

//    public CustomUserDetailsService() {
//        this.passwordEncoder = new BCryptPasswordEncoder();
//    }


}
