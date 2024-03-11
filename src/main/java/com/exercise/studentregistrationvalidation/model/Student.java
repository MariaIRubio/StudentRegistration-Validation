package com.exercise.studentregistrationvalidation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Field required")
    @Size(min = 1, message = "First name required")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "First name must contain only letters")
    private String firstName;

    @NotNull(message = "Field required")
    @Size(min = 1, message = "Last name required")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Last name must contain only letters")
    private String lastName;

    @NotNull(message = "Field required")
    @Size(min = 1, message = "Email required")
    private String email;


    @DateTimeFormat (pattern = "yyy-MM-dd")
    private Date birthdate;

    @NotNull(message = "Field required")
    @Size(min = 1, message = "Street required")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Street must contain only letters")
    private String street;

    @NotNull(message = "Field required")
    @Size(min = 1, message = "Number required")
    @Pattern(regexp = "^[0-9]+$", message = "Invalid number")
    private String number;

    @NotNull(message = "Field required")
    @Size(min = 1, message = "Zip required")
    @Pattern(regexp = "^[0-9]+${5}", message = "Min 5 digits")
    private String zip;

    @NotNull(message = "Field required")
    @Size(min = 1, message = "City required")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "City must contain only letters")
    private String city;

    @NotNull(message = "Field required")
    @Size(min = 1, message = "Phone number required")
    @Pattern(regexp = "^[0-9]+${10}", message = "Min 10 digits")
    private String phoneNumber;

    @AssertTrue(message = "Course selection is required")
    public boolean isCourseSelected() {
        return !"0".equals(course);
    }

    @NotNull(message = "Field required")
    private String course;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "\nID: " + id +
                "\nName: " + firstName +
                "\n " + lastName +
                "\nEmail: " + email +
                "\n Birthdate: " + birthdate +
                "\nAddress: " + street +
                " " + number +
                ", " + zip +
                ", " + city +
                "\n Phone Number: " + phoneNumber +
                "\n Course: " + course;
    }
}
