package com.example.app1.command;

import lombok.Data;

import java.io.Serializable;

@Data
public class commandResult<T> implements Serializable {
    public String code;
    public String message;
    public  T data;

}
