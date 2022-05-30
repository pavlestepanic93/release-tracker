package com.releasetracker.Releasetracker.controller;

import com.releasetracker.Releasetracker.entity.Release;
import com.releasetracker.Releasetracker.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReleaseController {

    @Autowired
    private ReleaseService releaseService;

    @PostMapping("/releases")
    public ResponseEntity<String> saveRelease(@Valid @RequestBody Release release) {
        return releaseService.saveRelease(release);
    }

    @GetMapping("/releases")
    public ResponseEntity<List<Release>> searchReleases(@RequestParam(value = "query", required = false, defaultValue = "") String query){
        return ResponseEntity.ok(releaseService.searchReleases(query));
    }

    @GetMapping("/releases/{id}")
    public Release fetchReleaseById(@PathVariable("id") Long releaseId){
        return releaseService.fetchReleaseById(releaseId);
    }

    @DeleteMapping("/releases/{id}")
    public ResponseEntity<String> deleteReleaseById(@PathVariable("id") Long releaseId){
        return releaseService.deleteReleaseById(releaseId);
    }

    @PutMapping("/releases/{id}")
    public ResponseEntity<String> updateRelease(@PathVariable("id") Long releaseId, @RequestBody Release release){
        return releaseService.updateRelease(releaseId, release);
    }

}
