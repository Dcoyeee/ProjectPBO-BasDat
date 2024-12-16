package com.bibliometrik.gui;

import javax.swing.*;
import java.awt.*;

public class FormUtama extends JFrame {
    public FormUtama() {
        setTitle("Form Utama");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Set the layout for the frame
        setLayout(new BorderLayout());
        
        // Create the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 2, 20, 20));
        
        // Add components to the main panel
        mainPanel.add(new JButton("Analisis"));
        mainPanel.add(new JButton("Publikasi"));
        mainPanel.add(new JButton("Transaksi"));
        mainPanel.add(new JButton("Pengujian"));
        
        // Add the main panel to the frame
        add(mainPanel, BorderLayout.CENTER);
        
        // Add a menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        fileMenu.add(new JMenuItem("Buka"));
        fileMenu.add(new JMenuItem("Simpan"));
        fileMenu.add(new JMenuItem("Keluar"));
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FormUtama().setVisible(true);
            }
        });
    }
}