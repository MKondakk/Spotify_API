package org.mkondak.app.repositories;

import org.mkondak.app.domains.Album;
import org.mkondak.app.domains.Artist;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource(collectionResourceRel = "artists", path = "artists")
public interface ArtistRepository extends CrudRepository<Artist, Long> {
    @RestResource(path = "byName", rel = "findByName")
    @Query(value = "select * from artist where name LIKE CONCAT('%', :name, '%')", nativeQuery = true)
    Iterable<Artist> findByName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query(value = "delete from artist where spotify_id = :id", nativeQuery = true)
    void deleteBySpotifyId(String id);

    @Override
    @RestResource(exported = false)
    void deleteById(Long id);
}
