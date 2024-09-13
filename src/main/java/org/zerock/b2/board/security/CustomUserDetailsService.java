package org.zerock.b2.board.security;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.zerock.b2.board.dto.MemberDTO;

import java.util.List;

@Component
@Log4j2
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("loadUserByUsername...................");

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMid(username);
        memberDTO.setMpw("$2a$12$zMtBjQl9HZR7V8oQfyWbdOoqJfiz9MkMgCPtHXUBNI7sn5uCApz0i");

        memberDTO.setRoles(List.of("USER"));

        return memberDTO;
    }
}
