package hello.core.autowired;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean{

        //noBean1번 자체가 실행되지 않음
        //의존관계가 없다면 이 메서드 자체가 실행이 안됨
        @Autowired(required = false)
        public void setNoBean1(Member noBean1){
            System.out.println("noBean1 = " + noBean1);
            System.out.println("noBean1 = " + noBean1);
        }

        //메서드가 실행은 됨
        @Autowired
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean2 = " + noBean2);
        }

        //메서드가 실행은 됨
        @Autowired
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("noBean3 = " + noBean3);
        }

    }

}
