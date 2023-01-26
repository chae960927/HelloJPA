package com.example.HelloJPA.Repository;

import com.example.HelloJPA.Domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void save() {
        //객체 초기화
        Member member = new Member();
        Member member2 = new Member();

        //데이터 생성
        member.setName("우똥균");
        //레포지토리에 담기
        Long result = memberRepository.save(member);
        //레포지토리에 담았던(result) 조회
        Member findedById = memberRepository.findById(result);

        member2.setName("test");
        memberRepository.save(member2);

        //조회해온(fundedById)
        // 값 비교
        assertThat(findedById.getMemberId()).isEqualTo(member.getMemberId());
        assertThat(findedById.getName()).isEqualTo(member.getName());


    }

    @Test
    public void findById() {

    }
}