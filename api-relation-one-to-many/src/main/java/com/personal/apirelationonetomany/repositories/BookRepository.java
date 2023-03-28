package com.personal.apirelationonetomany.repositories;

import com.personal.apirelationonetomany.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookModel, Integer> {
}
