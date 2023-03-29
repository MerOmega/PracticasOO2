package ej5;

import java.time.LocalDate;

public class File extends FileSystem{


    public File(String name, LocalDate localDate, int size) {
        super(name, localDate,size);
    }

    /**
     * @return
     */
    @Override
    public int totalSize() {
        return this.getSize();
    }

    /**
     * @return
     */
    @Override
    public FileSystem biggestFile() {
        return this;
    }

    /**
     * @return
     */
    @Override
    public FileSystem newestFile() {
        return this;
    }


}
