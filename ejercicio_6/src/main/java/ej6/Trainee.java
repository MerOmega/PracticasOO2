package ej6;

public class Trainee extends Employee {
    protected Trainee(Builder builder) {
        super(builder);
    }

    @Override
    double basicSalary() {
        return 20000;
    }

    @Override
    double aditionalSalary() {
        return this.exams*2000;
    }
}
