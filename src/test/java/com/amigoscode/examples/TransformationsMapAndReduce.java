package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.beans.PersonDTO;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class TransformationsMapAndReduce {

    @Test
    void yourFirstTransformationWithMap() throws IOException {
        List<Person> people = MockData.getPeople();
        List<PersonDTO> personDTOS = people.stream()
                //.map(person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge()))
                .map(PersonDTO::map)
                .toList();
        //personDTOS.forEach(System.out::println);
        assertThat(people.size()).isEqualTo(personDTOS.size());
    }

    @Test
    void mapToDoubleAndFindAverageCarPrice() throws IOException {
        List<Car> cars = MockData.getCars();
        cars.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .ifPresent(System.out::println);
    }

    @Test
    public void reduce() {
        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};
        int sub = Arrays.stream(integers)
                .reduce(0, (left, right) -> left - right);
        int sum = Arrays.stream(integers)
                .reduce(0, Integer::sum);
        System.out.println(sub);
        System.out.println(sum);
    }
}

