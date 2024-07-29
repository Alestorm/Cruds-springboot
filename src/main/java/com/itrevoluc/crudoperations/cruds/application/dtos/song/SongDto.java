package com.itrevoluc.crudoperations.cruds.application.dtos.song;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class SongDto {
    public Long idSong;

    public String title;

    public String artist;

    public String album;

    public int duration;

    public String genre;

    public int year;

    public boolean favorite;
    public String image;
}
