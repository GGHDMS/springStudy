package jpabook2.jpashop2.repository;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter @Setter
public class OrderSearch {

    private String memberName; //회원이름
    private String orderStatus; //주문 상태[ORDER, CANCEL]
}
