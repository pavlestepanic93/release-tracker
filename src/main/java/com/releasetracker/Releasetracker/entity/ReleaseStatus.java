package com.releasetracker.Releasetracker.entity;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

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

    private ReleaseStatus(String toString) {
        this.toString = toString;
    }

    public String toString(){
        return toString;
    }
}
