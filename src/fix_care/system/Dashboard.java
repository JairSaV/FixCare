package fix_care.system;

import java.awt.Component;
import fix_care.form.Form_Dashboard;
import fix_care.form.Form_Empty;
import fix_care.menu.EventMenuSelected;
import fix_care.clases.Usuario;
import fix_care.form.Alta_Edificio;
import fix_care.form.Alta_Ticket;
import fix_care.form.Alta_Usuario;
import fix_care.form.Consulta;
import fix_care.form.DashBoard_Usuario;
import fix_care.form.Seguimiento;
import fix_care.form.Vinculacion;
import fix_care.menu.*;
import static java.awt.SystemColor.menu;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dashboard extends javax.swing.JFrame {

    private static Dashboard main;
    private Usuario usuario;

    public Dashboard() {

    }

    public void setUsuario(Usuario user) {
        usuario = user;
        initComponents();
        init();
    }

    private void init() {
        main = this;
        menu.setUsuario(usuario);
        titleBar.initJFram(this);
        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int index, int indexSubMenu) {
                System.out.println(usuario.getRol());
                if (usuario.getRol().equals("Administrador")) {
                    if (index == 0 && indexSubMenu == 0) {
                        try {
                            showForm(new Form_Dashboard());
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (index == 1 && indexSubMenu == 1) {
                        showForm(new Alta_Usuario());
                    } else if (index == 2 && indexSubMenu == 1) {
                        try {
                            showForm(new Alta_Edificio());
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (index == 3 && indexSubMenu == 1) {
                        try {
                            showForm(new Alta_Ticket(usuario));
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }else if (index == 3 && indexSubMenu == 2) {
                        try {
                            showForm(new Vinculacion());
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } 
                    else if (index == 3 && indexSubMenu == 3) {
                        try {
                            showForm(new Seguimiento());
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                    else if (index == 4 && indexSubMenu == 0) {
                        showForm(new Consulta(usuario));

                    } else if (index == 5 && indexSubMenu == 0) {

                        logout();
                    } else {
                        showForm(new Form_Empty(index + " " + indexSubMenu));
                    }
                } 
                else {
                    if (index == 0 && indexSubMenu == 0) {
                        try {
                            showForm(new DashBoard_Usuario(usuario));
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } 
                    else if (index == 1 && indexSubMenu == 0) {
                        try {
                            showForm(new Alta_Ticket(usuario));
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } 
                    else if (index == 2 && indexSubMenu == 0) {
                       showForm(new Consulta(usuario));
                    }
                    else if (index == 4 && indexSubMenu == 0) {

                        logout();
                    } else {
                        showForm(new Form_Empty(index + " " + indexSubMenu));
                    }

                }
            }

        });
        menu.setSelectedIndex(0, 0);

    }

    public void showForm(Component com) {
        body.removeAll();
        body.add(com);
        body.repaint();
        body.revalidate();
    }

    public void logout() {
        Login salir = new Login();
        salir.show();
        this.setVisible(false);

        this.dispose();

    }

    public static Dashboard getMain() {
        return main;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        panelMenu = new javax.swing.JPanel();
        menu = new fix_care.menu.Menu();
        titleBar = new fix_care.swing.titlebar.TitleBar();
        body = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        background.setBackground(new java.awt.Color(245, 245, 245));

        panelMenu.setBackground(new java.awt.Color(242, 242, 242));
        panelMenu.setToolTipText("");

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 815, Short.MAX_VALUE)
        );

        body.setOpaque(false);
        body.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addComponent(titleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 255, Short.MAX_VALUE))
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1052, 1052, 1052))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                .addComponent(titleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(body, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel body;
    private fix_care.menu.Menu menu;
    private javax.swing.JPanel panelMenu;
    private fix_care.swing.titlebar.TitleBar titleBar;
    // End of variables declaration//GEN-END:variables
}
