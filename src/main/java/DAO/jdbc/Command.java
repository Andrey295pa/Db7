package DAO.jdbc;

import DAO.DAO;

public interface Command {
    void parse(String[] args);

    void execute();

}
