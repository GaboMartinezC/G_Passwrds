package DAL;
import Entidades.Usuario;
import java.io.*;
import java.util.ArrayList;

public class UsuarioDAL 
{
    private static ArrayList<Usuario> listaUS = new ArrayList<>();
    private String rutaU = "C:/GPWFLS/logged.bin";
    private String ruta = "C:/GPWFLS/infoUsuario.bin";
    
    private Usuario PrivLoged() throws Exception
    {
        Usuario usuario;
        ObjectInputStream leyendoArchivo = new ObjectInputStream (new FileInputStream(rutaU));
        usuario = (Usuario) leyendoArchivo.readObject();
        leyendoArchivo.close();
        return usuario;
    }
    public Usuario Loged() throws Exception
    {
        return this.PrivLoged();
    }
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
    public boolean Login(Usuario usuario, String contraIng) throws Exception
    {
        boolean retVal = false;
        String contra;
        EncriptDAL enc = new EncriptDAL();
        for (Usuario u: listaUS)
        {
            if (u.GetDescripcion().equals(usuario.GetDescripcion()))
            {
                contra = enc.DesencriptarContra(u.GetPasswd());
                if (contra.equals(contraIng))
                {
                    ObjectOutputStream escribiendoArchivo = new ObjectOutputStream (new FileOutputStream(rutaU));
                    escribiendoArchivo.writeObject(u);
                    escribiendoArchivo.close();
                    retVal = true;
                }
            }
        }
        return retVal;
    }
    public boolean Ingresar(Usuario usuario) throws Exception
    {
        boolean retVal = true;
        String contra;
        EncriptDAL encript = new EncriptDAL();
        for (Usuario u: listaUS)
        {
            if (usuario.GetDescripcion().equals(u.GetDescripcion()))
                retVal = false;
        }
        if (retVal)
        {
            contra = encript.HashContra(usuario.GetPasswd());
            usuario.SetId(listaUS.size()+1);
            usuario.SetPasswd(contra);
            listaUS.add(usuario);
            Escribir();
        }
        return retVal;
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
