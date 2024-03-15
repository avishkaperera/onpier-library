package org.onpier.onpierlibrary.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.onpier.onpierlibrary.persistence.model.User;
import org.onpier.onpierlibrary.service.UserService;
import org.onpier.onpierlibrary.util.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.doReturn;

@AutoConfigureMockMvc
@SpringBootTest
class LibraryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @SpyBean
    private UserService userService;

    @Test
    void getBorrowers() throws Exception {
        doReturn(getListOfBorrowers()).when(userService).findBorrowers();
        mockMvc.perform(MockMvcRequestBuilders.get("/library/borrowers"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        objectMapper.writeValueAsString(getListOfBorrowers().stream()
                                .map(UserConverter::toUserResponse).toList())));
    }

    private List<User> getListOfBorrowers() {
        return List.of(User.builder()
                .gender("m")
                .memberTill(LocalDate.now())
                .memberSince(LocalDate.now())
                .firstName("Elijah")
                .lastName("Chish")
                .build());
    }
}