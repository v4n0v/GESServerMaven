package ru.glassexpress.controllers;

public interface SecurityManagerInterface {
    void connectDB();
    boolean isValid();
    void validate();
    void sendEmail();
}
