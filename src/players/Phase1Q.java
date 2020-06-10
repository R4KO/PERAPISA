/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.players;

import java.io.FileNotFoundException;
import static java.lang.Thread.sleep;
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
    public static boolean state;
    public static boolean state2;
    public static boolean state3;
    public static boolean state4;
    public static int seconds;
    public static int minutes;
    public static int milliseconds;
    public static Thread t;
    public static Thread u;
    public static Thread v;
    public static Thread w;
    public static ArrayList<Integer> temp1 = new ArrayList();
    public static ArrayList<Integer> temp2= new ArrayList();
    public static ArrayList<Integer> temp3= new ArrayList();
    public static ArrayList<Integer> temp4= new ArrayList();
    
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
        score.setVisible(false);
        jButton4.setVisible(false);
        jButton3.setVisible(false);
        
        state = true;
        t = new Thread()
        {
            public void run(){
            
                
                for(;;)
                {
                    if(state == true)
                    {
                        try{
                            sleep(1);
                            if(milliseconds>1000)
                            {
                                milliseconds = 0;
                                seconds ++;

                            }
                            if (seconds > 60) {
                                seconds = 0;
                                minutes++;

                                    }
                            
                                jLabel4.setText("" + milliseconds);
                                milliseconds++;
                                jLabel3.setText("" + seconds+" :");
                                jLabel2.setText("" + minutes+" :");
                                

                        }
                        catch (Exception e){
                        
                        }
                    }
                    else
                    {
                        
                        break;
                    }
                                
                }
            
            }
        
        
        };
        t.start();
        jLabel5.setVisible(false);
        jLabel6.setVisible(false);
        jLabel7.setVisible(false);
        jLabel8.setVisible(false);
        jLabel9.setVisible(false);
        jLabel10.setVisible(false);
        jLabel11.setVisible(false);
        jLabel12.setVisible(false);
        jLabel13.setVisible(false);
        
        
        
        
        
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
        jButton4 = new javax.swing.JButton();
        score = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Microsoft Himalaya", 1, 36)); // NOI18N
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
        Joueurs1.setFont(new java.awt.Font("Microsoft Himalaya", 0, 30)); // NOI18N
        Joueurs1.setRows(5);
        jScrollPane1.setViewportView(Joueurs1);

        question.setEditable(false);
        question.setColumns(20);
        question.setFont(new java.awt.Font("Microsoft Himalaya", 0, 30)); // NOI18N
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

        jButton4.setText("Validez");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        score.setText("Affichez les scores");
        score.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scoreActionPerformed(evt);
            }
        });

        jLabel2.setText("00 :");

        jLabel3.setText("00 :");

        jLabel4.setText("00 ");

        jLabel5.setText("00 :");

        jLabel6.setText("00 :");

        jLabel7.setText("00 ");

        jLabel8.setText("00 :");

        jLabel9.setText("00 :");

        jLabel10.setText("00 ");

        jLabel11.setText("00 :");

        jLabel12.setText("00 :");

        jLabel13.setText("00 ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabel2)
                .addGap(39, 39, 39)
                .addComponent(jLabel3)
                .addGap(34, 34, 34)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(score, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(929, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(11, 11, 11)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(111, 111, 111)
                    .addComponent(jLabel5)
                    .addGap(39, 39, 39)
                    .addComponent(jLabel6)
                    .addGap(34, 34, 34)
                    .addComponent(jLabel7)
                    .addContainerGap(891, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(121, 121, 121)
                    .addComponent(jLabel8)
                    .addGap(39, 39, 39)
                    .addComponent(jLabel9)
                    .addGap(34, 34, 34)
                    .addComponent(jLabel10)
                    .addContainerGap(881, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(131, 131, 131)
                    .addComponent(jLabel11)
                    .addGap(39, 39, 39)
                    .addComponent(jLabel12)
                    .addGap(34, 34, 34)
                    .addComponent(jLabel13)
                    .addContainerGap(871, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton3)
                        .addGap(32, 32, 32)
                        .addComponent(jRadioButton4)
                        .addGap(61, 61, 61)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(score, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))))
                .addContainerGap(210, Short.MAX_VALUE))
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
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(405, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(385, 385, 385)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(568, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7))
                    .addGap(284, 284, 284)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(578, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10))
                    .addGap(274, 274, 274)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(588, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel12)
                        .addComponent(jLabel13))
                    .addGap(264, 264, 264)))
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
        
        jLabel5.setVisible(true);
        jLabel6.setVisible(true);
        jLabel7.setVisible(true);
       String choix = null;
       Enumeration elements = buttonGroup2.getElements();
       while(elements.hasMoreElements()){
           
           AbstractButton button = (AbstractButton)elements.nextElement();
           if(button.isSelected()){
               choix = button.getText();  
           }
       }
        state = false;
        
        if(ini.bonReponse.get(te).equals(choix)){
        
            SelectionJoueur.tab[0].mAJScore(2);
            SelectionJoueur.tab[0].afficher(); 
            JOptionPane.showMessageDialog(null, "bravo bonne réponse tu marques 2 points et tu as mis : "+minutes+":"+seconds+":"+milliseconds+ " pour répondre");
            temp1.add(minutes);
            temp1.add(seconds);
            temp1.add(milliseconds);
        }
        else{
            SelectionJoueur.tab[0].afficher(); 
            JOptionPane.showMessageDialog(null, "dommage la bonne réponse était " + ini.bonReponse.get(te)+"et tu as mis :"+minutes+":"+seconds+":"+milliseconds+ " pour répondre");
            temp1.add(minutes);
            temp1.add(seconds);
            temp1.add(milliseconds);
        }
        
        
        Joueur j2 = new Joueur();
        j2 = SelectionJoueur.tab[1];
        Joueurs1.setText(j2.toString());
        
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
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        

        jButton1.setVisible(false);
        jButton4.setVisible(false);
        jButton2.setVisible(true);
        
        milliseconds = 0;
        seconds = 0;
        minutes = 0;
        
        
        state2 =true;
        u = new Thread()
        {
            public void run(){
            
                
                for(;;)
                {
                    if(state2 == true)
                    {
                        try{
                            sleep(1);
                            if(milliseconds>1000)
                            {
                                milliseconds = 0;
                                seconds ++;

                            }
                            if (seconds > 60) {
                                seconds = 0;
                                minutes++;

                                    }
                            
                                jLabel7.setText("" + milliseconds);
                                milliseconds++;
                                jLabel6.setText("" + seconds+" :");
                                jLabel5.setText("" + minutes+" :");
                                

                        }
                        catch (Exception e){
                        
                        }
                    }
                    else
                    {
                        
                        break;
                    }
                                
                }
            
            }
        
        
        };
        u.start();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        
       state2 = false;
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
        
            SelectionJoueur.tab[1].mAJScore(2);
            SelectionJoueur.tab[1].afficher(); 
            JOptionPane.showMessageDialog(null, "bravo bonne réponse tu marques 2 points et tu as mis : "+minutes+":"+seconds+":"+milliseconds+ " pour répondre");
        
            temp2.add(minutes);
            temp2.add(seconds);
            temp2.add(milliseconds);
        
        }
        else{
            SelectionJoueur.tab[1].afficher(); 
            JOptionPane.showMessageDialog(null, "dommage la bonne réponse était " + ini.bonReponse.get(te)+"et tu as mis :"+minutes+":"+seconds+":"+milliseconds+ " pour répondre");
        
            temp2.add(minutes);
            temp2.add(seconds);
            temp2.add(milliseconds);
        }
        
        
        
        
        Joueur j3 = new Joueur();
        j3 = SelectionJoueur.tab[2];
        Joueurs1.setText(j3.toString());
        
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
        
        
        
        jButton2.setVisible(false);
        jButton4.setVisible(false);
        jButton3.setVisible(true);
       
        jLabel5.setVisible(false);
        jLabel6.setVisible(false);
        jLabel7.setVisible(false);
        jLabel8.setVisible(true);
        jLabel9.setVisible(true);
        jLabel10.setVisible(true);
        jLabel11.setVisible(false);
        jLabel12.setVisible(false);
        jLabel13.setVisible(false);
        
        milliseconds = 0;
        seconds = 0;
        minutes = 0;
        
        state3 =true;
        v = new Thread()
        {
            public void run(){
            
                
                for(;;)
                {
                    if(state3 == true)
                    {
                        try{
                            sleep(1);
                            if(milliseconds>1000)
                            {
                                milliseconds = 0;
                                seconds ++;

                            }
                            if (seconds > 60) {
                                seconds = 0;
                                minutes++;

                                    }
                            
                                jLabel10.setText("" + milliseconds);
                                milliseconds++;
                                jLabel9.setText("" + seconds+" :");
                                jLabel8.setText("" + minutes+" :");
                                

                        }
                        catch (Exception e){
                        
                        }
                    }
                    else
                    {
                        
                        break;
                    }
                                
                }
            
            }
        
        
        };
        v.start();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
       state3 = false; 
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
        
            SelectionJoueur.tab[2].mAJScore(2);
            SelectionJoueur.tab[2].afficher(); 
            JOptionPane.showMessageDialog(null, "bravo bonne réponse tu marques 2 points et tu as mis : "+minutes+":"+seconds+":"+milliseconds+ " pour répondre");
        
            temp3.add(minutes);
            temp3.add(seconds);
            temp3.add(milliseconds);
        
        }
        else{
            SelectionJoueur.tab[2].afficher(); 
            JOptionPane.showMessageDialog(null, "dommage la bonne réponse était " + ini.bonReponse.get(te)+"et tu as mis :"+minutes+":"+seconds+":"+milliseconds+ " pour répondre");
            temp3.add(minutes);
            temp3.add(seconds);
            temp3.add(milliseconds);
        }
        
        
        
        Joueur j4 = new Joueur();
        j4 = SelectionJoueur.tab[3];
        Joueurs1.setText(j4.toString());
        jButton3.setVisible(false);
        jButton4.setVisible(true);
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
        jButton3.setVisible(false);
        
        jLabel8.setVisible(false);
        jLabel9.setVisible(false);
        jLabel10.setVisible(false);
        jLabel11.setVisible(true);
        jLabel12.setVisible(true);
        jLabel13.setVisible(true);
        
        milliseconds = 0;
        seconds = 0;
        minutes = 0;
        
        state4 =true;
        w = new Thread()
        {
            public void run(){
            
                
                for(;;)
                {
                    if(state4 == true)
                    {
                        try{
                            sleep(1);
                            if(milliseconds>1000)
                            {
                                milliseconds = 0;
                                seconds ++;

                            }
                            if (seconds > 60) {
                                seconds = 0;
                                minutes++;

                                    }
                            
                                jLabel13.setText("" + milliseconds);
                                milliseconds++;
                                jLabel12.setText("" + seconds+" :");
                                jLabel11.setText("" + minutes+" :");
                                

                        }
                        catch (Exception e){
                        
                        }
                    }
                    else
                    {
                        
                        break;
                    }
                                
                }
            
            }
        
        
        };
        w.start();

        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        state4 = false;
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
        
            SelectionJoueur.tab[3].mAJScore(2);
            SelectionJoueur.tab[3].afficher(); 
            JOptionPane.showMessageDialog(null, "bravo bonne réponse tu marques 2 points et tu as mis : "+minutes+":"+seconds+":"+milliseconds+ " pour répondre");
        
            temp4.add(minutes);
            temp4.add(seconds);
            temp4.add(milliseconds);
        
        }
        else{
            SelectionJoueur.tab[3].afficher(); 
            JOptionPane.showMessageDialog(null, "dommage la bonne réponse était " + ini.bonReponse.get(te)+"et tu as mis :"+minutes+":"+seconds+":"+milliseconds+ " pour répondre");;
        
            temp4.add(minutes);
            temp4.add(seconds);
            temp4.add(milliseconds);
            
        }
        jButton4.setVisible(false);
        score.setVisible(true);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void scoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scoreActionPerformed
        // TODO add your handling code here:
        new AfficherScoreTour1().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_scoreActionPerformed

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
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea question;
    private javax.swing.JButton score;
    // End of variables declaration//GEN-END:variables
}
