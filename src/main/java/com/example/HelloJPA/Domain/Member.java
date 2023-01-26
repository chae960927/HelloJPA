package com.example.HelloJPA.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    /**
     * 1. 객체 생성
     * 2. 레퍼지토리에 메서드 구현
     * 3. create testcode
     * 4. 만들어놓은 객체(get/set) 불러와서 테스트 진행
     */



    //실제 데이터베이스에서 Primary Key를 의미
    @Id
    //시퀀스
    @GeneratedValue
    @Column(name = "memberId")
    private Long memberId;
    private String name;
    private String city;
    private String streets;
    private String zipcode;

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Orders> ordersList = new ArrayList<>();

    @Builder
    public Member(Long memberId, String name, String city, String streets, String zipcode) {
        this.memberId = memberId;
        this.name = name;
        this.city = city;
        this.streets = streets;
        this.zipcode = zipcode;
    }

    public Member() {
    }
}
