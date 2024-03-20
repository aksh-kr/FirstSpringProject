package com.example.FirstSpringProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String getHello() {
        return "<b>hello world</b>";
    }

    @GetMapping("/")
    public String getRoot() {
        return "Welcome Home ...";
    }

    @GetMapping("/test")
    public String getTest() {
        return "testing ... 1 2 3";
    }

    @GetMapping("/todo/{id}")
    public String getRetroFit(@PathVariable String id) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ToDoService toDoService = retrofit.create(ToDoService.class);

        ToDo toDo = toDoService.getToDoById(id).execute().body();

        return toDo.toString();
    }

}
