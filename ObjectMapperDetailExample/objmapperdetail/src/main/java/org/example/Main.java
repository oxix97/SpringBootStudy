package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.example.dto.Car;
import org.example.dto.User;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User();
        user.setName("Chan");
        user.setAge(27);


        Car car1 = new Car();
        car1.setName("K3");
        car1.setcarNumber("11나 1111");
        car1.setType("sedan");

        Car car2 = new Car();
        car2.setName("Q5");
        car2.setcarNumber("22나 2222");
        car2.setType("SUV");

        List<Car> carList = Arrays.asList(car1, car2);
        user.setCars(carList);

        String json = objectMapper.writeValueAsString(user);
        System.out.println(json);

        JsonNode jsonNode = objectMapper.readTree(json);
        String _name = jsonNode.get("name").asText();
        int _age = jsonNode.get("age").asInt();
        System.out.println("-------------");
        System.out.println("name : " + _name);
        System.out.println("age : " + _age);

        JsonNode cars = jsonNode.get("cars");
        ArrayNode arrayNode = (ArrayNode) cars;

        List<Car> _cars = objectMapper.convertValue(arrayNode, new TypeReference<List<Car>>() {
        });
        System.out.println(_cars);

        ObjectNode objectNode = (ObjectNode) jsonNode;
        objectNode.put("name", "KIM");

        System.out.println(objectNode.toPrettyString());
    }
}