package com.example.apirest.Utils;

public class Apis {

    public static final String URL_001="http://10.10.4.144:8083/tasks/";

    public static TaskService getTaskService(){
        return  Cliente.getClient(URL_001).create(TaskService.class);
    }
}
