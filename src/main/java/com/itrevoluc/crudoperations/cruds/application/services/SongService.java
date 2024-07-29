package com.itrevoluc.crudoperations.cruds.application.services;

import com.itrevoluc.crudoperations.cruds.application.contracts.ISongService;
import com.itrevoluc.crudoperations.cruds.application.dtos.song.AddSongDto;
import com.itrevoluc.crudoperations.cruds.application.dtos.song.SongDto;
import com.itrevoluc.crudoperations.cruds.application.mappers.SongMapper;
import com.itrevoluc.crudoperations.cruds.domain.entities.Song;
import com.itrevoluc.crudoperations.cruds.infrastructure.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository _songRepository;

    @Override
    public SongDto saveSong(AddSongDto addSongDto) {
        Song song = SongMapper.AddDtoToSong(addSongDto);
        return SongMapper.SongToDto(_songRepository.save(song));
    }

    @Override
    public SongDto getSong(long idSong) {
        Song song = _songRepository.findById(idSong).orElse(null);
        if (song == null) {
            return null;
        }
        return SongMapper.SongToDto(song);
    }

    @Override
    public List<SongDto> getSongs() {
        List<Song> songList = _songRepository.findAll();
        return songList.stream().map(SongMapper::SongToDto).collect(Collectors.toList());
    }

    @Override
    public List<SongDto> getSongsByTitle(String title) {
        List<Song> songList = _songRepository.getSongsByTitle(title);
        return songList.stream().map(SongMapper::SongToDto).collect(Collectors.toList());
    }

    @Override
    public List<SongDto> getSongsByArtist(String artist) {
        List<Song> songList = _songRepository.getSongsByArtist(artist);
        return songList.stream().map(SongMapper::SongToDto).collect(Collectors.toList());
    }

    @Override
    public List<SongDto> getFavoriteSongs() {
        List<Song> songList = _songRepository.getFavoriteSongs();
        return songList.stream().map(SongMapper::SongToDto).collect(Collectors.toList());
    }

    @Override
    public void setFavorite(long idSong) {

    }
}