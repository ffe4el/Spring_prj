package hello.core;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.Generated;

@Getter
@Setter
//롬복은 겟터 셋터를 만들어줌
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("dkssud");

        String name = helloLombok.getName();
        System.out.println("name = " + name);
    }
}
