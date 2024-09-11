package org.zerock.b2.board.mapper;

import org.apache.ibatis.annotations.Param;
import org.zerock.b2.board.dto.BoardRegisterDTO;

public interface BoardMapper {

    int insert(BoardRegisterDTO registerDTO);

    int insertAttach(@Param("bno")Long bno,
                     @Param("fileName")String fileName,
                     @Param("ord")int ord);
}
