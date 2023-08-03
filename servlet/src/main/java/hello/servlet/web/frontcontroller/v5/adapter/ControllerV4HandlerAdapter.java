package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v4.ControllerV4;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {
//    handler 가 ControllerV4 인 경우에만 처리하는 어댑터이다.
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV4);
    }


    //handler를 ContollerV4로 캐스팅하고, paramMap, model을 만들어서 해당 컨트롤러를 호출한다.
    //그리고 viewName을 반환받는다.
    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        ControllerV4 controller = (ControllerV4) handler;

        Map<String, String> paramMap = createParamMap(request);
        Map<String, Object> model = new HashMap<>();

        String viewName = controller.process(paramMap, model);


        //어댑터가 호출하는 ControllerV4는 뷰의 이름을 반환한다. 그런데 어댑터는 뷰의 이름이 아니라
        //ModelView를 만들어서 반환해야 한다. 여기서 어댑터가 꼭 필요한 이유가 나온다.
        //ControllerV4는 뷰의 이름을 반환했지만, 어댑터는 이것을 ModelView로 만들어서 형식을 맞추어 반환한다.
        ModelView mv = new ModelView(viewName);
        mv.setModel(model);

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
