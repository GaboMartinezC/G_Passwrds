package GUI;
import BL.*;
import javax.swing.JOptionPane;

public class Inicio 
{
    public static void main(String[] args) 
    {
        try
        {
            Arranque ar = new Arranque();
            ar.Cargar();
            UsuarioBL bl = new UsuarioBL();
            if (!bl.isLoged())
                Login.Cargar();
            else
                JOptionPane.showMessageDialog(null, "Is loged");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
}
