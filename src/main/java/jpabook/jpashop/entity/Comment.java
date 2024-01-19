package jpabook.jpashop.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter
@Setter
public class Comment {

    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    private String content;

    private LocalDateTime postDate;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


    //== 연관관계 편의 메서드 ==//
    public void setMember(Member member){
        this.member = member;
        member.getComments().add(this);
    }


    //== 연관관계 편의 메서드 ==//
    public void setBoard(Board board){
        this.board = board;
        board.getComments().add(this);
    }


    //== 생성 메서드 ==//
    public static Comment createComment(Board board, Member member, String content){
        Comment comment = new Comment();
        comment.setBoard(board);
        comment.setMember(member);
        comment.setContent(content);
        comment.setPostDate(LocalDateTime.now());
        return comment;
    }
}
