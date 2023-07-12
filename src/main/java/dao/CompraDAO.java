package dao;

import model.Compra;
import model.Roupa;
import model.Usuario;

import java.sql.*;

public class CompraDAO {
    private String sql;
    private Statement stmt;
    private ResultSet rs;
    private String status;
    private PreparedStatement preparedStatement;

    public void cadastrarCompra(Compra c, Usuario u){
        try(Connection conn = new ConectaDB().getConexao()){
            this.sql = "insert into compra(usuario_id,totalcompra) values (?,?)";

            this.preparedStatement = conn.prepareStatement(this.sql);
            this.preparedStatement.setInt(1,u.getId());
            this.preparedStatement.setFloat(2,c.getTotalCompra());

            this.preparedStatement.execute();
            this.rs = this.preparedStatement.getGeneratedKeys();
            this.rs.next();

            if(this.rs.getInt(1) > 0){
                c.setId(this.rs.getInt(1));
                this.status = "OK";
            }

            if(this.status.equals("OK")){
                for(Roupa r : c.getRoupas()){
                    this.sql = "insert into compra_roupa(id_roupa,id_compra,quantidade) values (?,?,?)";

                    this.preparedStatement = conn.prepareStatement(this.sql,PreparedStatement.RETURN_GENERATED_KEYS);
                    this.preparedStatement.setInt(1,r.getId());
                    this.preparedStatement.setInt(2,r);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
