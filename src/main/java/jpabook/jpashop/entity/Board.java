package jpabook.jpashop.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter
@Setter
@ToString
public class Board {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    private String title;

    private String content;

    private LocalDateTime postDate;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


    @OneToMany(mappedBy = "board")
    private List<Comment> comments = new ArrayList<>();


    // 연관관계 편의 메서드
    public void setMember(Member member){
        this.member = member;
        member.getBoards().add(this);
    }


    // 생성 메서드
    public static Board createBoard(Member member, String title, String content){
        Board board = new Board();
        System.out.println("member = " + member);
        board.setMember(member);
        board.setTitle(title);
        board.setContent(content);
        board.setPostDate(LocalDateTime.now());
        return board;
    }
}
