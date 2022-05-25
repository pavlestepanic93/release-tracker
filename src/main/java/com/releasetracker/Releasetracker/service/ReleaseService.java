package com.releasetracker.Releasetracker.service;

import com.releasetracker.Releasetracker.entity.Release;
import com.releasetracker.Releasetracker.repository.IReleaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class ReleaseService implements IReleaseService{

    @Autowired
    private IReleaseRepository releaseRepository;

    @Override
    public Release saveRelease(Release release) {
        release.setCreatedAt(LocalDateTime.now());
        release.setLastUpdateAt(LocalDateTime.now());
        return releaseRepository.save(release);
    }

    @Override
    public List<Release> fetchReleaseList() {
        return releaseRepository.findAll();
    }

    @Override
    public Release fetchReleaseById(Long releaseId) {
        return releaseRepository.findById(releaseId).get();
    }

    @Override
    public Release fetchReleaseByName(String releaseName) { return releaseRepository.findByName(releaseName); }

    @Override
    public void deleteReleaseById(Long releaseId) {
        releaseRepository.deleteById(releaseId);
    }

    @Override
    public Release updateRelease(Long releaseId, Release release) {
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
        return releaseRepository.save(releaseFromDb);
    }

}
