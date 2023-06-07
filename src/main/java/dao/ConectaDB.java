package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectaDB {
    public static void main(String[] args) {
        try{
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc");
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
