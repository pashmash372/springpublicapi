package com.ergo.demo.controllers;

import com.ergo.demo.models.Book;
import com.ergo.demo.models.Role;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/got")
@AllArgsConstructor
public class TvController {

    // Book List
    @GetMapping("/fullBookList")
    public List<Book> getGotAllBookList(@RequestParam String text) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://anapioficeandfire.com/api/books/";
//        List<Book> books = restTemplate.getForObject(url, List.class);
        ResponseEntity<Object[]> forEntity = restTemplate.getForEntity(url, Object[].class);
        Object[] objects = forEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();

        List<Book> ans = Arrays.stream(objects)
                .map(object -> mapper.convertValue(object, Book.class))
                .filter(b -> b.name.contains(text))
//                .map(Book::getName)
                .collect(Collectors.toList());
//        Optional<Book> ans = books.stream()
//                .filter(b -> b.name.contains(text))
//                .findAny();


        return ans;
    }

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
    public Role getGotList1(@RequestParam String id) { // jon snow - 583
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://anapioficeandfire.com/api/characters/"; // public api
        Role role = restTemplate.getForObject(url + id, Role.class);

        return role;
    }

    @GetMapping("/fullList")
    public List<Role> getGotAllList() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://anapioficeandfire.com/api/characters/";
        List<Role> roles = restTemplate.getForObject(url, List.class);

        return roles;
    }

    @GetMapping("/bookListWithParams")
    public Book getBookListWithId(@RequestParam String id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://anapioficeandfire.com/api/books/"; // book public api
        Book book = restTemplate.getForObject(url + id, Book.class);
        return book;
    }


}
