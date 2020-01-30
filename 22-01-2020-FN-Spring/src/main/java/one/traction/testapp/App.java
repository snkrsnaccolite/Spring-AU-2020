package one.traction.testapp;

import java.util.*;
import one.traction.models.*;
import one.traction.services.*;
import one.traction.config.AppConfig;
import org.springframework.context.*;
import org.springframework.context.support.*;
import org.springframework.context.annotation.*;

public class App {
    Map<Integer, Employee> maps = new HashMap<Integer, Employee>();

    public static void main( String[] args ) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        EmployeeManager manager = context.getBean(EmployeeManager.class);

        HashMap<Integer, Employee> emps = manager.getAllEmployees();
        for (Employee e : emps.values()) {
            System.out.println(e.getName());
        }

        ApplicationContext pointContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Point point =(Point) pointContext.getBean("point");
        System.out.println("X: " + point.getX() + "\tY: " + point.getY());
    }
}
