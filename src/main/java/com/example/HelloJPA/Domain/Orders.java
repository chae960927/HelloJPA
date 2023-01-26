package com.example.HelloJPA.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Orders {

    @Id
    @GeneratedValue
    @Column(name = "orderId")
    private Long orderId;


    //연관관계 설정
    //fetchType 설정필요 디폴트 => EAGER
    //EAGER 일 시에는 N+1 문제 발생
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;

    private LocalDateTime orderDate;

    public void setMember(Member member) {
        this.member = member;
        member.getOrdersList().add(this);
    }




}
