package org.zerock.b2.board.security;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("loadUserByUsername...................");

        UserDetails userDetails = User.builder()
                .username(username)
                .password("$2a$12$zMtBjQl9HZR7V8oQfyWbdOoqJfiz9MkMgCPtHXUBNI7sn5uCApz0i")
                .authorities("ROLE_USER")
                .build();

        return userDetails;
    }
}
