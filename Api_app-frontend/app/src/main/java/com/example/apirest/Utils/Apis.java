package com.example.apirest.Utils;

public class Apis {

    public static final String URL_001="http://192.168.1.2:8083/tasks/";

    public static TaskService getTaskService(){
        return  Cliente.getClient(URL_001).create(TaskService.class);
    }
}
