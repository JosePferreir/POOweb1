package dao;

import model.Endereco;
import model.Permissao;
import model.Usuario;

import java.sql.*;
import java.util.ArrayList;

public class UsuarioDAO {
    private String sql;
    private Statement stmt;
    private ResultSet rs;
    private String status;
    private PreparedStatement preparedStatement;

    public ArrayList<Usuario> getAllUsuarios(){
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        try(Connection conn = new ConectaDB().getConexao()){
            this.sql = "SELECT * FROM usuario, permissao, usuario_permissao " +
                       "WHERE usuario.usuario_id = usuario_permissao.usuario_id and permissao.permissao_id = usuario_permissao.permissao_id";
            this.stmt = conn.createStatement();
            this.rs = stmt.executeQuery(sql);

            while(rs.next()){
                Usuario user = new Usuario();

                user.setId(rs.getInt("usuario_id"));
                user.setNome(rs.getString("nome"));
                user.setCpf(rs.getString("cpf"));
                user.setIdade(rs.getInt("idade"));
                user.setEmail(rs.getString("email"));

                Permissao p = new Permissao();
                p.setId(rs.getInt("permissao_id"));
                p.setNome(rs.getString("nome_permissao"));
                user.setPermissao(p);

                usuarios.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return usuarios;
    }
    public Usuario getUsuarioAutenticar(String email){
        Usuario u = new Usuario();
        try(Connection conn = new ConectaDB().getConexao()){
            this.sql = "SELECT * FROM usuario, permissao, usuario_permissao " +
                    "WHERE usuario.usuario_id = usuario_permissao.usuario_id and " +
                    "permissao.permissao_id = usuario_permissao.permissao_id and " +
                    "usuario.email = ?";
            this.preparedStatement = conn.prepareStatement(this.sql);
            preparedStatement.setString(1,email);
            this.rs = this.preparedStatement.executeQuery();

            while(this.rs.next()){
                u.setId(this.rs.getInt("usuario_id"));
                u.setNome(this.rs.getString("nome"));
                u.setCpf(this.rs.getString("cpf"));
                u.setIdade(this.rs.getInt("idade"));
                u.setEmail(this.rs.getString("email"));
                u.setSenha((this.rs.getString(("senha"))));

                Permissao p = new Permissao();
                p.setId(rs.getInt("permissao_id"));
                p.setNome(rs.getString("nome_permissao"));
                u.setPermissao(p);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return u;
    }

    public Usuario getUsuarioById(int id){
        Usuario u = new Usuario();
        try(Connection conn = new ConectaDB().getConexao()){
            this.sql = "SELECT * FROM usuario, permissao, usuario_permissao " +
                    "WHERE usuario.usuario_id = usuario_permissao.usuario_id and " +
                    "permissao.permissao_id = usuario_permissao.permissao_id and " +
                    "usuario.usuario_id = ?";
            this.preparedStatement = conn.prepareStatement(this.sql);
            preparedStatement.setInt(1,id);
            this.rs = this.preparedStatement.executeQuery();

            while(this.rs.next()){
                u.setId(this.rs.getInt("usuario_id"));
                u.setNome(this.rs.getString("nome"));
                u.setCpf(this.rs.getString("cpf"));
                u.setIdade(this.rs.getInt("idade"));
                u.setEmail(this.rs.getString("email"));
                u.setSenha((this.rs.getString(("senha"))));

                Permissao p = new Permissao();
                p.setId(rs.getInt("permissao_id"));
                p.setNome(rs.getString("nome_permissao"));
                u.setPermissao(p);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return u;
    }

    public void editarUsuario(Usuario u){
        try(Connection conn = new ConectaDB().getConexao()){
            this.sql = "update usuario SET nome = ?, idade = ?, cpf = ?, email = ?, senha = ? WHERE usuario_id = ?";
            this.preparedStatement = conn.prepareStatement(this.sql);

            this.preparedStatement.setString(1,u.getNome());
            this.preparedStatement.setInt(2,u.getIdade());
            this.preparedStatement.setString(3,u.getCpf());
            this.preparedStatement.setString(4,u.getEmail());
            this.preparedStatement.setString(5,u.getSenha());
            this.preparedStatement.setInt(6,u.getId());

            this.preparedStatement.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public void excluirUsuario(int id){
        try(Connection conn = new ConectaDB().getConexao()){
            this.sql = "DELETE FROM usuario_permissao WHERE usuario_id = ?";
            this.preparedStatement = conn.prepareStatement(this.sql);

            this.preparedStatement.setInt(1,id);

            this.preparedStatement.execute();

            this.sql = "DELETE FROM usuario WHERE usuario_id = ?";
            this.preparedStatement = conn.prepareStatement(this.sql);

            this.preparedStatement.setInt(1,id);

            this.preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Usuario getUsuarioEndereco(int id){
        Usuario u = new Usuario();

        try(Connection conn = new ConectaDB().getConexao()){
            this.sql = "select * from usuario,endereco where endereco.usuario_id = usuario.usuario_id and usuario.usuario_id = ?";
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
            conn.setAutoCommit(false);

            this.sql = "insert into usuario(nome, idade, cpf, email, senha) values (?,?,?,?,?)";

            this.preparedStatement = conn.prepareStatement(this.sql, PreparedStatement.RETURN_GENERATED_KEYS);
            this.preparedStatement.setString(1,u.getNome());
            this.preparedStatement.setInt(2,u.getIdade());
            this.preparedStatement.setString(3,u.getCpf());
            this.preparedStatement.setString(4,u.getEmail());
            this.preparedStatement.setString(5,u.getSenha());

            this.preparedStatement.execute();
            this.rs = this.preparedStatement.getGeneratedKeys();
            this.rs.next();

            if(this.rs.getInt(1) > 0){
                u.setId(this.rs.getInt(1));
                this.status = "OK";
            }

            if(this.status.equals("OK")){
                this.sql = "INSERT INTO usuario_permissao (usuario_id, permissao_id) VALUES (?,?)";

                this.preparedStatement = conn.prepareStatement(this.sql, PreparedStatement.RETURN_GENERATED_KEYS);
                this.preparedStatement.setInt(1,u.getId());
                this.preparedStatement.setInt(2,u.getPermissao().getId());
                this.preparedStatement.execute();
                this.rs = this.preparedStatement.getGeneratedKeys();
                this.rs.next();

                if(this.rs.getInt(1) >0){
                    conn.commit();
                }

            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }
}
