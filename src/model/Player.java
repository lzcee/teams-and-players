package model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

public class Player {
    private String cpf;
    private String name;
    private LocalDate dateOfBirth;
    private Enum<Gender> gender;
    private double weight;
    private double height;
    private String emails[];
    private String phones[];
    private String positions[];

    private enum Gender {
        MALE, FEMALE
    };

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String[] getEmails() {
        return emails;
    }

    public void setEmails(String[] emails) {
        this.emails = emails;
    }

    public String[] getPhones() {
        return phones;
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
    }

    public String[] getPositions() {
        return positions;
    }

    public void setPositions(String[] positions) {
        this.positions = positions;
    }

    public String getGender() {
        return gender.toString();
    }

    public void setGender(String gender) {
        if(gender.equalsIgnoreCase("male")) {
            this.gender = Gender.MALE;
        } else if (gender.equalsIgnoreCase("female")) {
            this.gender = Gender.FEMALE;
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", weight=" + weight +
                ", height=" + height +
                ", emails=" + Arrays.toString(emails) +
                ", phones=" + Arrays.toString(phones) +
                ", positions=" + Arrays.toString(positions) +
                '}';
    }
}
