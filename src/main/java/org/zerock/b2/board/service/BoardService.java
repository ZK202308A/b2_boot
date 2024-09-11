package org.zerock.b2.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.b2.board.dto.BoardRegisterDTO;
import org.zerock.b2.board.mapper.BoardMapper;

import java.util.List;

@Service
@Log4j2
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;

    public void register(BoardRegisterDTO boardRegisterDTO) {

        boardMapper.insert(boardRegisterDTO);

        List<String> fileNames = boardRegisterDTO.getFileNames();

        for (int i = 0; i < fileNames.size() ; i++) {
            boardMapper.insertAttach(boardRegisterDTO.getBno(),
                    fileNames.get(i),
                    i);
        }//end for
    }
}
