package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    // 멤버 가져오기
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itmePrice){
        Member member = memberRepository.findById((memberId));
        int discountPrice = discountPolicy.discount(member, itmePrice);

        return new Order(memberId, itemName, itmePrice, discountPrice);
    }
}
