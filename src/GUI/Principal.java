package GUI;
import javax.swing.*;
import java.awt.event.*;
import BL.*;
import Entidades.Password;
import java.util.ArrayList;

public class Principal extends JFrame implements ActionListener
{
    private static Principal pri = new Principal();
    private UsuarioBL blU = new UsuarioBL();
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JButton jButton2;
    private JTable tabla;
    private JScrollPane jspContenedor = new JScrollPane();

    public Principal()
    {
        //Codigo generado por el IDE
        jPanel1 = new JPanel();
        jButton2 = new JButton();
        jButton1 = new JButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton2.setBackground(new java.awt.Color(255, 102, 102));
        jButton2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("<");
        jButton2.setBorder(null);
        jButton2.addActionListener(this);

        jButton1.setBackground(new java.awt.Color(153, 255, 153));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("+");
        jButton1.setBorder(null);
        jButton1.addActionListener(this);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("¡Hola "+GetUsuario()+"!");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/logo.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 363, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 359, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        //Demás codigo
        try
        {
            UsuarioBL blU = new UsuarioBL();
            PasswordBL bl = new PasswordBL();
            int id = blU.IdUsuario();
            ArrayList<Password> lista = bl.BuscarTodos(id);
            String[] columnas = {"ID", "Servicio", "Contraseña"};
            Object datos[][] = LlenarMatriz(lista);
            tabla = new JTable (datos, columnas);
            jspContenedor = new JScrollPane(tabla);
            tabla.setFillsViewportHeight(true);
            jspContenedor.setBounds(0, 0, 400, 200);
            add(jspContenedor);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        pack();
        
    }
    private Object[][] LlenarMatriz(ArrayList<Password> lista)
    {
        int contador = 0;
        Object [][] datos = new Object [lista.size()][3];
        for (Password p: lista)
        {
            datos [contador][0] = p.GetId();
            datos [contador][1] = p.GetDescripcionServicio();
            datos [contador][2] = "••••••••••••••••••";
            contador++;
        }
        return datos;
    }
    private String GetUsuario()
    {
        String retVal = "";
        try
        {
            retVal = blU.Loged().GetDescripcion();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return retVal;
    }
    private void Unlog()
    {
        try
        {
            blU.Unlog();
            System.exit(0);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==jButton1)
        {
            Ingreso.Cargar();
            pri.setVisible(false);
        }
        if (e.getSource()==jButton2)
            Unlog();
    }
    public static void Cargar()
    {
        pri.setBounds(0,0,830,545);
        pri.setResizable(false);
        pri.setLocationRelativeTo(null);
        pri.setVisible(true);
    }
}
