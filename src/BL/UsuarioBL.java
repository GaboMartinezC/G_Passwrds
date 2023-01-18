package BL;
import DAL.*;
import Entidades.*;
import java.util.ArrayList;

public class UsuarioBL 
{
    public void Unlog() throws Exception
    {
        UsuarioDAL dal = new UsuarioDAL();
        dal.Unlog();
    }
    public boolean isLoged () throws Exception
    {
        UsuarioDAL dal = new UsuarioDAL();
        return dal.isLoged();
    }
    public boolean Login (Usuario usuario, String contraIng) throws Exception
    {
        boolean retVal = false;
        UsuarioDAL dal = new UsuarioDAL();
        if (dal.Buscar(usuario.GetDescripcion()).GetId()!=-1)
            retVal = dal.Login(usuario, contraIng);
        return retVal;
    }
    public Usuario Buscar(String descripcion)
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
    public boolean Actualizar (Usuario usuario) throws Exception
    {
        boolean retVal = true;
        UsuarioDAL dal = new UsuarioDAL();
        if (IsEmpty(usuario))
            retVal = false;
        else
            retVal = dal.Actualizar(usuario);
        return retVal;
    }
    public boolean Ingresar(Usuario usuario) throws Exception
    {
        boolean retVal = true;
        UsuarioDAL dal = new UsuarioDAL();
        if (IsEmpty(usuario))
            retVal = false;
        else
            retVal = dal.Ingresar(usuario);
        return retVal;
    }
    private boolean IsEmpty(Usuario usuario)
    {
        boolean retVal = false;
        if ((usuario.GetDescripcion().equals(""))||(usuario.GetPasswd().equals("")))
            retVal = true;
        return retVal;
    }
}
