package ru.glassexpress.managers;

public interface SecurityManagerInterface {
    void connectDB();
    boolean isValid();
    void validate();
    void sendEmail();
}
