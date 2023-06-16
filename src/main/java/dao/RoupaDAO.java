package dao;

import model.Roupa;

import java.sql.*;
import java.util.ArrayList;

public class RoupaDAO {
    private String sql;
    private Statement stmt;
    private ResultSet rs;
    private String status;
    private PreparedStatement preparedStatement;

    public void cadastrarRoupa(Roupa r){
        try(Connection conn = new ConectaDB().getConexao()){
            this.sql = "insert into roupa(nome, tamanho, preco, cor, descricao) values (?,?,?,?,?)";

            this.preparedStatement = conn.prepareStatement(this.sql);
            this.preparedStatement.setString(1,r.getNome());
            this.preparedStatement.setString(2,r.getTamanho());
            this.preparedStatement.setInt(3,r.getPreco());
            this.preparedStatement.setString(4,r.getCor());
            this.preparedStatement.setString(5,r.getDescricao());

            this.preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Roupa> getAllRoupas(){
        ArrayList<Roupa> roupas = new ArrayList<>();

        try(Connection conn = new ConectaDB().getConexao()){
            this.sql = "SELECT * FROM roupa";
            this.stmt = conn.createStatement();
            this.rs = stmt.executeQuery(sql);

            while(rs.next()){
                Roupa r = new Roupa();
                r.setId(rs.getInt("id_roupa"));
                r.setNome(rs.getString("nome"));
                r.setTamanho(rs.getString("tamanho"));
                r.setPreco(rs.getInt("preco"));
                r.setCor(rs.getString("cor"));
                r.setDescricao(rs.getString("descricao"));

                roupas.add(r);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return roupas;
    }
}
