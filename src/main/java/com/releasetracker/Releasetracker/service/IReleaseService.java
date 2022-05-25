package com.releasetracker.Releasetracker.service;

import com.releasetracker.Releasetracker.entity.Release;

import java.util.List;


public interface IReleaseService {
    public Release saveRelease(Release release);
    public List<Release> fetchReleaseList();
    public Release fetchReleaseByName(String releaseName);
    public Release fetchReleaseById(Long releaseId);
    public void deleteReleaseById(Long releaseId);
    public Release updateRelease(Long releaseId, Release release);

}
