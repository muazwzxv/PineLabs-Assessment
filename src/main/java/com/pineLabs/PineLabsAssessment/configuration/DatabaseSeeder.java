package com.pineLabs.PineLabsAssessment.configuration;

import com.pineLabs.PineLabsAssessment.model.CourseOffline;
import com.pineLabs.PineLabsAssessment.model.enums.CourseCategory;
import com.pineLabs.PineLabsAssessment.model.enums.CourseStatus;
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
                    .courseName("How to spend time")
                    .description("The course will teach you how to never waste time again")
                    .status(CourseStatus.ACTIVE)
                    .category(CourseCategory.MOTIVATION)
                    .instructorName("Martin Luther King")
                    .venue("KLCC")
                    .totalStudent(300)
                    .build();

            CourseOffline course2 = CourseOffline.builder()
                    .courseName("How to be a not racist president")
                    .description("Respect people and don't hate")
                    .status(CourseStatus.ACTIVE)
                    .category(CourseCategory.MOTIVATION)
                    .instructorName("Donald Trump")
                    .venue("Not Twitter, cause he's banned there lol")
                    .totalStudent(300)
                    .build();

            CourseOffline course3 = CourseOffline.builder()
                    .courseName("How to suck at being a President")
                    .description("Motivation on what not to do")
                    .status(CourseStatus.ACTIVE)
                    .category(CourseCategory.MOTIVATION)
                    .instructorName("Joe Biden")
                    .venue("WhiteHouse")
                    .totalStudent(300)
                    .build();

            repository.save(course1);
            repository.save(course2);
            repository.save(course3);
        };
    }

}
