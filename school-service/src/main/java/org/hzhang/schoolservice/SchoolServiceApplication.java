package org.hzhang.schoolservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "org.hzhang.studentserviceapi")
@ComponentScan(basePackages = {"org.hzhang.studentserviceapi", "org.hzhang.schoolservice"})
@EnableTask
public class SchoolServiceApplication {

    @Bean
    public CommandLineRunner commandLineRunner() {
        return strings -> System.out.println("Executed at :" + new SimpleDateFormat().format(new Date()));
    }

    public static void main(String[] args) {
        SpringApplication.run(SchoolServiceApplication.class, args);
    }
}
