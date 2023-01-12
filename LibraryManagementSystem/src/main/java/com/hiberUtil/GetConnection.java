package com.hiberUtil;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.entity.Book;
import com.entity.Login;
import com.entity.Registration;

public class GetConnection {

	public static SessionFactory sf;

	public static SessionFactory con() {

		Configuration cfg = new Configuration();

		Properties pr = new Properties();
		pr.put(Environment.USER, "root");
		pr.put(Environment.PASS, "730270");
		pr.put(Environment.URL, "jdbc:mysql://localhost:3306/LibraryManagement");
		pr.put(Environment.HBM2DDL_AUTO, "create");

		cfg.setProperties(pr);
		cfg.addAnnotatedClass(Book.class);
		cfg.addAnnotatedClass(Registration.class);
		cfg.addAnnotatedClass(Login.class);

		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();

		sf = cfg.buildSessionFactory(sr);

		return sf;
	}
}
