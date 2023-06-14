package dao;

import model.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EnderecoDAO {
    private String sql;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement preparedStatement;

    public String cadastrarEndereco(int id, Endereco e){
        try(Connection conn = new ConectaDB().getConexao()){
            this.sql = "insert into endereco(cep, estado, cidade, rua, numero, complemento, bairro, usuario_id) values (?,?,?,?,?,?,?,?)";

            this.preparedStatement = conn.prepareStatement(this.sql);
            this.preparedStatement.setString(1,e.getCEP());
            this.preparedStatement.setString(2,e.getEstado());
            this.preparedStatement.setString(3,e.getCidade());
            this.preparedStatement.setString(4,e.getRua());
            this.preparedStatement.setString(5,e.getNumero());
            this.preparedStatement.setString(6,e.getComplemento());
            this.preparedStatement.setString(7,e.getBairro());
            this.preparedStatement.setInt(8,id);

            this.preparedStatement.execute();

        }catch (Exception exception){
            exception.printStackTrace();
        }

        return null;
    }

}
