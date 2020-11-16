package dao;

import model.Team;

import java.util.*;


public class TeamDAO {
    private static Map<Integer, Team> teams;

    public TeamDAO() {
        teams = new HashMap<>();
    }

    public static Boolean insert(Team team) {
        if (teams.containsKey(team.getCode())) {
            return false;
        } else {
            teams.put(team.getCode(),team);
            return true;
        }
    }

    public static Boolean update(Team team) {
        if (teams.containsKey(team.getCode())) {
            teams.replace(team.getCode(),team);
            return true;
        } else {
            return false;
        }
    }

    public Boolean delete(Integer code) {
        if (teams.containsKey(code)) {
            teams.remove(code);
            return true;
        } else {
            return false;
        }
    }

    public Collection<Team> getTeams() {
        return teams.values();
    }

    public Team getTeam(Integer code) {
        return teams.get(code);
    }
}
