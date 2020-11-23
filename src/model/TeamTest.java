package model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TeamTest {
    private static Team team;

    @BeforeAll
    public static void initializePlayer() {
        team = new Team(
                2512,
                "Team Name",
                LocalDate.parse("11/05/1960", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                "Rua xyz",
                "230",
                "13656-600",
                "City",
                "SP",
                new String[]{"3356-5236","98854-6325"},
                new String[]{"Fulano1 da Silva","Fuland2 da Silva"}
        );
    }

    @DisplayName("[GET] Code Test")
    @Order(1)
    @ParameterizedTest
    @ValueSource(ints = {2512,32565,223154})
    void getCode(Integer code) {
        assertEquals(code, team.getCode());
    }

    @DisplayName("[SET] Code Test")
    @Order(2)
    @ParameterizedTest
    @ValueSource(ints = {2512,32565,223154})
    void setCode(Integer code) {
        team.setCode(code);
        assertEquals(code,team.getCode());
    }

    @DisplayName("[GET] Name Test")
    @Order(3)
    @ParameterizedTest
    @ValueSource(strings = {"Team Name", "Team Name 2"})
    void getName(String name) {
        assertEquals(name, team.getName());
    }

    @DisplayName("[SET] Name Test")
    @Order(4)
    @ParameterizedTest
    @ValueSource(strings = {"Team Name2", "Team Name3"})
    void setName(String name) {
        team.setName(name);
        assertEquals(name, team.getName());
    }

    @DisplayName("[GET] Date Of Foundation Test")
    @Order(5)
    @ParameterizedTest
    @ValueSource(strings = {"11/05/1960", "12/12/1962"})
    void getDateOfFoundation(String date) {
        LocalDate dateSource = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        assertEquals(dateSource,team.getDateOfFundation());
    }

    @DisplayName("[SET] Date Of Foundation Test")
    @Order(6)
    @ParameterizedTest
    @ValueSource(strings = {"25/05/1925", "12/12/1962", "12/12/1960"})
    void setDateOfFoundation(String date) {
        LocalDate dateSource = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        team.setDateOfFundation(dateSource);
        assertEquals(dateSource,team.getDateOfFundation());
    }

    @DisplayName("[GET] Address Test")
    @Order(7)
    @ParameterizedTest
    @ValueSource(strings = {"Rua xyz", "RUA XYZ", "Rua abcd"})
    void getAddress(String address) {
        assertEquals(address,team.getAddress());
    }

    @DisplayName("[SET] Address Test")
    @Order(8)
    @ParameterizedTest
    @ValueSource(strings = {"Rua xyz", "RUA XYZ", "Rua abcd"})
    void setAddress(String address) {
        team.setAddress(address);
        assertEquals(address,team.getAddress());
    }

    @DisplayName("[GET] Address Number Test")
    @Order(9)
    @ParameterizedTest
    @ValueSource(strings = {"230", "123", "255"})
    void getAddressNumber(String addressNumber) {
        assertEquals(addressNumber,team.getAddressNumber());
    }

    @DisplayName("[SET] Address Number Test")
    @Order(10)
    @ParameterizedTest
    @ValueSource(strings = {"teste", "123", "255"})
    void setAddressNumber(String addressNumber) {
        team.setAddressNumber(addressNumber);
        assertEquals(addressNumber,team.getAddressNumber());
    }

    @DisplayName("[GET] CEP Test")
    @Order(11)
    @ParameterizedTest
    @ValueSource(strings = {"13656-600", "13656600", "123564"})
    void getCep(String cep) {
        assertEquals(cep,team.getCep());
    }

    @DisplayName("[SET] CEP Test")
    @Order(12)
    @ParameterizedTest
    @ValueSource(strings = {"17586-203", "17586203", "123564"})
    void setCep(String cep) {
        team.setCep(cep);
        assertEquals(cep,team.getCep());
    }

    @DisplayName("[GET] City Test")
    @Order(13)
    @ParameterizedTest
    @ValueSource(strings = {"Rua xyz", "Rua abcd", "Rua abcdef"})
    void getCity(String city) {
        assertEquals(city,team.getCity());
    }

    @DisplayName("[SET] City Test")
    @Order(14)
    @ParameterizedTest
    @ValueSource(strings = {"Rua abcd", "Rua abcdef","Rua xyz"})
    void setCity(String city) {
        team.setCity(city);
        assertEquals(city,team.getCity());
    }

    @DisplayName("[GET] State Test")
    @Order(15)
    @ParameterizedTest
    @ValueSource(strings = {"SP", "RJ", "MG"})
    void getState(String state) {
        assertEquals(state,team.getState());
    }

    @DisplayName("[GET] State Test")
    @Order(16)
    @ParameterizedTest
    @ValueSource(strings = {"SP", "RJ", "MG"})
    void setState(String state) {
        team.setState(state);
        assertEquals(state,team.getState());
    }

    @DisplayName("[GET] Phones Test")
    @Order(17)
    @Test
    void getPhones() {
        String[] phonesList = new String[]{"3356-5236","98854-6325"};
        assertArrayEquals(phonesList, team.getPhones());
    }

    @DisplayName("[SET] Phones Test")
    @Order(18)
    @Test
    void setPhones() {
        String[] phonesList = new String[]{"26599696","91112-6325"};
        team.setPhones(phonesList);
        assertArrayEquals(phonesList, team.getPhones());
    }

    @DisplayName("[GET] Founder Test")
    @Order(19)
    @Test
    void getFounders() {
        String[] foundersList = new String[]{"Fulano1 da Silva","Fuland2 da Silva"};
        assertArrayEquals(foundersList, team.getFounders());
    }

    @DisplayName("[SET] Founder Test")
    @Order(20)
    @Test
    void setFounders() {
        String[] foundersList = new String[]{"Beltrano1 Santos","Beltrano2 Santos"};
        team.setFounders(foundersList);
        assertArrayEquals(foundersList, team.getFounders());
    }
}