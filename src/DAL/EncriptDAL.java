package DAL;

public class EncriptDAL 
{
    public String DesencriptarContra(String contra)
    {
        char arr[] = contra.toCharArray();
        for (int i = 0; i<arr.length; i++)
            arr[i] = (char)(arr[i]/(char)7);
        return String.valueOf(arr);
    }
    public String HashContra(String contra)
    {
        char arr[] = contra.toCharArray();
        for (int i = 0; i<arr.length; i++)
            arr[i] = (char)(arr[i]*(char)7);
        return String.valueOf(arr);
    }
}
