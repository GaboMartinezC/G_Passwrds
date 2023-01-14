package Entidades;
import java.io.Serializable;

public class Usuario implements Serializable
{
    private int id;
    private String descripcion;
    private String passwd;

    public int GetId() 
    {
        return id;
    }
    public void SetId(int id) 
    {
        this.id = id;
    }
    public String GetDescripcion() 
    {
        return descripcion;
    }
    public void SetDescripcion(String descripcion) 
    {
        this.descripcion = descripcion;
    }
    public String GetPasswd() 
    {
        return passwd;
    }
    public void SetPasswd(String passwd) 
    {
        this.passwd = passwd;
    }
    
    
}
