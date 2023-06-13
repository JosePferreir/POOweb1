package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.ExecutionException;

public class ConectaDB {
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost/attitudeDB";
    private static final String USER = "postgres";
    private static final String SENHA = "1234";

    public Connection getConexao(){
        Connection conn = null;

        try{
            Class.forName(this.DRIVER);
            conn = DriverManager.getConnection(this.URL,this.USER,this.SENHA);
        }catch(Exception e){
            e.printStackTrace();
        }

        return conn;
    }
}
