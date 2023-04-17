import example.annotation.Controller;
import example.annotation.Service;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

//todo Controller 어노테이션이 설정되어있는 모든 클래스를 찾아 출력을 목적

public class ReflectionTest {
    private static final Logger log = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    void controllerScan() {
        Reflections reflection = new Reflections("example");

        //해당 org.exmaple 밑에 있는 코드중에 Controller.class가 붙어있는 클래스들을 beans에다가 담는다.
        Set<Class<?>> beans = new HashSet<>();
        beans.addAll(reflection.getTypesAnnotatedWith(Controller.class));
        beans.addAll(reflection.getTypesAnnotatedWith(Service.class));
        log.info("beans : [{}]", beans);
    }
}
