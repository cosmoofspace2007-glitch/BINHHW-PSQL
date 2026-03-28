package com.example.product_management.Baiss2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/task")

public class TaskController
{
    private final TaskService taskService;
    private final UserService userService;

    public TaskController(TaskService taskService, UserService userService)
    {
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> getAllTasks(@RequestParam(required = false) String search)
    {
        List<Task> listtask = taskService.findAllTasks();
        if(!search.isEmpty() && search != null)
        {
            List<Task> fillter = new ArrayList<>();
            for (Task task : listtask)
            {
                if(task.getTitle().toLowerCase().contains(search.toLowerCase()))
                    {
                    fillter.add(task);
                    }
            }
            listtask = fillter;
        }
        return ResponseEntity.ok(listtask);
    }

    @PostMapping
    public  ResponseEntity<?> createTask(@RequestBody Task newTask)
    {
        User u = userService.findUserById(Integer.parseInt(newTask.getAssignedTo()));
        if(u == null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        taskService.addTask(newTask);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
