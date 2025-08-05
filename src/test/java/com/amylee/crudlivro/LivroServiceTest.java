package com.amylee.crudlivro;

import com.amylee.crudlivro.entity.Livro;
import com.amylee.crudlivro.repository.LivroRepository;
import com.amylee.crudlivro.service.LivroService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class LivroServiceTest {

	@Mock
	private LivroRepository repository;

	@InjectMocks
	private LivroService service;

	@Test
	public void testBuscarLivroPorId(){
		Livro livro = new Livro(1L, "Dom Casmurro", "Machado de Assis", "123456789");
		Mockito.when(repository.findById(1L)).thenReturn(Optional.of(livro));

		Livro resultado = service.buscarPorId(1L);

		Assertions.assertEquals("Dom Casmurro", resultado.getTitulo());
	}
}
