/*
 * Copyright (c) 2018 Jalasoft.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * This software is the confidential and proprietary information of  Jalasoft, ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into  with Jalasoft.
 */

package com.search.view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import java.io.File;

public class PanelSearchParameters extends JPanel{
    private JLabel labelPath;
    private JLabel labelFileName;
    private JLabel labelExtension;
    private JTextField textPath;
    private JTextField fileName;
    private JTextField extension;
    private JButton buttonSearch;
    private JButton buttonChooser;
    private JPanel panelFieldNames;
    private JPanel panelInputFields;
    private JPanel panelButtons;
    private JPanel panelUp;
    private JFileChooser fileChooser;

    public PanelSearchParameters()
    {
        settings();
        init();
        //searchAction();
        setPathChooser();
    }

    public void settings()
    {
        setBorder(BorderFactory.createTitledBorder("Search Parameters"));
        labelPath = new JLabel("Path:");
        labelFileName = new JLabel("FileName:");
        labelExtension = new JLabel("Extension:");
        textPath = new JTextField(20);
        fileName = new JTextField(20);
        extension = new JTextField(20);
        buttonSearch = new JButton("Search");
        buttonChooser = new JButton("Select Path");
        fileChooser = new JFileChooser("c:/");
        panelFieldNames = new JPanel();
        panelInputFields = new JPanel();
        panelUp = new JPanel();
        panelButtons = new JPanel();
    }

    public void init()
    {
        panelFieldNames.setLayout(new GridLayout(3,0));
        panelFieldNames.add(labelPath);
        panelFieldNames.add(labelFileName);
        panelFieldNames.add(labelExtension);

        panelInputFields.setLayout(new GridLayout(3,0));
        panelInputFields.add(textPath);
        panelInputFields.add(fileName);
        panelInputFields.add(extension);
        panelUp.setLayout(new GridLayout(1,1));
        panelUp.setPreferredSize(new Dimension(300,200));
        panelUp.add(panelFieldNames);
        panelUp.add(panelInputFields);

        panelButtons.setLayout(new FlowLayout());
        panelButtons.setPreferredSize(new Dimension(200,50));
        panelButtons.add(buttonSearch);
        panelButtons.add(buttonChooser);

        setLayout(new GridLayout(2,0));
        add(panelUp);
        add(panelButtons);
    }

    public void searchAction()
    {
        buttonSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(PanelSearchParameters.this,
                        "Search Results:\n" + " No files found");

            }
        });
    }
    public void getSelectedPath()
    {
        String path;
        fileChooser.setDialogTitle("Select a Folder");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        int result = fileChooser.showDialog(PanelSearchParameters.this,"Select");
        if (result == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = fileChooser.getSelectedFile();
            path = selectedFile.getAbsolutePath();
            System.out.println("Selected Directory:" + selectedFile );
            textPath.setText(path);
        }
    }

    public  void setPathChooser()
    {
        buttonChooser.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                getSelectedPath();
            }
        });
    }

    public PanelSearchParameters getSearchPanel()
    {
        return this;
    }

    public JButton getButtonSearch()
    {
        System.out.println("On View" );
        return this.buttonSearch;
    }

    public String getPath()
    {
        return textPath.getText();
    }

    public String getFileName()
    {
        return fileName.getText();
    }

    public String getExtension()
    {
        return extension.getText();
    }
}
