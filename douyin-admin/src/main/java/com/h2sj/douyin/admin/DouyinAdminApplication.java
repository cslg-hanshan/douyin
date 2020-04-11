package com.h2sj.douyin.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EntityScan(basePackages = {"com.h2sj.douyin.domain.entity"})
@SpringBootApplication
public class DouyinAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(DouyinAdminApplication.class,args);
    }
}
