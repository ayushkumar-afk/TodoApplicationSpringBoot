package com.example.TodoProjectApplication;

import org.springframework.stereotype.Service;

@Service("fakeTodoService")
public class FakeTodoService implements TodoServiceInterface{
    @Override
    public String doSomething() {
        return " FakeTodoService";
    }
}
