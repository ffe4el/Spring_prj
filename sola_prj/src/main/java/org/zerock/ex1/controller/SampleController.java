//package org.zerock.ex1;
package org.zerock.ex1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//samplecontroller는 @restcontroller를 이용해서 별도의 화면없이 데이터를 전송하고자 한다.
@RestController
public class SampleController {
    @GetMapping("/hello")
    public String[] hello(){ //hello()는 @getMapping을 이용해서 브라우저의 주소창에서 호출이 가능하도록 설정
        return new String[]{"Hello", "World"};
    }
}

//SolaApplication 클래스의 main()을 실행하고 브라우저로 호출합니다.
