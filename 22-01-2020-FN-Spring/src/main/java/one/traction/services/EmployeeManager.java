package one.traction.services;

import java.util.*;
// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import one.traction.models.*;

@Service
public class EmployeeManager {
    private HashMap<Integer, Employee> employees = new HashMap<Integer, Employee>();

    public EmployeeManager(HashMap<Integer, Employee> emps) {
        this.employees = emps;
    }

    public HashMap<Integer, Employee> getAllEmployees() {
        return this.employees;
    }
}
