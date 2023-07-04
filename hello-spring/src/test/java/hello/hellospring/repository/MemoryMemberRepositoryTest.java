package hello.hellospring.repository;
import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach //각 함수가 끝날때마다 실행
    //각 테스트가 끝날때마다 메모리 초기화!
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        // assertThat은 첫번째괄호랑 두번째 괄호의 값을 비교해주는 메소드이다.
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByname(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        //repository.findAll(); 다쓰고 뒤에 cmd+shift+v 누르면 자동완성
        List<Member> result = repository.findAll();
//      List<Member> result = repository.findAll()
        assertThat(result.size()).isEqualTo(2);
    }


}
