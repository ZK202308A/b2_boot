package org.zerock.b2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.b2.time.mapper.TimeMapper;

@SpringBootTest
class B2ApplicationTests {

    @Autowired(required = false)
    TimeMapper timeMapper;

    @Test
    void contextLoads() {
        System.out.printf("timeMapper=%s\n", timeMapper);
        System.out.println(timeMapper.getTime());
    }

}
