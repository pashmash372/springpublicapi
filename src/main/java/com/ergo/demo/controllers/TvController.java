package com.ergo.demo.controllers;

import com.ergo.demo.models.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/got")
public class TvController {

    @GetMapping("/{id}")
    public ResponseEntity<String> getGot(@PathVariable int id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://anapioficeandfire.com/api/characters/583";
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        return forEntity;
    }

    @GetMapping("/list/{id}")
    public String getGot1(@PathVariable int id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://anapioficeandfire.com/api/characters/583";
        Role role = restTemplate.getForObject(url, Role.class);
//        System.out.println(role);
        System.out.println(role.getBooks());
        System.out.println(role.getName());
        return role.toString();
    }

    @GetMapping("/fullListWithParameters/{id}")
    public Role getGotList(@PathVariable int id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://anapioficeandfire.com/api/characters/";
        Role role = restTemplate.getForObject(url + id, Role.class);
//        System.out.println(role);
        System.out.println(role.getBooks());
        System.out.println(role.getName());
        return role;
    }

    @GetMapping("/fullListWithParams")
    public Role getGotList1(@RequestParam String id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://anapioficeandfire.com/api/characters/";
        Role role = restTemplate.getForObject(url + id, Role.class);

        return role;
    }

}
