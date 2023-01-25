package DAL;
import Entidades.Password;
import java.util.ArrayList;
import java.io.*;

public class PasswordDAL 
{
    private static ArrayList<Password> listaPW = new ArrayList<>();
    private final static String rutaDir = "C:/GPWFLS";
    private final static String ruta = "C:/GPWFLS/infopw.bin";
    private static EncriptDAL encript = new EncriptDAL();
    
    public boolean Actualizar(Password password) throws Exception
    {
        boolean retVal = false;
        for (Password p: listaPW)
        {
            if (p.GetId()==password.GetId())
            {
                p.SetDescripcionServicio(password.GetDescripcionServicio());
                p.SetInformacion(encript.HashContra(password.GetInformacion()));
                Escribir();
            }
        }
        return retVal;
    }
    public String Desencriptar(int id)
    {
        String retVal = "", contraEncriptada = "";
        for (Password p: listaPW)
        {
            if (p.GetId()==id)
                contraEncriptada = p.GetInformacion();
        }
        retVal = encript.DesencriptarContra(contraEncriptada);
        return retVal;
    }
    public ArrayList<Password> BuscarTodos(int id)
    {
        ArrayList<Password> retVal = new ArrayList<>();
        for (Password p: listaPW)
        {
            if (p.GetUsuario()==id)
                retVal.add(p);
        }
        return retVal;
    }
    public boolean Borrar(int id) throws Exception
    {
        boolean retVal = false;
        for (int i = 0; i<listaPW.size();i++)
        {
            if (listaPW.get(i).GetId()==id)
            {
                retVal = true;
                listaPW.remove(i);
                Escribir();
            }
        }
        return retVal;
    }
    public void Ingresar(Password password) throws Exception
    {
        String contra = encript.HashContra(password.GetInformacion());
        boolean control = false;
        int idAsignado = listaPW.size()+1;
        while (!control)
        {
            control = true;
            for (Password p: listaPW)
            {
                if (p.GetId()==idAsignado)   
                    control = false;
                    idAsignado++;
                    break;
            }
        }
        password.SetId(idAsignado);
        password.SetInformacion(contra);
        listaPW.add(password);
        Escribir();   
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
