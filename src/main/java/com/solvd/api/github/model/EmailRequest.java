package com.solvd.api.github.model;

import java.util.List;

public class EmailRequest {
    private List<String> emails;

    public EmailRequest() {
    }

    public EmailRequest(List<String> emails) {
        this.emails = emails;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }
}
