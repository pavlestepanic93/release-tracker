package com.releasetracker.Releasetracker.repository;
import com.releasetracker.Releasetracker.entity.Release;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReleaseRepository extends JpaRepository<Release, Long> {

    @Query(value = "SELECT * FROM release r WHERE " +
            "r.name LIKE CONCAT('%',:query, '%')" +
            "Or r.description LIKE CONCAT('%',:query, '%')" +
            "Or r.status LIKE CONCAT('%',:query, '%')", nativeQuery = true)
    List<Release> searchReleases(String query);

}
