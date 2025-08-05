package com.amylee.crudlivro.repository;

import com.amylee.crudlivro.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro,Long> {
}
