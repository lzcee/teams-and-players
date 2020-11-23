package dao;

import model.Player;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PlayerDAOTest {
    private  PlayerDAO playerDAO;

    @BeforeEach
    public void initializePlayerDAO() {
        playerDAO = new PlayerDAO();
    }

    @DisplayName("[PLAYER] Insert")
    @Order(1)
    @Test
    void insert() {
        Player player = new Player(
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
        assertTrue(playerDAO.insert(player));
        Player newPlayer = playerDAO.getPlayer("123.456.789-99");
        assertAll("insertPlayer",
                () -> assertEquals(player.getCpf(), newPlayer.getCpf()),
                () -> assertEquals(player.getName(), newPlayer.getName()),
                () -> assertEquals(player.getDateOfBirth(), newPlayer.getDateOfBirth()),
                () -> assertEquals(player.getGender(), newPlayer.getGender()),
                () -> assertEquals(player.getWeight(), newPlayer.getWeight()),
                () -> assertEquals(player.getHeight(), newPlayer.getHeight()),
                () -> assertArrayEquals(player.getEmails(), newPlayer.getEmails()),
                () -> assertArrayEquals(player.getPhones(), newPlayer.getPhones()),
                () -> assertArrayEquals(player.getPositions(), newPlayer.getPositions())
        );
    }

    @DisplayName("[PLAYER] Update")
    @Order(2)
    @Test
    void update() {
        Player oldPlayer = new Player(
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
        playerDAO.insert(oldPlayer);

        Player newPlayer = new Player(
                "123.456.789-99",
                "Fulano da Silva",
                LocalDate.parse("11/12/1996", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                Player.Gender.MALE,
                80,
                1.67,
                new String[]{"fulano1@fulano.com", "teste1@teste.com"},
                new String[]{"3356-5236","98854-6325"},
                new String[]{"position1"}
        );
        assertTrue(playerDAO.update(newPlayer));

        Player updatedPlayer = playerDAO.getPlayer("123.456.789-99");

        assertAll("updatePlayer",
                () -> assertEquals(newPlayer.getCpf(), updatedPlayer.getCpf()),
                () -> assertEquals(newPlayer.getName(), updatedPlayer.getName()),
                () -> assertEquals(newPlayer.getDateOfBirth(), updatedPlayer.getDateOfBirth()),
                () -> assertEquals(newPlayer.getGender(), updatedPlayer.getGender()),
                () -> assertEquals(newPlayer.getWeight(), updatedPlayer.getWeight()),
                () -> assertEquals(newPlayer.getHeight(), updatedPlayer.getHeight()),
                () -> assertArrayEquals(newPlayer.getEmails(), updatedPlayer.getEmails()),
                () -> assertArrayEquals(newPlayer.getPhones(), updatedPlayer.getPhones()),
                () -> assertArrayEquals(newPlayer.getPositions(), updatedPlayer.getPositions())
        );
    }

    @DisplayName("[PLAYER] Delete")
    @Order(3)
    @Test
    void delete() {
        Player player = new Player(
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
        playerDAO.insert(player);
        assertTrue(playerDAO.delete("123.456.789-99"));

        Player deletedPlayer = playerDAO.getPlayer("123.456.789-99");
        assertNull(deletedPlayer);
    }

    @DisplayName("[PLAYER] getPlayers")
    @Order(5)
    @Test
    void getPlayers() {
        Player player1 = new Player(
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
        Player player2 = new Player(
                "456.365.123-96",
                "Beltrana da Silva",
                LocalDate.parse("22/01/1982", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                Player.Gender.FEMALE,
                65,
                1.90,
                new String[]{"beltrana@beltrana.com", "beltrana@teste.com"},
                new String[]{"95412-2365"},
                new String[]{"position1"}
        );
        Map<String,Player> playersList = new HashMap<>();
        playersList.put("123.456.789-99", player1);
        playersList.put("456.365.123-96", player2);

        playerDAO.insert(player1);
        playerDAO.insert(player2);
        assertIterableEquals(playersList.values(),playerDAO.getPlayers());
    }

    @DisplayName("[PLAYER] getPlayer")
    @Order(5)
    @Test
    void getPlayer() {
        Player player = new Player(
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
        playerDAO.insert(player);
        Player addedPlayer = playerDAO.getPlayer("123.456.789-99");

        assertAll("getPlayer",
                () -> assertEquals(player.getCpf(), addedPlayer.getCpf()),
                () -> assertEquals(player.getName(), addedPlayer.getName()),
                () -> assertEquals(player.getDateOfBirth(), addedPlayer.getDateOfBirth()),
                () -> assertEquals(player.getGender(), addedPlayer.getGender()),
                () -> assertEquals(player.getWeight(), addedPlayer.getWeight()),
                () -> assertEquals(player.getHeight(), addedPlayer.getHeight()),
                () -> assertArrayEquals(player.getEmails(), addedPlayer.getEmails()),
                () -> assertArrayEquals(player.getPhones(), addedPlayer.getPhones()),
                () -> assertArrayEquals(player.getPositions(), addedPlayer.getPositions())
        );
    }
}