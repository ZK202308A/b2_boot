package org.zerock.b2.board.mapper;

import org.apache.ibatis.annotations.Param;
import org.zerock.b2.board.dto.BoardListDTO;
import org.zerock.b2.board.dto.BoardReadDTO;
import org.zerock.b2.board.dto.BoardRegisterDTO;
import org.zerock.b2.board.dto.PageRequest;

import java.util.Optional;

public interface BoardMapper {

    int insert(BoardRegisterDTO registerDTO);

    int insertAttach(@Param("bno")Long bno,
                     @Param("fileName")String fileName,
                     @Param("ord")int ord);

    java.util.List<BoardListDTO> listImage(PageRequest pageRequest);

    int count(PageRequest pageRequest);

    Optional<BoardReadDTO> select(Long bno);

}
