package jpabook.jpashop.service;


import jpabook.jpashop.entity.Board;
import jpabook.jpashop.entity.Comment;
import jpabook.jpashop.entity.Member;
import jpabook.jpashop.repository.BoardRepository;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public List<Board> showAll(){
        return boardRepository.showAll();
    }


    @Transactional
    public void createBoard() {
        Member findMember = memberRepository.findOne(1L);
        System.out.println(findMember);
        Board board = Board.createBoard(findMember, "조제", "이 내용은 장애인과 일반인이 사랑에 빠지는 내용입니다");
        boardRepository.createBoard(board);
    }

    @Transactional
    public void createComment() {
        Member createCommentMember = memberRepository.findOne(1L);
        Board createCommentBoard = boardRepository.findOne(1L);
        String content = "이것은 첫번째 댓글입니다.";
        Comment comment = Comment.createComment(createCommentBoard, createCommentMember, content);
        boardRepository.createComment(comment);
    }

    public List<Comment> readComment(){
        Board board = boardRepository.findOne(1L);
        return board.getComments();
    }
}
