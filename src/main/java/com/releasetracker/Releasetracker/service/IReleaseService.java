package com.releasetracker.Releasetracker.service;

import com.releasetracker.Releasetracker.entity.Release;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface IReleaseService {
    public ResponseEntity<String> saveRelease(Release release);
    public Release fetchReleaseById(Long releaseId);
    public ResponseEntity<String> deleteReleaseById(Long releaseId);
    public ResponseEntity<String> updateRelease(Long releaseId, Release release);
    public Boolean isReleaseStatusValid(String releaseStatus);
    public List<Release> searchReleases(String query);
}
