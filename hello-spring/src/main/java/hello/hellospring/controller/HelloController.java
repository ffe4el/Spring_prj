package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {
//    정적 컨텐츠
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        //return 값에 넣은 이름의 템플릿을 찾아서 반환해줌 => hello.html을 연결시켜줌!!
        return "hello";
    }

//    MVC와 템플릿 엔진
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

//    API
    @GetMapping("hello-string")
    @ResponseBody //http의 주소 body부분에 내가 직접 return값을 넣어주겠다.
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

//    진짜 쓰는 API
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        //객체 만들기
        Hello hello = new Hello();
        hello.setName(name);
        //리턴값으로 객체 넘겨주기 => 웹에 제이슨 방식으로 나온다.
        return hello;
    }
    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }



}
