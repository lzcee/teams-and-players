package view;

import br.com.caelum.stella.format.CPFFormatter;
import br.com.caelum.stella.format.Formatter;
import br.com.caelum.stella.validation.CPFValidator;
import dao.PlayerDAO;
import model.Player;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PlayerView {

    Scanner read = new Scanner(System.in);

    private Boolean validateCpf(String cpf){
        CPFValidator cpfValidator = new CPFValidator();
        try {
            cpfValidator.assertValid(cpf);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

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

    private void insertCpf(Player player) {
        Formatter formatter = new CPFFormatter();
        Boolean notValid = true;

        System.out.println("Cpf:");
        while (notValid) {
            String cpf = read.next();
            if (validateCpf(cpf)) {
                String cpfFormatted = formatter.unformat(cpf);
                player.setCpf(cpfFormatted);
                notValid = false;
            }
        }
    }

    private void insertName(Player player) {
        Boolean notValid = true;

        System.out.println("Name:");
        while (notValid) {
            String name = read.next();
            if (!name.equals("")) {
                player.setName(name);
                notValid = false;
            }
        }
    }

    private void insertDateOfBirth(Player player) {
        Boolean notValid = true;

        System.out.println("Date of Birth:");
        while (notValid) {
            String dateOfBirth = read.next();
            if (validateDate(dateOfBirth)) {
                player.setDateOfBirth(LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                notValid = false;
            }
        }
    }

    private void insertGender(Player player) {
        Boolean notValid = true;

        System.out.println("Gender:");
        while (notValid) {
            System.out.println("1. Male:");
            System.out.println("2. Female:");
            int gender = read.nextInt();
            switch (gender) {
                case 1:
                    player.setGender("male");
                    notValid = false;
                    break;
                case 2:
                    player.setGender("female");
                    notValid = false;
                    break;
            }
        }
    }

    private void insertWeight(Player player) {
        Boolean notValid = true;

        System.out.println("Weight:");
        while (notValid) {
            Double weight = read.nextDouble();
            if(weight >  0) {
                player.setWeight(weight);
                notValid = false;
            }
        }
    }

    private void insertHeight(Player player) {
        Boolean notValid = true;

        System.out.println("Height:");
        while (notValid) {
            Double height = read.nextDouble();
            if(height >  0) {
                player.setWeight(height);
                notValid = false;
            }
        }
    }

    private void insertEmails(Player player) {
        Boolean notValid = true;

        System.out.println("Emails: (comma-separated)");
        while (notValid) {
            String emails = read.nextLine();
            if(!emails.equals("")) {
                String[] emailsList = emails.split(",");
                player.setEmails(emailsList);
                notValid = false;
            }
        }
    }

    private void insertPhones(Player player) {
        Boolean notValid = true;

        System.out.println("Phones: (comma-separated)");
        while (notValid) {
            String phones = read.nextLine();
            if(!phones.equals("")) {
                String[] phonesList = phones.split(",");
                player.setPhones(phonesList);
                notValid = false;
            }
        }
    }

    private void insertFounders(Player player) {
        Boolean notValid = true;

        System.out.println("Positions: (comma-separated)");
        while (notValid) {
            String positions = read.nextLine();
            if(!positions.equals("")) {
                String[] positionsList = positions.split(",");
                player.setPositions(positionsList);
                notValid = false;
            }
        }
    }

    public void AddPlayer(PlayerDAO playerDAO) {
        Player player = new Player();

        System.out.println("====== ADD ======");
        insertCpf(player);
        insertName(player);
        insertDateOfBirth(player);
        insertGender(player);
        insertWeight(player);
        insertHeight(player);
        insertEmails(player);
        insertPhones(player);
        insertFounders(player);

        Boolean addPlayer = playerDAO.insert(player);
        if (addPlayer) {
            System.out.println("Player added.");
        } else {
            System.out.println("Player already exists.");
        };
    }

    public void ListAllPlayers(PlayerDAO playerDAO) {
        Collection<Player> players  = playerDAO.getPlayers();
        Iterator<Player> iterator = players.iterator();

        System.out.println("====== LIST ALL ======");
        if(iterator.hasNext()) {
            while (iterator.hasNext()) {
                System.out.println(iterator.next().toString());
            }
        } else {
            System.out.println("No players found.");
        }
    }

    public void ListOnePlayers(PlayerDAO playerDAO) {
        Player player = new Player();

        System.out.println("====== LIST ONE ======");
        insertCpf(player);
        player = playerDAO.getPlayer(player.getCpf());
        if (player != null) {
            System.out.println(player.toString());
        } else {
            System.out.println("Player not found.");
        }
    }

    public void UpdatePlayer(PlayerDAO playerDAO) {
        Player player = new Player();

        System.out.println("===== UPDATE =====");
        insertCpf(player);
        insertName(player);
        insertDateOfBirth(player);
        insertGender(player);
        insertWeight(player);
        insertHeight(player);
        insertEmails(player);
        insertPhones(player);
        insertFounders(player);

        Boolean addPlayer = playerDAO.update(player);
        if (addPlayer) {
            System.out.println("Player updated.");
            player.toString();
        } else {
            System.out.println("Player not found.");
        };
    }

    public void DeletePlayer(PlayerDAO playerDAO) {
        Player player = new Player();

        System.out.println("===== DELETE =====");
        insertCpf(player);
        Boolean deleted = playerDAO.delete(player.getCpf());
        if (deleted) {
            System.out.println("Player  deleted.");
        } else {
            System.out.println("Player not found.");
        }
    }
}
