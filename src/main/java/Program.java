import org.springframework.context.ApplicationContext;

import DAO.jdbc.Command;
import org.apache.tools.ant.types.Commandline;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Map;
import java.util.Scanner;

public class Program {

    static Map<String, Command> commands;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Entitu.SpringConfig1.class);
        commands = (Map<String, Command>)context.getBean("commands");
        Scanner scanner = context.getBean(Scanner.class);

        greetUser();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            parseUserInput(line);
            greetUser();
        }
    }

    private static void parseUserInput(String input) {
        String userCommand[] = Commandline.translateCommandline(input);

        String commandName = userCommand[0];
        String[] params = new String[userCommand.length - 1];
        System.arraycopy(userCommand, 1, params, 0, params.length);

        try {
            executeCommand(commandName, params);
        }
       // catch (CommandFormatException e) {
        catch (Exception e){
            System.out.println(String.format("%s has some invalid arguments", commandName));
        }
//        catch (NotImplementedException e) {
//            System.out.println(String.format("Unknown command %s", commandName));
//        }
    }

    private static void executeCommand(String commandName, String[] params) {
        Command command = commands.get(commandName);

        if (null == command)
            throw new NotImplementedException();

        command.parse(params);
        command.execute();
    }

    private static void greetUser() {
        System.out.print("courses-jdbc>");
    }

//    public static void main(String[] args) {
//        System.out.println("Hello71");
////
////       SessionFactory sessions = new Configuration().configure().buildSessionFactory();
////        Session session = sessions.openSession();
//
////        session.beginTransaction();
////        TypeEntity typeEntity = new TypeEntity();
////        typeEntity.setName("Light");
////        session.save(typeEntity);
////        session.getTransaction().commit();
//
////        session.beginTransaction();
////        List<TypeEntity> list = session.createCriteria(TypeEntity.class).list();
//
//
//
////        List<Object[]> entities = session.createSQLQuery("select * from Type ").list();
////
////
////        for (Object[] entity : entities) {
////            for (Object entityCol : entity) {
////                System.out.print(" " + entityCol);
////            }
////            System.out.println("");
////        }
////
////       session.getTransaction().commit();
////
////       session.getTransaction().begin();
////       TypeEntity first=session.get(TypeEntity.class,6);
////      // first.setName("Cool");
////       // session.delete(first);
////       session.getTransaction().commit();
////       System.out.println(first.getId()+" "+ first.getName()+"вывод 5-того ");
////
////        for (TypeEntity ty: list) {
////            System.out.println(ty.getId()+" "+ty.getName());
////        }
////
////        session.close();
////        sessions.close();
//
////
//        System.out.println("Hello72");
////
////        MyTypeCommand typeCommand= new MyTypeCommand();
////        typeCommand.readAll();
//
//       // MySessionFactory.getSession().getTransaction().begin();
//
//
//    }

}
