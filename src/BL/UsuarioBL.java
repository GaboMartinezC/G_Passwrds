package BL;
import DAL.*;
import Entidades.*;
import java.util.ArrayList;

public class UsuarioBL 
{
    public boolean Login (Usuario usuario, String contraIng) throws Exception
    {
        UsuarioDAL dal = new UsuarioDAL();
        return dal.Login(usuario, contraIng);
    }
    public Usuario Buscar(String descripcion) throws Exception
    {
        UsuarioDAL dal = new UsuarioDAL();
        return dal.Buscar(descripcion);
    }
    public ArrayList<Usuario> BuscarTodos() throws Exception
    {
        UsuarioDAL dal = new UsuarioDAL();
        return dal.BuscarTodos();
    }
    public void Borrar (Usuario usuario) throws Exception
    {
       UsuarioDAL dal = new UsuarioDAL();
       dal.Borrar(usuario);
    }
    public boolean Ingresar(Usuario usuario) throws Exception
    {
        UsuarioDAL dal = new UsuarioDAL();
        return dal.Ingresar(usuario);
    }
}
