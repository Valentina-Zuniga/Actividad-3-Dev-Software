package co.edu.udec.taskmgr;

import co.edu.udec.taskmgr.infrastructure.config.SQLiteDatabaseInitializer;



public class Main {
    public static void main(String[] args) {
        System.out.println("Ejecutandse Ok");
        SQLiteDatabaseInitializer.initialize();
    }
}

