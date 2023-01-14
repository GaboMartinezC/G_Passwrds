package BL;
import DAL.*;

public class Arranque 
{
    public void Cargar()
    {
        PasswordDAL dal1 = new PasswordDAL();
        UsuarioDAL dal2 = new UsuarioDAL();
        dal1.AccesoLeer();
        //dal2.AccesoLeer();
    }
}
