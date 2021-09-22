package view.main;

import view.arbolGrafico.ArbolGrafico;
import model.structure.Arbol;
import controller.TransaccionController;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import model.system.Persona;
import view.Dialog;

public class MainView extends javax.swing.JFrame {

    private Arbol arbol;
    private final ArbolGrafico arbolGrafico;
    private final TransaccionController transaccionController;
    private final Persona user;

    public MainView(Arbol arbol, Persona user) {
        initComponents();
        this.arbol = arbol;
        this.user = user;
        this.transaccionController = new TransaccionController(arbol);
        this.arbolGrafico = new ArbolGrafico(arbol);

        // Añadir los paneles externos
        this.arbolPanel.add(this.arbolGrafico);
        this.mainPanel.add(this.inicioPanel);

        this.idTxt.setText(String.valueOf(user.getId()));
        this.namesTxt.setText(user.getNames() + " " + user.getLastNames());
        this.moneyVisual.setText(String.valueOf(user.getDinero()));

        this.revalidate();
        this.repaint();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        inicioPanel = new javax.swing.JPanel();
        fistPanel = new javax.swing.JPanel();
        moneyPanel = new javax.swing.JPanel();
        avilableLabel = new javax.swing.JLabel();
        moneyLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        idTxt = new javax.swing.JLabel();
        namesTxt = new javax.swing.JLabel();
        moneyVisual = new javax.swing.JLabel();
        scrollPanel = new javax.swing.JScrollPane();
        sendCenterPanel = new javax.swing.JPanel();
        sendFormPanel = new javax.swing.JPanel();
        sendUserNameLabel = new javax.swing.JLabel();
        sendUserNameTxt = new javax.swing.JTextField();
        sendMoneyLabel = new javax.swing.JLabel();
        sendMoneyTxt = new javax.swing.JSpinner();
        sendMessangeLabel = new javax.swing.JLabel();
        scrollMessangePanel = new javax.swing.JScrollPane();
        sendMenssangeTxt = new javax.swing.JTextArea();
        sendTitleLabel = new javax.swing.JLabel();
        sendBtn = new javax.swing.JButton();
        arbolPanel = new javax.swing.JPanel();
        perfilPanel = new javax.swing.JPanel();
        signUpUserLabel = new javax.swing.JLabel();
        signUpPasswordLabel = new javax.swing.JLabel();
        signUpUserNameTxt = new javax.swing.JTextField();
        signUpPasswordTxt = new javax.swing.JPasswordField();
        changeDataBtn = new javax.swing.JButton();
        labelName = new javax.swing.JLabel();
        signUpLastNameTxt = new javax.swing.JTextField();
        singUpNameTxt = new javax.swing.JTextField();
        singUpLastNameLabel = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        ActivityPanel = new javax.swing.JPanel();
        showArbolBtn = new javax.swing.JButton();
        showInicioBtn = new javax.swing.JButton();
        showPerfilBtn = new javax.swing.JButton();

        inicioPanel.setBackground(new java.awt.Color(27, 20, 100));
        inicioPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inicioPanel.setLayout(new java.awt.BorderLayout());

        fistPanel.setBackground(new java.awt.Color(27, 20, 100));
        fistPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));

        moneyPanel.setBackground(new java.awt.Color(236, 0, 140));
        moneyPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        moneyPanel.setMaximumSize(new java.awt.Dimension(100, 120));
        moneyPanel.setMinimumSize(new java.awt.Dimension(300, 120));
        moneyPanel.setPreferredSize(new java.awt.Dimension(330, 130));
        moneyPanel.setLayout(null);

        avilableLabel.setBackground(new java.awt.Color(255, 255, 255));
        avilableLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        avilableLabel.setForeground(new java.awt.Color(255, 255, 255));
        avilableLabel.setText("Disponible");
        avilableLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        moneyPanel.add(avilableLabel);
        avilableLabel.setBounds(10, 10, 58, 17);

        moneyLabel.setBackground(new java.awt.Color(255, 255, 255));
        moneyLabel.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        moneyLabel.setForeground(new java.awt.Color(255, 255, 255));
        moneyLabel.setText("$ ");
        moneyPanel.add(moneyLabel);
        moneyLabel.setBounds(10, 27, 35, 60);

        idLabel.setBackground(new java.awt.Color(255, 255, 255));
        idLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        idLabel.setForeground(new java.awt.Color(255, 255, 255));
        idLabel.setText("ID");
        moneyPanel.add(idLabel);
        idLabel.setBounds(10, 87, 13, 17);

        nameLabel.setBackground(new java.awt.Color(255, 255, 255));
        nameLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(255, 255, 255));
        nameLabel.setText("Nombre");
        moneyPanel.add(nameLabel);
        nameLabel.setBounds(10, 110, 46, 17);

        idTxt.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        idTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        moneyPanel.add(idTxt);
        idTxt.setBounds(149, 88, 161, 16);

        namesTxt.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        namesTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        moneyPanel.add(namesTxt);
        namesTxt.setBounds(149, 110, 161, 17);

        moneyVisual.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        moneyVisual.setForeground(new java.awt.Color(255, 255, 255));
        moneyVisual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        moneyPanel.add(moneyVisual);
        moneyVisual.setBounds(142, 30, 170, 40);

        fistPanel.add(moneyPanel);

        inicioPanel.add(fistPanel, java.awt.BorderLayout.PAGE_START);

        scrollPanel.setBackground(new java.awt.Color(255, 255, 255));
        scrollPanel.setBorder(null);
        scrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        sendCenterPanel.setBackground(new java.awt.Color(27, 20, 100));
        sendCenterPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        sendCenterPanel.setPreferredSize(new java.awt.Dimension(380, 230));

        sendFormPanel.setBackground(new java.awt.Color(255, 255, 255));
        sendFormPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(27, 20, 100), 1, true));
        sendFormPanel.setPreferredSize(new java.awt.Dimension(330, 320));

        sendUserNameLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        sendUserNameLabel.setText("Usuario");

        sendUserNameTxt.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        sendMoneyLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        sendMoneyLabel.setText("Cantidad");

        sendMoneyTxt.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        sendMessangeLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        sendMessangeLabel.setText("Mensaje");

        sendMenssangeTxt.setColumns(20);
        sendMenssangeTxt.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        sendMenssangeTxt.setRows(5);
        scrollMessangePanel.setViewportView(sendMenssangeTxt);

        sendTitleLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        sendTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sendTitleLabel.setText("Enviar Dinero");

        sendBtn.setBackground(new java.awt.Color(0, 255, 197));
        sendBtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        sendBtn.setText("Enviar");
        sendBtn.setBorderPainted(false);
        sendBtn.setFocusPainted(false);
        sendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sendFormPanelLayout = new javax.swing.GroupLayout(sendFormPanel);
        sendFormPanel.setLayout(sendFormPanelLayout);
        sendFormPanelLayout.setHorizontalGroup(
            sendFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sendFormPanelLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(sendFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sendMessangeLabel)
                    .addComponent(sendTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(sendFormPanelLayout.createSequentialGroup()
                        .addComponent(sendMoneyLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sendMoneyTxt))
                    .addGroup(sendFormPanelLayout.createSequentialGroup()
                        .addComponent(sendUserNameLabel)
                        .addGap(18, 18, 18)
                        .addComponent(sendUserNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(67, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sendFormPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollMessangePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sendFormPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sendBtn)
                .addGap(124, 124, 124))
        );
        sendFormPanelLayout.setVerticalGroup(
            sendFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sendFormPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(sendTitleLabel)
                .addGap(18, 18, 18)
                .addGroup(sendFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendUserNameLabel)
                    .addComponent(sendUserNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(sendFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendMoneyLabel)
                    .addComponent(sendMoneyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(sendMessangeLabel)
                .addGap(18, 18, 18)
                .addComponent(scrollMessangePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sendBtn)
                .addContainerGap())
        );

        sendCenterPanel.add(sendFormPanel);

        scrollPanel.setViewportView(sendCenterPanel);

        inicioPanel.add(scrollPanel, java.awt.BorderLayout.CENTER);

        arbolPanel.setBackground(new java.awt.Color(255, 255, 255));
        arbolPanel.setLayout(new java.awt.BorderLayout());

        perfilPanel.setBackground(new java.awt.Color(255, 255, 255));
        perfilPanel.setFocusable(false);
        perfilPanel.setPreferredSize(new java.awt.Dimension(353, 240));
        perfilPanel.setRequestFocusEnabled(false);
        perfilPanel.setLayout(new java.awt.GridBagLayout());

        signUpUserLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        signUpUserLabel.setText("Usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 68, 10, 0);
        perfilPanel.add(signUpUserLabel, gridBagConstraints);

        signUpPasswordLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        signUpPasswordLabel.setText("Contraseña");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 68, 10, 0);
        perfilPanel.add(signUpPasswordLabel, gridBagConstraints);

        signUpUserNameTxt.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        signUpUserNameTxt.setToolTipText("Usuario");
        signUpUserNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpUserNameTxtActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 148;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 18, 10, 35);
        perfilPanel.add(signUpUserNameTxt, gridBagConstraints);

        signUpPasswordTxt.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        signUpPasswordTxt.setToolTipText("Contraseña");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 148;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 18, 10, 35);
        perfilPanel.add(signUpPasswordTxt, gridBagConstraints);

        changeDataBtn.setBackground(new java.awt.Color(236, 0, 140));
        changeDataBtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        changeDataBtn.setForeground(new java.awt.Color(255, 255, 255));
        changeDataBtn.setText("Cambiar");
        changeDataBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        changeDataBtn.setBorderPainted(false);
        changeDataBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        changeDataBtn.setFocusPainted(false);
        changeDataBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeDataBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 23;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 68, 10, 0);
        perfilPanel.add(changeDataBtn, gridBagConstraints);

        labelName.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        labelName.setText("Nombres");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 68, 10, 0);
        perfilPanel.add(labelName, gridBagConstraints);

        signUpLastNameTxt.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        signUpLastNameTxt.setToolTipText("Usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 148;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 18, 10, 35);
        perfilPanel.add(signUpLastNameTxt, gridBagConstraints);

        singUpNameTxt.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        singUpNameTxt.setToolTipText("Usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 148;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 18, 10, 35);
        perfilPanel.add(singUpNameTxt, gridBagConstraints);

        singUpLastNameLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        singUpLastNameLabel.setText("Apellidos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 68, 10, 0);
        perfilPanel.add(singUpLastNameLabel, gridBagConstraints);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Block Pay");
        setExtendedState(6);
        setIconImage((new ImageIcon(getClass().getResource("/resources/img/logo.png"))).getImage());
        setMinimumSize(new java.awt.Dimension(600, 650));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setForeground(new java.awt.Color(255, 255, 255));
        mainPanel.setMinimumSize(new java.awt.Dimension(600, 356));
        mainPanel.setPreferredSize(new java.awt.Dimension(600, 356));
        mainPanel.setLayout(new java.awt.BorderLayout());
        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        ActivityPanel.setBackground(new java.awt.Color(27, 20, 100));
        ActivityPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        showArbolBtn.setBackground(new java.awt.Color(42, 35, 115));
        showArbolBtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        showArbolBtn.setForeground(new java.awt.Color(255, 255, 255));
        showArbolBtn.setText("Arbol");
        showArbolBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        showArbolBtn.setBorderPainted(false);
        showArbolBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showArbolBtn.setFocusPainted(false);
        showArbolBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showArbolBtnActionPerformed(evt);
            }
        });
        ActivityPanel.add(showArbolBtn);

        showInicioBtn.setBackground(new java.awt.Color(42, 35, 115));
        showInicioBtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        showInicioBtn.setForeground(new java.awt.Color(255, 255, 255));
        showInicioBtn.setText("Inicio");
        showInicioBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        showInicioBtn.setBorderPainted(false);
        showInicioBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showInicioBtn.setFocusPainted(false);
        showInicioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showInicioBtnActionPerformed(evt);
            }
        });
        ActivityPanel.add(showInicioBtn);

        showPerfilBtn.setBackground(new java.awt.Color(42, 35, 115));
        showPerfilBtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        showPerfilBtn.setForeground(new java.awt.Color(255, 255, 255));
        showPerfilBtn.setText("Perfil");
        showPerfilBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        showPerfilBtn.setBorderPainted(false);
        showPerfilBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showPerfilBtn.setFocusPainted(false);
        showPerfilBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPerfilBtnActionPerformed(evt);
            }
        });
        ActivityPanel.add(showPerfilBtn);

        getContentPane().add(ActivityPanel, java.awt.BorderLayout.PAGE_END);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void showArbolBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showArbolBtnActionPerformed
        this.mainPanel.removeAll();
        this.mainPanel.add(this.arbolPanel);
        this.setTitle("Block Pay | Árbol");
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_showArbolBtnActionPerformed

    private void showInicioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showInicioBtnActionPerformed
        this.mainPanel.removeAll();
        this.mainPanel.add(this.inicioPanel);
        this.setTitle("Block Pay | Inicio");
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_showInicioBtnActionPerformed

    private void showPerfilBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPerfilBtnActionPerformed
        this.mainPanel.removeAll();
        this.mainPanel.add(this.perfilPanel);
        this.setTitle("Block Pay | Perfil");
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_showPerfilBtnActionPerformed

    private void sendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBtnActionPerformed
        System.out.println("view.main.MainView.sendBtn root " + this.arbol.getRoot().getInfo());
        Dialog dialog = new Dialog();
        
        float monto = Float.parseFloat(String.valueOf(this.sendMoneyTxt.getValue()));
        
        if (!sendUserNameTxt.getText().isEmpty()) {
                    
            if (monto >= 50) {
                System.out.println("view.main.MainView.sendBtn root " + this.arbol.getRoot().getInfo());
            
                Persona persona = this.arbol.searchUser(this.arbol.getRoot().getChildren().search(0), sendUserNameTxt.getText(), 0);
                
                if (persona != null) {
                    int id = persona.getId();
                    this.transaccionController.transaccion(Integer.parseInt(this.idTxt.getText()), id, monto, this.moneyVisual);
                    this.sendUserNameTxt.setText("");
                    this.sendMoneyTxt.setValue(0);
                } else {
                    dialog.setMessage("No se encontro a este usuario");
                }
            
            } else {
                dialog.setMessage("Debe envíar una cantidad de dinero mayor a $50");
            }
            
        } else {
            dialog.setMessage("Campo usuario no puede estar vacío");
        }
    }//GEN-LAST:event_sendBtnActionPerformed

    private void changeDataBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeDataBtnActionPerformed
        String names = singUpNameTxt.getText().trim();
        String lastNames = signUpLastNameTxt.getText().trim();
        String user = signUpUserNameTxt.getText().trim();
        String password = signUpPasswordTxt.getText().trim();

        // Enviamos con los espacios en blanco removidos
        singUpNameTxt.setText(names);
        signUpLastNameTxt.setText(lastNames);
        signUpUserNameTxt.setText(user);
        signUpPasswordTxt.setText(password);

        Dialog dialog = new Dialog();

        if (names.isEmpty() || lastNames.isEmpty() || user.isEmpty() || password.isEmpty()) {
            dialog.setMessage("No puede haber campos vacios");

        } else {

            if (user.contains(" ") || user.contains("#")) {
                dialog.setMessage("El nombre de usuario no puede contener espacio en blanco o #.");

            } else if (password.length() < 10) {
                dialog.setMessage("La contraseña debe tener más de 10 o más caracteres");

            }else {
                // joinController.signUp(user,names,lastNames, password);
            }
        }
    }//GEN-LAST:event_changeDataBtnActionPerformed

    private void signUpUserNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpUserNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_signUpUserNameTxtActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ActivityPanel;
    private javax.swing.JPanel arbolPanel;
    private javax.swing.JLabel avilableLabel;
    private javax.swing.JButton changeDataBtn;
    private javax.swing.JPanel fistPanel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel idTxt;
    private javax.swing.JPanel inicioPanel;
    private javax.swing.JLabel labelName;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel moneyLabel;
    private javax.swing.JPanel moneyPanel;
    private javax.swing.JLabel moneyVisual;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel namesTxt;
    public javax.swing.JPanel perfilPanel;
    private javax.swing.JScrollPane scrollMessangePanel;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JButton sendBtn;
    private javax.swing.JPanel sendCenterPanel;
    private javax.swing.JPanel sendFormPanel;
    private javax.swing.JTextArea sendMenssangeTxt;
    private javax.swing.JLabel sendMessangeLabel;
    private javax.swing.JLabel sendMoneyLabel;
    private javax.swing.JSpinner sendMoneyTxt;
    private javax.swing.JLabel sendTitleLabel;
    private javax.swing.JLabel sendUserNameLabel;
    private javax.swing.JTextField sendUserNameTxt;
    private javax.swing.JButton showArbolBtn;
    private javax.swing.JButton showInicioBtn;
    private javax.swing.JButton showPerfilBtn;
    private javax.swing.JTextField signUpLastNameTxt;
    private javax.swing.JLabel signUpPasswordLabel;
    private javax.swing.JPasswordField signUpPasswordTxt;
    private javax.swing.JLabel signUpUserLabel;
    private javax.swing.JTextField signUpUserNameTxt;
    private javax.swing.JLabel singUpLastNameLabel;
    private javax.swing.JTextField singUpNameTxt;
    // End of variables declaration//GEN-END:variables
}
