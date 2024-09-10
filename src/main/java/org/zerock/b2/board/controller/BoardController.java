package org.zerock.b2.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
@Log4j2
@RequiredArgsConstructor
public class BoardController {

    @GetMapping("ex1")
    public void ex1(Model model) {
        log.info("ex1");
        model.addAttribute("msg", "ex1 Msg");

        model.addAttribute("list", List.of("A1111","B2222","C3333","D44444") );

    }

}
