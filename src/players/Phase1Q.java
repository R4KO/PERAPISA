/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.players;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import static src.players.Initial.enonceQuestion;
import src.question.ListeQuestions;
import src.question.Question;
import src.question.TypeQCM;
import src.question.TypeRC;
import src.question.TypeVF;

/**
 *
 * @author samot
 */
public class Phase1Q extends javax.swing.JFrame {

    public static Initial ini;
    public static int te;
    
    /**
     * Creates new form Phase1Q
     */
    public Phase1Q() throws FileNotFoundException {
        initComponents();
        
        ini = new Initial();
        ListeQuestions listq = ini.remplirQuestions();
        te = 0;
        Question <TypeQCM> selec = null;
        while(selec == null) {
                te = (int) (Math.random() * 100 % ListeQuestions.getList().size());
                selec = listq.selectionnerQuestion(1, te);
            }
        
        question.setText(ini.enonceQuestion.get(te));
        
        int ti = (int) (Math.random() * 100 % 4);
        if (ti % 4 == 0) {
            jRadioButton1.setText(ini.bonReponse.get(te));
            jRadioButton2.setText(ini.autreRepQcm.get(te*3));
            jRadioButton3.setText(ini.autreRepQcm.get((te*3)+1));
            jRadioButton4.setText(ini.autreRepQcm.get((te*3)+2));
        }else if(ti % 4 == 1){
            jRadioButton2.setText(ini.bonReponse.get(te));
            jRadioButton1.setText(ini.autreRepQcm.get(te*3));
            jRadioButton3.setText(ini.autreRepQcm.get((te*3)+1));
            jRadioButton4.setText(ini.autreRepQcm.get((te*3)+2));
        }else if(ti % 4 == 2){
            jRadioButton3.setText(ini.bonReponse.get(te));
            jRadioButton2.setText(ini.autreRepQcm.get(te*3));
            jRadioButton1.setText(ini.autreRepQcm.get((te*3)+1));
            jRadioButton4.setText(ini.autreRepQcm.get((te*3)+2));
        }else{
            jRadioButton4.setText(ini.bonReponse.get(te));
            jRadioButton2.setText(ini.autreRepQcm.get(te*3));
            jRadioButton3.setText(ini.autreRepQcm.get((te*3)+1));
            jRadioButton1.setText(ini.autreRepQcm.get((te*3)+2));
        }
        

        Joueur j1 = new Joueur();
        j1 = SelectionJoueur.tab[0];
        
        
        Joueurs1.setText(j1.toString());
        jButton2.setVisible(false);
        jButton3.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Joueurs1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        question = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Phase 1 : Tour 1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(518, 518, 518)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        Joueurs1.setEditable(false);
        Joueurs1.setColumns(20);
        Joueurs1.setRows(5);
        jScrollPane1.setViewportView(Joueurs1);

        question.setEditable(false);
        question.setColumns(20);
        question.setRows(5);
        jScrollPane2.setViewportView(question);

        jButton1.setText("Validez");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Validez");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Validez");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton1);
        jRadioButton1.setText("jRadioButton1");

        buttonGroup2.add(jRadioButton2);
        jRadioButton2.setText("jRadioButton2");

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setText("jRadioButton3");

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("jRadioButton4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(590, 590, 590)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addGap(109, 109, 109))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(906, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(34, 34, 34)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(919, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(21, 21, 21)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(jRadioButton1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton4))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(384, 384, 384)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(406, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(395, 395, 395)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(395, Short.MAX_VALUE)))
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
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
       String choix = null;
       Enumeration elements = buttonGroup2.getElements();
       while(elements.hasMoreElements()){
           
           AbstractButton button = (AbstractButton)elements.nextElement();
           if(button.isSelected()){
               choix = button.getText();  
           }
       }
       JOptionPane.showMessageDialog(null, "a"+ini.bonReponse.get(te)+"a"+choix);
        if(ini.bonReponse.get(te).equals(choix)){
        
            SelectionJoueur.tab[0].mAJScore(2);
            SelectionJoueur.tab[0].afficher(); 
             JOptionPane.showMessageDialog(null, "bravo bonne réponse tu marques 2 points");
        }
        else{
        
            JOptionPane.showMessageDialog(null, "dommage la bonne réponse était " + ini.bonReponse.get(te));
        
        
        
        }
       
       
       
       

        Joueur j2 = new Joueur();
        j2 = SelectionJoueur.tab[1];
        Joueurs1.setText(j2.toString());
        jButton1.setVisible(false);
        jButton2.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Joueur j3 = new Joueur();
        j3 = SelectionJoueur.tab[2];
        Joueurs1.setText(j3.toString());
        
        
        
        
        jButton2.setVisible(false);
        jButton3.setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Joueur j4 = new Joueur();
        j4 = SelectionJoueur.tab[3];
        Joueurs1.setText(j4.toString());
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Phase1Q.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Phase1Q.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Phase1Q.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Phase1Q.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Phase1Q().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Phase1Q.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    
    
    public static void jeuPhase1(ListeQuestions questi,ArrayList<String> bonReponse, Joueur j){
        System.out.println("Joueur " + j.getNom() + " c'est à vous de jouer");
        Scanner sc = new Scanner(System.in);
        String reponse = "null";
        int i = 0;
        
            //type = QCM
            //On gère la selection de la question par rapport à un niveau donné
            Question<TypeQCM> selec = null;
            while(selec == null) {
                i = (int) (Math.random() * 100 % ListeQuestions.getList().size());
                selec = questi.selectionnerQuestion(1, i);
            }
            Question<TypeQCM> q = new Question<TypeQCM>(1, (TypeQCM) selec.getEnonceQ());
            //On affiche la question, ici dans le désordre pour ne pas que l'utilisateur sache ou est la bonne reponse
            q.afficher();
            //On gère la réponse donné par l'utilisateur
            System.out.println("Réécrivez la réponse que vous trouver juste:");
            reponse = sc.nextLine();
            if(bonReponse.get(i).equals(reponse)){
                j.mAJScore(2);
                System.out.println("Bravo c'est la bonne réponse\n");
            }else{
                System.out.println("dommage la bonne réponse était " + bonReponse.get(i)+ "\n");
            }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Joueurs1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea question;
    // End of variables declaration//GEN-END:variables
}