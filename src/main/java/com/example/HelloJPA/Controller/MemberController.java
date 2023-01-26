package com.example.HelloJPA.Controller;

import com.example.HelloJPA.Domain.Member;
import com.example.HelloJPA.Repository.MemberRepository;
import com.example.HelloJPA.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {


    private final MemberService memberService;


    @GetMapping("/users")
    public List<Member> findAllUser(){
        return memberService.findAllUser();
    }


}
