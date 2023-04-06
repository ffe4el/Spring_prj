package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        //return 값에 넣은 이름의 템플릿을 찾아서 반환해줌 => hello.html을 연결시켜줌!!
        return "hello";
    }
}
