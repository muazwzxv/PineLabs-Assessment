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

import java.time.LocalDate;
import java.time.Month;


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
                    .category(CourseCategory.MOTIVATION.getCode())
                    .instructorName("Martin Luther King")
                    .venue("KLCC")
                    .totalStudent(300)
                    .build();

            CourseOffline course2 = CourseOffline.builder()
                    .courseName("How to be a not racist president")
                    .description("Respect people and don't hate")
                    .status(CourseStatus.ACTIVE)
                    .category(CourseCategory.MOTIVATION.getCode())
                    .instructorName("Donald Trump")
                    .venue("Not Twitter, cause he's banned there lol")
                    .totalStudent(300)
                    .build();

            CourseOffline course3 = CourseOffline.builder()
                    .courseName("How to suck at being a President")
                    .description("Motivation on what not to do")
                    .status(CourseStatus.ACTIVE)
                    .category(CourseCategory.MOTIVATION.getCode())
                    .instructorName("Joe Biden")
                    .venue("WhiteHouse")
                    .totalStudent(300)
                    .build();

            CourseOffline course4 = CourseOffline.builder()
                    .courseName("How to be a good student")
                    .description("Motivation on being a good student")
                    .status(CourseStatus.ARCHIVED)
                    .category(CourseCategory.MOTIVATION.getCode())
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
                    .status(CourseStatus.ACTIVE.getCode())
                    .category(CourseCategory.MOTIVATION.getCode())
                    .instructorName("Marci")
                    .link("https://www.tutorialspoint.com/junit/junit_writing_tests.htm")
                    .totalStudent(200)
                    .courseDate(LocalDate.of(2023, Month.JULY, 23))
                    .build();

            CourseOnline course2 = CourseOnline.builder()
                    .courseName("Matrices")
                    .description("Master matrices in 1 hour")
                    .status(CourseStatus.ARCHIVED.getCode())
                    .category(CourseCategory.MATHEMATICS.getCode())
                    .instructorName("John Doe")
                    .link("https://www.w3schools.com/java/java_enums.asp")
                    .totalStudent(300)
                    .courseDate(LocalDate.of(2022, Month.SEPTEMBER, 25))
                    .build();

            CourseOnline course3 = CourseOnline.builder()
                    .courseName("Meiosis and Mitosis")
                    .description("From 1 become 2")
                    .status(CourseStatus.ACTIVE.getCode())
                    .category(CourseCategory.SCIENCE.getCode())
                    .instructorName("Lily")
                    .link("https://byjus.com/biology/mitosis-and-meiosis/")
                    .totalStudent(5)
                    .courseDate(LocalDate.of(2022, Month.DECEMBER, 2))
                    .build();

            CourseOnline course4 = CourseOnline.builder()
                    .courseName("Respiration")
                    .description("Respiration is real")
                    .status(CourseStatus.ACTIVE.getCode())
                    .category(CourseCategory.SCIENCE.getCode())
                    .instructorName("Natsuki")
                    .link("https://byjus.com/biology/respiration/")
                    .totalStudent(250)
                    .courseDate(LocalDate.of(2023, Month.FEBRUARY, 21))
                    .build();

            CourseOnline course5 = CourseOnline.builder()
                    .courseName("Art")
                    .description("What is art")
                    .status(CourseStatus.ARCHIVED.getCode())
                    .category(CourseCategory.ART.getCode())
                    .instructorName("Yumi")
                    .link("https://byjus.com/art/art of hell/")
                    .totalStudent(500)
                    .courseDate(LocalDate.of(2023, Month.MARCH, 12))
                    .build();

            repository.save(course1);
            repository.save(course2);
            repository.save(course3);
            repository.save(course4);
            repository.save(course5);

        };
    }
}
