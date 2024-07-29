package com.itrevoluc.crudoperations.cruds.application.contracts;

import com.itrevoluc.crudoperations.cruds.application.dtos.book.AddBookDto;
import com.itrevoluc.crudoperations.cruds.application.dtos.book.BookDto;
import com.itrevoluc.crudoperations.cruds.domain.entities.Book;

import java.util.List;

public interface IBookService {
    BookDto saveBook(AddBookDto addBookDto);
    BookDto getBook(long idBook);
    List<BookDto> getBooks();
    List<BookDto> getBooksByTitle(String title);

}
