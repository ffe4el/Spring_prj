package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    //jpa는 EntityManager를 통해 모든 동작을 수행함
    private  final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        //persist는 영구저장하다 라는 뜻
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // id를 토대로 Member class에서 찾아서 member에 저장
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member); //값이 있으면 반환, 없으면 null 반환
    }


    //id와 같이 pk 기반이 아닌것들은 jpql을 작성해줘야함(createQuery)
    @Override
    public Optional<Member> findByName(String name) {
        //쿼리를 만들어서 name과 일치하는 객체를 찾아서 조회
        List<Member> result = em.createQuery("select m from Member as m Where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        //member entity를 조회해서 객체 자체를 select함
        return em.createQuery("select m from Member as m", Member.class).getResultList();
    }
}
