package com.amylee.crudlivro;

import com.amylee.crudlivro.controller.LivroController;
import com.amylee.crudlivro.entity.Livro;
import com.amylee.crudlivro.service.LivroService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

    @WebMvcTest(LivroController.class)
    class LivroControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private ObjectMapper objectMapper;

        @MockBean
        private LivroService livroService;

        @Test
        void CriarLivro() throws Exception {
            Livro livro = new Livro(null,"1984", "George Orwell","987654321" );

            Mockito.when(livroService.criarLivro(Mockito.any(Livro.class))).thenReturn(new Livro(1L, "1984", "George Orwell", "987654321"));

            mockMvc.perform(MockMvcRequestBuilders.post("/livro")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(livro)))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.titulo").value("1984"))
                    .andExpect(jsonPath("$.autor").value("George Orwell"));
        }
    }