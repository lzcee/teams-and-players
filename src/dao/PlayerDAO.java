package dao;

import model.Player;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class PlayerDAO {
    private Map<String, Player> players;

    public PlayerDAO() {
        players = new HashMap<>();
    }

    public Boolean insert(Player player) {
        if (players.containsKey(player.getCpf())) {
            return false;
        } else {
            players.put(player.getCpf(),player);
            return true;
        }
    }

    public Boolean update(Player player) {
        if (players.containsKey(player.getCpf())) {
            players.replace(player.getCpf(),player);
            return true;
        } else {
            return false;
        }
    }

    public Boolean delete(String cpf) {
        if (players.containsKey(cpf)) {
            players.remove(cpf);
            return true;
        } else {
            return false;
        }
    }

    public Collection<Player> getPlayers() {
        return players.values();
    }

    public Player getPlayer(String cpf) {
        return players.get(cpf);
    }
}
