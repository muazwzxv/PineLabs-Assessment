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

            CourseOffline course4 = CourseOffline.builder()
                    .courseName("How to be a good student")
                    .description("Motivation on being a good student")
                    .status(CourseStatus.ARCHIVED)
                    .category(CourseCategory.MOTIVATION)
                    .instructorName("Joe Mama")
                    .venue("KLCC")
                    .totalStudent(300)
                    .build();

            repository.save(course1);
            repository.save(course2);
            repository.save(course3);
            repository.save(course4);
        };
    }

    @Bean
    CommandLineRunner initDatabaseOnline(CourseOnlineRepository repository) {
        return args -> {
            CourseOnline course1 = CourseOnline.builder()
                    .courseName("How to rank up your medal")
                    .description("Just play")
                    .status(CourseStatus.ACTIVE)
                    .category(CourseCategory.MOTIVATION)
                    .instructorName("Marci")
                    .link("https://www.tutorialspoint.com/junit/junit_writing_tests.htm")
                    .totalStudent(200)
                    .build();

            CourseOnline course2 = CourseOnline.builder()
                    .courseName("Matrices")
                    .description("Master matrices in 1 hour")
                    .status(CourseStatus.ARCHIVED)
                    .category(CourseCategory.MATHEMATICS)
                    .instructorName("John Doe")
                    .link("https://www.w3schools.com/java/java_enums.asp")
                    .totalStudent(300)
                    .build();

            CourseOnline course3 = CourseOnline.builder()
                    .courseName("Meiosis and Mitosis")
                    .description("From 1 become 2")
                    .status(CourseStatus.ACTIVE)
                    .category(CourseCategory.SCIENCE)
                    .instructorName("Lily")
                    .link("https://byjus.com/biology/mitosis-and-meiosis/")
                    .totalStudent(5)
                    .build();

            CourseOnline course4 = CourseOnline.builder()
                    .courseName("Respiration")
                    .description("Respiration is real")
                    .status(CourseStatus.ACTIVE)
                    .category(CourseCategory.SCIENCE)
                    .instructorName("Natsuki")
                    .link("https://byjus.com/biology/respiration/")
                    .totalStudent(250)
                    .build();

            CourseOnline course5 = CourseOnline.builder()
                    .courseName("Art")
                    .description("What is art")
                    .status(CourseStatus.ARCHIVED)
                    .category(CourseCategory.ART)
                    .instructorName("Yumi")
                    .link("https://byjus.com/art/art of hell/")
                    .totalStudent(500)
                    .build();

            repository.save(course1);
            repository.save(course2);
            repository.save(course3);
            repository.save(course4);
            repository.save(course5);

        };
    }
}
