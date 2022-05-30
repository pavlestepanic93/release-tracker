package com.releasetracker.Releasetracker.service;
import com.releasetracker.Releasetracker.entity.Release;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface IReleaseService {
    ResponseEntity<String> saveRelease(Release release);
    Release fetchReleaseById(Long releaseId);
    ResponseEntity<String> deleteReleaseById(Long releaseId);
    ResponseEntity<String> updateRelease(Long releaseId, Release release);
    Boolean isReleaseStatusValid(String releaseStatus);
    List<Release> searchReleases(String query);
}
