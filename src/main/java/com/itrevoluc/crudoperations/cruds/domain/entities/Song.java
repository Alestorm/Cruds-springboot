package com.itrevoluc.crudoperations.cruds.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSong;

    private String title;

    private String artist;

    private String album;

    private int duration;

    private String genre;

    private int year;

    private boolean favorite;

    @Column(length = 2083)
    private String image;

    public Song(String title, String artist, String album, int duration, String genre, int year,String image) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
        this.genre = genre;
        this.year = year;
        this.image = image;
    }
}