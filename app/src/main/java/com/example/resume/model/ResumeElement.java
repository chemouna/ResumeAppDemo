package com.example.resume.model;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class ResumeElement {

    public abstract String name();
    public abstract String imageUrl();
    public abstract String details();

    public static ResumeElement create(String name, String imageUrl, String details) {
        return new AutoValue_ResumeElement(name, imageUrl, details);
    }
}
