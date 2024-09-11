package org.zerock.b2.board;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.b2.board.mapper.BoardMapper;

@SpringBootTest
@ActiveProfiles("dev")
@Sql(scripts = {"classpath:sql/boardBefore.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Log4j2

public class BoardMapperTests {

    @Autowired(required = false)
    private BoardMapper mapper;

    @Test
    @Transactional
    @Commit
    public void test1() {

    }

}
