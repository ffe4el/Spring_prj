package hello.core.member;


//MemberServiceImpl은 MemberRepository에도 의존하고 MemoryMemberRepository에도 의존함
public class MemberServiceImpl implements MemberService{

    //이부분에서 DIP 위배, 실제 할당하는 부분이 구현체를 의존함
    private final MemberRepository memberRepository;


    public MemberServiceImpl(MemberRepository memberRepository) {//생성자를 통해서..
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}