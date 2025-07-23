package com.example.TodoProjectApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {


    private TodoServiceInterface todoService;


    private TodoServiceInterface todoServicedoSomething;


    private static List<Todo>todoList;

    public TodoController( @Qualifier("todoService") TodoServiceInterface todoService,
                           @Qualifier("faketodoService")  TodoServiceInterface todoServicedoSomething){

        this.todoService = todoService;
        this.todoServicedoSomething =todoServicedoSomething;
        todoList = new ArrayList<>();
        todoList.add(new Todo(1,false,"FirstOne",1));
        todoList.add(new Todo(2,true,"SecondOne",2));
        todoList.add(new Todo(3,true,"ThirdOne",3));


    }
    //GetRequest
    @GetMapping
    public ResponseEntity<List<Todo>> getTodosList(@RequestParam(required = false) boolean isCompleted){
        System.out.println( "Status of the Query is :-"+ isCompleted+ todoService.doSomething());
        return ResponseEntity.status(HttpStatus.OK).body(todoList);
    }

    //PostRequest
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public Todo  createtodo(@RequestBody Todo newtodo){
        todoList.add(newtodo);
        return newtodo;
    }



    //First User Function
    @GetMapping("/{todoId}")
    //@PathVariable Http Method path we mostly
    public ResponseEntity<List<Todo>> getTodoById(@PathVariable Long todoId){
        for(Todo todo : todoList){
            if(todo.getUserId() == todoId){
                return ResponseEntity.status(HttpStatus.OK).body(todoList);
            }
        }
        return ResponseEntity.notFound().build();
    }




    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteIdTodo(@PathVariable int id){
        for(Todo todo : todoList){
            if(todo.getUserId() == id){
                todoList.remove(todo);
                ResponseEntity.ok("Succesfully removed it");
            }
        }
        return ResponseEntity.badRequest().build();
    }






}
