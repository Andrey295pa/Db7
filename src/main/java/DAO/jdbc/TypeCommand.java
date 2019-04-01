package DAO.jdbc;

import DAO.DAO;
import DAO.jdbc.CrudCommand;
import Entitu.TypeEntity;

import java.util.Scanner;

public class TypeCommand extends CrudCommand<TypeEntity, Integer> {
    private Scanner scanner;

    public TypeCommand(DAO<TypeEntity, Integer> dao, Scanner scanner) {
        super(dao, TypeEntity.class);
        this.scanner = scanner;
    }

    @Override
    protected void readEntity(TypeEntity type) {
        System.out.print("\tname: ");
        if (scanner.hasNext()) {
            String name = scanner.nextLine();
            type.setName(name);
        }
    }

    @Override
    protected Integer convertId(String id) {
        return Integer.parseInt(id);
    }

    @Override
    protected void print(TypeEntity m) {
        System.out.println(String.format("\tType { id: %d, name: %s }", m.getId(), m.getName()));
    }
}

