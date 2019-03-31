package DAO;

public interface Command {
    void parse(String[] args);

    void execute();

}
