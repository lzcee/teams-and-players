package model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PlayerTest {
    private static Player player;

    @BeforeAll
    public static void initializePlayer() {
        player = new Player(
                "123.456.789-99",
                "Fulano da Silva",
                LocalDate.parse("11/05/1996", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                Player.Gender.MALE,
                80,
                1.67,
                new String[]{"fulano@fulano.com", "teste@teste.com"},
                new String[]{"3356-5236","98854-6325"},
                new String[]{"position1"}
        );
    }

    @DisplayName("[GET] CPF Test")
    @Order(1)
    @ParameterizedTest
    @ValueSource(strings = {"123.456.789-99", "12345678999"})
    void getCpf(String cpf) {
        assertEquals(cpf, player.getCpf());
    }

    @DisplayName("[SET] CPF Test")
    @Order(2)
    @ParameterizedTest
    @ValueSource(strings = {"123.456.789-99", "12345678999", "2222", "222.203.656-99"})
    void setCpf(String cpf) {
        player.setCpf(cpf);
        assertEquals(cpf, player.getCpf());
    }

    @DisplayName("[GET] Name Test")
    @Order(3)
    @ParameterizedTest
    @ValueSource(strings = {"Fulano da Silva", "Beltrano Santos"})
    void getName(String name) {
        assertEquals(name, player.getName());
    }

    @DisplayName("[SET] Name Test")
    @Order(4)
    @ParameterizedTest
    @ValueSource(strings = {"Fulano da Silva", "Beltrano Santos"})
    void setName(String name) {
        player.setName(name);
        assertEquals(name, player.getName());
    }

    @DisplayName("[GET] Date Of Birth Test")
    @Order(5)
    @ParameterizedTest
    @ValueSource(strings = {"11/05/1996", "11/06/1996"})
    void getDateOfBirth(String date) {
        LocalDate dateSource = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        assertEquals(dateSource,player.getDateOfBirth());
    }

    @DisplayName("[SET] Date Of Birth Test")
    @Order(6)
    @ParameterizedTest
    @ValueSource(strings = {"11/05/1996", "21/12/2001"})
    void setDateOfBirth(String date) {
        LocalDate dateSource = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        player.setDateOfBirth(dateSource);
        assertEquals(dateSource,player.getDateOfBirth());
    }

    @DisplayName("[SET - Wrong] Date of Birth Test")
    @Order(7)
    @ParameterizedTest
    @ValueSource(strings = {"blablabla", "1234124234"})
    public void testWrongDateOfBirth(String date) throws DateTimeParseException {
        assertThrows(DateTimeParseException.class, () -> player.setDateOfBirth(LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
    }

    @DisplayName("[GET] Weight Test")
    @Order(8)
    @ParameterizedTest
    @ValueSource(doubles = {80,82.6})
    void getWeight(Double weight) {
        assertEquals(weight,player.getWeight());
    }

    @DisplayName("[SET] Weight Test")
    @Order(9)
    @ParameterizedTest
    @ValueSource(doubles = {80,82.6})
    void setWeight(Double weight) {
        player.setWeight(weight);
        assertEquals(weight,player.getWeight());
    }

    @DisplayName("[GET] Height Test")
    @Order(9)
    @ParameterizedTest
    @ValueSource(doubles = {1.80,1.67})
    void getHeight(Double height) {
        assertEquals(height,player.getHeight());
    }

    @DisplayName("[SET] Height Test")
    @Order(11)
    @ParameterizedTest
    @ValueSource(doubles = {1.80,1.67})
    void setHeight(Double height) {
        player.setHeight(height);
        assertEquals(height,player.getHeight());
    }

    @DisplayName("[GET] Emails Test")
    @Order(12)
    @Test
    void getEmails() {
        String[] emailsList = new String[]{"fulano@fulano.com", "teste@teste.com"};
        assertArrayEquals(emailsList, player.getEmails());
    }

    @DisplayName("[SET] Emails Test")
    @Order(13)
    @Test
    void setEmails() {
        String[] emailsList = new String[]{"fulano2@fulano.com", "teste2@teste.com"};
        player.setEmails(emailsList);
        assertArrayEquals(emailsList, player.getEmails());
    }

    @DisplayName("[GET] Phones Test")
    @Order(14)
    @Test
    void getPhones() {
        String[] phonesList = new String[]{"3356-5236","98854-6325"};
        assertArrayEquals(phonesList, player.getPhones());
    }

    @DisplayName("[SET] Phones Test")
    @Order(15)
    @Test
    void setPhones() {
        String[] phonesList = new String[]{"2659-9696","91112-6325"};
        player.setPhones(phonesList);
        assertArrayEquals(phonesList, player.getPhones());
    }

    @DisplayName("[GET] Positions Test")
    @Order(16)
    @Test
    void getPositions() {
        String[] positionsList = new String[]{"position1"};
        assertArrayEquals(positionsList, player.getPositions());
    }

    @DisplayName("[SET] Positions Test")
    @Order(17)
    @Test
    void setPositions() {
        String[] positionsList = new String[]{"position2","position3"};
        player.setPositions(positionsList);
        assertArrayEquals(positionsList, player.getPositions());
    }

    @DisplayName("[GET] Gender Test")
    @Order(18)
    @ParameterizedTest
    @ValueSource(strings = {"male", "m", "MALE"})
    void getGender(String gender) {
        assertEquals(gender,player.getGender());
    }

    @DisplayName("[SET] Gender Test")
    @Order(19)
    @ParameterizedTest
    @ValueSource(strings = {"female", "FEMALE", "f"})
    void setGender(String gender) {
        player.setGender(gender);
        assertEquals(gender,player.getGender());
    }

    @DisplayName("[SET - Wrong] Gender Test")
    @Order(20)
    @ParameterizedTest
    @ValueSource(strings = {"female", "f"})
    void testWrongGender(String gender) {
        player.setGender(gender);
        assertNotEquals(gender,player.getGender());
    }
}