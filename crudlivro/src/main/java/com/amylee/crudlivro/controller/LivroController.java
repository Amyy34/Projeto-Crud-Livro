package com.amylee.crudlivro.controller;

import com.amylee.crudlivro.entity.Livro;
import com.amylee.crudlivro.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService service;

    @GetMapping
    public List<Livro> listarLivros(){
        return service.listarLivros();
    }

    @GetMapping("/{id}")
    public Livro buscarLivroById(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PostMapping
    public Livro criarlivro(@RequestBody Livro livro){
        return service.criarLivro(livro);
    }

    @PutMapping("/{id}")
    public Livro atualizar(@PathVariable Long id, @RequestBody Livro livro){
        return service.atualizarlivro(id,livro);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletarLivro(id);
    }
}
