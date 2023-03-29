package ej6;

import java.lang.reflect.Constructor;
import java.util.Optional;

public abstract class Employee {

    int kids;
    boolean married;
    int hours;
    int antique;
    int exams;
    protected Employee(Builder builder) {
        this.kids = builder.kids;
        this.married = builder.married;
        this.hours = builder.hours;
        this.antique = builder.antique;
        this.exams = builder.exams;
    }

    public double getSalary(){
        double additionalDiscount = 0.05;
        double basicDiscount = 0.13;
        return basicSalary()*(1- basicDiscount) + aditionalSalary()*(1- additionalDiscount);
    }

    abstract double basicSalary();
    abstract double aditionalSalary();


    //Builder pattern to avoid using more than one constructor

    public static class Builder {
        private int kids;
        private boolean married;
        private int hours;
        private int antique;
        private int exams;

        public Builder kids(Integer kids) {
            Optional.ofNullable(kids).ifPresent(value -> this.kids = value);
            return this;
        }

        public Builder married(Boolean married) {
            Optional.ofNullable(married).ifPresent(value -> this.married = value);
            return this;
        }

        public Builder hours(Integer hours) {
            Optional.ofNullable(hours).ifPresent(value -> this.hours = value);
            return this;
        }

        public Builder antique(Integer antique) {
            Optional.ofNullable(antique).ifPresent(value -> this.antique = value);
            return this;
        }

        public Builder exams(Integer exams) {
            Optional.ofNullable(exams).ifPresent(value -> this.exams = value);
            return this;
        }

        public Employee build(Class<? extends Employee> employeeClass) {
            try {
                Constructor<? extends Employee> constructor = employeeClass.getDeclaredConstructor(Builder.class);
                return constructor.newInstance(this);
            } catch (Exception e) {
                throw new RuntimeException("Unable to create Employee instance.", e);
            }
        }
    }

}
