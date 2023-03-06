import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
public class PenjualanTiket extends javax.swing.JFrame {
    private PreparedStatement stat;
    private ResultSet rs;
    private DefaultTableModel model = null;
    koneksi k = new koneksi();
   
    /**
     * Creates new form PenjualanTiket
     */
    public PenjualanTiket() {
        initComponents();
        k.connect();
        this.refreshTable();
        this.setEnableComponent();
    }
    
    public void setEnableComponent(){
         this.inputHargaTiket.setEnabled(false);
         this.inputDiskon.setEnabled(false);
         this.inputSubTotal.setEnabled(false);
         this.inputTotalBayar.setEnabled(false);
    }

    class tiket extends PenjualanTiket{
        int id;
        boolean selected;
        String nama,tujuan,member,JumlahTiket,diskon,subtotal,totalbayar,hargaTiket;
        public tiket() {
            this.id = 0;
            this.tujuan = inputTujuan.getSelectedItem().toString();
            this.JumlahTiket = inputJumlahTiket.getText();
            this.member = checkMember.isSelected() ? "Ya" : "Tidak";
            this.hargaTiket = inputHargaTiket.getText();
            this.diskon = inputDiskon.getText();
            this.subtotal = inputSubTotal.getText();
        }
        
    }
        public void refreshTable()
       {
            model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("NAMA PEMESAN");
            model.addColumn("TUJUAN");
            model.addColumn("JUMLAH TIKET");
            model.addColumn("HARGA TIKET");
            model.addColumn("DISKON");
            model.addColumn("SUB TOTAL");
            model.addColumn("TOTAL BAYAR");
            model.addColumn("MEMBER");
           tblTiket.setModel(model);
           try {
               stat = k.getCon().prepareStatement("SELECT * FROM tbl_tiket");
               rs = stat.executeQuery();
               while(rs.next()){
                   Object[] data = {
                       rs.getString("id"),
                       rs.getString("nama"),
                       rs.getString("tujuan"),
                       rs.getString("jumlah"),
                       rs.getString("harga"),
                       rs.getString("diskon"),
                       rs.getString("sub_total"),
                       rs.getString("totalbayar"),
                       rs.getString("member")
                   };
                   model.addRow(data);
               }
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
           inputId.setText("");
           inputHargaTiket.setText("");
           inputDiskon.setText("");
           inputJumlahTiket.setText("");
           inputNama.setText("");
           inputSubTotal.setText("");
           inputTotalBayar.setText("");
        }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        inputNama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        inputTujuan = new javax.swing.JComboBox<>();
        inputJumlahTiket = new javax.swing.JTextField();
        checkMember = new javax.swing.JCheckBox();
        inputHargaTiket = new javax.swing.JTextField();
        inputDiskon = new javax.swing.JTextField();
        inputTotalBayar = new javax.swing.JTextField();
        inputSubTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTiket = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        btnRekam = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        inputId = new javax.swing.JTextField();
        btnHitung = new javax.swing.JButton();

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("FORM PENJUALAN TIKET");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Nama ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Tujuan");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Jumalah Tiket");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Member");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Harga Tiket");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Sub Total");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Total Bayar");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Diskon");

        inputTujuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih Tujuan--", "Jakarta", "Bali", "Surabaya" }));
        inputTujuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputTujuanActionPerformed(evt);
            }
        });

        inputJumlahTiket.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                inputJumlahTiketInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        inputJumlahTiket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputJumlahTiketActionPerformed(evt);
            }
        });
        inputJumlahTiket.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputJumlahTiketKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputJumlahTiketKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputJumlahTiketKeyTyped(evt);
            }
        });

        checkMember.setText("Ya");
        checkMember.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                checkMemberStateChanged(evt);
            }
        });
        checkMember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkMemberMouseClicked(evt);
            }
        });
        checkMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkMemberActionPerformed(evt);
            }
        });

        tblTiket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblTiket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTiketMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTiket);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("DATA PENJUALAN TIKET");

        btnRekam.setText("REKAM");
        btnRekam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRekamActionPerformed(evt);
            }
        });

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnHitung.setText("HITUNG");
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(59, 59, 59)))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inputNama)
                            .addComponent(inputTujuan, 0, 303, Short.MAX_VALUE)
                            .addComponent(inputJumlahTiket, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5)
                            .addComponent(btnHitung, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputTotalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkMember, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputHargaTiket, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRekam, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addGap(533, 533, 533)
                .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 308, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(checkMember, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(44, 44, 44)
                                .addComponent(jLabel6))
                            .addComponent(inputHargaTiket, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inputDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inputSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inputTotalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(inputNama, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10))
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(inputTujuan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(inputJumlahTiket, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRekam, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(btnHitung, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkMemberActionPerformed

        tiket t = new tiket();
        t.selected = this.checkMember.isSelected();
        int hargaT = Integer.parseInt(t.hargaTiket);
        
        if (t.selected) {
             t.diskon = String.valueOf(0.1 * hargaT);
             this.inputDiskon.setText(t.diskon);
        } else {
             t.diskon = String.valueOf(0);
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_checkMemberActionPerformed

    private void btnRekamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRekamActionPerformed
        tiket t = new tiket();
       
        try {
            stat = k.getCon().prepareStatement("INSERT INTO tbl_tiket VALUES (?,?,?,?,?,?,?,?,?)");
            stat.setInt(1,0);
            stat.setString(2, inputNama.getText());
            stat.setString(3, t.tujuan);
            stat.setString(4, t.JumlahTiket);
            stat.setString(5, t.member);
            stat.setString(6, t.hargaTiket);
            stat.setString(7, t.subtotal);
            stat.setString(8, String.valueOf(t.diskon));
            stat.setString(9, inputTotalBayar.getText());
            stat.executeUpdate();
            refreshTable();
            JOptionPane.showMessageDialog(null, "DATA BERHASIL DI INPUT !");
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnRekamActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
      try {
            stat = k.getCon().prepareStatement("delete from tbl_tiket where id= ?");
            stat.setString(1,inputId.getText());
            stat.executeUpdate();
            refreshTable();
            JOptionPane.showMessageDialog(null, "DATA BERHASIL DI HAPUS !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblTiketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTiketMouseClicked
      inputId.setText(model.getValueAt(tblTiket.getSelectedRow(), 0).toString());
       inputNama.setText(model.getValueAt(tblTiket.getSelectedRow(), 1).toString());
         inputTujuan.setSelectedItem(model.getValueAt(tblTiket.getSelectedRow(), 2).toString());
         inputJumlahTiket.setText(model.getValueAt(tblTiket.getSelectedRow(), 3).toString());
          checkMember.setText(model.getValueAt(tblTiket.getSelectedRow(), 8).toString());
           inputHargaTiket.setText(model.getValueAt(tblTiket.getSelectedRow(), 4).toString());
            inputDiskon.setText(model.getValueAt(tblTiket.getSelectedRow(), 5).toString());
               inputSubTotal.setText(model.getValueAt(tblTiket.getSelectedRow(), 6).toString());
                  inputTotalBayar.setText(model.getValueAt(tblTiket.getSelectedRow(), 7).toString());
    }//GEN-LAST:event_tblTiketMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
         tiket t = new tiket();
        try {       
             stat = k.getCon().prepareStatement("UPDATE tbl_tiket SET nama=?,"
            + "tujuan=?,jumlah=?,member=?,harga=?,sub_total=?,diskon=?,totalbayar=? WHERE id=?");
            stat.setString(1, inputNama.getText());
            stat.setString(2, t.tujuan);
            stat.setString(3, t.JumlahTiket);
            stat.setString(4, t.member);
            stat.setString(5, t.hargaTiket);
            stat.setString(6, t.subtotal);
            stat.setString(7, String.valueOf(t.diskon));
            stat.setString(8, inputTotalBayar.getText());
            stat.setString(9,inputId.getText());
            stat.executeUpdate();
            refreshTable();
            JOptionPane.showMessageDialog(null, "DATA BERHASIL DI UBAH !");
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void checkMemberStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_checkMemberStateChanged

        // TODO add your handling code here:
    }//GEN-LAST:event_checkMemberStateChanged

    private void checkMemberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkMemberMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_checkMemberMouseClicked

    private void inputJumlahTiketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputJumlahTiketActionPerformed
           
    }//GEN-LAST:event_inputJumlahTiketActionPerformed

    private void inputTujuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputTujuanActionPerformed
        tiket t = new tiket();
        if(null == t.tujuan){
            t.hargaTiket = String.valueOf(0);
            this.inputHargaTiket.setText(String.valueOf(0));
        }else switch (t.tujuan) {
            case "Jakarta":
                t.hargaTiket = String.valueOf(950000);
                this.inputHargaTiket.setText(String.valueOf(950000));
                break;
        // TODO add your handling code here:
            case "Bali":
                 t.hargaTiket = String.valueOf(1200000);
                this.inputHargaTiket.setText(String.valueOf(1200000));
                break;
            default:
                t.hargaTiket = String.valueOf(1000000);
                this.inputHargaTiket.setText(String.valueOf(1000000));
                break;
        }
    }//GEN-LAST:event_inputTujuanActionPerformed

    private void inputJumlahTiketInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_inputJumlahTiketInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_inputJumlahTiketInputMethodTextChanged

    private void inputJumlahTiketKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputJumlahTiketKeyPressed
         
        // TODO add your handling code here:
    }//GEN-LAST:event_inputJumlahTiketKeyPressed

    private void inputJumlahTiketKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputJumlahTiketKeyTyped
        
        // TODO add your handling code here:
    }//GEN-LAST:event_inputJumlahTiketKeyTyped

    private void inputJumlahTiketKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputJumlahTiketKeyReleased
         tiket t = new tiket();
        int hargaT = Integer.parseInt(t.hargaTiket);
        int jmlT = Integer.parseInt(t.JumlahTiket);
        int hasil = hargaT * jmlT; 
        t.subtotal = String.valueOf(hasil);
        this.inputSubTotal.setText(String.valueOf(hasil)); 
        // TODO add your handling code here:
    }//GEN-LAST:event_inputJumlahTiketKeyReleased

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
        tiket t = new tiket();
        int subT = Integer.parseInt(t.subtotal);
        double diskon = Double.parseDouble(t.diskon);
        double hasil = subT - diskon;
        t.totalbayar = String.valueOf(hasil);
        this.inputTotalBayar.setText(String.valueOf(hasil));
        

// TODO add your handling code here:
    }//GEN-LAST:event_btnHitungActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(PenjualanTiket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PenjualanTiket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PenjualanTiket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PenjualanTiket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PenjualanTiket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnRekam;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JCheckBox checkMember;
    private javax.swing.JTextField inputDiskon;
    private javax.swing.JTextField inputHargaTiket;
    private javax.swing.JTextField inputId;
    private javax.swing.JTextField inputJumlahTiket;
    private javax.swing.JTextField inputNama;
    private javax.swing.JTextField inputSubTotal;
    private javax.swing.JTextField inputTotalBayar;
    private javax.swing.JComboBox<String> inputTujuan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable tblTiket;
    // End of variables declaration//GEN-END:variables
}
