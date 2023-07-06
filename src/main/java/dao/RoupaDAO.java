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
            this.sql = "SELECT * FROM roupa ORDER BY id_roupa";
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

    public Roupa getRoupa(int id){
        Roupa r = new Roupa();

        try(Connection conn = new ConectaDB().getConexao()){
            this.sql = "select * from roupa where id_roupa = ?";

            this.preparedStatement = conn.prepareStatement(this.sql);
            this.preparedStatement.setInt(1,id);
            this.rs = this.preparedStatement.executeQuery();

            while (this.rs.next()){
                r.setId(this.rs.getInt("id_roupa"));
                r.setNome(this.rs.getString("nome"));
                r.setTamanho(this.rs.getString("tamanho"));
                r.setPreco(this.rs.getInt("preco"));
                r.setCor(this.rs.getString("cor"));
                r.setDescricao(this.rs.getString("descricao"));
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return r;
    }
    public void editarRoupa(Roupa r){
        try(Connection conn = new ConectaDB().getConexao()){
            this.sql = "update roupa SET nome = ?, tamanho = ?, preco = ?, cor = ?, descricao = ? WHERE id_roupa = ?";
            this.preparedStatement = conn.prepareStatement(this.sql);

            this.preparedStatement.setString(1,r.getNome());
            this.preparedStatement.setString(2,r.getTamanho());
            this.preparedStatement.setInt(3,r.getPreco());
            this.preparedStatement.setString(4,r.getCor());
            this.preparedStatement.setString(5,r.getDescricao());
            this.preparedStatement.setInt(6,r.getId());

            this.preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void excluirRoupa(int id){
        try(Connection conn = new ConectaDB().getConexao()){
            this.sql = "DELETE FROM roupa WHERE id_roupa = ?";
            this.preparedStatement = conn.prepareStatement(this.sql);

            this.preparedStatement.setInt(1,id);

            this.preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
