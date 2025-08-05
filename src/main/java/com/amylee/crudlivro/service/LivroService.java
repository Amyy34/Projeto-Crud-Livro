package com.amylee.crudlivro.service;

import com.amylee.crudlivro.entity.Livro;
import com.amylee.crudlivro.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    public List<Livro> listarLivros(){
        return repository.findAll();
    }

    public Livro buscarPorId(Long id){
        return repository.findById(id).orElse(null);
    }

    public Livro criarLivro(Livro livro){
        return repository.save(livro);
    }

    public Livro atualizarlivro(Long id, Livro novoLivro){
        Livro existente = buscarPorId(id);
        if (existente != null){
            existente.setTitulo(novoLivro.getTitulo());
            existente.setAutor(novoLivro.getAutor());
            existente.setIsbn(novoLivro.getIsbn());
            return repository.save(novoLivro);
        }
        return null;
    }

    public void deletarLivro(Long id){
        repository.deleteById(id);
    }
}
