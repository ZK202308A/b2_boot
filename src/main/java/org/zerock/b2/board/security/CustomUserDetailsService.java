package org.zerock.b2.board.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.zerock.b2.board.dto.MemberDTO;

import java.util.HashMap;
import java.util.List;

@Component
@Log4j2
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("loadUserByUsername...................");

        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8081/api/member/read?email=" + username;

        ResponseEntity<HashMap> response =
                restTemplate.getForEntity(url, HashMap.class);

        HashMap<String, String>  result =
                (HashMap<String, String>) response.getBody();

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMid(result.get("email"));
        memberDTO.setMpw(encoder.encode(result.get("pw")));
        memberDTO.setMname(result.get("name"));
        memberDTO.setRoles(java.util.List.of("USER"));

        return memberDTO;
    }
}
