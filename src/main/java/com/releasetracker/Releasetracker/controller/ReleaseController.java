package com.releasetracker.Releasetracker.controller;

import com.releasetracker.Releasetracker.entity.Release;
import com.releasetracker.Releasetracker.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReleaseController {

    @Autowired
    private ReleaseService releaseService;

    @PostMapping("/releases")
    public Release saveRelease(@RequestBody Release release) {
        return releaseService.saveRelease(release);
    }

    @GetMapping("/releases")
    public List<Release> fetchReleaseList(){
        return releaseService.fetchReleaseList();
    }

    @GetMapping("/releases/{id}")
    public Release fetchReleaseById(@PathVariable("id") Long releaseId){
        return releaseService.fetchReleaseById(releaseId);
    }

    @DeleteMapping("/releases/{id}")
    public String deleteReleaseById(@PathVariable("id") Long releaseId){
        releaseService.deleteReleaseById(releaseId);
        return "Release deleted Successfully!!!";
    }

    @PutMapping("/releases/{id}")
    public Release updateRelease(@PathVariable("id") Long releaseId, @RequestBody Release release){
        return releaseService.updateRelease(releaseId, release);
    }

    @GetMapping("/releases/name/{name}")
    public Release fetchReleaseByName(@PathVariable("name") String releaseName){
        return releaseService.fetchReleaseByName(releaseName);
    }
}
