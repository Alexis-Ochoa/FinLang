package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class FinLangInterpreterUI extends JFrame {

    private JTextArea codeTextArea;
    private JTextArea outputTextArea;
    private JButton executeButton;
    private JButton clearButton;
    private javax.swing.JPanel exitButton;
    private javax.swing.JLabel exitText;

    public FinLangInterpreterUI() {
        setTitle("FinLang IDE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        initComponents();
        applyStyles(); // Aplicar estilos después de inicializar componentes
    }package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

    public class FinLangInterpreterUI extends JFrame {

        private JTextArea codeTextArea;
        private JTextArea outputTextArea;
        private JButton executeButton;
        private JButton clearButton;
        private javax.swing.JPanel exitButton;
        private javax.swing.JLabel exitText;

        public FinLangInterpreterUI() {
            setTitle("FinLang IDE");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(800, 600);
            setLocationRelativeTo(null);

            initComponents();
            applyStyles(); // Aplicar estilos después de inicializar componentes
        }

        private void initComponents() {
            setLayout(new BorderLayout());

            codeTextArea = new JTextArea();
            add(new JScrollPane(codeTextArea), BorderLayout.CENTER);

            JPanel buttonPanel = new JPanel();
            executeButton = new JButton("Ejecutar");
            clearButton = new JButton("Limpiar");

            // Prueba
            exitButton = new javax.swing.JPanel();
            exitText = new javax.swing.JLabel("X");
            exitButton.add(exitText); // Añadir el texto al panel
            buttonPanel.add(exitButton); // Añadir el panel de salida al panel de botones

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            //setUndecorated(true);
            setResizable(false);



            executeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    outputTextArea.append("Ejecutando código...\n");
                }
            });

            clearButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    codeTextArea.setText("");
                    outputTextArea.setText("");
                }
            });

            buttonPanel.add(executeButton);
            buttonPanel.add(clearButton);
            add(buttonPanel, BorderLayout.NORTH);

            outputTextArea = new JTextArea();
            outputTextArea.setEditable(false);
            add(new JScrollPane(outputTextArea), BorderLayout.SOUTH);

            createMenu();

            setVisible(true);
        }

        private void createMenu() {
            JMenuBar menuBar = new JMenuBar();
            JMenu fileMenu = new JMenu("Archivo");
            JMenuItem newMenuItem = new JMenuItem("Nuevo");
            JMenuItem openMenuItem = new JMenuItem("Abrir");
            JMenuItem saveMenuItem = new JMenuItem("Guardar");
            JMenuItem exitMenuItem = new JMenuItem("Salir");

            fileMenu.add(newMenuItem);
            fileMenu.add(openMenuItem);
            fileMenu.add(saveMenuItem);
            fileMenu.addSeparator();
            fileMenu.add(exitMenuItem);

            JMenu editMenu = new JMenu("Editar");
            JMenuItem cutMenuItem = new JMenuItem("Cortar");
            JMenuItem copyMenuItem = new JMenuItem("Copiar");
            JMenuItem pasteMenuItem = new JMenuItem("Pegar");

            editMenu.add(cutMenuItem);
            editMenu.add(copyMenuItem);
            editMenu.add(pasteMenuItem);

            menuBar.add(fileMenu);
            menuBar.add(editMenu);

            setJMenuBar(menuBar);
        }

        private void applyStyles() {
            // Estilos para el área de entrada
            codeTextArea.setBackground(new Color(255, 255, 230)); //  Amarillo claro
            codeTextArea.setForeground(new Color(0, 0, 139));   //  Azul oscuro
            codeTextArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
            codeTextArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));

            // Estilos para el área de salida
            outputTextArea.setBackground(Color.DARK_GRAY);
            outputTextArea.setForeground(Color.GREEN);
            outputTextArea.setFont(new Font("Courier New", Font.BOLD, 12));
            outputTextArea.setBorder(BorderFactory.createEtchedBorder());

            // Estilos para los botones
            executeButton.setBackground(new Color(0, 128, 0));  //  Verde oscuro
            executeButton.setForeground(Color.WHITE);
            executeButton.setFont(new Font("Arial", Font.BOLD, 16));
            executeButton.setBorder(BorderFactory.createRaisedBevelBorder());

            clearButton.setBackground(Color.RED);
            clearButton.setForeground(Color.WHITE);
            clearButton.setFont(new Font("Arial", Font.BOLD, 16));
            clearButton.setBorder(BorderFactory.createLoweredBevelBorder());

            exitButton.setBackground(new java.awt.Color(255, 0, 0));
            exitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            exitButton.setPreferredSize(new Dimension(40, 40));

            exitText.setFont(new java.awt.Font("Roboto Light", 0, 36)); // NOI18N
            exitText.setForeground(new java.awt.Color(0, 0, 0));
            exitText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            exitText.setText("X");
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new org.example.FinLangInterpreterUI();
                }
            });
        }
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        codeTextArea = new JTextArea();
        add(new JScrollPane(codeTextArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        executeButton = new JButton("Ejecutar");
        clearButton = new JButton("Limpiar");

        // Prueba
        exitButton = new javax.swing.JPanel();
        exitText = new javax.swing.JLabel("X");
        exitButton.add(exitText); // Añadir el texto al panel
        buttonPanel.add(exitButton); // Añadir el panel de salida al panel de botones

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        //setUndecorated(true);
        setResizable(false);

        

        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputTextArea.append("Ejecutando código...\n");
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                codeTextArea.setText("");
                outputTextArea.setText("");
            }
        });

        buttonPanel.add(executeButton);
        buttonPanel.add(clearButton);
        add(buttonPanel, BorderLayout.NORTH);

        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        add(new JScrollPane(outputTextArea), BorderLayout.SOUTH);

        createMenu();

        setVisible(true);
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Archivo");
        JMenuItem newMenuItem = new JMenuItem("Nuevo");
        JMenuItem openMenuItem = new JMenuItem("Abrir");
        JMenuItem saveMenuItem = new JMenuItem("Guardar");
        JMenuItem exitMenuItem = new JMenuItem("Salir");

        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        JMenu editMenu = new JMenu("Editar");
        JMenuItem cutMenuItem = new JMenuItem("Cortar");
        JMenuItem copyMenuItem = new JMenuItem("Copiar");
        JMenuItem pasteMenuItem = new JMenuItem("Pegar");

        editMenu.add(cutMenuItem);
        editMenu.add(copyMenuItem);
        editMenu.add(pasteMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        setJMenuBar(menuBar);
    }

    private void applyStyles() {
        // Estilos para el área de entrada
        codeTextArea.setBackground(new Color(255, 255, 230)); //  Amarillo claro
        codeTextArea.setForeground(new Color(0, 0, 139));   //  Azul oscuro
        codeTextArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        codeTextArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        // Estilos para el área de salida
        outputTextArea.setBackground(Color.DARK_GRAY);
        outputTextArea.setForeground(Color.GREEN);
        outputTextArea.setFont(new Font("Courier New", Font.BOLD, 12));
        outputTextArea.setBorder(BorderFactory.createEtchedBorder());

        // Estilos para los botones
        executeButton.setBackground(new Color(0, 128, 0));  //  Verde oscuro
        executeButton.setForeground(Color.WHITE);
        executeButton.setFont(new Font("Arial", Font.BOLD, 16));
        executeButton.setBorder(BorderFactory.createRaisedBevelBorder());

        clearButton.setBackground(Color.RED);
        clearButton.setForeground(Color.WHITE);
        clearButton.setFont(new Font("Arial", Font.BOLD, 16));
        clearButton.setBorder(BorderFactory.createLoweredBevelBorder());

        exitButton.setBackground(new java.awt.Color(255, 0, 0));
        exitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitButton.setPreferredSize(new Dimension(40, 40));

        exitText.setFont(new java.awt.Font("Roboto Light", 0, 36)); // NOI18N
        exitText.setForeground(new java.awt.Color(0, 0, 0));
        exitText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitText.setText("X");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FinLangInterpreterUI();
            }
        });
    }
}