package BL;
import DAL.*;

public class Arranque 
{
    public void Cargar()
    {
        try
        {
            PasswordDAL dal1 = new PasswordDAL();
            UsuarioDAL dal2 = new UsuarioDAL();
            dal1.AccesoLeer();
            dal2.AccesoLeer();
            dal2.AccesoPW();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
