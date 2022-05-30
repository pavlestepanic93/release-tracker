package com.releasetracker.Releasetracker.entity;

public enum ReleaseStatus {
    CREATED("Created"),
    IN_DEVELOPMENT("In Development"),
    ON_DEV("On DEV"),
    QA_DONE_ON_DEV("QA Done on DEV"),
    ON_STAGING("On staging"),
    QA_DONE_ON_STAGING("QA done on STAGING"),
    ON_PROD("On PROD"),
    DONE("Done");

    private final String toString;

    ReleaseStatus(String toString) {
        this.toString = toString;
    }

    public String toString(){
        return toString;
    }
}
