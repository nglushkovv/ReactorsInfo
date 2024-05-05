/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.reactorsinfo;
import com.mycompany.reactorsinfo.model.Reactor;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author 79175
 */
public class UserGUI extends javax.swing.JFrame {
    private ManagementController managementController;

    /**
     * Creates new form UserGUI
     * @param managementController
     */
    public UserGUI(ManagementController managementController) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            ImageIcon icon = new ImageIcon(this.getClass().getResource("/logo.png"));
            this.setIconImage(icon.getImage());
            
            
        } catch (ClassNotFoundException | IllegalAccessException | 
                InstantiationException | UnsupportedLookAndFeelException e) {
        }
        initComponents();
        
        this.managementController = managementController;
        configureComponents();
        
       
    }
    
    private void configureTreeUI() {
        Icon expandedIcon = new ImageIcon(this.getClass().getResource("/reactorIcon.png"));
        Icon collapsedIcon = new ImageIcon(this.getClass().getResource("/atom.png"));
        
        DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) infoTree.getCellRenderer();
        renderer.setClosedIcon(expandedIcon);
        renderer.setOpenIcon(expandedIcon);
        renderer.setLeafIcon(collapsedIcon);
    }

    private void configureComponents() {
         
        try {
            configureTreeUI();
            configureImages();
            configureFileChooser();
            configureTree();
            configureDialog();
        } catch (IOException ex) {
            Logger.getLogger(UserGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void configureImages() throws IOException{
        URL inputStream = this.getClass().getResource("/atomPic.png");
         ImageIcon logoImage = new ImageIcon(inputStream);
         imageLabel.setIcon(logoImage);
         
         
    }
    
    private void configureDialog() {
        
        workingDialog.setSize(800, 800);
        workingDialog.setLocationRelativeTo(null);
        workingDialog.setTitle("Ведутся программные работы по написанию 4 лабы...");
        workingDialog.setIconImage(this.getIconImage());
        URL inputStream = this.getClass().getResource("/working.gif");
        ImageIcon logoImage = new ImageIcon(inputStream);
        workingPic.setIcon(logoImage);
    }
    
    private void configureTree() {
        DefaultMutableTreeNode model = new DefaultMutableTreeNode("Реакторы");
        List<Reactor> listOfReactors = managementController.getRepository().getListOfReactors();
        
        for(Reactor reactor: listOfReactors) {
            String[] attributes = reactor.getAtrributes();
            DefaultMutableTreeNode reactorNode = new DefaultMutableTreeNode(attributes[0]);
            
            for(int i=1; i<attributes.length; i++){
                reactorNode.add(new DefaultMutableTreeNode(
                        attributes[i].replace("null", "не указано")));
            }
            model.add(reactorNode);
        }
        
        infoTree.setModel(new javax.swing.tree.DefaultTreeModel(model));
        
        
    }
    
    private void configureFileChooser() {
        try {
            File currentDirectory = new File(getClass().getProtectionDomain()
                    .getCodeSource().getLocation().toURI().getPath()).getParentFile();
            fileChooser = new JFileChooser(currentDirectory);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Языки разметки",
                    "json", "xml", "yaml");
            fileChooser.setFileFilter(filter);
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.setDialogTitle("Импорт данных");
            
        } catch (URISyntaxException ex) {
            Logger.getLogger(UserGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        workingDialog = new javax.swing.JDialog();
        workingPic = new javax.swing.JLabel();
        workingLabel = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        mainTabbedPane = new javax.swing.JTabbedPane();
        treeTabPanel = new javax.swing.JScrollPane();
        infoTree = new javax.swing.JTree();
        labelPanel = new javax.swing.JPanel();
        reactorsInfoLabel = new javax.swing.JLabel();
        loadFileButton = new javax.swing.JButton();
        instructionButton = new javax.swing.JButton();
        imageLabel = new javax.swing.JLabel();
        databaseModeButton = new javax.swing.JButton();

        fileChooser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        workingDialog.setIconImage(null);
        workingDialog.setIconImages(null);
        workingDialog.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workingPic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        workingDialog.getContentPane().add(workingPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 800, 600));

        workingLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        workingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        workingLabel.setText("Ведутся программные работы...");
        workingDialog.getContentPane().add(workingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 640, 390, 70));

        workingDialog.getAccessibleContext().setAccessibleParent(mainPanel);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 102, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainTabbedPane.setBackground(new java.awt.Color(255, 200, 124));
        mainTabbedPane.setName(""); // NOI18N

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        infoTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        treeTabPanel.setViewportView(infoTree);

        mainTabbedPane.addTab("Отображение", treeTabPanel);

        mainPanel.add(mainTabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 450, 370));

        labelPanel.setBackground(new java.awt.Color(102, 153, 255));
        labelPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        reactorsInfoLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        reactorsInfoLabel.setForeground(new java.awt.Color(255, 255, 255));
        reactorsInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reactorsInfoLabel.setText("ReactorsINFO");
        labelPanel.add(reactorsInfoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 250, 70));

        loadFileButton.setText("Загрузить файл");
        loadFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadFileButtonActionPerformed(evt);
            }
        });
        labelPanel.add(loadFileButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 170, -1));

        instructionButton.setText("Инструкция");
        instructionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructionButtonActionPerformed(evt);
            }
        });
        labelPanel.add(instructionButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 170, -1));

        imageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPanel.add(imageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 190, 200));

        mainPanel.add(labelPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -10, 260, 470));

        databaseModeButton.setText("Режим работы с БД");
        databaseModeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                databaseModeButtonActionPerformed(evt);
            }
        });
        mainPanel.add(databaseModeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 150, 30));

        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void databaseModeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_databaseModeButtonActionPerformed
        workingDialog.setVisible(true);
    }//GEN-LAST:event_databaseModeButtonActionPerformed

    private void loadFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadFileButtonActionPerformed
        int returnValue = fileChooser.showOpenDialog(rootPane);
        
        if (returnValue == JFileChooser.APPROVE_OPTION) {
              File selectedFile = fileChooser.getSelectedFile();
              try{
                  managementController.readFile(selectedFile);
              } catch (IllegalArgumentException ex) {
                  JOptionPane.showMessageDialog(rootPane,
                          "Ошибка. Файл повреждён. Исправьте файл и попробуйте снова.",
                          "Ошибка импорта данных.",
                          JOptionPane.ERROR_MESSAGE);
              }
              configureTree();
        }
              
    }//GEN-LAST:event_loadFileButtonActionPerformed

    private void instructionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instructionButtonActionPerformed
        workingDialog.setVisible(true);
    }//GEN-LAST:event_instructionButtonActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton databaseModeButton;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JTree infoTree;
    private javax.swing.JButton instructionButton;
    private javax.swing.JPanel labelPanel;
    private javax.swing.JButton loadFileButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTabbedPane mainTabbedPane;
    private javax.swing.JLabel reactorsInfoLabel;
    private javax.swing.JScrollPane treeTabPanel;
    private javax.swing.JDialog workingDialog;
    private javax.swing.JLabel workingLabel;
    private javax.swing.JLabel workingPic;
    // End of variables declaration//GEN-END:variables
}
