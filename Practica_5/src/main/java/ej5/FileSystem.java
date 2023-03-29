package ej5;

import java.time.LocalDate;
import java.util.Date;

public abstract class FileSystem {

    private String name;
    private LocalDate localDate;
    private int size;

    public FileSystem(String name, LocalDate localDate) {
        this.name = name;
        this.localDate = localDate;
    }

    public FileSystem(String name, LocalDate localDate,int size) {
        this.name = name;
        this.localDate = localDate;
        this.size=size;
    }

    public String getName() {
        return name;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocalDate( LocalDate localDate) {
        this.localDate = localDate;
    }

    public abstract int totalSize();
    public abstract FileSystem biggestFile();
    public abstract FileSystem newestFile();
}
