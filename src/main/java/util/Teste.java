package util;

import dao.ConectaDB;
import dao.EnderecoDAO;
import dao.UsuarioDAO;
import model.Endereco;
import model.Usuario;

public class Teste {
    public static void main(String[] args) {

        //testeCadastrarUsuario();
        testeGetAllUsuarios();
        //testeCadastrarEndereco();
        //testeGetUsuarioEndereco();
    }

    public static void testeGetAllUsuarios(){
        for(Usuario u : new UsuarioDAO().getAllUsuarios()){
            System.out.println("\nNome: "+u.getNome());
            System.out.println("Idade: "+u.getIdade());
            System.out.println("Cpf: "+u.getCpf());
            System.out.println("Email: "+u.getEmail());
        }
    }
    public static void testeGetUsuarioEndereco(){
        Usuario u = new UsuarioDAO().getUsuarioEndereco(1);
        System.out.println("\nNome: "+u.getNome());
        System.out.println("Idade: "+u.getIdade());
        System.out.println("Cpf: "+u.getCpf());
        System.out.println("Email: "+u.getEmail());
        System.out.println("Cidade: "+u.getEndereco().getCidade());
        System.out.println("Rua: "+u.getEndereco().getRua());

    }

    public static void testeCadastrarUsuario(){
        Usuario u = new Usuario();
        u.setNome("Jose");
        u.setIdade(19);
        u.setCpf("123.456.789.45");
        u.setEmail("jose@teste");
        u.setSenha("1234");

        new UsuarioDAO().cadastrarUsuario(u);
    }
    public static void testeCadastrarEndereco(){
        Endereco e = new Endereco();
        e.setCEP("12789-000");
        e.setEstado("Rio Grande do Sul");
        e.setCidade("Santa Maria");
        e.setRua("Qualquer nome");
        e.setNumero("1122");
        e.setComplemento("Apto 101");
        e.setBairro("Camobi");

        new EnderecoDAO().cadastrarEndereco(1,e);
    }
}
