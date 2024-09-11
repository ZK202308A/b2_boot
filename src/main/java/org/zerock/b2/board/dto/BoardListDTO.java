package org.zerock.b2.board.dto;

import lombok.Data;

import java.time.LocalDateTime;

//
//board.bno, title, writer, regDate, modDate,
//replyCnt, fileName
@Data
public class BoardListDTO {

    private Long bno;
    private String title;
    private String writer;
    private LocalDateTime regDate;
    private LocalDateTime modDate;

    private int replyCnt;
    private String fileName;
    private int viewCnt;

}
