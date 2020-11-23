package dao;

import model.Team;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TeamDAOTest {
    private  TeamDAO teamDAO;

    @BeforeEach
    public void initializeTeamDAO() {
        teamDAO = new TeamDAO();
    }

    @DisplayName("[TEAM] Insert")
    @Order(1)
    @Test
    void insert() {
        Team team = new Team(
                1,
                "Timezão",
                LocalDate.parse("11/05/1996", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                "Avenida do tal, jardim nova escócia, 987",
                "80",
                "15789884",
                "São Paulo",
                "SP",
                new String[]{"3356-5236","98854-6325"},
                new String[]{"Gilberto Brutus"}
        );
        assertTrue(teamDAO.insert(team));
        Team newTeam = teamDAO.getTeam(1);
        assertAll("insertTeam",
                () -> assertEquals(team.getCode(), newTeam.getCode()),
                () -> assertEquals(team.getName(), newTeam.getName()),
                () -> assertEquals(team.getDateOfFundation(), newTeam.getDateOfFundation()),
                () -> assertEquals(team.getAddress(), newTeam.getAddress()),
                () -> assertEquals(team.getAddressNumber(), newTeam.getAddressNumber()),
                () -> assertEquals(team.getCep(), newTeam.getCep()),
                () -> assertEquals(team.getCity(), newTeam.getCity()),
                () -> assertEquals(team.getState(), newTeam.getState()),
                () -> assertArrayEquals(team.getPhones(), newTeam.getPhones()),
                () -> assertArrayEquals(team.getFounders(), newTeam.getFounders())
        );
    }

    @DisplayName("[TEAM] Update")
    @Order(2)
    @Test
    void update() {
        Team oldTeam = new Team(
            1,
            "Timezão",
            LocalDate.parse("11/05/1996", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
            "Avenida do tal, jardim nova escócia, 987",
            "80",
            "15789884",
            "São Paulo",
            "SP",
            new String[]{"3356-5236","98854-6325"},
            new String[]{"Gilberto Brutus"}
    );
        teamDAO.insert(oldTeam);

        Team newTeam = new Team(
            1,
            "São Paulos",
            LocalDate.parse("11/05/1996", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
            "Avenida São Paulo, jardim nova escócia, 987",
            "80",
            "15789884",
            "São Paulo",
            "SP",
            new String[]{"3356-5236","98854-6325"},
            new String[]{"Gilberto Brutus"}
    );
        assertTrue(teamDAO.update(newTeam));

        Team updatedTeam = teamDAO.getTeam(1);

        assertAll("updateTeam",
                () -> assertEquals(newTeam.getCode(), updatedTeam.getCode()),
                () -> assertEquals(newTeam.getName(), updatedTeam.getName()),
                () -> assertEquals(newTeam.getDateOfFundation(), updatedTeam.getDateOfFundation()),
                () -> assertEquals(newTeam.getAddress(), updatedTeam.getAddress()),
                () -> assertEquals(newTeam.getAddressNumber(), updatedTeam.getAddressNumber()),
                () -> assertEquals(newTeam.getCep(), updatedTeam.getCep()),
                () -> assertEquals(newTeam.getCity(), updatedTeam.getCity()),
                () -> assertEquals(newTeam.getState(), updatedTeam.getState()),
                () -> assertArrayEquals(newTeam.getPhones(), updatedTeam.getPhones()),
                () -> assertArrayEquals(newTeam.getFounders(), neupdatedTeamwTeam.getFounders())
        );
    }

    @DisplayName("[TEAM] Delete")
    @Order(3)
    @Test
    void delete() {
        Team team = new Team(
            1,
            "São Paulos",
            LocalDate.parse("11/05/1996", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
            "Avenida São Paulo, jardim nova escócia, 987",
            "80",
            "15789884",
            "São Paulo",
            "SP",
            new String[]{"3356-5236","98854-6325"},
            new String[]{"Gilberto Brutus"}
        );
        teamDAO.insert(team);
        assertTrue(teamDAO.delete(1));

        Team deletedTeam = teamDAO.getTeam(1);
        assertNull(deletedTeam);
    }

    @DisplayName("[TEAM] getTeams")
    @Order(5)
    @Test
    void getPlayers() {
        Team team1 = new Team(
            1,
            "São Paulos",
            LocalDate.parse("11/05/1996", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
            "Avenida São Paulo, jardim nova escócia, 987",
            "80",
            "15789884",
            "São Paulo",
            "SP",
            new String[]{"3356-5236","98854-6325"},
            new String[]{"Gilberto Brutus"}
        );
        Team team2 = new Team(
            2,
            "São Paulos",
            LocalDate.parse("11/05/1996", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
            "Avenida São Paulo, jardim nova escócia, 987",
            "80",
            "15789884",
            "São Paulo",
            "SP",
            new String[]{"3356-5236","98854-6325"},
            new String[]{"Gilberto Brutus"}
        );
        Map<String,Team> teamsList = new HashMap<>();
        teamsList.put(1, team1);
        teamsList.put(2, team2);

        teamDAO.insert(team1);
        teamDAO.insert(team2);
        assertIterableEquals(teamsList.values(),teamDAO.getTeams());
    }

    @DisplayName("[TEAM] getTeam")
    @Order(5)
    @Test
    void getPlayer() {
        Team team = new Team(
            1,
            "São Paulos",
            LocalDate.parse("11/05/1996", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
            "Avenida São Paulo, jardim nova escócia, 987",
            "80",
            "15789884",
            "São Paulo",
            "SP",
            new String[]{"3356-5236","98854-6325"},
            new String[]{"Gilberto Brutus"}
        );
        teamDAO.insert(team);
        Team addedTeam = teamDAO.getTeam(1);

        assertAll("getTeam",
                () -> assertEquals(team.getCode(), addedTeam.getCode()),
                () -> assertEquals(team.getName(), addedTeam.getName()),
                () -> assertEquals(team.getDateOfFundation(), addedTeam.getDateOfFundation()),
                () -> assertEquals(team.getAddress(), addedTeam.getAddress()),
                () -> assertEquals(team.getAddressNumber(), addedTeam.getAddressNumber()),
                () -> assertEquals(team.getCep(), addedTeam.getCep()),
                () -> assertEquals(team.getCity(), addedTeam.getCity()),
                () -> assertEquals(team.getState(), addedTeam.getState()),
                () -> assertArrayEquals(team.getPhones(), addedTeam.getPhones()),
                () -> assertArrayEquals(team.getFounders(), addedTeam.getFounders())
        );
    }
}
