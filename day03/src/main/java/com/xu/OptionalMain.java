package com.xu;

import java.util.Optional;

/**
 * @author xudenghui
 * @create 2021-02-04 9:59
 **/
public class OptionalMain {
  public static void main(String[] args) {
      Person person = new Person();
      Optional<Person> optPerson = Optional.ofNullable(person);
//      optPerson.map(Person::getCar)
//              .map(Car::getInsurance)
//              .map(Insurance::getName);

      optPerson.flatMap(Person::getCar)
              .flatMap(Car::getInsurance)
              .map(Insurance::getName).orElse("Unknown");
  }
}
