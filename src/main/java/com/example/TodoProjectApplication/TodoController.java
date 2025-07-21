package com.example.TodoProjectApplication;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {
    private static List<Todo>todoList;

    public TodoController(){
        todoList = new ArrayList<>();
        todoList.add(new Todo(1,false,"FirstOne",1));
        todoList.add(new Todo(2,true,"SecondOne",2));
        todoList.add(new Todo(3,true,"ThirdOne",3));
    }
    //GetRequest
    @GetMapping("/todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Todo> getTodosList(){
        return todoList;
    }

    //PostRequest
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/createtodos")
    public void  createtodo(@RequestBody Todo newtodo){
        todoList.add(newtodo);
     //   return newtodo;
    }


}
