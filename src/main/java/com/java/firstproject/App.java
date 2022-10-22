package com.java.firstproject;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "First Project" );
        Configuration cfgConfiguration=new Configuration();
        cfgConfiguration.configure(); 
        SessionFactory sessionFactory=cfgConfiguration.buildSessionFactory();
        System.out.println(sessionFactory);
        System.out.println(sessionFactory.isClosed());
        
        
        Student student=new Student();
        student.setId(0);
        student.setName("Mohan");
        student.setCity("Saharsa");
        System.out.print(student);
        
        Session currentSession = sessionFactory.openSession();
        
        Transaction beginTransaction = currentSession.beginTransaction();
        currentSession.save(student);
        
        beginTransaction.commit();
        
        
        currentSession.close();
        
    }
}
