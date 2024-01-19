package jpabook.jpashop.repository;


import jakarta.persistence.EntityManager;
import jpabook.jpashop.entity.Board;
import jpabook.jpashop.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final EntityManager em;


    public List<Board> showAll() {
        return em.createQuery("SELECT b from Board b", Board.class)
                .getResultList();
    }

    public void createBoard(Board board){
        em.persist(board);
    }

    public Board findOne(Long boardId){
        return em.find(Board.class, boardId);
    }

    public void createComment(Comment comment) {
        em.persist(comment);
    }
}
