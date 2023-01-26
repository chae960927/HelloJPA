package com.example.HelloJPA.service;

import com.example.HelloJPA.Domain.Member;
import com.example.HelloJPA.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    @Autowired
    MemberRepository memberRepository;


    public List<Member> findAllUser() {
        return memberRepository.findAll();
    }
}
