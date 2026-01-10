package com.solvd.api.github.model;

public class EmailVisibilityRequest {
    private String visibility;

    public EmailVisibilityRequest() {
    }

    public EmailVisibilityRequest(String visibility) {
        this.visibility = visibility;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }
}
