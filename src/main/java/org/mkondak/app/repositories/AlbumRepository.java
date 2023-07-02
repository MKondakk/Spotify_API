package org.mkondak.app.repositories;

import org.mkondak.app.domains.Album;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource(collectionResourceRel = "albums", path = "albums")
public interface AlbumRepository extends CrudRepository<Album, Long> {
    @RestResource(path = "byName", rel = "findByName")
    @Query(value = "select * from album where name LIKE CONCAT('%', :name, '%')", nativeQuery = true)
    Iterable<Album> findByName(@Param("name") String name);

    @RestResource(path = "byArtist", rel = "findByArtist")
    @Query(value = "select * from album where artist_names LIKE CONCAT('%', :name, '%')", nativeQuery = true)
    Iterable<Album> findByArtistNames(@Param("name") String name);

    @Modifying
    @Transactional
    @Query(value = "delete from album where spotify_id = :id", nativeQuery = true)
    void deleteBySpotifyId(String id);

    @Override
    @RestResource(exported = false)
    void deleteById(Long id);
}
