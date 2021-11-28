import javax.swing.*;
import java.awt.color.CMMException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Company {
    private ArrayList<Manager> managers = new ArrayList<>();
    private ArrayList<Operator> operators = new ArrayList<>();
    private ArrayList<TopManager> topManagers = new ArrayList<>();
    private Integer managerSalary = 100000;
    private Integer topManagerSalary = 150000;
    private Integer operatorSalary = 90000;
    private Integer incomeOfCompany = 9000000;

    public void hire(String position) {
        Random random = new Random();
        switch (position.toLowerCase()) {
            case "manager" -> {
                Manager employee = new Manager();
                Employee.employeeID = Employee.employeeID + 1;
                employee.setIncomeToCompany(random.nextInt(115000, 140000));
                employee.setAge(random.nextInt(18, 60));
                employee.setMonthlySalary((int) (random.nextInt(this.managerSalary, this.topManagerSalary) + employee.getIncomeToCompany() * employee.getPercent()));
                this.managers.add(employee);
                this.setIncomeOfCompany(employee.getIncomeToCompany());
                break;
            }
            case "operator" -> {
                Operator employee = new Operator();
                Employee.employeeID = Employee.employeeID + 1;
                employee.setMonthlySalary(random.nextInt(this.operatorSalary, this.managerSalary));
                employee.setAge(random.nextInt(18, 60));
                this.operators.add(employee);
                break;
            }
            case "topmanager" -> {
                TopManager employee = new TopManager();
                Employee.employeeID = Employee.employeeID + 1;
                employee.setMonthlySalary(random.nextInt(this.topManagerSalary, 100 * this.topManagerSalary));
                employee.setAge(random.nextInt(18, 60));
                employee.setMonthlySalary((int) (employee.getMonthlySalary() + (this.incomeOfCompany > employee.getBonusIncome() ? employee.getMonthlySalary() : 0) * employee.getPercent()));
                this.topManagers.add(employee);
                break;
            }
        }
    }

    public void hireAll(String position, Integer amount) {
        for (int i = 0; i < amount; i++) {
            hire(position);
        }
    }

    private void setIncomeOfCompany(Integer addition) {
        this.incomeOfCompany += addition;
    }

    public int getIncome() {
        return this.incomeOfCompany;
    }

    public void printEmployees() {
        if (managers.size() == 0 && operators.size() == 0 && topManagers.size() == 0) {
            System.out.println("Not Found employees");
        }

        this.printTopManagers();
        this.printManagers();
        this.printOperator();
    }

    public void printManagers() {
        if (this.managers.size() == 0) {
            System.out.println("Not found Managers");
        }

        AtomicInteger index = new AtomicInteger(1);
        System.out.println("Managers: ");
        this.managers.forEach(manager -> {
            System.out.println("Index " + index);
            System.out.println("Full Name: " + manager.getFullName());
            System.out.println("Age: " + manager.getAge());
            System.out.println("Salary: " + manager.getMonthlySalary());
            System.out.println("Income to Company: " + manager.getIncomeToCompany());
            System.out.println("\n");
            index.addAndGet(1);
        });
    }

    public void printTopManagers() {
        if (this.topManagers.size() == 0) {
            System.out.println("Not found Top Managers");
        }

        AtomicInteger index = new AtomicInteger(1);
        System.out.println("Top Managers: ");
        this.topManagers.forEach(manager -> {
            System.out.println("Index " + index);
            System.out.println("Full Name: " + manager.getFullName());
            System.out.println("Age: " + manager.getAge());
            System.out.println("Salary: " + manager.getMonthlySalary());
            System.out.println("\n");
            index.addAndGet(1);
        });
    }

    public void printOperator() {
        if (this.operators.size() == 0) {
            System.out.println("Not found Operators");
        }

        AtomicInteger index = new AtomicInteger(1);
        System.out.println("Operators: ");
        this.operators.forEach(manager -> {
            System.out.println("Index " + index);
            System.out.println("Full Name: " + manager.getFullName());
            System.out.println("Age: " + manager.getAge());
            System.out.println("Salary: " + manager.getMonthlySalary());
            System.out.println("\n");
            index.addAndGet(1);
        });
    }

    public void fire(String position, Integer index) {
        switch (position.toLowerCase()) {
            case "manager" -> this.managers.remove(index);
            case "topmanager" -> this.topManagers.remove(index );
            case "operators" -> this.operators.remove(index );
        }
    }

    public ArrayList<Manager> sortManagerTop() {
        ArrayList<Manager> newManager;
        newManager = this.managers;
        Collections.sort(newManager, new Comparator<Manager>() {
            public int compare(Manager c1, Manager c2) {
                return Integer.compare(c2.getMonthlySalary(), c1.getMonthlySalary());
            }
        });

        return newManager;
    }

    public ArrayList<Manager> sortManagerLowest() {
        ArrayList<Manager> newManager;
        newManager = this.managers;
        Collections.sort(newManager, new Comparator<Manager>() {
            public int compare(Manager c1, Manager c2) {
                return Integer.compare(c2.getMonthlySalary(), c1.getMonthlySalary());
            }
        });

        Collections.reverse(newManager);
        return newManager;
    }

    public ArrayList<TopManager> sortTopManagerTop() {
        ArrayList<TopManager> newManager;
        newManager = this.topManagers;
        Collections.sort(newManager, new Comparator<TopManager>() {
            public int compare(TopManager c1, TopManager c2) {
                return Integer.compare(c2.getMonthlySalary(), c1.getMonthlySalary());
            }
        });

        return newManager;
    }

    public ArrayList<TopManager> sortTopManagerLowest() {
        ArrayList<TopManager> newManager;
        newManager = this.topManagers;
        Collections.sort(newManager, new Comparator<TopManager>() {
            public int compare(TopManager c1, TopManager c2) {
                return Integer.compare(c2.getMonthlySalary(), c1.getMonthlySalary());
            }
        });

        Collections.reverse(newManager);
        return newManager;
    }

    public ArrayList<Operator> sortOperatorLowest() {
        ArrayList<Operator> newManager;
        newManager = this.operators;
        Collections.sort(newManager, new Comparator<Operator>() {
            public int compare(Operator c1, Operator c2) {
                return Integer.compare(c2.getMonthlySalary(), c1.getMonthlySalary());
            }
        });

        Collections.reverse(newManager);
        return newManager;
    }


    public ArrayList<Operator> sortOperatorTop() {
        ArrayList<Operator> newManager;
        newManager = this.operators;
        Collections.sort(newManager, new Comparator<Operator>() {
            public int compare(Operator c1, Operator c2) {
                return Integer.compare(c2.getMonthlySalary(), c1.getMonthlySalary());
            }
        });

        return newManager;
    }


    public void printStuffLowestSalary(int count) {
        ArrayList<Manager> sortedManagers = (ArrayList<Manager>) this.sortManagerLowest().clone();
        ArrayList<TopManager> sortedTopManagers = (ArrayList<TopManager>) this.sortTopManagerLowest().clone();
        ArrayList<Operator> sortedOperators = (ArrayList<Operator>) this.sortOperatorLowest().clone();
        ArrayList<Integer> salary = new ArrayList<>();
        sortedOperators.forEach(operator -> salary.add(operator.getMonthlySalary()));
        sortedManagers.forEach(operator -> salary.add(operator.getMonthlySalary()));
        sortedTopManagers.forEach(topManager -> salary.add(topManager.getMonthlySalary()));
        Collections.sort(salary, new Comparator<Integer>() {
            public int compare(Integer c1, Integer c2) {
                return Integer.compare(c2, c1);
            }
        });

        Collections.reverse(salary);
        for (int i = 0; i < count; i++) {
            System.out.println(salary.get(0) + " руб");
            salary.remove(0);
        }
    }

    public void printStuffTopSalary(int count) {
        ArrayList<Manager> sortedManagers = (ArrayList<Manager>) this.sortManagerTop().clone();
        ArrayList<TopManager> sortedTopManagers = (ArrayList<TopManager>) this.sortTopManagerTop().clone();
        ArrayList<Operator> sortedOperators = (ArrayList<Operator>) this.sortOperatorTop().clone();

        ArrayList<Integer> salary = new ArrayList<>();
        sortedOperators.forEach(operator -> salary.add(operator.getMonthlySalary()));
        sortedManagers.forEach(operator -> salary.add(operator.getMonthlySalary()));
        sortedTopManagers.forEach(topManager -> salary.add(topManager.getMonthlySalary()));
        Collections.sort(salary, new Comparator<Integer>() {
            public int compare(Integer c1, Integer c2) {
                return Integer.compare(c2, c1);
            }
        });
        for (int i = 0; i < count; i++) {
            System.out.println(salary.get(0) + " руб");
            salary.remove(0);
        }
    }

    public ArrayList<Manager> getListOfManagers() {
        return this.managers;
    }

    public ArrayList<TopManager> getListOfTopManagers() {
        return this.topManagers;
    }

    public ArrayList<Operator> getListOfOperators() {
        return this.operators;
    }
}



