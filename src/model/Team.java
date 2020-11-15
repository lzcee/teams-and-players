package model;

import java.util.Date;
import java.util.List;

public class Team {
    private int code;
    private String name;
    private Date dateOfFundation;
    private String address;
    private int addressNumber;
    private String cep;
    private String city;
    private String state;
    private String phones[];
    private String founders[];
    private List<Player> players;

    public Team(int code, String name, Date dateOfFundation, String address, int addressNumber, String cep, String city, String state, String[] phones, String[] founders, List<Player> players) {
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
        this.players = players;
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

    public Date getDateOfFundation() {
        return dateOfFundation;
    }

    public void setDateOfFundation(Date dateOfFundation) {
        this.dateOfFundation = dateOfFundation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(int addressNumber) {
        this.addressNumber = addressNumber;
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

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
