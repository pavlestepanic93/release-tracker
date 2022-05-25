package com.releasetracker.Releasetracker.repository;

import com.releasetracker.Releasetracker.entity.Release;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IReleaseRepository extends JpaRepository<Release, Long> {

    @Query(value = "SELECT * FROM RELEASE R WHERE R.name = ?1", nativeQuery = true)
    public Release findByName(String Name);

}
