package org.zerock.b2.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.b2.board.dto.BoardRegisterDTO;
import org.zerock.b2.board.dto.PageRequest;
import org.zerock.b2.board.dto.SampledDTO;
import org.zerock.b2.board.service.BoardService;
import org.zerock.b2.board.util.UploadUtil;

import java.util.List;

@Controller
@RequestMapping("/board")
@Log4j2
@RequiredArgsConstructor
public class BoardController {

    private final UploadUtil uploadUtil;

    private final BoardService boardService;

    @PostMapping("register")
    public String register(
            BoardRegisterDTO boardRegisterDTO,
            RedirectAttributes rttr) {

        log.info("Registering board: " + boardRegisterDTO);

        List<String> uploadedFileNames = uploadUtil.upload(boardRegisterDTO.getImages());

        boardRegisterDTO.setFileNames(uploadedFileNames);

        //서비스 등록
        boardService.register(boardRegisterDTO);

        rttr.addFlashAttribute("bno", boardRegisterDTO.getBno());

        return "redirect:/board/list";
    }

    @GetMapping("register")
    public void register(){

    }

    @GetMapping("list")
    public void list(PageRequest pageRequest, Model model) {

        model.addAttribute("result", boardService.list(pageRequest));

    }

    @GetMapping("read/{bno}")
    public String read (@PathVariable("bno") Long bno, Model model) {

        return "/board/read";
    }


    @GetMapping("ex1")
    public void ex1(Model model) {
        log.info("ex1");
        model.addAttribute("msg", "ex1 Msg");
        model.addAttribute("list", List.of("A1111","B2222","C3333","D44444") );
    }

    @GetMapping("ex2")
    public void ex2(Model model) {

        log.info("ex2");

        List<SampledDTO> list = List.of(
            SampledDTO.builder().name("1AAA").age(15).addr("1BBB").build(),
            SampledDTO.builder().name("2AAA").age(16).addr("2BBB").build(),
            SampledDTO.builder().name("3AAA").age(17).addr("3BBB").build(),
            SampledDTO.builder().name("4AAA").age(18).addr("4BBB").build()
        );

        model.addAttribute("list", list);


    }


}
