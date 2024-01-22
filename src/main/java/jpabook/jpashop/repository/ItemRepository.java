package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.entity.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public Item findOne(Long id){
        return em.find(Item.class, id);
    }
}
