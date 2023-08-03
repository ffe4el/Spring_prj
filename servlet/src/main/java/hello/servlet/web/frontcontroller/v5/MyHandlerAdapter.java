package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

public interface MyHandlerAdapter {

    //handler = 컨트롤러
    //어댑터가 해당 컨트롤러를 처리할 수 있는지 판단하는 메서드다.
    boolean supports(Object handler);


    //어댑터는 실제 컨트롤러를 호출하고, 그 결과로 ModelView를 반환
    //이전에는 프론트 컨트롤러가 실제 컨트롤러를 호출했지만 이제는 이 어댑터를 통해서 실제 컨트롤러가 호출된다.
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
}
