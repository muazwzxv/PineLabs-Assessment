package com.pineLabs.PineLabsAssessment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pineLabs.PineLabsAssessment.model.CourseOffline;
import com.pineLabs.PineLabsAssessment.model.enums.CourseCategory;
import com.pineLabs.PineLabsAssessment.model.enums.CourseStatus;
import com.pineLabs.PineLabsAssessment.service.CourseOfflineService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(CourseController.class)
public class CourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseOfflineService offlineService;

    @Autowired
    private ObjectMapper objectMapper;

    private static final List<CourseOffline> activeCourseOfflineData = new ArrayList<>(Arrays.asList(
            CourseOffline.builder()
                    .courseName("How to spend time")
                    .description("The course will teach you how to never waste time again")
                    .status(CourseStatus.ACTIVE.getCode())
                    .category(CourseCategory.MOTIVATION.getCode())
                    .instructorName("Martin Luther King")
                    .venue("KLCC")
                    .totalStudent(300)
                    .build(),

            CourseOffline.builder()
                    .courseName("How to be a not racist president")
                    .description("Respect people and don't hate")
                    .status(CourseStatus.ACTIVE.getCode())
                    .category(CourseCategory.MOTIVATION.getCode())
                    .instructorName("Donald Trump")
                    .venue("Not Twitter, cause he's banned there lol")
                    .totalStudent(300)
                    .build(),
            CourseOffline.builder()
                    .courseName("How to suck at being a President")
                    .description("Motivation on what not to do")
                    .status(CourseStatus.ACTIVE.getCode())
                    .category(CourseCategory.MOTIVATION.getCode())
                    .instructorName("Joe Biden")
                    .venue("WhiteHouse")
                    .totalStudent(300)
                    .build()
    ));


    /*
        junit test for Get All courses Api
        ? status = offline
     */
    @Test
    public void givenGetAll_whenCallAPIWithStatusOnline_thenReturnListOfOfflineCourse() throws Exception {

        String uri = "/api/v1/courses?status=offline";
        given(offlineService.findAllActiveCourses())
                .willReturn(activeCourseOfflineData);

        ResultActions res = mockMvc.perform(get(uri));
        res.andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

}
