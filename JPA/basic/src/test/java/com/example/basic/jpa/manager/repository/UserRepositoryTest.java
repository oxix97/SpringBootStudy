package com.example.basic.jpa.manager.repository;

import com.example.basic.jpa.manager.domain.Gender;
import com.example.basic.jpa.manager.domain.UserData;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@WebAppConfiguration
class UserRepositoryTest {
    @Autowired
    private UserRepository repository;

    @Test
    void printList() {
        List<UserData> list = repository.findAll();
        list.forEach(System.out::println);
    }

    @Test
    @Transactional
    void crudTest() {
        repository.findAll().forEach(System.err::println);
        System.err.println(repository.getReferenceById(1L));

        UserData data = repository.findById(1L).orElse(null);
        System.err.println(data);

        repository.save(new UserData());
    }

    @Test
    void saveTest() {
        UserData data = new UserData("name", "mail");
        repository.save(data);
        printList();
        data.setName("Chan");
        repository.save(data);
        printList();

        //update false기 때문에 에러
//        repository.getReferenceById((long) 6).setCreatedAt(LocalDateTime.now());
    }

    @Test
    void enumTest() {
        UserData test = repository.findById(1L).orElseThrow(RuntimeException::new);
        test.setGender(Gender.MALE);

        repository.save(test);
        repository.findAll().forEach(System.out::println);

        //Enum 클래스에 저장된 인덱스 값으로 나오게 된다. 결과 : 0
        // 데이터베이스에 gender 값은 Enum클래스의 0번째 필드로 이루어졌다는 뜻이다. -> 0: MALE, 1:FEMALE 로 지정됨
        //문제는 ENUM 클래스에 요소가 추가되면 값이 변경될 가능성이 있다.
        // 그렇기 때문에 ORDINAL이 아닌 String으로 지정하는것이 좋다. -> MALE 출력
        System.out.println(repository.findRawRecord().get("gender"));
    }

//    @Test
//    void insertTest() {
//        repository.save(new UserData("nname","ieejo716@naver.com"));
//        repository.findAll().forEach(System.err::println);
//    }

    @Test
    void deleteTest() {
//        repository.save(new UserData("nname","ieejo716@naver.com"));
        repository.deleteAll();
        repository.findAll().forEach(System.err::println);
    }

    @Test
    void findTest() {
        UserData data1 = repository.findByEmail("dennis@naver.com");
        List<UserData> data2 = repository.findAllByName("martin");
        UserData data3 = repository.findSomethingByEmail("dennis@naver.com");
        System.out.println("data 1 : " + data1);
        System.out.println("data 2 : " + data2);
        System.out.println("data 3 : " + data3);
    }

    @Test
    void findAndOrTest() {
        UserData data1 = repository.findByNameAndEmail("martin", "martin@another.com");
        List<UserData> data2 = repository.findByNameOrEmail("martin", "dennis@naver.com");
        List<UserData> data3 = repository.findFirstByName("martin");
        System.out.println("data 1 : " + data1);
        System.out.println("data 2 : " + data2);
        System.out.println("data 3 : " + data3);
    }

//    @Test
//    void runTimeTest() {
//        UserData data = repository.findByByName("dennis");
//        System.out.println("data : "+data);
//    }
}