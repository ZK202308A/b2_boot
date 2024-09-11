package org.zerock.b2.board;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.b2.board.dto.BoardRegisterDTO;
import org.zerock.b2.board.mapper.BoardMapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

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
    @Disabled
    public void testInsert100() {

        IntStream.rangeClosed(1,100).forEach(j -> {

            BoardRegisterDTO dto = BoardRegisterDTO.builder()
                    .title("title")
                    .content("content")
                    .writer("writer")
                    .tag("aaa,bbb,ccc,ddd")
                    .fileNames(List.of(UUID.randomUUID()+".jpg",UUID.randomUUID()+".jpg"))
                    .build();

            mapper.insert(dto);

            Long bno = dto.getBno();

            log.info("BNO: " + bno);

            for(int i = 0; i < dto.getFileNames().size(); i++) {

                mapper.insertAttach(bno, dto.getFileNames().get(i), i);

            }//end for

        });//end stream

    }

}












