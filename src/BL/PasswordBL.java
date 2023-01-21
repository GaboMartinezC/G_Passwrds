package BL;
import DAL.PasswordDAL;
import Entidades.Password;
import java.util.ArrayList;

public class PasswordBL 
{
    public void Ingresar (Password password) throws Exception
    {
        PasswordDAL dal = new PasswordDAL();
        dal.Ingresar(password);
    }
    public ArrayList<Password> BuscarTodos(int id)
    {
        PasswordDAL dal = new PasswordDAL();
        return dal.BuscarTodos(id);
    }
}
