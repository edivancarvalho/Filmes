package br.com.torrent.dal;

import br.com.torrent.model.Usuario;
import br.com.torrent.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    private Connection conexao;

    public UsuarioDao() throws Exception {
        conexao = (Connection) Conexao.getInstance();
    }

    public void adicionarUsuario(Usuario usuario) throws Exception {
        String sql = "INSERT INTO usuario (usu_nome, usu_cpf, usu_email, usu_senha, usu_cup_iden) VALUES (?, ?,?, ?, ?, default )";

        try { // preparando a conexao;
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setObject(1, usuario.getNome());
            preparedStatement.setObject(2, usuario.getCpf());
            preparedStatement.setObject(3, usuario.getEmail());
            preparedStatement.setObject(4, usuario.getSenha());

            preparedStatement.executeUpdate(); // executa o comando da String sql;
        } catch (SQLException erro) {
            throw new Exception("Error ao inserir registro" + erro.getMessage());
        }
    }

    public void deleteUsuario(int id) throws Exception {
        String sql = "DELETE FROM usuario WHERE usu_iden=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException erro) {
            throw new Exception("Ocorreu um erro ao deletar este registro!\n"
                    + erro.getMessage());
        }
    }

    public void updateUsuario(Usuario usuario) throws Exception {
        String sql = "UPDATE usuario set  usu_nome=?, usu_cpf=?, usu_email=?, usu_senha=?, where usu_cup_iden=?";

        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setInt(2, usuario.getIden());
            preparedStatement.setString(3, usuario.getEmail());
            preparedStatement.setString(4, usuario.getSenha());
            preparedStatement.executeUpdate();

        } catch (SQLException erro) {
            throw new Exception("Ocorreu um erro ao alterar este registro\n"
                    + erro.getMessage());
        }
    }

    public List<Usuario> getAllUsuario() throws Exception {
        List<Usuario> listUsuario = new ArrayList<Usuario>();
        // buscar por ordenação por ID;
        //String sql = "SELECT * from aluno ORDER by aluno.alu_id";
        String sql = "SELECT * FROM usuario";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            //        ↓ enquato estive proximo faça;
            while (rs.next()) {
                //     ↓ fazendo um estaciação com o [new]
                Usuario usuario = new Usuario();
                usuario.setIden(rs.getInt("usu_iden"));
                usuario.setNome(rs.getString("usu_nome"));
                usuario.setNome(rs.getString("usu_email"));
                usuario.setNome(rs.getString("usu_senha"));
                listUsuario.add(usuario);
                System.out.println("teste 1");
            }
        } catch (SQLException erro) {
            throw new Exception("Ocorreu um erro ao consultar os registros de fabricantes\n" + erro.getMessage());
        }
        return listUsuario;
    }

    public Usuario getUsuarioById(int id) throws Exception {
        Usuario usuario = new Usuario();
        String sql = "SELECT * FROM usuario WHERE usu_iden=?";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                usuario.setIden(rs.getInt("alu_id"));
                usuario.setNome(rs.getString("alu_nome"));
                usuario.setEmail(rs.getString("alu_nome"));
                usuario.setSenha(rs.getString("alu_nome"));
            }
        } catch (Exception erro) {
            throw new Exception("Erro ao buscar no banco de dados: Alunos!!\n" + erro.getMessage());
        }
        return usuario;
    }
}
