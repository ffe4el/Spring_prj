package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        //ControllerV3를 처리할 수 있는 어댑터를 뜻한다.
        return handler instanceof ControllerV3;
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        //handler를 컨트롤러 V3로 변환한 다음에 V3 형식에 맞도록 호출한다.(캐스팅)
        //supports()를 통해 ControllerV3만 지원하기 때문에 타입 변환은 걱정없이 실행가능...
        ControllerV3 controller = (ControllerV3) handler;
        Map<String, String> paramMap = createParamMap(request);

        //ControllerV3는 ModelView를 반환하므로 그대로 ModelView를 반환하면 된다.
        ModelView mv = controller.process(paramMap);
        return mv;

    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName,
                        request.getParameter(paramName)));
        return paramMap;
    }


}
