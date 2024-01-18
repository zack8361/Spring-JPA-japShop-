package jpabook.jpashop.repository;


import jakarta.persistence.EntityManager;
import jpabook.jpashop.entity.Board;
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
}
