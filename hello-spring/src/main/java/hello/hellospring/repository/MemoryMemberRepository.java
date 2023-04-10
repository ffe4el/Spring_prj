package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

//implements를 이용해서 인터페이스를 불러들인다.
public class MemoryMemberRepository implements MemberRepository{
    //이 맵과 해쉬맵은 뭐지...?
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequece = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequece); //멤버 한명이 추가되면 아이디 값을 하나씩 올려준다.
        store.put(member.getId(), member); //store에다가 넣어준다.
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //찾는 아이디 값이 null 값이더라도 옵셔널로 감싸서 전달한다.
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        // 이건 자바의 람다식인데, stream()은 람다식을 활용할 수 있는 기술 중 하나로써 loop를 돌린다.
        //filter를 이용한다. 맵에 저장되어 있는 정보를 하나씩 흐름대로(stream) 도는데,
        // 찾는 name이 나타나면 걔를 반환하고, 끝까지 돌렸는데 없으면, 옵셔널에서 널값을 감싸서 반환한다.
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    //메모리 초기화 코드
    public void clearStore(){
        store.clear();
    }
}
