package com.amylee.crudlivro;

import com.amylee.crudlivro.entity.Livro;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
    @AutoConfigureMockMvc
    class LivroControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private ObjectMapper objectMapper;

        @Test
        void CriarLivro() throws Exception {
            Livro livro = new Livro(null,"1984", "George Orwell","987654321" );

            mockMvc.perform(post("/livro")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(livro)))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.titulo").value("1984"))
                    .andExpect(jsonPath("$.autor").value("George Orwell"));
        }
    }