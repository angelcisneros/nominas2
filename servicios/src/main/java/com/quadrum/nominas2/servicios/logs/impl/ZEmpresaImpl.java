
package  com.quadrum.nominas2.servicios.logs.impl;

import com.quadrum.nominas2.entidades.Empresa;
import com.quadrum.nominas2.repositorios.EmpresaRepositorio;
import com.quadrum.nominas2.servicios.logs.ZEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author vcisneros
 */
@Service
public class ZEmpresaImpl implements ZEmpresa {

    @Autowired
    EmpresaRepositorio empresaRepositorio;

    @Override
    public Empresa sesion() {
        Authentication a = SecurityContextHolder.getContext().getAuthentication();
        if ("anonymousUser".equals(a.getPrincipal())) {
            return null;
        }
        User user = (User) a.getPrincipal();
        Empresa empresa = empresaRepositorio.buscarPorUsuario(user.getUsername());
        return empresa;
    }

}
