public class Employee {
    static Integer employeeID = 0;
    private String fullName;
    private Integer age;

    public void setFullName(String name) {
        this.fullName = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFullName() {
        return this.fullName;
    }

    public Integer getAge() {
        return this.age;
    }

}


class Manager extends Employee {
    private Integer salary;
    private final Double percent = 0.05;
    private Integer incomeToCompany;
    private final String position = "Manager";

    public void setMonthlySalary(Integer salary)
    {
        this.salary = salary;
    }

    public void setIncomeToCompany(Integer incomeToCompany)
    {
        this.incomeToCompany = incomeToCompany;
    }

    public int getMonthlySalary()
    {
        return this.salary;
    }

    public Double getPercent()
    {
        return this.percent;
    }

    public int getIncomeToCompany()
    {
        return this.incomeToCompany;
    }

}

class TopManager extends Employee{
    private Integer salary;
    private final Double percent = 1.50;
    private final String position = "Top Manager";
    private final Integer bonusIncome = 1000000;

    public void setMonthlySalary(Integer salary)
    {
        this.salary = salary;
    }

    public int getMonthlySalary()
    {
        return this.salary;
    }


    public Double getPercent()
    {
        return this.percent;
    }

    public int getBonusIncome()
    {
        return this.bonusIncome;
    }

}

class Operator extends Employee {
    private Integer salary;
    private final String position = "Operator";

    public void setMonthlySalary(Integer salary)
    {
        this.salary = salary;
    }

    public int getMonthlySalary()
    {
        return this.salary;
    }

}