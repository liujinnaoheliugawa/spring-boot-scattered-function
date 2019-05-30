package com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.restOnSpringMvc.controller;

import com.liugawaheliujinnao.singleFunction.springBootScatteredFunction.restOnSpringMvc.domain.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: {@link RestController}
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
@RestController
public class PersonRestController {

    @GetMapping("/person/{id}")
    public Person person(@PathVariable Long id, @RequestParam(required = false) String name) {
        Person person = new Person();
        person.setId(id);
        person.setName(name);
        return person;
    }

    @PostMapping(value = "/person/json/to/properties"
            , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE // 请求类型，Content-Type
            , produces = "application/properties+person") //响应类型，Accept
    public Person personJsonToProperties(@RequestBody Person person) {
        // @RequestBody 的内容是 JSON
        // 响应的内容是 Properties
        return person;
    }

    @PostMapping(value = "/person/properties/to/json"
            , consumes = "application/properties+person" // 请求类型，Content-Type
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE) //响应类型，Accept
    public Person personPropertiesToJson(@RequestBody Person person) {
        // @RequestBody 的内容是 Properties
        // 响应的内容是 JSON
        return person;
    }
}
