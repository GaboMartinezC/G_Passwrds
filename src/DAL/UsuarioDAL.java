package DAL;
import Entidades.Usuario;
import java.io.*;
import java.util.ArrayList;

public class UsuarioDAL 
{
    private static ArrayList<String> listaPW = new ArrayList<>();
    private static ArrayList<Usuario> listaUS = new ArrayList<>();
    private String rutaPW = "C:/GPWFLS/psw.bin";
    private String rutaU = "C:/GPWFLS/logged.bin";
    private String ruta = "C:/GPWFLS/infoUsuario.bin";
    
    public void Unlog() throws Exception
    {
        Usuario usuario = new Usuario();
        usuario.SetId(-1);
        ObjectOutputStream escribiendoArchivo = new ObjectOutputStream (new FileOutputStream(rutaU));
        escribiendoArchivo.writeObject(usuario);
        escribiendoArchivo.close();
    }
    public boolean isLoged() throws Exception
    {
        boolean retVal = true;
        ObjectInputStream leyendoArchivo = new ObjectInputStream (new FileInputStream(rutaU));
        Usuario usuario = (Usuario) leyendoArchivo.readObject();
        leyendoArchivo.close();
        if (usuario.GetId()==-1)
            retVal = false;
        return retVal;
    }
    public Usuario Buscar(String descripcion)
    {
        Usuario retVal = new Usuario();
        retVal.SetId(-1);
        for (Usuario u: listaUS)
        {
            if (u.GetDescripcion().equals(descripcion))
                retVal = u;
        }
        return retVal;
    }
    public boolean Login(Usuario usuario, String contraIng) throws Exception
    {
        boolean retVal = true;
        EncriptDAL encript = new EncriptDAL();
        String contra;
        File archivo = new File(rutaU);
        if (Buscar(usuario.GetDescripcion()).GetId()!=-1)
        {
            contra = listaPW.get(Integer.parseInt(usuario.GetPasswd()));
            contra = encript.DesencriptarContra(contra);
            if (contraIng.equals(contra))
            {
                
                if (!archivo.exists())
                    archivo.createNewFile();
                
                ObjectOutputStream escribiendoArchivo = new ObjectOutputStream (new FileOutputStream(rutaU));
                escribiendoArchivo.writeObject(usuario);
                escribiendoArchivo.close();
            }
            else
            {
                retVal = false;
            }
        }
        else
        {
            retVal = false;
        }
        return retVal;
    }
    public ArrayList<Usuario> BuscarTodos()
    {
        return listaUS;
    }
    public void Borrar(Usuario usuario) throws Exception
    {
        for (int i = 0; i<listaUS.size(); i++)
        {
            if (listaUS.get(i).GetId()==usuario.GetId())
                listaUS.remove(i);
        }
    }
    public boolean Ingresar(Usuario usuario) throws Exception
    {
        String contra;
        boolean retVal = true;
        EncriptDAL encript = new EncriptDAL();
        for (Usuario u: listaUS)
        {
            if (u.GetDescripcion().equals(usuario.GetDescripcion()))
                retVal = false;
        }
        if (retVal)
        {
            ruta = "psw"+listaPW.size()+".bin";
            usuario.SetId(listaUS.size()+1);
            contra = encript.HashContra(usuario.GetPasswd());
            usuario.SetPasswd(String.valueOf(listaPW.size()));
            listaPW.add(contra);
            EscribirPW();
            listaUS.add(usuario);
            Escribir();
        }
        return retVal;
    }
    private void EscribirPW() throws Exception
    {
        ObjectOutputStream escribiendoArchivo = new ObjectOutputStream (new FileOutputStream(rutaPW));
        escribiendoArchivo.writeObject(listaPW);
        escribiendoArchivo.close();
    }
    private void LeerPW() throws Exception
    {
        File archivo = new File(rutaPW);
        if (!archivo.exists())
        {
            ObjectOutputStream escribiendoArchivo = new ObjectOutputStream (new FileOutputStream(rutaPW));
            archivo.createNewFile();
            escribiendoArchivo.writeObject(listaPW);
            escribiendoArchivo.close();
        }
        ObjectInputStream leyendoArchivo = new ObjectInputStream (new FileInputStream(ruta));
        listaPW = (ArrayList<String>) leyendoArchivo.readObject();
        leyendoArchivo.close();
    }
    public void AccesoPW() throws Exception
    {
        LeerPW();
    }
    private void Escribir() throws Exception
    {
        ObjectOutputStream escribiendoArchivo = new ObjectOutputStream (new FileOutputStream(ruta));
        escribiendoArchivo.writeObject(listaUS);
        escribiendoArchivo.close();
    }
    public void AccesoLeer () throws Exception
    {
        Leer();
    }
    private void Leer() throws Exception
    {
        File archivo = new File(ruta);
        File rutau = new File(rutaU);
        Usuario usuario = new Usuario();
        usuario.SetId(-1);
        if (!archivo.exists())
        {
            ObjectOutputStream escribiendoArchivo = new ObjectOutputStream (new FileOutputStream(ruta));
            ObjectOutputStream escribiendoArchivoU = new ObjectOutputStream (new FileOutputStream(rutaU));
            archivo.createNewFile();
            escribiendoArchivo.writeObject(listaUS);
            escribiendoArchivo.close();
            rutau.createNewFile();
            escribiendoArchivoU.writeObject(usuario);
            escribiendoArchivoU.close();
        }
        ObjectInputStream leyendoArchivo = new ObjectInputStream (new FileInputStream(ruta));
        listaUS = (ArrayList<Usuario>) leyendoArchivo.readObject();
        leyendoArchivo.close();
    }
}
