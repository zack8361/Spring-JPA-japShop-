package jpabook.jpashop.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    List<OrderItem> orderItems = new ArrayList<>();

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;


    //== 양뱡향 연관관계 편의 메서드 ==//
    public void setMember(Member member){
        this.member = member;
        member.getOrders().add(this);
    }
    public void setOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    //== 생성 메서드 ==//
    public static Order createOrder(Member member, OrderItem... orderItems){
        Order order = new Order();
        order.setMember(member);
        for (OrderItem orderItem : orderItems) {
            order.setOrderItem(orderItem);
        }
        order.setOrderDate(LocalDateTime.now());
        order.setOrderStatus(OrderStatus.COMP);
        return order;
    }

    public void cancel(){
        this.setOrderStatus(OrderStatus.CANCEL);
        for (OrderItem orderItem : orderItems) {
            orderItem.cancel();
        }
    }
}
