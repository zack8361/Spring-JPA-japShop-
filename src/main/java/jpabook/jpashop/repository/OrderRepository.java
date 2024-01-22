package jpabook.jpashop.repository;


import jakarta.persistence.EntityManager;
import jpabook.jpashop.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager em;

    public void save(Order order) {
        em.persist(order);
    }

    public Order findOne(Long orderId) {

        return em.find(Order.class,orderId);
    }
}
