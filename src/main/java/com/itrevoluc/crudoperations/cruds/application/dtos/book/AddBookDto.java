package com.itrevoluc.crudoperations.cruds.application.dtos.book;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class AddBookDto {
    public String title;
    public String author;
    public int publicationYear;
    public String genre;
    public String language;
    public String isbn;
    public String publisher;
}