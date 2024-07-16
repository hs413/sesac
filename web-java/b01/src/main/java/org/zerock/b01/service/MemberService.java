package org.zerock.b01.service;

import org.zerock.b01.dto.MemberJoinDTO;

public interface MemberService {

    static class MidExistException extends Exception {}

    public void join(MemberJoinDTO memberJoinDTO) throws MidExistException;

}
