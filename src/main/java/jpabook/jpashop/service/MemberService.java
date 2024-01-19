package jpabook.jpashop.service;


import jpabook.jpashop.entity.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void join(HashMap<String,Object> map){
        Member member = new Member();
        member.setName((String) map.get("name"));
        member.setPassword((String) map.get("password"));
        memberRepository.save(member);
    }

    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }
}
