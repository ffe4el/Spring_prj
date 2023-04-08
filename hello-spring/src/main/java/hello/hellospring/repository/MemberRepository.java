package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    //save를 하면 멤버가 저장소에 저장됨
    Member save(Member member);

    //findById, findByName 을 통해서 찾아올 수 있음
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);

    //지금까지 저장된 모든 회원리스트를 반환해줌
    List<Member> findAll();

}
