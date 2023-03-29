package ej5;

import java.time.LocalDate;
import java.util.*;

public class Directory extends FileSystem{

    private List<FileSystem> archiveFiles;

    public Directory(String name,LocalDate localDate, List<FileSystem> archiveFiles) {
        super(name, localDate,32);
        this.archiveFiles=archiveFiles;
    }

    public Directory(String name,LocalDate localDate) {
        super(name, localDate,32);
        this.archiveFiles= new ArrayList<>();
    }

    /**
     * @return
     */
    @Override
    public int totalSize() {
        int suma=this.getSize();
        suma+=archiveFiles.stream()
                .mapToInt(
                        FileSystem::totalSize
                ).sum();
        return suma;
    }


    /**
     * @return
     */
    @Override
    public FileSystem biggestFile() {
        return archiveFiles.stream()
                .map(FileSystem::biggestFile)
                .filter(Objects::nonNull)
                .filter(fs -> fs instanceof File)
                .max(Comparator.comparing(FileSystem::totalSize))
                .orElse(null);

    }

    /**
     * @return
     */
    @Override
    public FileSystem newestFile() {
        return archiveFiles.stream()
                .map(FileSystem::newestFile)
                .filter(Objects::nonNull)
                .filter(fs -> fs instanceof File)
                .max(Comparator.comparing(FileSystem::getLocalDate))
                .orElse(null);
    }

    public void add(FileSystem file){
        this.archiveFiles.add(file);
    }
}
