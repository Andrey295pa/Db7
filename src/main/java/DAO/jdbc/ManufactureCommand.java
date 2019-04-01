package DAO.jdbc;

import Entitu.ManufactureEntity;

import java.util.Scanner;
import  DAO.DAO;

public class ManufactureCommand extends CrudCommand<ManufactureEntity, Integer> {
    private Scanner scanner;

    public ManufactureCommand(DAO<ManufactureEntity, Integer> dao, Scanner scanner) {
        super(dao, ManufactureEntity.class);
        this.scanner = scanner;
    }

    @Override
    protected void readEntity(ManufactureEntity manufacture) {
        System.out.print("\tname: ");
        if (scanner.hasNext()) {
            String name = scanner.nextLine();
            manufacture.setName(name);
        }
    }

    @Override
    protected Integer convertId(String id) {
        return Integer.parseInt(id);
    }

    @Override
    protected void print(ManufactureEntity manufacture) {
        System.out.println(String.format("\tManufacture { id: %d, name: %s }",
                manufacture.getId(), manufacture.getName()));
    }
}
