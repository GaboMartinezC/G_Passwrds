package DAL;
import Entidades.Password;
import java.util.ArrayList;
import java.io.*;

public class PasswordDAL 
{
    private static ArrayList<Password> listaPW = new ArrayList<>();
    private static String rutaDir = "C:/GPWFLS";
    private static String ruta = "C:/GPWFLS/infopw.bin";
    private static EncriptDAL encript = new EncriptDAL();
    
    public boolean Actualizar(Password password)
    {
        boolean retVal = false;
        for (Password p: listaPW)
        {
            if (p.GetId()==password.GetId())
            {
                p = password;
                retVal = true;
                
            }
        }
        return retVal;
    }
    public ArrayList<Password> BuscarTodos()
    {
        return listaPW;
    }
    public String Buscar (Password password)
    {
        String retVal = "";
        for (Password p: listaPW)
        {
            if (p.GetId()==password.GetId())
            {
                retVal = p.GetInformacion();
                retVal =  encript.DesencriptarContra(retVal);
            }
        }
        return retVal;
    }
    public boolean Ingresar(Password password) throws Exception
    {
        boolean retVal = true;
        if (!password.GetInformacion().equals(""))
        {
            String contra = encript.HashContra(password.GetInformacion());
            password.SetInformacion(contra);
            listaPW.add(password);
        }
        else
            retVal = false;
        return retVal;
        
    }
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
