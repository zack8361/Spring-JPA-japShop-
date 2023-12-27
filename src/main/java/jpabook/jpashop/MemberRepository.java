package jpabook.jpashop;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
    @PersistenceContext
    private EntityManager em;

//  INSERT
    public Long save(Member member){
        em.persist(member);
        return member.getId();
    }

//  SELECT
    public Member find(Long id){
        return em.find(Member.class,id);
    }
}
