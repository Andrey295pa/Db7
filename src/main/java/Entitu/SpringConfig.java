package Entitu;

import DAO.DAO;
import DAO.hbm.*;
import Entitu.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class SpringConfig {

    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("dialect", "org.hibernate.dialect.SQLiteDialect");
        hibernateProperties.setProperty("connection.pool_size", "1");
        hibernateProperties.setProperty("show_sql", "true");
        hibernateProperties.setProperty("format_sql", "true");
        hibernateProperties.setProperty("hibernate.jdbc.batch_size", "30");

        return hibernateProperties;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new HibernateTransactionManager(sessionFactory);
    }

    @Bean
    public DriverManagerDataSource configurableDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUrl("jdbc:sqlite:Socks.db");
        return dataSource;
    }

    @Bean
    public DataSource dataSource() {
        return configurableDataSource();
    }

    @Bean (name="localSessionFactoryBean")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setHibernateProperties(hibernateProperties());
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setAnnotatedClasses(
                ManufactureEntity.class,
                MaterialEntity.class,
                TypeEntity.class,
                SocksEntity.class,
                SocksMaterialEntity.class);
        return sessionFactory;
    }

    SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory factory) {
        this.sessionFactory = factory;
    }

//    @Bean
//    public DAO<TypeEntity, Integer> typeDao() {
//        return new TypeDao(sessionFactory);
//    }

    @Bean
    public DAO<TypeEntity,Integer>typeDao(){
        return new TypeDao(sessionFactory);
    }

    @Bean
    public DAO<MaterialEntity, Integer> materialDao() {
        return new MaterialDao(sessionFactory);
    }

    @Bean
    public DAO<ManufactureEntity, Integer> manufactureDao() {
        return new ManufactureDao(sessionFactory);
    }

//    @Bean
//    public DAO<SocksEntity, Integer> socksDao() {
//        return new SocksDao(sessionFactory);
//    }
}
