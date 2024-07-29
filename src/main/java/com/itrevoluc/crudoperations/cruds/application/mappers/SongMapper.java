package com.itrevoluc.crudoperations.cruds.application.mappers;

import com.itrevoluc.crudoperations.cruds.application.dtos.song.AddSongDto;
import com.itrevoluc.crudoperations.cruds.application.dtos.song.SongDto;
import com.itrevoluc.crudoperations.cruds.domain.entities.Song;

public class SongMapper {
    public static SongDto SongToDto(Song song) {
        return new SongDto(
                song.getIdSong(),
                song.getTitle(),
                song.getArtist(),
                song.getAlbum(),
                song.getDuration(),
                song.getGenre(),
                song.getYear(),
                song.isFavorite(),
                song.getImage()
        );
    }

    public static Song AddDtoToSong(AddSongDto addSongDto) {
        return new Song(
                addSongDto.title,
                addSongDto.artist,
                addSongDto.album,
                addSongDto.duration,
                addSongDto.genre,
                addSongDto.year,
                addSongDto.image
                );
    }
}