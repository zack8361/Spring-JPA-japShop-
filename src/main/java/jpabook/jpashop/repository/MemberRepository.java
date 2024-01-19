package jpabook.jpashop.repository;


import jakarta.persistence.EntityManager;
import jpabook.jpashop.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(Long memberId) {
        return em.find(Member.class,memberId);
    }

}
