package view;
import dao.TeamDAO;
import model.Team;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class TeamView {

    Scanner read = new Scanner(System.in);

    private Boolean validateDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate.parse(date,formatter);
            return true;
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            return false;
        }
    }


    private void insertName(Team team) {
        Boolean notValid = true;

        System.out.println("Name:");
        while (notValid) {
            String name = read.next();
            if (!name.equals("")) {
                team.setName(name);
                notValid = false;
            }
        }
    }

    private void insertDateOfFundation(Team team) {
        Boolean notValid = true;

        System.out.println("Date of Fundation:");
        while (notValid) {
            String dateOfFundation = read.next();
            if (validateDate(dateOfFundation)) {
                team.setDateOfFundation(LocalDate.parse(dateOfFundation, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                notValid = false;
            }
        }
    }

    private void insertCode(Team team) {
        Boolean notValid = true;

        System.out.println("Code:");
        while (notValid) {
            int code = read.nextInt();
            team.setCode(code);
            notValid = false;
        }
    }

    private void insertAddress(Team team) {
        Boolean notValid = true;

        System.out.println("Address:");
        while (notValid) {
            String address = read.next();
            if (!address.equals("")) {
                team.setAddress(address);
                notValid = false;
            }
        }
    }

    private void insertAddressNumber(Team team) {
        Boolean notValid = true;

        System.out.println("Address Number:");
        while (notValid) {
            String addressNumber = read.next();
            if (!addressNumber.equals("")) {
                team.setAddressNumber(addressNumber);
                notValid = false;
            }
        }
    }

    private void insertCep(Team team) {
        Boolean notValid = true;

        System.out.println("CEP:");
        while (notValid) {
            String cep = read.next();
            if (!cep.equals("") && cep.length() == 8) {
                team.setCep(cep);
                notValid = false;
            }
        }
    }

    private void insertCity(Team team) {
        Boolean notValid = true;

        System.out.println("City:");
        while (notValid) {
            String city = read.next();
            if (!city.equals("")) {
                team.setCity(city);
                notValid = false;
            }
        }
    }

    private void insertPhones(Team team) {
        Boolean notValid = true;

        System.out.println("Phones: (comma-separated)");
        while (notValid) {
            String phones = read.nextLine();
            if(!phones.equals("")) {
                String[] phonesList = phones.split(",");
                team.setPhones(phonesList);
                notValid = false;
            }
        }
    }

    private void insertFounders(Team team) {
        Boolean notValid = true;

        System.out.println("Founders: (comma-separated)");
        while (notValid) {
            String positions = read.nextLine();
            if(!positions.equals("")) {
                String[] positionsList = positions.split(",");
                team.setFounders(positionsList);
                notValid = false;
            }
        }
    }

    private void insertState(Team team) {
        Boolean notValid = true;

        System.out.println("State:");
        while (notValid) {
            String state = read.next();
            if (!state.equals("")) {
                team.setState(state);
                notValid = false;
            }
        }
    }

    public void addTeam(TeamDAO teamDAO) {
        Team team = new Team();

        System.out.println("====== ADD ======");
        insertCode(team);
        insertName(team);
        insertDateOfFundation(team);
        insertAddress(team);
        insertAddressNumber(team);
        insertCep(team);
        insertCity(team);
        insertState(team);
        insertPhones(team);
        insertFounders(team);

        Boolean addTeam = TeamDAO.insert(team);
        if (addTeam) {
            System.out.println("Team added.");
        } else {
            System.out.println("Team already exists.");
        };
    }

    public void listAllTeams(TeamDAO teamDAO) {
        Collection<Team> teams  = teamDAO.getTeams();
        Iterator<Team> iterator = teams.iterator();

        System.out.println("====== LIST ALL ======");
        if(iterator.hasNext()) {
            while (iterator.hasNext()) {
                System.out.println(iterator.next().toString());
            }
        } else {
            System.out.println("No teams found.");
        }
    }

    public void listOneTeam(TeamDAO teamDAO) {
        Team team = new Team();

        System.out.println("====== LIST ONE ======");
        insertCode(team);
        team = teamDAO.getTeam(team.getCode());
        if (team != null) {
            System.out.println(team.toString());
        } else {
            System.out.println("Team not found.");
        }
    }

    public void updateTeam(TeamDAO DAO) {
        Team team = new Team();

        System.out.println("===== UPDATE =====");
        insertCode(team);
        insertName(team);
        insertDateOfFundation(team);
        insertAddress(team);
        insertAddressNumber(team);
        insertCep(team);
        insertCity(team);
        insertState(team);
        insertPhones(team);
        insertFounders(team);

        Boolean addTeam = TeamDAO.update(team);
        if (addTeam) {
            System.out.println("Team updated.");
            team.toString();
        } else {
            System.out.println("Team not found.");
        };
    }

    public void deleteTeam(TeamDAO TeamDAO) {
        Team team = new Team();

        System.out.println("===== DELETE =====");
        insertCode(team);
        Boolean deleted = TeamDAO.delete(team.getCode());
        if (deleted) {
            System.out.println("Team  deleted.");
        } else {
            System.out.println("Team not found.");
        }
    }
}
