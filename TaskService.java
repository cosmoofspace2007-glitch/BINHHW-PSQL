package com.example.product_management.Baiss2;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService
{
    private final   TaskRepository taskRepository;
    public  TaskService(TaskRepository taskRepository)
    {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAllTasks()
    {
        return taskRepository.findAll();
    }

    public void addTask(Task task)
    {
        findAllTasks().add(task);
    }
}
