package com.example.TodoProjectApplication;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("todoService")
@Primary
public class TodoService implements TodoServiceInterface {
    @Override
    public  String doSomething(){
        return  "Something";
    }
}
