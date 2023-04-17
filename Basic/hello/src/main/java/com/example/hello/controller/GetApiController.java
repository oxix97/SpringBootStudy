package com.example.hello.controller;

import com.example.hello.dto.UserReq;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get-test")
public class GetApiController {

    @GetMapping(path = "/hello") // http://localhost:9090/api/get-test/hello
    public String printHello() {
        return "get Hello";
    }

    // get,post,pu,delete 지정 할 수 있으며 위의 get mapping의 경우를 이전에 사용한 경우다.
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String hi() {
        return "get hi";
    }

    //http:localhost:9090/api/get-test/path-variable/{name}
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String pathName) {
        System.out.println("name : " + pathName);
        return pathName;
    }

    //http:localhost:9090/api/get-test/query-param?user=chan&email=ieejo716@navre.com&age=27
    //query의 시작은 ?이며 key=value로 이루어져 있다. 조건을 추가하고 싶은 경우 &를 붙여 key=value 형식으로 나아갈수있다.


    //해당 부분은 Map으로 query를 받아 어떠한 것이 들어와도 형식이 맞으면 된다.
    @GetMapping("/query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {
        StringBuilder sb = new StringBuilder();

        queryParam.forEach((key, value) -> sb.append(key).append(" , ").append(value));

        return sb.toString();
    }

    @GetMapping("/query-param2")
    public String queryParam2(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ) {
        return "name : " + name + "\nemail : " + email + "\nage : " + age;
    }

    //객체를 바로 query-parameter로 매치가 되기 때문에 @Requestparam을 사용하지 않아도 된다.
    @GetMapping("/query-param3")
    public String queryParam3(UserReq request) {
        System.out.println(request.toString());
        return request.toString();
    }
}
