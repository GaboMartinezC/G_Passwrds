package BL;
import DAL.*;
import Entidades.*;

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
        UsuarioDAL dal = new UsuarioDAL();
        return dal.Login(usuario, contraIng);
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
