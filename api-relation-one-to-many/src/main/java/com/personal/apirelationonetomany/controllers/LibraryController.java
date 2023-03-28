package com.personal.apirelationonetomany.controllers;

import com.personal.apirelationonetomany.dtos.LibraryDto;
import com.personal.apirelationonetomany.models.LibraryModel;
import com.personal.apirelationonetomany.response.ResponseHandler;
import com.personal.apirelationonetomany.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getLibraryById(@PathVariable Integer id){
        try {
            LibraryModel library = libraryService.getLibraryById(id);
            return ResponseHandler.generateResponse("Successfully retrieved data", HttpStatus.OK, library);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> createLibrary(@RequestBody LibraryDto libraryDto){
        try {
            LibraryModel newLibrary = libraryService.saveLibrary(new LibraryModel(libraryDto.getName()));
            return ResponseHandler.generateResponse("Successfully added data", HttpStatus.CREATED, newLibrary);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateLibrary(@PathVariable Integer id, @Valid @RequestBody LibraryModel library) {
        try {
            LibraryModel libraryFound = libraryService.getLibraryById(id);
            if(libraryFound == null) {
                return ResponseHandler.generateResponse("Library not found", HttpStatus.NOT_FOUND, null);
            }

            library.setId(libraryFound.getId());
            libraryService.saveLibrary(library);
            return ResponseHandler.generateResponse("Library updated", HttpStatus.NO_CONTENT, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLibrary(@PathVariable Integer id, @Valid @RequestBody LibraryModel library) {
        try {
            LibraryModel libraryFound = libraryService.getLibraryById(id);

            if(libraryFound == null) {
                return ResponseHandler.generateResponse("Library not found", HttpStatus.NOT_FOUND, null);
            }

            libraryService.deleteLibrary(library);
            return ResponseHandler.generateResponse("Library deleted", HttpStatus.NO_CONTENT, null);
        } catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
}
