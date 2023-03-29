package ej5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DirectoryTest {

    private Directory vacio;
    private Directory conUnFile;
    private Directory conVariosFiles;
    private Directory conSubDirectorys;
    private File grande;
    private File backup2015;

    @BeforeEach
    void setUp() throws Exception {

        LocalDate date = LocalDate.of(2015, 1, 1);
        grande = new File("grande.tmp", LocalDate.of(2016, 4, 2), 2000000);
        backup2015 = new File("2015.zip", LocalDate.of(2016, 4, 6), 240000000);
        Directory mysql = new Directory("mysql", date);
        mysql.add(new File("mysql01.log", LocalDate.of(2015, 12, 3), 1200000));
        mysql.add(new File("mysql02.log", LocalDate.of(2014, 3, 3), 2000000));
        mysql.add(new File("mysql03.log", LocalDate.of(2013, 3, 21), 2000000));
        mysql.add(new File("mysql04.log", LocalDate.of(2014, 7, 15), 2000000));
        Directory older = new Directory("older", date);
        older.add(backup2015);
        mysql.add(older);
        Directory postgres = new Directory("postgres", date);
        postgres.add(new File("pg01.log", LocalDate.of(2015, 4, 12), 1400000));
        postgres.add(new File("pg02.log", LocalDate.of(2016, 3, 8), 4000000));
        postgres.add(new File("pg03.log", LocalDate.of(2016, 2, 13), 4000000));
        // Directory vacío
        vacio = new Directory("home", date);
        //"Directory con un solo File"
        conUnFile = new Directory("var", date);
        File config = new File("config.bak", LocalDate.of(2016, 4, 2), 128);
        conUnFile.add(config);
        // Directory con varios Files, pero sin subDirectorys"
        conVariosFiles = new Directory("tmp", date);
        conVariosFiles.add(new File("nada.tmp", LocalDate.of(2015, 5, 1), 0));
        conVariosFiles.add(new File("chico.tmp", LocalDate.of(2013, 6, 3), 10));
        conVariosFiles.add(grande);
        conVariosFiles.add(new File("mediano.tmp", LocalDate.of(1995, 11, 23), 10000));
        //Directory con subDirectorys, Files, y Files dentro de los subDirectorys"
        conSubDirectorys = new Directory("log", date);
        conSubDirectorys.add(new File("sys.log", LocalDate.of(2016, 3, 3), 90000));
        conSubDirectorys.add(mysql);
        conSubDirectorys.add(postgres);
    }

    @Test
    void testBiggestFile() {
        assertEquals(null, vacio.biggestFile());
        assertEquals("config.bak", conUnFile.biggestFile().getName());
        assertEquals(grande, conVariosFiles.biggestFile());
        assertEquals(backup2015, conSubDirectorys.biggestFile());
    }

    @Test
    void testFileMasNuevo() {
        assertEquals(null, vacio.newestFile());
        assertEquals("config.bak", conUnFile.newestFile().getName());
        assertEquals(grande, conVariosFiles.newestFile());
        assertEquals(backup2015, conSubDirectorys.newestFile());
    }

    @Test
    void testTamanoTotalOcupado() {
        assertEquals(32, vacio.totalSize());
        assertEquals(160, conUnFile.totalSize()); //32 del Directory + 128 del File
        assertEquals(2010042, conVariosFiles.totalSize()); //  2M de grande + 10K + 0 + 10 + 32 Directory
        assertEquals(256690128, conSubDirectorys.totalSize());
    }


}