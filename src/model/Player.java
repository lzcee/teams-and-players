package model;

import java.util.Date;

public class Player {
    private int cpf;
    private String name;
    private Date dateOfBirth;
    private Enum<Gender> gender;
    private double weight;
    private double height;
    private String emails[];
    private String phones[];
    private String positions[];

    private enum Gender {
        MALE, FEMALE
    };

    public Player(int cpf, String name, Date dateOfBirth, Enum<Gender> gender, double weight, double height, String[] emails, String[] phones, String[] positions) {
        this.cpf = cpf;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.emails = emails;
        this.phones = phones;
        this.positions = positions;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
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

    public Enum<Gender> getGender() {
        return gender;
    }

    public void setGender(Enum<Gender> gender) {
        this.gender = gender;
    }
}
