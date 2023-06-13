package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConectaDB_teste {
    public static void main(String[] args) {
        try{
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/attitudeDB", "postgres","1234");

            System.out.println("Conectou na base");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");

            while(rs.next()){
                System.out.println("Id: "+rs.getInt("usuario_id"));
                System.out.println("Nome: "+rs.getString("nome"));
                System.out.println("Idade: "+rs.getInt("idade"));
                System.out.println("Cpf: "+rs.getString("cpf"));


            }

            stmt.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
