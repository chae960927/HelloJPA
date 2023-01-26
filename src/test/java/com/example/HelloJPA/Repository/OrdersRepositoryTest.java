package com.example.HelloJPA.Repository;

import com.example.HelloJPA.Domain.Member;
import com.example.HelloJPA.Domain.Orders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrdersRepositoryTest {

    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    MemberRepository memberRepository;


    @Test
    @Transactional
    @Rollback(false)
    public void save() {

        Member member = new Member();

        member.setName("우동균");
        memberRepository.save(member);

        Orders orders = new Orders();
        orders.setOrderDate(LocalDateTime.now());
        orders.setMember(member);
        ordersRepository.save(orders);
    }

    @Test
    public void findById() {

    }
}