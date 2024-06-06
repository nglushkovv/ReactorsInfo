/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.reactorsinfo;
import com.mycompany.reactorsinfo.model.ReactorType;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author 79175
 */
public class UserGUI extends javax.swing.JFrame {
    private ManagementController managementController;
    private Thread mainThread = new Thread();

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
            showTable.setVisible(false);
            
        } catch (IOException ex) {
            Logger.getLogger(UserGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void configureTable() {
        databaseModeTable.setDefaultEditor(Object.class, null);
        
        int type = optionsComboBox.getSelectedIndex();
        DefaultTableModel model = managementController.getTaskRunner().prepareTableModel(type);
        databaseModeTable.setModel(model);
        databaseModeTable.repaint();
    }
    
    
    private void configureImages() throws IOException{
        URL inputStream = this.getClass().getResource("/atomPic.png");
         ImageIcon logoImage = new ImageIcon(inputStream);
         imageLabel.setIcon(logoImage);
        
        
    }
    
    private void configureDialog() {
        
        databaseModeDialog.setSize(700, 550);
        databaseModeDialog.setLocationRelativeTo(null);
        databaseModeDialog.setTitle("Режим работы с БД");
        
        
        
    }
    
    private void configureTree() {
        DefaultMutableTreeNode model = new DefaultMutableTreeNode("Реакторы");
        List<ReactorType> listOfReactors = managementController.getReactorService().getListOfReactorTypes();
        
        for(ReactorType reactor: listOfReactors) {
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
        dropProcessButton = new javax.swing.JButton();
        databaseModeDialog = new javax.swing.JDialog();
        scrollPaneDialog = new javax.swing.JScrollPane();
        databaseModeTable = new javax.swing.JTable();
        optionsComboBox = new javax.swing.JComboBox<>();
        mainPanel = new javax.swing.JPanel();
        mainTabbedPane = new javax.swing.JTabbedPane();
        treeTabPanel = new javax.swing.JScrollPane();
        infoTree = new javax.swing.JTree();
        labelPanel = new javax.swing.JPanel();
        reactorsInfoLabel = new javax.swing.JLabel();
        loadFileButton = new javax.swing.JButton();
        imageLabel = new javax.swing.JLabel();
        databaseModeButton = new javax.swing.JButton();
        showTable = new javax.swing.JButton();

        fileChooser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        workingDialog.setIconImage(null);
        workingDialog.setIconImages(null);
        workingDialog.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workingPic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        workingDialog.getContentPane().add(workingPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 800, 600));

        dropProcessButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        dropProcessButton.setText("Прервать процесс создания БД");
        dropProcessButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropProcessButtonActionPerformed(evt);
            }
        });
        workingDialog.getContentPane().add(dropProcessButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, 320, 50));

        workingDialog.getAccessibleContext().setAccessibleParent(mainPanel);

        databaseModeDialog.setBackground(new java.awt.Color(102, 153, 255));
        databaseModeDialog.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        databaseModeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrollPaneDialog.setViewportView(databaseModeTable);

        databaseModeDialog.getContentPane().add(scrollPaneDialog, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 51, 640, 410));

        optionsComboBox.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        optionsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Суммарное потребление по регионам", "Суммарное потребление по странам", "Суммарное потребление по компаниям", "Объем ежегодного потребления реактором топлива" }));
        optionsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionsComboBoxActionPerformed(evt);
            }
        });
        databaseModeDialog.getContentPane().add(optionsComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 530, 30));

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
        labelPanel.add(loadFileButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 170, -1));

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

        showTable.setText("Посмотреть таблицу");
        showTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showTableActionPerformed(evt);
            }
        });
        mainPanel.add(showTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 150, 30));

        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void databaseModeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_databaseModeButtonActionPerformed
        
        try {
            
            if(checkDatabaseFile()) {
                managementController.startDatabaseMode("UPDATE");
                databaseModeDialog.setVisible(true);
                databaseModeButton.setEnabled(false);
                showTable.setVisible(true);
                configureTable();
                
            }
            else{
                if(mainThread != null || mainThread.isAlive()){
                    mainThread.interrupt();
                }
                String[] choices = {"Создать новую базу данных (Займет некоторое время)", "Выбрать существующую..."};
                Object dialogResult = JOptionPane.showInputDialog(
                                        rootPane,
                                        "Выбор варианта.",
                                        "База данных не обнаружена. Выберите один из вариантов.",
                                        JOptionPane.QUESTION_MESSAGE,
                                        null, choices,
                                         choices[0]);
                if(dialogResult != null &&
                        dialogResult.toString().equals(choices[0])){
                    if(managementController.getReactorService().getListOfReactorTypes().isEmpty()){
    
                        JOptionPane.showMessageDialog(rootPane,
                                "Ошибка." +
                                " Перед началом загрузите информацию о типе реакторов.",
                                "Ошибка", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        startCreatingDB();
                        }
                        
                    
                } else if (dialogResult != null &&
                        dialogResult.toString().equals(choices[1])){
                    chooseDBFile();
                }
                
            }
            
        } catch (IOException ex) {
             JOptionPane.showMessageDialog(rootPane, "Ошибка."
                    + "Непредвиденная ошибка. Попробуйте снова.", "Ошибка", JOptionPane.ERROR_MESSAGE);
        
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(rootPane, "Ошибка."
                    + " База данных в данный момент уже используется.", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_databaseModeButtonActionPerformed

    private void chooseDBFile() throws IOException {
        FileNameExtensionFilter filter = new FileNameExtensionFilter("H2 База данных",
                    "db");
                fileChooser.setFileFilter(filter);
        int returnValue = fileChooser.showOpenDialog(rootPane);
        
        if (returnValue == JFileChooser.APPROVE_OPTION) {
                      File selectedFile = fileChooser.getSelectedFile();
                      String filepath = selectedFile.getAbsolutePath();
                      managementController.setDBPath(filepath);
                      managementController.startDatabaseMode("UPDATE");
                      databaseModeDialog.setVisible(true);
                      databaseModeButton.setEnabled(false);
                      showTable.setVisible(true);
                      configureTable();
                      
                
            }
    }
    
    private void startCreatingDB() {
        System.out.println("Начался процесс парсинга и создания БД. В идеале он займет 16-17 минут.");
        mainThread = new Thread() {
            public void run() {
                try {
                    databaseModeButton.setEnabled(false);
                    managementController.startDatabaseMode("CREATE");
                    databaseModeDialog.setVisible(true);
                    configureTable();
                } catch (IOException ex) {
                                    JOptionPane.showMessageDialog(rootPane, "Ошибка."
                    + "Непредвиденная ошибка. Попробуйте снова.", "Ошибка", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        };
        mainThread.start();
 
        }
      
    
    
    
    
    private Boolean checkDatabaseFile() {
        try {
            
            String jarPath = new File(this.getClass().
                    getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();
            String jarDir = new File(jarPath).getParent();
            String fileName = "ReactorInfo.mv.db";
            Path filePath = Paths.get(jarDir, fileName);
            if(Files.exists(filePath)){
                return true;
            }
            else{
                return false;
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(UserGUI.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return false;
    }
    
    private void doDatabaseModeChanges() {
        databaseModeDialog.setVisible(true);
        databaseModeDialog.setSize(750, 500);
    }
    
    
    private void loadFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadFileButtonActionPerformed
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Языки разметки",
                    "json", "xml", "yaml");
        fileChooser.setFileFilter(filter);
        
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

    private void optionsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionsComboBoxActionPerformed
        configureTable();
        
    }//GEN-LAST:event_optionsComboBoxActionPerformed

    private void dropProcessButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropProcessButtonActionPerformed
        mainThread.interrupt();
    }//GEN-LAST:event_dropProcessButtonActionPerformed

    private void showTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showTableActionPerformed
        databaseModeDialog.setVisible(true);
    }//GEN-LAST:event_showTableActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton databaseModeButton;
    private javax.swing.JDialog databaseModeDialog;
    private javax.swing.JTable databaseModeTable;
    private javax.swing.JButton dropProcessButton;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JTree infoTree;
    private javax.swing.JPanel labelPanel;
    private javax.swing.JButton loadFileButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTabbedPane mainTabbedPane;
    private javax.swing.JComboBox<String> optionsComboBox;
    private javax.swing.JLabel reactorsInfoLabel;
    private javax.swing.JScrollPane scrollPaneDialog;
    private javax.swing.JButton showTable;
    private javax.swing.JScrollPane treeTabPanel;
    private javax.swing.JDialog workingDialog;
    private javax.swing.JLabel workingPic;
    // End of variables declaration//GEN-END:variables
}
