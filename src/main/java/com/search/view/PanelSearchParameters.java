/*
 * Copyright (c) 2018 Jalasoft.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * This software is the confidential and proprietary information of  Jalasoft, ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into  with Jalasoft.
 */

package com.search.view;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Properties;
import java.util.Date;

public class PanelSearchParameters extends JPanel{
    private JLabel labelPath;
    private JLabel labelFileName;
    private JLabel labelExtension;
    private JLabel labelDateCriteria;
    private JLabel labelSelectedMDate;
    private JLabel labelSelectedCDate;
    private JLabel labelSelectedADate;
    private JLabel labelSize;
    private JLabel labelKind;
    private JLabel labelAdvancedOptions;
    private JLabel labelHidden;
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
    private UtilDateModel dateModelM;
    private Properties datePropertiesM;
    private JDatePanelImpl datePanelM;
    private UtilDateModel dateModelA;
    private Properties datePropertiesA;
    private JDatePanelImpl datePanelA;
    private UtilDateModel dateModelC;
    private Properties datePropertiesC;
    private JDatePanelImpl datePanelC;
    private JDatePickerImpl datePickerM;
    private JDatePickerImpl datePickerA;
    private JDatePickerImpl datePickerC;
    private JComboBox comboFileSize;
    private JComboBox comboFileKind;
    private JCheckBox checkBoxHidden;
    private JCheckBox checkBoxDirectory;

    public PanelSearchParameters()
    {
        settings();
        init();
        //searchAction();
        setPathChooser();
        getModifiedDate();
    }

    public void settings()
    {
        setBorder(BorderFactory.createTitledBorder("Search Parameters"));
        labelPath = new JLabel("** Path:");
        labelFileName = new JLabel("File Name:");
        labelExtension = new JLabel("Extension:");
        labelDateCriteria = new JLabel("Date Criteria:");
        labelSelectedMDate = new JLabel("Modified Date:");
        labelSelectedADate = new JLabel("Last Access Date:");
        labelSelectedCDate = new JLabel("Created Date:");
        labelSize = new JLabel("Size:");
        labelKind = new JLabel("Kind:");
        labelAdvancedOptions = new JLabel("Advanced Options");

        textPath = new JTextField(20);
        fileName = new JTextField(20);
        extension = new JTextField(20);
        buttonSearch = new JButton("Search");
        buttonChooser = new JButton("Select Path");
        fileChooser = new JFileChooser("c:/");
        dateModelM = new UtilDateModel();
        datePropertiesM = new Properties();
        datePropertiesM.put("text.today","Today");
        datePropertiesM.put("text.month", "Month");
        datePropertiesM.put("text.year", "Year");
        datePanelM = new JDatePanelImpl(dateModelM, datePropertiesM);

        dateModelA = new UtilDateModel();
        datePropertiesA = new Properties();
        datePropertiesA.put("text.today","Today");
        datePropertiesA.put("text.month", "Month");
        datePropertiesA.put("text.year", "Year");
        datePanelA = new JDatePanelImpl(dateModelA, datePropertiesA);

        dateModelC = new UtilDateModel();
        datePropertiesC = new Properties();
        datePropertiesC.put("text.today","Today");
        datePropertiesC.put("text.month", "Month");
        datePropertiesC.put("text.year", "Year");
        datePanelC = new JDatePanelImpl(dateModelC, datePropertiesC);

        datePickerM = new JDatePickerImpl(datePanelM, new DateComponentFormatter());
        datePickerA = new JDatePickerImpl(datePanelA, new DateComponentFormatter());
        datePickerC = new JDatePickerImpl(datePanelC, new DateComponentFormatter());
        comboFileSize = new JComboBox(setSizeList());
        comboFileKind = new JComboBox(setKindList());
        checkBoxHidden = new JCheckBox("Hidden fields?", false);
        checkBoxDirectory = new JCheckBox("Directory Only?", false);

        panelFieldNames = new JPanel();
        panelInputFields = new JPanel();
        panelUp = new JPanel();
        panelButtons = new JPanel();
    }

    public void init()
    {
        panelFieldNames.setLayout(new GridLayout(12,0));
        panelFieldNames.add(labelPath);
        panelFieldNames.add(labelFileName);
        panelFieldNames.add(labelExtension);
        panelFieldNames.add(labelSelectedMDate);
        panelFieldNames.add(labelSelectedADate);
        panelFieldNames.add(labelSelectedCDate);
        panelFieldNames.add(labelSize);
        panelFieldNames.add(labelKind);
        panelFieldNames.add(labelAdvancedOptions);

        panelInputFields.setLayout(new GridLayout(12,0));
        panelInputFields.add(textPath);
        panelInputFields.add(fileName);
        panelInputFields.add(extension);
        panelInputFields.add(datePickerM);
        panelInputFields.add(datePickerA);
        panelInputFields.add(datePickerC);

        panelInputFields.add(comboFileSize);
        panelInputFields.add(comboFileKind);
        panelInputFields.add(checkBoxHidden);
        panelInputFields.add(checkBoxDirectory);

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

    public Date getModifiedDate()
    {
        Date selectedDate = (Date) datePickerM.getModel().getValue();
        System.out.println(selectedDate);
        return selectedDate;
    }
    public void requirePath()
    {
        labelPath.setForeground(Color.RED);
    }
    public String[] setSizeList()
    {
        String[] sizeList = new String[8];
        sizeList [0] = "Empty (0 KB)";
        sizeList [1] = "Tiny (0 - 10 KB)";
        sizeList [2] = "Small (10 - 100KB)";
        sizeList [3] = "Medium (100 KB - 1MB)";
        sizeList [4] = "Large(1 - 16 MB)";
        sizeList [5] = "Huge(16 - 128MB)";
        sizeList [6] = "Gigantic(>128 MB)";
        sizeList [7] = "Other";
        return sizeList;
    }

    public String[] setKindList()
    {
        String[] kindList = new String[8];
        kindList [0] = "E-mail";
        kindList [1] = "Folder";
        kindList [2] = "Movie";
        kindList [3] = "Music";
        kindList [4] = "Note";
        kindList [5] = "Picture";
        kindList [6] = "Video";
        kindList [7] = "unknown";
        return kindList;
    }

    public JComboBox getComboFileSize()
    {
        return comboFileSize;
    }
}
