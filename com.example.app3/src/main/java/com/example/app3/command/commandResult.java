package com.example.app3.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
public class commandResult<T> implements Serializable {
    public String code;
    public String message;
    public  T data;

    public commandResult(String code,String message,T data)
    {
        setCode(code);
        setData(data);
        setMessage(message);
    }
}
