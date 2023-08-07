package hello.springmvc.basic.response;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

//정적 리소스나 뷰 템플릿을 거치지 않고, 직접 HTTP 응답 메시지를 전달하는 경우
@Slf4j
@Controller
public class ResponseBodyController {

    /**
     *
     * 서블릿 다룰 때 처럼, HttpServletResponse 객체를 통해서 바디에 직접 ok 메세지 전달
     */
    @GetMapping("/response-body-string-v1")
    public void responseBodyV1(HttpServletResponse response) throws IOException {
        response.getWriter().write("ok");
    }


    /**
     * HttpEntity, ResponseEntity(Http Status 추가)
     * HttpEntity는 HTTP 메시지의 헤더, 바디 정보를 가지고 있다
     */
    @GetMapping("response-body-string-v2")
    public ResponseEntity<String> responseBodyV2() {
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }


    /**
     * @responseBody를 사용하면 view를 사용하지 않고, http 메시지 컨버터를 통해서 http 메시지를 직접 입력할 수 있다.
     * ResponseEntity도 동일한 방식으로 동작한다.
     */
    @ResponseBody
    @GetMapping("response-body-string-v3")
    public String responseBodyV3() {
        return "ok";
    }


    /**
     * ResponseEntity 를 반환한다.
     * HTTP 메시지 컨버터를 통해서 JSON 형식으로 변환되어서 반환된다.
     */
    @GetMapping("/response-body-json-v1")
    public ResponseEntity<HelloData> responseBodyJsonV1() {
        HelloData helloData = new HelloData();
        helloData.setUsername("userA");
        helloData.setAge(20);

        return new ResponseEntity<>(helloData, HttpStatus.OK);
    }


    /**
     * @ResponseStatus(HttpStatus.OK) 애노테이션을 사용하여 응답 코드도 설정 가능
     */
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping("/response-body-json-v2")
    public HelloData responseBodyJsonV2() {
        HelloData helloData = new HelloData();
        helloData.setUsername("userA");
        helloData.setAge(20);

        return helloData;
    }
}
