package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    // @reeturn 할인 대상 금액액
   int discount(Member member, int price);
}
