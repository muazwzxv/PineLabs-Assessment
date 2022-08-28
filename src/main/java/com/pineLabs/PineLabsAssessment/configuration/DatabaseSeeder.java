package com.pineLabs.PineLabsAssessment.configuration;

import com.pineLabs.PineLabsAssessment.model.CourseOffline;
import com.pineLabs.PineLabsAssessment.repository.CourseOfflineRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DatabaseSeeder {
    private static final Logger LOG = LoggerFactory.getLogger(DatabaseSeeder.class);

    @Bean
    CommandLineRunner initDatabase(CourseOfflineRepository repository) {
        return args -> {
            CourseOffline course1 = CourseOffline.builder()
                    .courseName("How to oppress a racial group")
                    .instructorName("Martin Luther King")
                    .venue("Cemetary")
                    .build();

            CourseOffline course2 = CourseOffline.builder()
                    .courseName("How to be a racist president")
                    .instructorName("Donald Trump")
                    .venue("Not Twitter, cause he's banned there lol")
                    .build();

            CourseOffline course3 = CourseOffline.builder()
                    .courseName("How to suck at being a President")
                    .instructorName("Joe Biden")
                    .venue("WhiteHouse")
                    .build();

            repository.save(course1);
            repository.save(course2);
            repository.save(course3);
        };
    }
}
