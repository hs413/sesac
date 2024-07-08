package spring.security.security.handler;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import spring.security.security.dto.MemberSecurityDTO;
import spring.security.util.JWTUtil;

import java.io.IOException;
import java.util.Map;

@Log4j2
@RequiredArgsConstructor
public class CustomSocialLoginSuccessHandler implements AuthenticationSuccessHandler {
    private final JWTUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("----------------------------------");
        log.info("CustomLoginSuccessHandler onAuthenticationSuccess");
        log.info(authentication.getPrincipal());

        MemberSecurityDTO memberSecurityDTO = (MemberSecurityDTO) authentication.getPrincipal();
        String encodedPw = memberSecurityDTO.getMpw();

        boolean requirePasswordChange = false;

        if (memberSecurityDTO.isSocial() && (encodedPw.equals("1111") ||
                passwordEncoder.matches("1111", encodedPw)
        )) {
            log.info("Should Change Password");

            requirePasswordChange = true;
        }

        Map<String, Object> claim = Map.of("mid", memberSecurityDTO.getMid());

        String accessToken = jwtUtil.generateToken(claim, 1);
        String refreshToken = jwtUtil.generateToken(claim, 30);

        Map<String, String> keyMap = Map.of(
                "accessToken", accessToken,
                "refreshToken", refreshToken,
                "requirePasswordChange", String.valueOf(requirePasswordChange));

        Gson gson = new Gson();

        String jsonStr = gson.toJson(keyMap);
        response.getWriter().println(jsonStr);
    }
}
