package ej6;

public class Permanent extends Employee{

    protected Permanent(Builder builder) {
        super(builder);
    }

    @Override
    double basicSalary() {
        return 20000+(this.hours)*300;
    }

    @Override
    double aditionalSalary() {
        double amount=0;
        amount=2000*(this.kids);
        amount+=2000*this.antique;
        return amount + ((married) ? 5000 : 0);
    }
}
