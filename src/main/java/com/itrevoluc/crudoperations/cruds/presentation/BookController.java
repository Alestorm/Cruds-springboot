package com.itrevoluc.crudoperations.cruds.presentation;

import com.itrevoluc.crudoperations.cruds.application.contracts.IBookService;
import com.itrevoluc.crudoperations.cruds.application.contracts.IMovieService;
import com.itrevoluc.crudoperations.cruds.application.dtos.book.AddBookDto;
import com.itrevoluc.crudoperations.cruds.application.dtos.book.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private IBookService _bookService;

    @PostMapping
    public ResponseEntity<BookDto> SaveBook(@RequestBody AddBookDto addBookDto) {
        return new ResponseEntity<>(_bookService.saveBook(addBookDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> GetBooks() {
        return new ResponseEntity<>(_bookService.getBooks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> GetBook(@PathVariable long id) {
        var book = _bookService.getBook(id);
        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<BookDto>> GetBooksByTitle(@RequestParam(name = "title") String title) {
        return new ResponseEntity<>(_bookService.getBooksByTitle(title), HttpStatus.OK);
    }
}
