package com.itrevoluc.crudoperations.cruds.presentation;

import com.itrevoluc.crudoperations.cruds.application.contracts.ISongService;
import com.itrevoluc.crudoperations.cruds.application.dtos.song.AddSongDto;
import com.itrevoluc.crudoperations.cruds.application.dtos.song.SongDto;
import com.itrevoluc.crudoperations.cruds.domain.entities.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("/api/songs")
public class SongController {
    @Autowired
    private ISongService _songService;

    @PostMapping
    public ResponseEntity<Response<SongDto>> SaveSong(@RequestBody AddSongDto addSongDto) {
        SongDto songDto = _songService.saveSong(addSongDto);
        return new ResponseEntity<>(Response.Success(HttpStatus.CREATED, songDto), HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<Response<List<SongDto>>> GetSongs() {
        List<SongDto> songs = _songService.getSongs();
        return new ResponseEntity<>(Response.Success(HttpStatus.OK, songs), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<SongDto>> GetSong(@PathVariable long id) {
        SongDto songDto = _songService.getSong(id);
        if (songDto == null) {
            return new ResponseEntity<>(Response.Failure(HttpStatus.NOT_FOUND, List.of("Not found")), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(Response.Success(HttpStatus.OK, songDto), HttpStatus.OK);
    }

    @GetMapping("/search/title")
    public ResponseEntity<Response<List<SongDto>>> GetSongsByTitle(@RequestParam(name = "title") String title) {
        List<SongDto> songs = _songService.getSongsByTitle(title);
        return new ResponseEntity<>(Response.Success(HttpStatus.OK, songs), HttpStatus.OK);
    }

    @GetMapping("/search/artist")
    public ResponseEntity<Response<List<SongDto>>> GetSongsByArtist(@RequestParam(name = "artist") String artist) {
        List<SongDto> songs = _songService.getSongsByArtist(artist);
        return new ResponseEntity<>(Response.Success(HttpStatus.OK, songs), HttpStatus.OK);
    }
    @PostMapping(value = "demo")
    public String welcome(){
        return "Welcome from secure endpoint";
    }
}