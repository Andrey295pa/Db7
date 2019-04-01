package Entitu;


import DAO.jdbc.*;
import DAO.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Configuration
@Import(SpringConfig1.class)
public class SpringConfig1 {
    @Autowired
    DAO<TypeEntity, Integer> typeDao;

    @Autowired
    DAO<SocksEntity, Integer> socksDao;

    @Autowired
    DAO<MaterialEntity, Integer> materialDao;

    @Autowired
    DAO<ManufactureEntity, Integer> manufactureDao;

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

    @Bean
    public CrudCommand<TypeEntity, Integer> typeCommand() {
        return new TypeCommand(typeDao, scanner());
    }

    @Bean
    public CrudCommand<ManufactureEntity, Integer> manufactureCommand() {
        return new ManufactureCommand(manufactureDao, scanner());
    }

//    @Bean
//    public CrudCommand<SocksEntity, Integer> socksCommand() {
//        return new SocksCommand(socksDao, typeDao, materialDao, manufactureDao, scanner());
//    }
//
    @Bean
    public CrudCommand<MaterialEntity, Integer> materialCommand() {
        return new MaterialCommand(materialDao, scanner());
    }

    @Bean(name = "commands")
    public Map<String, Command> commands() {
        Map<String, Command> commands = new HashMap<>();

        commands.put("type", typeCommand());
       // commands.put("socks", socksCommand());
        commands.put("material", materialCommand());
        commands.put("manufacture", manufactureCommand());

        return commands;
    }
}
