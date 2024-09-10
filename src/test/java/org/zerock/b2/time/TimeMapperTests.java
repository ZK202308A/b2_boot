package org.zerock.b2.time;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@ActiveProfiles("dev")
@Sql(scripts = {"classpath:sql/timeBefore.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = {"classpath:sql/timeAfter.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)

@Log4j2
public class TimeMapperTests {

    @Test
    public void test1() {

        log.info("test1.....................");
        log.info("test1.....................");
        log.info("test1.....................");

    }

}
