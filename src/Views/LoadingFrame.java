package Views;

import Helper.ShareHelper;

public class LoadingFrame extends javax.swing.JFrame {

    public LoadingFrame() {
        initComponents();
        init();
    }

    // lệnh cài đặt cơ bản
    private void init() {
        setIconImage(ShareHelper.APP_ICON);
        setLocationRelativeTo(null);
        pack();
        lblIcon.setIcon(ShareHelper.ResizeImage(String.valueOf(ShareHelper.readLogo("logo.png")), lblIcon));
    }

    // mở main frame quản lý
    void openWelcome() {
        new mainFrame().setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        curvesPanel1 = new Swing_palette.CurvesPanel();
        lblIcon = new javax.swing.JLabel();
        lblChao = new javax.swing.JLabel();
        loadingbar = new Swing_palette.ProgressBarCustom();
        lblPercent = new javax.swing.JLabel();
        lblLoad = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Đang loading");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIcon.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblIcon.setForeground(new java.awt.Color(77, 77, 77));
        lblIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblChao.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblChao.setForeground(new java.awt.Color(51, 51, 51));
        lblChao.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblPercent.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPercent.setForeground(new java.awt.Color(102, 102, 102));
        lblPercent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPercent.setText("%");
        lblPercent.setPreferredSize(new java.awt.Dimension(13, 15));

        lblLoad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblLoad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoad.setPreferredSize(new java.awt.Dimension(13, 15));

        javax.swing.GroupLayout curvesPanel1Layout = new javax.swing.GroupLayout(curvesPanel1);
        curvesPanel1.setLayout(curvesPanel1Layout);
        curvesPanel1Layout.setHorizontalGroup(
            curvesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(curvesPanel1Layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addGroup(curvesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblChao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(curvesPanel1Layout.createSequentialGroup()
                        .addGroup(curvesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loadingbar, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(curvesPanel1Layout.createSequentialGroup()
                                .addComponent(lblLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(177, Short.MAX_VALUE))))
        );
        curvesPanel1Layout.setVerticalGroup(
            curvesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(curvesPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(curvesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loadingbar, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblChao, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        getContentPane().add(curvesPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 420));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    doTask("Đang kết nối database", 5);
                    doTask("o", 10);
                    doTask("o o", 20);
                    doTask("o o o", 30);
                    doTask("o o o o", 40);
                    doTask("o o o o o", 50);
                    doTask("o o o o o o", 60);
                    doTask("o o o o o o o", 70);
                    doTask("o o o o o o o o", 80);
                    doTask("o o o o o o o o o", 90);
                    doTask("Đã xong ! Chúc bạn một ngày làm việc tốt! ( •̀ ω •́ )", 100);
                    dispose();
                    curvesPanel1.stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }//GEN-LAST:event_formWindowOpened

    private void doTask(String taskName, int progress) throws Exception {
        lblChao.setText(taskName);
        Thread.sleep(200);
        loadingbar.setValue(progress);
        lblPercent.setText(String.valueOf(progress) + "%");
        if (loadingbar.getValue() == 100) {
            openWelcome();
        }
    }

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
            java.util.logging.Logger.getLogger(LoadingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoadingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoadingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoadingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoadingFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Swing_palette.CurvesPanel curvesPanel1;
    private javax.swing.JLabel lblChao;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblLoad;
    private javax.swing.JLabel lblPercent;
    private Swing_palette.ProgressBarCustom loadingbar;
    // End of variables declaration//GEN-END:variables
}
