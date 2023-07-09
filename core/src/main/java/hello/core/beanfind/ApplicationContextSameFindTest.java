package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

import java.lang.annotation.Documented;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextSameFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    //No qualifying bean of type 'hello.core.member.MemberRepository' available: expected single matching bean but found 2
    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류가 일어난다.")
    void findBeanByTypeDuplicate(){
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(MemberRepository.class));
        MemberRepository bean = ac.getBean(MemberRepository.class);
    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 빈 이름을 지정하면 된다.")
    void findBeanName(){
        MemberRepository memberRepository = ac.getBean("memberRepository1", MemberRepository.class);
        assertInstanceOf(MemberRepository.class, memberRepository);

    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findAllBeanByType(){
        Map<String, MemberRepository> beansOFType = ac.getBeansOfType(MemberRepository.class);
        for (String key : beansOFType.keySet()){
            System.out.println("key = " + key + "value = " + beansOFType.get(key));
        }
        System.out.println("beansOFType = " + beansOFType);
        assertEquals(2, beansOFType.size());
    }

    @Configuration
    static class SameBeanConfig{

        @Bean
        public MemberRepository memberRepository1(){
            return new MemoryMemberRepository();
        }
        @Bean
        public MemberRepository memberRepository2(){
            return new MemoryMemberRepository();
        }
    }

}
