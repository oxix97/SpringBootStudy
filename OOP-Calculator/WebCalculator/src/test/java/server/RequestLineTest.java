package server;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestLineTest {
    @Test
    void created(){
        RequestLine requestLine = new RequestLine("GET /calculate?operand1=4&operator=*&operand2=5 HTTP/1.1");
        Assertions.assertNotNull(requestLine);
        Assertions.assertEquals(requestLine, new RequestLine("GET", "/calculate","operand1=4&operator=*&operand2=5"));
    }
}