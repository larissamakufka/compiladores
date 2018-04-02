package trabalhofinalcompiladores;

import java.awt.Label;
import trabalhofinalcompiladores.Comum.Utils.CompiladorConst;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Compilador extends JFrame {

    private String caminho;
    private File nomeArquivo;

    public Compilador() {
        initComponents();
        inicializar();
    }

    private void inicializar() {
        CompiladorConst contadorLinhas = new CompiladorConst(taEditor);
        jspEditor.setRowHeaderView(contadorLinhas);

        adicionaActionPerformed(jbNovo, KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
        adicionaActionPerformed(jbAbrir, KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        adicionaActionPerformed(jbSalvar, KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        adicionaActionPerformed(jbColar, KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
        adicionaActionPerformed(jbRecortar, KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
        adicionaActionPerformed(jbCompilar, KeyStroke.getKeyStroke("F9"));
        adicionaActionPerformed(jbEquipe, KeyStroke.getKeyStroke("F1"));

        caminho = "";
        lbBarraStatus.setText(caminho);
    }

    private void adicionaActionPerformed(final JButton botao, KeyStroke ks) {
        ActionMap actionMap = botao.getActionMap();
        actionMap.put("action", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (botao.getText()) {
                    case "novo [ctrl-n]":
                        jbNovoActionPerformed(e);
                        break;
                    case "abrir [ctrl-o]":
                        jbAbrirActionPerformed(e);
                        break;
                    case "salvar [ctrl-s]":
                        jbSalvarActionPerformed(e);
                        break;
                    case "copiar [ctrl-c]":
                        jbCopiarActionPerformed(e);
                        break;
                    case "colar [ctrl-v]":
                        jbColarActionPerformed(e);
                        break;
                    case "recortar [ctrl-x]":
                        jbRecortarActionPerformed(e);
                        break;
                    case "compilar [F9]":
                        jbCompilarActionPerformed(e);
                        break;
                    case "equipe [F1]":
                        jbEquipeActionPerformed(e);
                        break;
                }
            }
        });
        InputMap inputMap = botao.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(ks, "action");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbBarraStatus = new java.awt.Label();
        jpBarraFerramentas = new javax.swing.JPanel();
        jbNovo = new javax.swing.JButton();
        jbAbrir = new javax.swing.JButton();
        jbSalvar = new javax.swing.JButton();
        jbCopiar = new javax.swing.JButton();
        jbColar = new javax.swing.JButton();
        jbRecortar = new javax.swing.JButton();
        jbCompilar = new javax.swing.JButton();
        jbEquipe = new javax.swing.JButton();
        jspMensagens = new javax.swing.JScrollPane();
        taMensagens = new javax.swing.JTextArea();
        jspEditor = new javax.swing.JScrollPane();
        taEditor = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 620));

        lbBarraStatus.setText("Barra de status");

        jpBarraFerramentas.setPreferredSize(new java.awt.Dimension(144, 544));

        jbNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Novo.png"))); // NOI18N
        jbNovo.setText("new [ctrl-n]");
        jbNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });

        jbAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Abrir.png"))); // NOI18N
        jbAbrir.setText("open [ctrl-o]");
        jbAbrir.setActionCommand("jbAbrir");
        jbAbrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbAbrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAbrirActionPerformed(evt);
            }
        });

        jbSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Salvar.png"))); // NOI18N
        jbSalvar.setText("save [ctrl-s]");
        jbSalvar.setActionCommand("jbSalvar");
        jbSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbCopiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Copiar.gif"))); // NOI18N
        jbCopiar.setText("copy [ctrl-c]");
        jbCopiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbCopiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbCopiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCopiarActionPerformed(evt);
            }
        });

        jbColar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Colar.png"))); // NOI18N
        jbColar.setText("paste [ctrl-v]");
        jbColar.setActionCommand("jbColar");
        jbColar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbColar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbColar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbColarActionPerformed(evt);
            }
        });

        jbRecortar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Recortar.png"))); // NOI18N
        jbRecortar.setText("cut [ctrl-x]");
        jbRecortar.setActionCommand("jbRecortar");
        jbRecortar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbRecortar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbRecortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRecortarActionPerformed(evt);
            }
        });

        jbCompilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Compilar.png"))); // NOI18N
        jbCompilar.setText("compilar [F9]");
        jbCompilar.setActionCommand("jbCompilar");
        jbCompilar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbCompilar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCompilarActionPerformed(evt);
            }
        });

        jbEquipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Equipe.png"))); // NOI18N
        jbEquipe.setText("about [F1]");
        jbEquipe.setActionCommand("jbGerarCodigo");
        jbEquipe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbEquipe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbEquipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEquipeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpBarraFerramentasLayout = new javax.swing.GroupLayout(jpBarraFerramentas);
        jpBarraFerramentas.setLayout(jpBarraFerramentasLayout);
        jpBarraFerramentasLayout.setHorizontalGroup(
            jpBarraFerramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jbNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jbAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jbSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jbCopiar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jbColar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jbRecortar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jbCompilar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jbEquipe, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jpBarraFerramentasLayout.setVerticalGroup(
            jpBarraFerramentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBarraFerramentasLayout.createSequentialGroup()
                .addComponent(jbNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jbAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jbSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jbCopiar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jbColar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jbRecortar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jbCompilar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jbEquipe, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jspMensagens.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jspMensagens.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        taMensagens.setColumns(20);
        taMensagens.setRows(5);
        taMensagens.setEnabled(false);
        taMensagens.setMinimumSize(new java.awt.Dimension(750, 105));
        jspMensagens.setViewportView(taMensagens);

        jspEditor.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jspEditor.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        taEditor.setColumns(20);
        taEditor.setRows(5);
        taEditor.setMinimumSize(new java.awt.Dimension(750, 480));
        taEditor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                taEditorKeyPressed(evt);
            }
        });
        jspEditor.setViewportView(taEditor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpBarraFerramentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jspMensagens, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
                    .addComponent(jspEditor)))
            .addComponent(lbBarraStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jspEditor, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jspMensagens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jpBarraFerramentas, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbBarraStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        taEditor.setText("");
        taMensagens.setText("");
        lbBarraStatus.setText("");
        caminho = "";
    }//GEN-LAST:event_jbNovoActionPerformed

    private void jbAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAbrirActionPerformed
        JFileChooser jfc = new JFileChooser();
        try {
            jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            FileNameExtensionFilter f = new FileNameExtensionFilter(".txt", "txt");
            jfc.setFileFilter(f);
            int resultado = jfc.showOpenDialog(this);
            if (resultado == JFileChooser.APPROVE_OPTION) {
                nomeArquivo = jfc.getSelectedFile();
                FileReader fr = new FileReader(nomeArquivo);
                BufferedReader br = new BufferedReader(fr);
                String linha = null;
                linha = (String) br.readLine();
                String texto = "";
                while (linha != null) {
                    texto += linha + "\n";
                    linha = br.readLine();
                }
                taEditor.setText(texto);
                br.close();

                lbBarraStatus.setText("" + nomeArquivo);
                caminho = nomeArquivo.toPath().toString();
                taMensagens.setText("");
            }
        } catch (ArrayIndexOutOfBoundsException | IOException e) {
        }
    }//GEN-LAST:event_jbAbrirActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        salvar(".txt");
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void salvar(String extensao) {
        if (caminho.isEmpty()) {
            JFileChooser arquivo = new JFileChooser();
            FileNameExtensionFilter f = new FileNameExtensionFilter(extensao, extensao);
            arquivo.setFileFilter(f);
            int resultado = arquivo.showSaveDialog(null);
            if (resultado == JFileChooser.APPROVE_OPTION) {
                FileWriter fw = null;
                try {
                    nomeArquivo = arquivo.getSelectedFile();
                    if (arquivo.getSelectedFile().toString().contains(extensao)) {
                        fw = new FileWriter(nomeArquivo);
                        caminho = nomeArquivo.toPath().toString();
                    } else {
                        fw = new FileWriter(nomeArquivo + extensao);
                        caminho = nomeArquivo.toPath().toString() + extensao;
                    }
                    lbBarraStatus.setText("" + nomeArquivo);
                    BufferedWriter br = new BufferedWriter(fw);
                    String[] str = taEditor.getText().split("\n");
                    for (int i = 0; i < str.length; i++) {
                        br.write(str[i]);
                        br.newLine();
                    }
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fw.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else {
            FileWriter fw = null;
            try {
                fw = new FileWriter(caminho);
                BufferedWriter br = new BufferedWriter(fw);
                String[] str = taEditor.getText().split("\n");
                for (int i = 0; i < str.length; i++) {
                    br.write(str[i]);
                    br.newLine();
                }
                br.close();
                taMensagens.setText("");
                lbBarraStatus.setText("" + caminho);
            } catch (IOException ex) {
                Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fw.close();
                } catch (IOException ex) {
                    Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

    private void jbCopiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCopiarActionPerformed
        taEditor.copy();
    }//GEN-LAST:event_jbCopiarActionPerformed

    private void jbColarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbColarActionPerformed
        taEditor.paste();
    }//GEN-LAST:event_jbColarActionPerformed

    private void jbRecortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRecortarActionPerformed
        taEditor.cut();
    }//GEN-LAST:event_jbRecortarActionPerformed

    private void jbCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCompilarActionPerformed
        taMensagens.setText("compilação de programas ainda não foi implementada");
    }//GEN-LAST:event_jbCompilarActionPerformed

    private void jbEquipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEquipeActionPerformed
        taMensagens.setText(" - Douglas Eduardo Bauler; \n - Jefferson do Nascimento Júnior; \n - Larissa Sindy Makufka Schlichting.");
    }//GEN-LAST:event_jbEquipeActionPerformed

    public String getNomePrograma() {
        if (nomeArquivo != null) {
            return nomeArquivo.getName().replaceFirst("(?<=.)\\.[^\\.]+?$", "").replaceAll("\\s|\\.", "_"); 
        }
        return "";
    }

    public static void salvar(File file, String content) throws IOException {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        try (FileOutputStream fos = new FileOutputStream(file); 
                BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            fos.write(content.getBytes());
        }
    }
    private void taEditorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_taEditorKeyPressed
        lbBarraStatus.setText("" + caminho);
    }//GEN-LAST:event_taEditorKeyPressed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compilador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compilador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbAbrir;
    private javax.swing.JButton jbColar;
    private javax.swing.JButton jbCompilar;
    private javax.swing.JButton jbCopiar;
    private javax.swing.JButton jbEquipe;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbRecortar;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JPanel jpBarraFerramentas;
    private javax.swing.JScrollPane jspEditor;
    private javax.swing.JScrollPane jspMensagens;
    private java.awt.Label lbBarraStatus;
    private javax.swing.JTextArea taEditor;
    private javax.swing.JTextArea taMensagens;
    // End of variables declaration//GEN-END:variables

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public File getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(File nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public JButton getJbAbrir() {
        return jbAbrir;
    }

    public void setJbAbrir(JButton jbAbrir) {
        this.jbAbrir = jbAbrir;
    }

    public JButton getJbColar() {
        return jbColar;
    }

    public void setJbColar(JButton jbColar) {
        this.jbColar = jbColar;
    }

    public JButton getJbCompilar() {
        return jbCompilar;
    }

    public void setJbCompilar(JButton jbCompilar) {
        this.jbCompilar = jbCompilar;
    }

    public JButton getJbCopiar() {
        return jbCopiar;
    }

    public void setJbCopiar(JButton jbCopiar) {
        this.jbCopiar = jbCopiar;
    }

    public JButton getJbEquipe() {
        return jbEquipe;
    }

    public void setJbEquipe(JButton jbEquipe) {
        this.jbEquipe = jbEquipe;
    }

    public JButton getJbNovo() {
        return jbNovo;
    }

    public void setJbNovo(JButton jbNovo) {
        this.jbNovo = jbNovo;
    }

    public JButton getJbRecortar() {
        return jbRecortar;
    }

    public void setJbRecortar(JButton jbRecortar) {
        this.jbRecortar = jbRecortar;
    }

    public JButton getJbSalvar() {
        return jbSalvar;
    }

    public void setJbSalvar(JButton jbSalvar) {
        this.jbSalvar = jbSalvar;
    }

    public JPanel getJpBarraFerramentas() {
        return jpBarraFerramentas;
    }

    public void setJpBarraFerramentas(JPanel jpBarraFerramentas) {
        this.jpBarraFerramentas = jpBarraFerramentas;
    }

    public JScrollPane getJspEditor() {
        return jspEditor;
    }

    public void setJspEditor(JScrollPane jspEditor) {
        this.jspEditor = jspEditor;
    }

    public JScrollPane getJspMensagens() {
        return jspMensagens;
    }

    public void setJspMensagens(JScrollPane jspMensagens) {
        this.jspMensagens = jspMensagens;
    }

    public Label getLbBarraStatus() {
        return lbBarraStatus;
    }

    public void setLbBarraStatus(Label lbBarraStatus) {
        this.lbBarraStatus = lbBarraStatus;
    }

    public JTextArea getTaEditor() {
        return taEditor;
    }

    public void setTaEditor(JTextArea taEditor) {
        this.taEditor = taEditor;
    }

    public JTextArea getTaMensagens() {
        return taMensagens;
    }

    public void setTaMensagens(JTextArea taMensagens) {
        this.taMensagens = taMensagens;
    }
    
}
