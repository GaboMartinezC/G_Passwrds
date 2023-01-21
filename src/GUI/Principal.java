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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;

    public Principal()
    {
        String[] columnas = {"ID","SERVICIO","CONTRASEÑA (CIFRADO)"};
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable(LlenarMatriz(),columnas);
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/logo.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("¡Hola "+GetUsuario()+"!");

        jButton1.setBackground(new java.awt.Color(102, 153, 255));
        jButton1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText(" ? ");
        jButton1.setToolTipText("");
        jButton1.setBorder(null);
        jButton1.addActionListener(this);
        
        jButton2.setBackground(new java.awt.Color(255, 153, 153));
        jButton2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("<");
        jButton2.setBorder(null);
        jButton2.addActionListener(this);

        jScrollPane1.setViewportView(jTable1);

        jButton3.setBackground(new java.awt.Color(204, 255, 204));
        jButton3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("+");
        jButton3.setToolTipText("");
        jButton3.setBorder(null);
        jButton3.addActionListener(this);
        
        jButton4.setBackground(new java.awt.Color(102, 204, 255));
        jButton4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setText(" X ");
        jButton4.setToolTipText("");
        jButton4.setBorder(null);
        jButton4.addActionListener(this);
        
        jButton5.setBackground(new java.awt.Color(0, 204, 255));
        jButton5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 0, 0));
        jButton5.setText(" M ");
        jButton5.setToolTipText("");
        jButton5.setBorder(null);
        jButton5.addActionListener(this);
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1))
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(38, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel2)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton4)
                                .addComponent(jButton5)
                                .addComponent(jButton1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
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
    private void Desencriptar()
    {
        try
        {
            PasswordBL bl = new PasswordBL();
            int id = Integer.parseInt(jTextField1.getText());
            if (String.valueOf(jTextField1.getText()).equals(""))
                JOptionPane.showMessageDialog(null, "No hay informacion");
            else
            {
                if (bl.Desencriptar(id).equals(""))
                    JOptionPane.showMessageDialog(null, "No hay informacion");
                else
                    JOptionPane.showMessageDialog(null, bl.Desencriptar(id));
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "No hay informacion");
        }
    }
    private void Borrar()
    {
        try
        {
            PasswordBL bl = new PasswordBL();
            int id = Integer.parseInt(jTextField1.getText());
            if (String.valueOf(jTextField1.getText()).equals(""))
                JOptionPane.showMessageDialog(null, "No hay informacion");
            else
            {
                if (bl.Borrar(id))
                    JOptionPane.showMessageDialog(null, "Borrado correcto");
                else
                    JOptionPane.showMessageDialog(null, "No hay informacion");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "No hay informacion");
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==jButton1)
            Desencriptar();
        if (e.getSource()==jButton2)
            Unlog();
        if (e.getSource()==jButton3)
        {
            Ingreso.Cargar();
            pri.setVisible(false);
        }
        if (e.getSource()==jButton4)
            Borrar();
        if (e.getSource()==jButton5)
        {
            try
            {
                Actualizar.Cargar(Integer.parseInt(jTextField1.getText()));
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, "No hay informacion");
            }
        }
            
    }
    public static void Cargar()
    {
        pri.setBounds(0,0,830,545);
        pri.setResizable(false);
        pri.setLocationRelativeTo(null);
        pri.setVisible(true);
    }
}

