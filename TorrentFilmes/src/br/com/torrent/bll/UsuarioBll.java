package br.com.torrent.bll;

import br.com.torrent.dal.UsuarioDao;
import br.com.torrent.model.Usuario;
import java.util.List;

public class UsuarioBll {

    private UsuarioDao usuarioDao;

    public UsuarioBll() throws Exception {
        usuarioDao = new UsuarioDao();
    }

    // 1°
    public void adicionarUsuario(Usuario usuario) throws Exception {
        usuarioDao.adicionarUsuario(usuario);
    }

    // 2°
    public void removerUsuario(Usuario usuario) throws Exception {
        usuarioDao.deleteUsuario(usuario.getIden());
    }

    // 3°
    public void alterarUsuario(Usuario usuario) throws Exception {
        usuarioDao.updateUsuario(usuario);
    }

    // 4° 
    public List<Usuario> consultarUsuario() throws Exception {
        return usuarioDao.getAllUsuario();
    }

    // 5°
    public Usuario consultarUsuarioPorId(int id) throws Exception {
        return usuarioDao.getUsuarioById(id);
    }
}
