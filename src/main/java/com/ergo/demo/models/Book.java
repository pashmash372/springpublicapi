package com.ergo.demo.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;

@Getter
//@ToString
public class Book{
    public String url;
    public String name;
    public String isbn;
    public ArrayList<String> authors;
    public int numberOfPages;
    public String publisher;
    public String country;
    public String mediaType;
    public Date released;
    public ArrayList<Object> characters;
    public ArrayList<Object> povCharacters;
}