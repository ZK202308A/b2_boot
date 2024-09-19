package org.zerock.b2.member;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.client.RestTemplate;
import org.zerock.b2.board.dto.MemberDTO;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@Log4j2
public class MemberTests {

    @Autowired
    private PasswordEncoder encoder;

    @Test
    public void test1() {
        log.info("-------------------------");

        RestTemplate restTemplate = new RestTemplate();

        String email = "aaa@bbb.com";

        String url = "http://localhost:8081/api/member/read?email=" + email;

        ResponseEntity<HashMap> response =
                restTemplate.getForEntity(url, HashMap.class);

        HashMap<String, String>  result =
                (HashMap<String, String>) response.getBody();

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMid(result.get("email"));
        memberDTO.setMpw(encoder.encode(result.get("pw")));
        memberDTO.setMname(result.get("name"));
        memberDTO.setRoles(java.util.List.of("USER"));

        log.info(memberDTO);

    }

}













