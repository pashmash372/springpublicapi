package com.ergo.demo.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Data {
    public int year;
    public double price;
    @JsonProperty("CPU model")
    public String cpuModel;
    @JsonProperty("Hard disk size")
    public String hardDiskSize;
}
