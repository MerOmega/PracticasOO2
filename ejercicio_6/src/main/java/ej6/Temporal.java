package ej6;

public class Temporal extends Employee{


    protected Temporal(Builder builder) {
        super(builder);
    }

    @Override
    double basicSalary() {
        return 20000;
    }

    @Override
    double aditionalSalary() {
        double amount=0;
        amount=2000*(this.kids);
        return amount + ((married) ? 5000 : 0);
    }
}
