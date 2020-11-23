package model;

import java.time.LocalDate;
import java.util.Arrays;

public class Team {
    private int code;
    private String name;
    private LocalDate dateOfFundation;
    private String address;
    private String addressNumber;
    private String cep;
    private String city;
    private String state;
    private String phones[];
    private String founders[];

    public Team() {
    }

    public Team(int code, String name, LocalDate dateOfFundation, String address, String addressNumber, String cep, String city, String state, String[] phones, String[] founders) {
        this.code = code;
        this.name = name;
        this.dateOfFundation = dateOfFundation;
        this.address = address;
        this.addressNumber = addressNumber;
        this.cep = cep;
        this.city = city;
        this.state = state;
        this.phones = phones;
        this.founders = founders;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfFundation() {
        return dateOfFundation;
    }

    public void setDateOfFundation(LocalDate dateOfFundation) {
        this.dateOfFundation = dateOfFundation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber2) {
        this.addressNumber = addressNumber2;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String[] getPhones() {
        return phones;
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
    }

    public String[] getFounders() {
        return founders;
    }

    public void setFounders(String[] founders) {
        this.founders = founders;
    }

    @Override
    public String toString() {
        return "Team{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", dateOfFundation=" + dateOfFundation +
                ", address=" + address +
                ", addressNumber=" + addressNumber +
                ", cep=" + cep +
                ", state=" + state +
                ", city=" + city +
                ", phones=" + Arrays.toString(phones) +
                ", founders=" + Arrays.toString(founders) +
                '}';
    }
}
