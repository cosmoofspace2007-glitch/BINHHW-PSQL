package Baiseasion12;

public class Lecture extends Staff implements ICapability
{
    private int teachingHours;

    public Lecture(int id, String name, double baseSalary, int teachingHours) {
        super(id, name, baseSalary);
        this.teachingHours = teachingHours;
    }

    @Override
    public double calculateTotalSalary() {
        return baseSalary + (teachingHours * 200000);
    }

    @Override
    public void checkPerformance() {
        if (teachingHours > 50) {
            System.out.println("Excellent Lecturer");
        } else {
            System.out.println("Normal Lecturer");
        }
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Teaching Hours: " + teachingHours +
                " | Total Salary: " + calculateTotalSalary());
    }
}
