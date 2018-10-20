package p2_zoo;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class zoogisticsView extends JFrame implements ActionListener {
    JLabel title;
    JButton logButton, moveButton, nxtupButton, addButton;
    JPanel mainPanel, logPanel, mvPanel, vwPanel, addPanel;
    
    //TODO: Spread buttons out, make them larger? Change font on button text
    public zoogisticsView() {
        super("Zoogistics");
        this.setSize(600, 550); //size may change 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screen.getWidth() - getWidth()) /2);
        int y = (int) ((screen.getHeight() -getHeight()) /2);
        setLocation(x, y); 
        
        // initialize all panels
        mainPanel = new JPanel();
        logPanel = new JPanel();
        mvPanel = new JPanel();
        vwPanel = new JPanel();
        addPanel = new JPanel();
        
        // Main Panel components
        Font myTitleFont = new Font("Georgia", Font.BOLD, 40);
        title = new JLabel();
        //TODO: plan is to positon at top center
        title.setText("Zoogistics");
        title.setPreferredSize(new Dimension(400, 60));
        title.setFont(myTitleFont);
        mainPanel.add(title);
        
        logButton = new JButton("Log an Activity");
        logButton.setPreferredSize(new Dimension(240, 40));
        logButton.addActionListener(this);
        mainPanel.add(logButton);
        
        moveButton = new JButton("Move Animal");
        moveButton.setPreferredSize(new Dimension(240, 40));
        moveButton.addActionListener(this);
        mainPanel.add(moveButton);
        
        nxtupButton = new JButton("View Next Up");
        nxtupButton.setPreferredSize(new Dimension(240, 40));
        nxtupButton.addActionListener(this);
        mainPanel.add(nxtupButton);
        
        addButton = new JButton("Add Animal");
        addButton.setPreferredSize(new Dimension(240, 40));
        addButton.addActionListener(this);
        mainPanel.add(addButton);

        this.add(mainPanel);
        
        // create other views
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
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
            java.util.logging.Logger.getLogger(zoogisticsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(zoogisticsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(zoogisticsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(zoogisticsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new zoogisticsView().setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        /*TODO: move out mainPanel.setVisible(false); since all will have their own panel
            have zoogisticsView.add(respectivepanel) and respectivepanel.setvisble(true)
            in each block instead. 
        */ 
        if(str.equals("Log an Activity")) {
            mainPanel.setVisible(false);
        } else if (str.equals("Move Animal")) {
            mainPanel.setVisible(false);
        } else if(str.equals("View Next Up")) {
            mainPanel.setVisible(false);
        } else if (str.equals("Add Animal")) {
            mainPanel.setVisible(false);
        }
     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
