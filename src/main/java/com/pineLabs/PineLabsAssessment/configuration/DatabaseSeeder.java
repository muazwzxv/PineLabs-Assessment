package com.pineLabs.PineLabsAssessment.configuration;

import com.pineLabs.PineLabsAssessment.model.CourseOffline;
import com.pineLabs.PineLabsAssessment.model.CourseOnline;
import com.pineLabs.PineLabsAssessment.model.enums.CourseCategory;
import com.pineLabs.PineLabsAssessment.model.enums.CourseStatus;
import com.pineLabs.PineLabsAssessment.repository.CourseOfflineRepository;
import com.pineLabs.PineLabsAssessment.repository.CourseOnlineRepository;
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

    @Bean
    CommandLineRunner initDatabase(CourseOnlineRepository repository) {
        return args -> {
            CourseOnline course1 = CourseOnline.builder()
                    .courseName("How to rank up to immortal")
                    .description("Just play")
                    .status(CourseStatus.ACTIVE)
                    .category(CourseCategory.MOTIVATION)
                    .instructorName("Marci")
                    .link("https://www.tutorialspoint.com/junit/junit_writing_tests.htm")
                    .total_student(200)
                    .build();

            CourseOnline course2 = CourseOnline.builder()
                    .courseName("Matrices")
                    .description("Master matrices in 1 hour")
                    .status(CourseStatus.ARCHIVED)
                    .category(CourseCategory.MATHEMATICS)
                    .instructorName("Mr. John")
                    .link("https://www.w3schools.com/java/java_enums.asp")
                    .total_student(300)
                    .build();

            CourseOnline course3 = CourseOnline.builder()
                    .courseName("Meiosis and Mitosis")
                    .description("From 1 became 2")
                    .status(CourseStatus.PENDING)
                    .category(CourseCategory.SCIENCE)
                    .instructorName("Mrs Lili")
                    .link("https://byjus.com/biology/mitosis-and-meiosis/")
                    .total_student(5)
                    .build();

            repository.save(course1);
            repository.save(course2);
            repository.save(course3);

        };
    }
}
