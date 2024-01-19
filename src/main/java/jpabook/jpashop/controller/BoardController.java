package jpabook.jpashop.controller;


import jpabook.jpashop.entity.Board;
import jpabook.jpashop.service.BoardService;
import jpabook.jpashop.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final MemberService memberService;
    private final BoardService boardService;
    @GetMapping("/register")
    public String getRegister(){
        return "hello";
    }

    @PostMapping("/registerMember")
    public String register(@RequestParam HashMap<String,Object> map){
        memberService.join(map);
        return "login";
    }

    @GetMapping("/getBoard")
    public String getBoard(){
        List<Board> boards = boardService.showAll();

        for (Board board : boards) {
            System.out.println(board);
        }

        return "hello";
    }

    @PostMapping("/postBoard")
    public String postBoard(){
        boardService.createBoard();
        return "hello";
    }

    @PostMapping("/postComment")
    public String postComment(){
        boardService.createComment();

        return "hello";
    }


    @GetMapping("/readComment")
    public String readComment(){
        boardService.readComment();

        return "hello";
    }
}
