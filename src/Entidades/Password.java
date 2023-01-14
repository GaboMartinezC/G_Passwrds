package Entidades;
import java.io.Serializable;

public class Password implements Serializable
{
    private int id;
    private int usuario;
    private String descripcionServicio;
    private String informacion;
    
    public int GetId() 
    {
        return id;
    }
    public void SetId(int id) 
    {
        this.id = id;
    }
    public int GetUsuario() 
    {
        return usuario;
    }
    public void SetUsuario(int usuario) 
    {
        this.usuario = usuario;
    }
    public String GetDescripcionServicio() 
    {
        return descripcionServicio;
    }
    public void SetDescripcionServicio(String descripcionServicio) 
    {
        this.descripcionServicio = descripcionServicio;
    }
    public String GetInformacion() 
    {
        return informacion;
    }
    public void SetInformacion(String informacion) 
    {
        this.informacion = informacion;
    }
}
