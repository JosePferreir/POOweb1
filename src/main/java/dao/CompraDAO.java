package dao;

import model.Compra;
import model.Roupa;
import model.Usuario;

import java.sql.*;
import java.util.ArrayList;

public class CompraDAO {
    private String sql;
    private Statement stmt;
    private ResultSet rs;
    private String status;
    private PreparedStatement preparedStatement;

    public void cadastrarCompra(Compra c, Usuario u){
        try(Connection conn = new ConectaDB().getConexao()){
            conn.setAutoCommit(false);

            this.sql = "insert into compra(usuario_id,totalcompra) values (?,?)";

            this.preparedStatement = conn.prepareStatement(this.sql, PreparedStatement.RETURN_GENERATED_KEYS);
            this.preparedStatement.setInt(1,u.getId());
            this.preparedStatement.setFloat(2,c.getTotalCompra());

            this.preparedStatement.execute();
            this.rs = this.preparedStatement.getGeneratedKeys();
            this.rs.next();

            if(this.rs.getInt(1) > 0){
                c.setId(this.rs.getInt(1));
                System.out.println(c.getId());
                this.status = "OK";
            }

            if(this.status.equals("OK")){
                this.sql = "insert into compra_roupa(id_roupa,id_compra,quantidade) values (?,?,?)";
                this.preparedStatement = conn.prepareStatement(this.sql,PreparedStatement.RETURN_GENERATED_KEYS);

                for(Roupa r : c.getRoupas()){
                    this.preparedStatement.setInt(1,r.getId());
                    this.preparedStatement.setInt(2,c.getId());
                    this.preparedStatement.setInt(3,r.getQuantidade());
                    this.preparedStatement.addBatch();
                }

                this.preparedStatement.executeBatch();
                this.rs = this.preparedStatement.getGeneratedKeys();
                this.rs.next();

                if(this.rs.getInt(1) >0){
                    conn.commit();
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public ArrayList<Compra> getHistoricoUsuario(int id){
        ArrayList<Compra> compras = new ArrayList<>();

        try(Connection conn = new ConectaDB().getConexao()){
            this.sql = "SELECT * FROM compra where usuario_id = ?";

            this.preparedStatement = conn.prepareStatement(this.sql);

            this.preparedStatement.setInt(1,id);
            this.rs = this.preparedStatement.executeQuery();

            while(this.rs.next()){
                Compra c = new Compra();

                c.setId(rs.getInt("id_compra"));
                c.setTotalCompra(rs.getFloat("totalcompra"));

                compras.add(c);
            }

            if(compras.size() > 0){
                this.sql = "Select * FROM compra_roupa cr, roupa where cr.id_roupa = roupa.id_roupa and cr.id_compra = ?";
                this.preparedStatement = conn.prepareStatement(this.sql);

                for(int i = 0; i < compras.size(); i++){
                    this.preparedStatement.setInt(1,compras.get(i).getId());
                    this.rs = this.preparedStatement.executeQuery();

                    while(this.rs.next()){
                        Roupa r = new Roupa();

                        r.setId(this.rs.getInt("id_roupa"));
                        r.setNome(this.rs.getString("nome"));
                        r.setTamanho(this.rs.getString("tamanho"));
                        r.setPreco(this.rs.getInt("preco"));
                        r.setCor(this.rs.getString("cor"));
                        r.setDescricao(this.rs.getString("descricao"));
                        r.setQuantidade(rs.getInt("quantidade"));

                        compras.get(i).setRoupas(r);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return compras;
    }

    public ArrayList<Compra> getHistoricoAdmin(){
        ArrayList<Compra> compras = new ArrayList<>();

        try(Connection conn = new ConectaDB().getConexao()){
            this.sql = "select id_compra,totalcompra,compra.usuario_id,nome from compra,usuario where compra.usuario_id = usuario.usuario_id";
            this.preparedStatement = conn.prepareStatement(this.sql);
            this.stmt = conn.createStatement();

            this.rs = stmt.executeQuery(sql);

            while(rs.next()){
                Compra c = new Compra();

                c.setId(rs.getInt("id_compra"));
                c.setTotalCompra(rs.getFloat("totalcompra"));

                Usuario u = new Usuario();

                u.setId(rs.getInt("usuario_id"));
                u.setNome(rs.getString("nome"));
                c.setCliente(u);

                compras.add(c);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return compras;
    }

    public Compra getCompraById(int id, float valor){
        Compra c = new Compra();
        c.setTotalCompra(valor);

        try(Connection conn = new ConectaDB().getConexao()){
            this.sql = "Select * FROM compra_roupa cr, roupa where cr.id_roupa = roupa.id_roupa and cr.id_compra = ?";
            this.preparedStatement = conn.prepareStatement(this.sql);

            this.preparedStatement.setInt(1,id);
            this.rs = this.preparedStatement.executeQuery();

            while(this.rs.next()){
                Roupa r = new Roupa();

                r.setId(this.rs.getInt("id_roupa"));
                r.setNome(this.rs.getString("nome"));
                r.setTamanho(this.rs.getString("tamanho"));
                r.setPreco(this.rs.getInt("preco"));
                r.setCor(this.rs.getString("cor"));
                r.setDescricao(this.rs.getString("descricao"));
                r.setQuantidade(rs.getInt("quantidade"));

                c.setRoupas(r);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return c;
    }
}
