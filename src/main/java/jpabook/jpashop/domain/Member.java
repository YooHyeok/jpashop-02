package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String name;
    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")// 연관관계 거울:읽기전용 (Order에 있는 member필드와 매핑) _ 양방향 연관관계 - 여러개의 주문은 각각 하나의 member를 갖는다.
    private List<Order> orders = new ArrayList<>(); //값을 넣는다고 해서 fk값이 변경되지 않는다.

}