package BL;
import DAL.PasswordDAL;
import Entidades.Password;
import java.util.ArrayList;

public class PasswordBL 
{
    public String Buscar (Password password)
    {
        PasswordDAL dal = new PasswordDAL();
        return dal.Buscar(password);
    }
    public boolean Ingresar (Password password) throws Exception
    {
        PasswordDAL dal = new PasswordDAL();
        return dal.Ingresar(password);
    }
    public boolean Actualizar(Password password) throws Exception
    {
        PasswordDAL dal = new PasswordDAL();
        return dal.Actualizar(password);
    }
    public ArrayList<Password> BuscarTodos()
    {
        PasswordDAL dal = new PasswordDAL();
        return dal.BuscarTodos();
    }
}
