package GUI;
import javax.swing.*;
import java.awt.event.*;
import BL.*;
import Entidades.Password;
import java.util.ArrayList;

public class Principal extends JFrame implements ActionListener
{
    private static Principal pri = new Principal();
    private PasswordBL blP = new PasswordBL();
    private UsuarioBL blU = new UsuarioBL();
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTable jTable1;

    public Principal()
    {
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jScrollPane1 = new JScrollPane();
        String[] columnas = {"ID","SERVICIO","CONTRASEÑA"};
        jTable1 = new JTable(LlenarMatriz(),columnas);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/logo.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("¡Hola "+GetUsuario()+"!");

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("<");
        jButton1.setBorder(null);
        jButton1.addActionListener(this);

        jButton2.setBackground(new java.awt.Color(204, 255, 204));
        jButton2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("+");
        jButton2.setBorder(null);
        jButton2.addActionListener(this);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
             jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGap(0, 481, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel2)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 56, Short.MAX_VALUE))
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

        pack();
        
    }
    private Object[][] LlenarMatriz()
    {
        ArrayList<Password> lista;
        Object [][] datos = {null};
        try
        {
            int contador = 0, id = -1;
            id = blU.IdUsuario();
            lista = blP.BuscarTodos(id);
            datos = new Object [lista.size()][3];
            for (Password p: lista)
            {
                datos [contador][0] = p.GetId();
                datos [contador][1] = p.GetDescripcionServicio();
                datos [contador][2] = p.GetInformacion();
                contador++;
            }
            return datos;
        }
        catch(Exception e)
        {
            e.printStackTrace();
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
        if (e.getSource()==jButton2)
        {
            Ingreso.Cargar();
            pri.setVisible(false);
        }
        if (e.getSource()==jButton1)
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
