package jpabook2.jpashop2.repository;

import jpabook2.jpashop2.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter @Setter
public class OrderSearch {

    private String memberName; //회원이름
    private OrderStatus orderStatus; //주문 상태[ORDER, CANCEL]
}
