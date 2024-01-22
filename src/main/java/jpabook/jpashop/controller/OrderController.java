package jpabook.jpashop.controller;


import jpabook.jpashop.service.OrderService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class OrderController {


    private final OrderService orderService;

    @PostMapping("/order")
    public String order() {
        Long orderId = orderService.order(1L, 1L, 2);
        System.out.println("orderId = " + orderId);
        return "hello";
    }

    @PostMapping("/orderCancel")
    public String orderCancel(){
        System.out.println("주문 취소 로직");
        orderService.cancelOrder(1L);
        return "hello";
    }
}
