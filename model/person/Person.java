package model.person;

import java.time.LocalDate;
import java.time.Period;

public abstract class Person {
    private final int id;
    private final String fullName;
    private String address;
    private String phone;
    private String email;
    private final LocalDate dateOfBirth;

    // Constructor with full details
    protected Person(int id, String fullName, String address, String phone, String email, LocalDate dateOfBirth) {
        validateId(id);
        validateFullName(fullName);
        validatePhone(phone);
        validateEmail(email);
        validateDateOfBirth(dateOfBirth);

        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    // Constructor with minimal details
    protected Person(int id, String fullName, LocalDate dateOfBirth) {
        validateId(id);
        validateFullName(fullName);
        validateDateOfBirth(dateOfBirth);

        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
    }

    private void validateId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be a positive number.");
        }
    }

    private void validateFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("Full name cannot be null or empty.");
        }
    }

    private void validatePhone(String phone) {
        if (phone != null && !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Phone number must contain only digits.");
        }
    }

    private void validateEmail(String email) {
        if (email != null && !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format.");
        }
    }

    private void validateDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth == null || dateOfBirth.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Date of birth cannot be in the future.");
        }
    }

    public int getId() { return id; }
    public String getFullName() { return fullName; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }

    public int getAge() {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

    public void setAddress(String address) { this.address = address; }

    public void setPhone(String phone) {
        validatePhone(phone);
        this.phone = phone;
    }

    public void setEmail(String email) {
        validateEmail(email);
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", address='" + (address != null ? address : "N/A") + '\'' +
                ", phone='" + (phone != null ? phone : "N/A") + '\'' +
                ", email='" + (email != null ? email : "N/A") + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
