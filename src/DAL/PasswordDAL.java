package DAL;
import Entidades.Password;
import java.util.ArrayList;
import java.io.*;

public class PasswordDAL 
{
    private static ArrayList<Password> listaPW = new ArrayList<Password>();
    private static String rutaDir = "C:/GPWFLS";
    private static String ruta = "C:/GPWFLS/infopw.bin";
    
    private void Escribir() throws Exception
    {
        ObjectOutputStream escribiendoArchivo = new ObjectOutputStream (new FileOutputStream(ruta));
        escribiendoArchivo.writeObject(listaPW);
        escribiendoArchivo.close();
    }
    
    public void AccesoLeer () throws Exception
    {
        Leer();
    }
    private void Leer() throws Exception
    {
        File fich = new File(rutaDir);
        File archivo = new File(ruta);
        if (!fich.exists())
        {
            if (fich.mkdirs())
            {
                if (!archivo.exists())
                {
                    ObjectOutputStream escribiendoArchivo = new ObjectOutputStream (new FileOutputStream(ruta));
                    archivo.createNewFile();
                    escribiendoArchivo.writeObject(listaPW);
                    escribiendoArchivo.close();
                }
            }
        }
        ObjectInputStream leyendoArchivo = new ObjectInputStream (new FileInputStream(ruta));
        listaPW = (ArrayList<Password>) leyendoArchivo.readObject();
        leyendoArchivo.close();
    }
}
