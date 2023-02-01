package com.example.fitness.model;

import java.util.UUID;

public class Exercise {

    private long id;
    private String exercise_name;
    private String muscle_group;
    private String reference_on_video;
    private String description;


    public Exercise(long id, String exercise_name, String muscle_group, String reference_on_video, String description) {
        this.id = id;
        this.exercise_name = exercise_name;
        this.muscle_group = muscle_group;
        this.reference_on_video = reference_on_video;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExercise_name() {
        return exercise_name;
    }

    public void setExercise_name(String exercise_name) {
        this.exercise_name = exercise_name;
    }

    public String getMuscle_group() {
        return muscle_group;
    }

    public void setMuscle_group(String muscle_group) {
        this.muscle_group = muscle_group;
    }

    public String getReference_on_video() {
        return reference_on_video;
    }

    public void setReference_on_video(String reference_on_video) {
        this.reference_on_video = reference_on_video;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {

        return exercise_name;

    }
}
