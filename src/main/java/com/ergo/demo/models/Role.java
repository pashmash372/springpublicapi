package com.ergo.demo.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;


@Getter
//@ToString
public class Role{
    public String url;
    public String name;
    public String gender;
    public String culture;
    public String born;
    public String died;
    public ArrayList<String> titles;
    public ArrayList<String> aliases;
    public String father;
    public String mother;
    public String spouse;
    public ArrayList<String> allegiances;
    public ArrayList<String> books;
    public ArrayList<String> povBooks;
    public ArrayList<String> tvSeries;
    public ArrayList<String> playedBy;
}

