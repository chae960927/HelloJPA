package com.example.HelloJPA.Repository;

import com.example.HelloJPA.Domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {

    //영속성
    @PersistenceContext
    EntityManager em;

    public Long save(Member member){
        em.persist(member);
        return member.getMemberId();
    }

    public Member findById(Long memberId){
        return em.find(Member.class, memberId);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }
}
