package DAO.jdbc;

import Entitu.MaterialEntity;
import DAO.DAO;

import java.util.Scanner;

public class MaterialCommand extends CrudCommand<MaterialEntity, Integer> {
    private Scanner scanner;

    public MaterialCommand(DAO<MaterialEntity, Integer> dao, Scanner scanner) {
        super(dao, MaterialEntity.class);
        this.scanner = scanner;
    }

    @Override
    protected void readEntity(MaterialEntity material) {
        System.out.print("\tname: ");
        if (scanner.hasNext()) {
            String name = scanner.nextLine();
            material.setName(name);
        }
    }

    @Override
    protected Integer convertId(String id) {
        return Integer.parseInt(id);
    }

    @Override
    protected void print(MaterialEntity m) {
        System.out.println(String.format("\tMaterial { id: %d, name: %s }", m.getId(), m.getName()));
    }
}
