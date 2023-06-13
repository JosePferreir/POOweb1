package util;

import dao.ConectaDB;
import dao.UsuarioDAO;
import model.Usuario;

public class Teste {
    public static void main(String[] args) {

        testeCadastrarUsuario();
        testeGetUsuarios();
    }

    public static void testeGetUsuarios(){
        for(Usuario u : new UsuarioDAO().getAllUsuarios()){
            System.out.println("\nNome: "+u.getNome());
            System.out.println("Idade: "+u.getIdade());
            System.out.println("Cpf: "+u.getCpf());
            System.out.println("Email: "+u.getEmail());/*
            System.out.println("Cidade: "+u.getEndereco().getCidade());
            System.out.println("Rua: "+u.getEndereco().getRua());*/
        }
    }

    public static void testeCadastrarUsuario(){
        Usuario u = new Usuario();
        u.setId(3);
        u.setNome("Carlos");
        u.setIdade(19);
        u.setCpf("147.258.369-10");
        u.setEmail("carlos@teste");
        u.setSenha("1234");

        new UsuarioDAO().cadastrarUsuario(u);
    }
}
