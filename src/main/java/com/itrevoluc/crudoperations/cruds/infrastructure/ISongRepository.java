package com.itrevoluc.crudoperations.cruds.infrastructure;

import com.itrevoluc.crudoperations.cruds.domain.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISongRepository extends JpaRepository<Song,Long> {
    @Query("select s from Song s where lower(s.title) like lower(concat('%',:title,'%'))")
    List<Song> getSongsByTitle(@Param("title") String title);

    @Query("select s from Song s where lower(s.artist) like lower(concat('%',:artist,'%'))")
    List<Song> getSongsByArtist(@Param("artist") String artist);

    @Query("select s from Song s where s.favorite = true")
    List<Song> getFavoriteSongs();
}
