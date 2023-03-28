package com.personal.apirelationonetomany.repositories;

import com.personal.apirelationonetomany.models.LibraryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<LibraryModel, Integer> {
}
