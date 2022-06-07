package Fashion.config;
//package Fashion.config;
//
//import java.util.Properties;
//
//import org.hibernate.SessionFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.hibernate5.HibernateTemplate;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import Fashion.Model.Category;
//import Fashion.Model.Product;
//import Fashion.Model.Supplier;
//import Fashion.Model.User;
//
//
//@Configuration
//@EnableTransactionManagement
//@ComponentScan("Fashion")
//public class DBConfig {
//
//	@Bean(name="dataSource")
//	public DriverManagerDataSource getDataSource() {
//		
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/fashion");
//		dataSource.setUsername("root");
//		dataSource.setPassword("milandai");
//		return dataSource;
//		
//	}
//	
//	@Bean(name="sessionFactory")
//	public SessionFactory getSessionFactory() {
//		
//		Properties hibernateProp =  new Properties();
//		hibernateProp.put("hibernate.hbm2ddl.auto","update");
//		hibernateProp.put("hibernate.dialect","org.hibernate.dialect.MySQL57Dialect");
//		hibernateProp.put("hibernate.show_sql","true");
//		LocalSessionFactoryBuilder localFactory = new LocalSessionFactoryBuilder(getDataSource());
//		localFactory.addProperties(hibernateProp);
//		localFactory.addAnnotatedClass(Category.class);
//		localFactory.addAnnotatedClass(Product.class);
//		localFactory.addAnnotatedClass(Supplier.class);
//		localFactory.addAnnotatedClass(User.class);
//		return localFactory.buildSessionFactory();
//	}
//	
//	@Bean(name="hibernateTemplate")
//	public HibernateTemplate htemplate() {
//		HibernateTemplate template = new HibernateTemplate(getSessionFactory());
//		return template;
//	}	
//	
//	@Bean(name="txManager")
//	public HibernateTransactionManager txManager(SessionFactory sessionFactory) {
//		return new HibernateTransactionManager(sessionFactory);
//	}
//}
