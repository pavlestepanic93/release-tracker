package com.releasetracker.Releasetracker.controller;

import com.releasetracker.Releasetracker.entity.Release;
import com.releasetracker.Releasetracker.service.ReleaseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import java.time.LocalDateTime;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReleaseController.class)
class ReleaseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReleaseService releaseService;

    private Release release;
    private Release releaseTwo;

    @BeforeEach
    void setUp() {

        release = Release.builder()
                .id(1L)
                .name("Release 1")
                .description("Description 1")
                .status("Created")
                .releaseDate(LocalDateTime.now().minusDays(10))
                .createdAt(LocalDateTime.now().minusDays(30))
                .lastUpdateAt(LocalDateTime.now().minusDays(5))
                .build();

    }

    @Test
    void saveRelease() throws Exception{
        Release inputRelease = Release.builder()
                .name("Release 1")
                .description("Description 1")
                .status("Created")
                .build();

        Mockito.when(releaseService.saveRelease(inputRelease))
                .thenReturn(ResponseEntity.status(HttpStatus.OK).body("Release successfully created."));

        mockMvc.perform(post("/api/releases")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"description\": \"Description 1\",\n" +
                        "  \"name\": \"Release 1\",\n" +
                        "  \"status\": \"Created\"\n" +
                        "}"))
                .andExpect(status().isOk());
    }

    @Test
    void fetchReleaseById() throws Exception {
        Mockito.when(releaseService.fetchReleaseById(1L))
                .thenReturn(release);

        mockMvc.perform(get("/api/releases/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name")
                .value(release.getName()));
    }

    @Test
    void searchReleases() {

    }
    @Test
    void deleteReleaseById() {
    }

    @Test
    void updateRelease() {
    }
}