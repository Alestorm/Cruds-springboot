package com.itrevoluc.crudoperations.cruds.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private Long idBook;

    private String title;

    private String author;

    @Column(name = "publication_year")
    private int publicationYear;

    private String genre;

    private String language;

    private String isbn;

    private String publisher;

    public Book(String title, String author, int publicationYear, String genre, String language, String isbn, String publisher) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.genre = genre;
        this.language = language;
        this.isbn = isbn;
        this.publisher = publisher;
    }
}
