package com.example.contactsapp.pojos;

import android.net.Uri;

import java.net.URI;

public class Contact {
    private String firstName, lastName, language, phoneNumber;
    private char gender;
    private Uri picture;

    public Contact(String firstName, String lastName, String language, String phoneNumber, char gender, Uri picture) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.language = language;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.picture = picture;
    }

    public Contact(String ln) {
        String[] array = ln.split(",");

        this.firstName = array[1];
        this.lastName = array[2];
        this.language = array[3];
        this.phoneNumber = array[6];
        this.gender = array[4].charAt(0);
        this.picture = Uri.parse(array[5]);

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Uri getPicture() {
        return picture;
    }

    public void setPicture(Uri picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", language='" + language + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender=" + gender +
                ", picture=" + picture +
                '}';
    }
}
