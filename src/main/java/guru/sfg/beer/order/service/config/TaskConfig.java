package guru.sfg.beer.order.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Task Configuration - enable asyc tasks
 */
@EnableScheduling
@EnableAsync
@Configuration
public class TaskConfig {

    @Bean
    TaskExecutor taskExecutor() {
        return new SimpleAsyncTaskExecutor();
    }
}


/*
(1)
https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/scheduling/annotation/EnableScheduling.html
@EnableScheduling

            we have to use this @EnableScheduling annotation in the @Configuration class so that in the begining of the
application it will be called , as we use here @EnableScheduling  that means we have defined somewhere in the application

@Scheduled() annotation  <<-- this we have defined in the  TastingRoomService class  on the placeTestingRoomOrder() method

so every 2 sec this method is called


@Scheduled(fixedRate = 2000) //run every 2 seconds -- in the TaskConfig class we have used
    public void placeTastingRoomOrder
-----------------------------------------------------------------------------------------
(2)
https://www.youtube.com/watch?v=3rJBLFA95Io&t=365s         Java Techie
@EnableAsync

with this annotation we are telling spring that to run our Task in the background as we can define a ThreadPool
or ExecutorService  so those Threads specification will be defined in this class and through @EnableAsync we are
informing the Spring to execute them in the background

--------------------------------------------------------------------------------------------------------
(3)
@Bean   <-- this annotation we will use on a method() in the JavaConfig class , as we are using this method in the
            class where @Configuration is used. so in the begining @Configuration class will be executed and the
            method with the @Bean will also be executed
----------------------------------------------------------------------------------------------
(4)
SimpleAsyncTaskExecutor()

we can set many options for it but in this example he did not mention those settings
i saw a example of it in this link

https://www.javatips.net/api/org.springframework.core.task.simpleasynctaskexecutor
 */
