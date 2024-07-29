package com.itrevoluc.crudoperations.cruds.application.services;

import com.itrevoluc.crudoperations.cruds.application.contracts.IBookService;
import com.itrevoluc.crudoperations.cruds.application.dtos.book.AddBookDto;
import com.itrevoluc.crudoperations.cruds.application.dtos.book.BookDto;
import com.itrevoluc.crudoperations.cruds.domain.entities.Book;
import com.itrevoluc.crudoperations.cruds.infrastructure.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository _bookRepository;


    @Override
    public BookDto saveBook(AddBookDto addBookDto) {
        Book book = DtoToBook(addBookDto);

        _bookRepository.save(book);
        return DbToBookDto(book);
    }

    @Override
    public BookDto getBook(long idBook) {
        var book = _bookRepository.findById(idBook).orElse(null);
        if (book == null) {
            return null;
        }
        return DbToBookDto(book);
    }

    @Override
    public List<BookDto> getBooks() {
        return _bookRepository.findAll().stream()
                .map(this::DbToBookDto)
                .collect(Collectors.toList());

    }

    @Override
    public List<BookDto> getBooksByTitle(String title) {
        return _bookRepository.getBooksByTitle(title).stream()
                .map(this::DbToBookDto)
                .collect(Collectors.toList());
    }

    private BookDto DbToBookDto(Book book) {
        return new BookDto(book.getIdBook(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublicationYear(),
                book.getGenre(),
                book.getLanguage(),
                book.getIsbn(),
                book.getPublisher()
        );
    }

    private Book DtoToBook(AddBookDto bookDto) {
        return new Book(
                bookDto.title,
                bookDto.author,
                bookDto.publicationYear,
                bookDto.genre,
                bookDto.language,
                bookDto.isbn,
                bookDto.publisher
        );
    }
}
