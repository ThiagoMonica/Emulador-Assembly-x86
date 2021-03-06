package javaapplication17;

import java.util.*;
import javax.swing.text.*;
import javax.swing.JOptionPane;
import javaapplication17.AssemblyCompiler;
import java.util.HashMap;
import java.util.Scanner;

public class NewJFrame extends javax.swing.JFrame {
    String[] linha = new String[10000];
    private int numeroLinhas = 0;
    private int highlightComeco = 0;
    private int highlightFim = 0;
    private int linhaAtual=0;
    private int contador=0;
    private int iterador;
    public static int AX;
    public static int BX;
    public static int CX;
    public static int DX;
    public static int PC;
    public static int MBR;
    public static int MAR;
    public static int ULAA;
    public static int ULAB;
    public static int ULAX;
    public static int ULAR;
    public static String portasUsadas;
    public static String [] sinaisdecontrole;
    List guardaLinha =new ArrayList();
    Thread oi;
    public NewJFrame() {
        initComponents();
    }
    public int getIterador(){
        return this.iterador;
    }
    public void setIterador(int numero1, int numero2){
        this.iterador = numero1 +numero2;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TextFieldAX = new javax.swing.JTextField();
        TextFieldBX = new javax.swing.JTextField();
        TextFieldCX = new javax.swing.JTextField();
        TextFieldDX = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        TextFieldPortas = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        TextFieldPC = new javax.swing.JTextField();
        TextFieldMAR = new javax.swing.JTextField();
        TextFieldMBR = new javax.swing.JTextField();
        TextFieldULAR = new javax.swing.JTextField();
        TextFieldULAA = new javax.swing.JTextField();
        TextFieldULAB = new javax.swing.JTextField();
        TextFieldULAX = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jTextFieldLinha = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setToolTipText("");
        jPanel1.setName(""); // NOI18N

        jLabel1.setText("Registradores");

        jLabel2.setText("AX:");

        jLabel3.setText("BX:");

        jLabel4.setText("CX:");

        jLabel5.setText("DX:");

        TextFieldAX.setEditable(false);

        TextFieldBX.setEditable(false);

        TextFieldCX.setEditable(false);

        TextFieldDX.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextFieldBX, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextFieldAX, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TextFieldCX, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TextFieldDX, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(TextFieldAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldCX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(TextFieldDX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setText("MEM�RIA");

        jLabel7.setText("PC");

        jLabel8.setText("MAR");

        jLabel9.setText("MBR");

        jLabel10.setText("ULA(B)");

        jLabel11.setText("ULA(A)");

        jLabel12.setText("ULAX");

        jLabel13.setText("ULA Resultado");

        TextFieldPortas.setEditable(false);

        jLabel14.setText("PORTAS USADAS");

        TextFieldPC.setEditable(false);
        TextFieldPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldPCActionPerformed(evt);
            }
        });

        TextFieldMAR.setEditable(false);

        TextFieldMBR.setEditable(false);

        TextFieldULAR.setEditable(false);

        TextFieldULAA.setEditable(false);

        TextFieldULAB.setEditable(false);

        TextFieldULAX.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(26, 26, 26)
                                        .addComponent(TextFieldMBR, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TextFieldMAR, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TextFieldPC, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TextFieldULAB, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TextFieldULAA, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TextFieldULAX, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel14))
                        .addGap(51, 51, 51))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextFieldPortas)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextFieldULAR)))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TextFieldPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(TextFieldULAA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TextFieldMAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(TextFieldULAB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(TextFieldMBR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(TextFieldULAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(TextFieldULAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextFieldPortas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton1.setText("Comecar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Avancar");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextPane1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jScrollPane2.setViewportView(jTextPane1);

        jTextFieldLinha.setEditable(false);

        jLabel16.setText("Linha:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jButton1)
                        .addGap(28, 28, 28)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jTextFieldLinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    public static HashMap getRegisters(Uc uc) {
		return uc.getRegisters();
	}
    public  void compiladorAssembly(String[][] codigoAssembly) {
		Uc uc = new Uc();
		int pc = Integer.parseInt(uc.pc.getValue()) - 1;
		uc.printaValores();
                
		// Gera o firmware e em seguida passa para o ciclo de execução
		while(pc < codigoAssembly.length) {
                    portasUsadas ="";
                        Label.adicionaLabel(codigoAssembly[pc][0], pc);
			String[] sinaisDeControle = uc.cicloDeBusca(codigoAssembly[pc]);
			System.out.print("\t"+codigoAssembly[pc][0]+" ");
			System.out.print(codigoAssembly[pc][1]+" ");
			System.out.println(codigoAssembly[pc][2]+"\n");
			uc.cicloExecucao(sinaisDeControle);

			pc = Integer.parseInt(uc.pc.getValue(), 2) - 1;
                        try {
                            System.out.println("dormindo");
                            highlight(PC-1);
                            TextFieldAX.setText(String.valueOf(AX));
                            TextFieldBX.setText(String.valueOf(BX));
                            TextFieldCX.setText(String.valueOf(CX));
                            TextFieldDX.setText(String.valueOf(DX));
                            TextFieldPC.setText(String.valueOf(PC));
                            TextFieldMAR.setText(String.valueOf(MAR));
                            TextFieldMBR.setText(String.valueOf(MBR));
                            TextFieldULAA.setText(String.valueOf(ULAA));
                            TextFieldULAB.setText(String.valueOf(ULAB));
                            TextFieldULAX.setText(String.valueOf(ULAX));
                            TextFieldULAR.setText(String.valueOf(ULAR));
                            jTextFieldLinha.setText(String.valueOf(PC-1));
                            TextFieldPortas.setText(portasUsadas);
                            oi.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
		}
	
            }
    //Bot�o comecar
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       //for (String line : textArea.getText().split("\\n")) doStuffWithLine(line);
        jButton1.setEnabled(false);
        jButton2.setEnabled(true);
        linhaAtual=1;
        int totalCharacters = jTextPane1.getDocument().getLength(); 
        int lineCount = (totalCharacters == 0) ? 1 : 0;

        try {
            int offset = totalCharacters; 
            while (offset > 0) {
                offset = Utilities.getRowStart(jTextPane1, offset) - 1;
                lineCount++;
            }
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        final int totalLinhas = lineCount;
        System.out.println(totalLinhas);

        oi =new Thread(){
            public void run(){
                synchronized(oi){
                String[][] codigoAssembly = new String[totalLinhas][3];
                String[] s=jTextPane1.getText().trim().split("\\s+|\\\\n");

                int p=0;
                for(int i = 0; i<totalLinhas; i++){
                    for(int j = 0; j<3; j++){

                            codigoAssembly[i][j] =s[p];
                            
                            //Verifica se � Label
                            if (Label.adicionaLabel(s[p], i)){
                            	
                            	System.out.println(Label.getLinhaLabel(s[p]));
                            	
                                //Se for, a label eh a primeira palavra da linha e o resto enche com "0" pra nao deixar vazio
                                codigoAssembly[i][1]="0"; 
                                
                                codigoAssembly[i][2] = "0";
                                 p++;
                                break;
                            }
                            
                            String x = "String";
                            switch(codigoAssembly[i][0]) {
                            case "jmp": 
                            case "je":
                            case "jne": 
                            case "jg": 
                            case "jge": 
                            case "jl": 
                            case "jle":
                            
                            x = codigoAssembly[i][0];
                            }
                            
                        	if(codigoAssembly[i][0].equals(x)) {
                        		
                        		//codigoAssembly[i][1] = Integer.toString(Label.getLinhaLabel(codigoAssembly[i][1]));
                        		codigoAssembly[i][2] = "0";
                        		//p++;
                        		
                        	}
                            
                            System.out.println("codigo "+i+" "+j +" "+codigoAssembly[i][j] );

                        p++;
                    }
                }        
		compiladorAssembly(codigoAssembly);
	}

	

	// Compilador assembly, recebe uma matriz com c�digo em assembly.
	// Dentro da matriz, os arranjos devem ser compostos de:
	// 1 - Opcode com a opera��o, 2 - Primeiro registrador, 3 - Segundo registrador
            }
        };
        oi.start();
        
       
    }                                        

    //Bot�o Avancar
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //continua = true;
        synchronized(oi){
            oi.notify();
        }
        
        
    }                                        

    private void TextFieldPCActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           


    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }


    public void highlight(int highlightLinha){
        highlightComeco =highlightFim;
        highlightFim = 0;
        int quebraLinha =0;

        char[] aux = jTextPane1.getText().trim().toCharArray(); ;
        for(int i=0;i<aux.length;i++){
            System.out.println("aux[i] = "+aux[i]);
            highlightFim++;
            if(aux[i] == '\n') quebraLinha++;
            if(quebraLinha == highlightLinha && highlightLinha > 1) break;
            if(highlightLinha == 1 && aux[i] == '\n') break;
        }
        highlightFim = highlightFim - highlightLinha ;
        System.out.println("Highlight Come�o = "+highlightComeco);
        System.out.println("Highlight Fim = "+highlightFim);
        try{
            jTextPane1.getHighlighter().removeAllHighlights();
            jTextPane1.getHighlighter().addHighlight(highlightComeco, highlightFim, DefaultHighlighter.DefaultPainter);
        }catch(Exception e){
            
        }
        
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextField TextFieldAX;
    private javax.swing.JTextField TextFieldBX;
    private javax.swing.JTextField TextFieldCX;
    private javax.swing.JTextField TextFieldDX;
    private javax.swing.JTextField TextFieldMAR;
    private javax.swing.JTextField TextFieldMBR;
    private javax.swing.JTextField TextFieldPC;
    private javax.swing.JTextField TextFieldPortas;
    private javax.swing.JTextField TextFieldULAA;
    private javax.swing.JTextField TextFieldULAB;
    private javax.swing.JTextField TextFieldULAR;
    private javax.swing.JTextField TextFieldULAX;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldLinha;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration                   
}
