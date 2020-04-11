package com.h2sj.douyin.admin.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DatabaseRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Custom Runner...");
        List<String> arrayList = new ArrayList<String>();
        arrayList.add("s");
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            iterator.remove();
        }
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        Future<String> submit = scheduledExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("xixi");
            }
        }, "ret");
        submit.get();
    }
}
