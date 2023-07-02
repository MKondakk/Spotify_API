package org.mkondak.app.repositories;

import org.mkondak.app.domains.Track;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource(collectionResourceRel = "tracks", path = "tracks")
public interface TrackRepository extends CrudRepository<Track, Long> {
    @RestResource(path = "byName", rel = "findByName")
    @Query(value = "select * from track where name LIKE CONCAT('%', :name, '%')", nativeQuery = true)
    Iterable<Track> findByName(@Param("name") String name);

    @RestResource(path = "byArtist", rel = "findByArtist")
    @Query(value = "select * from track where artist_names LIKE CONCAT('%', :name, '%')", nativeQuery = true)
    Iterable<Track> findByArtistNames(@Param("name") String name);

    @RestResource(path = "byAlbum", rel = "findByAlbum")
    @Query(value = "select * from track where album_name LIKE CONCAT('%', :name, '%')", nativeQuery = true)
    Iterable<Track> findByAlbumName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query(value = "delete from track where spotify_id = :id", nativeQuery = true)
    void deleteBySpotifyId(String id);

    @Override
    @RestResource(exported = false)
    void deleteById(Long id);
}
