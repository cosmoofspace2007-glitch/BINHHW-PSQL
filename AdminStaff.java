package Baiseasion12;

public class AdminStaff extends Staff implements ICapability {

    private double bonus;

    public AdminStaff(int id, String name, double baseSalary, double bonus) {
        super(id, name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateTotalSalary() {
        return baseSalary + bonus;
    }

    @Override
    public void checkPerformance() {
        if (bonus > 1000000) {
            System.out.println("Excellent Admin Staff");
        } else {
            System.out.println("Normal Admin Staff");
        }
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Bonus: " + bonus +
                " | Total Salary: " + calculateTotalSalary());
    }
}