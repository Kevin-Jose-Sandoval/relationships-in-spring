package com.personal.apirelationonetomany.services;

import com.personal.apirelationonetomany.models.LibraryModel;
import com.personal.apirelationonetomany.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    public LibraryModel saveLibrary(LibraryModel library){
        return libraryRepository.save(library);
    }

    public LibraryModel getLibraryById(Integer id){
        Optional<LibraryModel> libraryFound = libraryRepository.findById(id);

        return libraryFound.orElse(null);
    }

    public void deleteLibrary(LibraryModel library){
        libraryRepository.delete(library);
    }
}
