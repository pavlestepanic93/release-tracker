package com.releasetracker.Releasetracker.service;

import com.releasetracker.Releasetracker.entity.Release;
import com.releasetracker.Releasetracker.entity.ReleaseStatus;
import com.releasetracker.Releasetracker.repository.IReleaseRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class ReleaseService implements IReleaseService{

    @Autowired
    private IReleaseRepository releaseRepository;

    @Override
    public ResponseEntity<String> saveRelease(Release release) {
        release.setCreatedAt(LocalDateTime.now());
        release.setLastUpdateAt(LocalDateTime.now());
        if(!isReleaseStatusValid(release.getStatus())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Status is not valid.");
        }
        releaseRepository.save(release);
        return ResponseEntity.status(HttpStatus.OK).body("Release successfully created.");
    }

    @Override
    public Release fetchReleaseById(Long releaseId) {
        return releaseRepository.findById(releaseId).get();
    }

    @Override
    public ResponseEntity<String> deleteReleaseById(Long releaseId) {
        releaseRepository.deleteById(releaseId);
        return ResponseEntity.status(HttpStatus.OK).body("Release successfully deleted.");
    }

    @Override
    public ResponseEntity<String> updateRelease(Long releaseId, Release release) {
        Release releaseFromDb = releaseRepository.findById(releaseId).get();

        if(Objects.nonNull(release.getName()) &&
        !"".equalsIgnoreCase(release.getName())){
            releaseFromDb.setName(release.getName());
        }

        if(Objects.nonNull(release.getDescription()) &&
                !"".equalsIgnoreCase(release.getDescription())){
            releaseFromDb.setDescription(release.getDescription());
        }

        if(Objects.nonNull(release.getStatus()) &&
                !"".equalsIgnoreCase(release.getStatus())){
            if(!isReleaseStatusValid(release.getStatus())){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Status is not valid.");
            }
            releaseFromDb.setStatus(release.getStatus());
        }

        if(Objects.nonNull(release.getReleaseDate())){
            releaseFromDb.setReleaseDate(release.getReleaseDate());
        }

        if(Objects.nonNull(release.getCreatedAt())){
            releaseFromDb.setCreatedAt(release.getCreatedAt());
        }

        if(Objects.nonNull(release.getLastUpdateAt())){
            releaseFromDb.setLastUpdateAt(release.getLastUpdateAt());
        }
        releaseFromDb.setLastUpdateAt(LocalDateTime.now());

        releaseRepository.save(releaseFromDb);
        return ResponseEntity.status(HttpStatus.OK).body("Release successfully updated.");
    }

    @Override
    public List<Release> searchReleases(String query) {
        List<Release> releases = releaseRepository.searchReleases(query);
        return releases;
    }

    @Override
    public Boolean isReleaseStatusValid(String releaseStatus) {
        for(ReleaseStatus day : ReleaseStatus.values()) {
            if(day.toString().equals(releaseStatus))
                return true;
        }
        return false;
    }

}
