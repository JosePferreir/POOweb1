package dao;

import model.Endereco;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuarioDAO {
    private String sql;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement preparedStatement;

    public ArrayList<Usuario> getAllUsuarios(){
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        try(Connection conn = new ConectaDB().getConexao()){
            this.sql = "SELECT * FROM usuario";
            this.stmt = conn.createStatement();
            this.rs = stmt.executeQuery(sql);

            while(rs.next()){
                Usuario user = new Usuario();

                user.setId(rs.getInt("usuario_id"));
                user.setNome(rs.getString("nome"));
                user.setCpf(rs.getString("cpf"));
                user.setIdade(rs.getInt("idade"));
                user.setEmail(rs.getString("email"));

                usuarios.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return usuarios;
    }

    public Usuario getUsuarioEndereco(int id){
        Usuario u = new Usuario();

        try(Connection conn = new ConectaDB().getConexao()){
            this.sql = "select * from usuario,endereco where endereco.usuario_id = usuario.usuario_id and usuario.usuario_id = ?";
            /*
            this.stmt = conn.createStatement();
            this.rs = stmt.executeQuery(sql);
            */
            this.preparedStatement = conn.prepareStatement(this.sql);
            preparedStatement.setInt(1,id);
            this.rs = this.preparedStatement.executeQuery();


            while(this.rs.next()){
                u.setId(this.rs.getInt("usuario_id"));
                u.setNome(this.rs.getString("nome"));
                u.setCpf(this.rs.getString("cpf"));
                u.setIdade(this.rs.getInt("idade"));
                u.setEmail(this.rs.getString("email"));

                Endereco endereco = new Endereco();
                endereco.setId(this.rs.getInt("endereco_id"));
                endereco.setCEP(this.rs.getString("cep"));
                endereco.setEstado(this.rs.getString("estado"));
                endereco.setCidade(this.rs.getString("cidade"));
                endereco.setRua(this.rs.getString("rua"));
                endereco.setCEP(this.rs.getString("numero"));
                endereco.setComplemento(this.rs.getString("complemento"));
                endereco.setBairro(this.rs.getString("bairro"));

                u.setEndereco(endereco);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return u;
    }

    public String cadastrarUsuario(Usuario u){
        try(Connection conn = new ConectaDB().getConexao()){
            this.sql = "insert into usuario(nome, idade, cpf, email, senha) values (?,?,?,?,?)";

            this.preparedStatement = conn.prepareStatement(this.sql);
            this.preparedStatement.setString(1,u.getNome());
            this.preparedStatement.setInt(2,u.getIdade());
            this.preparedStatement.setString(3,u.getCpf());
            this.preparedStatement.setString(4,u.getEmail());
            this.preparedStatement.setString(5,u.getSenha());

            this.preparedStatement.execute();

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
