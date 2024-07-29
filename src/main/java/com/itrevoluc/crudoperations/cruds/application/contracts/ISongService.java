package com.itrevoluc.crudoperations.cruds.application.contracts;

import com.itrevoluc.crudoperations.cruds.application.dtos.song.AddSongDto;
import com.itrevoluc.crudoperations.cruds.application.dtos.song.SongDto;
import com.itrevoluc.crudoperations.cruds.domain.entities.Song;

import java.util.List;

public interface ISongService {
    SongDto saveSong(AddSongDto addSongDto);
    SongDto getSong(long idSong);
    List<SongDto> getSongs();
    List<SongDto> getSongsByTitle(String title);
    List<SongDto> getSongsByArtist(String artist);
    List<SongDto> getFavoriteSongs();
    void setFavorite(long idSong);
}