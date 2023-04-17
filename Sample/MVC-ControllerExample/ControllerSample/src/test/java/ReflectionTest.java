import example.annotation.Controller;
import example.annotation.Service;
import example.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//todo Controller 어노테이션이 설정되어있는 모든 클래스를 찾아 출력을 목적

public class ReflectionTest {
    private static final Logger log = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    void controllerScan() {
        Set<Class<?>> beans = getTypesAnnotatedWith(List.of(Controller.class, Service.class));
        log.info("beans : [{}]", beans);
    }

    private Set<Class<?>> getTypesAnnotatedWith(List<Class<? extends Annotation>> annotations) {
        Reflections reflection = new Reflections("example");

        //해당 org.exmaple 밑에 있는 코드중에 Controller.class가 붙어있는 클래스들을 beans에다가 담는다.
        Set<Class<?>> beans = new HashSet<>();
        annotations.forEach(it -> beans.addAll(reflection.getTypesAnnotatedWith(it)));
        return beans;
    }

    @Test
    void showClass() {
        Class<User> clazz = User.class;
        log.debug(clazz.getName());

        log.info("User all declared fields : [{}]", Arrays.stream(clazz.getDeclaredFields()).collect(Collectors.toList()));
        log.info("User all declared constructor : [{}]", Arrays.stream(clazz.getDeclaredConstructors()).collect(Collectors.toList()));
        log.info("User all declared method : [{}]", Arrays.stream(clazz.getDeclaredMethods()).collect(Collectors.toList()));
    }

    @Test
    void loadTest() throws ClassNotFoundException {
        //1
        Class<User> clazz = User.class;

        //2
        User user = new User("Chan", "Khan");
        Class<? extends User> clazz2 = user.getClass();

        //3
        Class<?> clazz3 = Class.forName("example.model.User");
        log.info("clazz : [{}]", clazz);
        log.info("clazz : [{}]", clazz2);
        log.info("clazz : [{}]", clazz3);

        Assertions.assertEquals(clazz, clazz2);
        Assertions.assertEquals(clazz, clazz3);
        Assertions.assertEquals(clazz2, clazz3);

    }
}
