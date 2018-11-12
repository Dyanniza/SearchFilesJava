/*
 * Copyright (c) 2018 Jalasoft.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * This software is the confidential and proprietary information of  Jalasoft, ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into  with Jalasoft.
 */
/**
 * Description: JPanel class that contains, configure, initialize and set action
 * events for the Search parameters fields
 * @version 1.0
 * @autor Cecilia Chalar
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
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
    private JLabel empty;
    private JTextField textPath;
    private JTextField fileName;
    private JTextField extension;
    private JTextField fileSize;
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
    private JComboBox comboFileOperator;
    private JComboBox comboFileKind;
    private JCheckBox checkBoxHidden;
    private JCheckBox checkBoxDirectory;
    private JCheckBox checkBoxReadOnly;


    public PanelSearchParameters()
    {
        settings();
        init();
        //searchAction();
        setPathChooser();
        getModifiedDate();
        setSelectSizeOperator();
    }
    /**
     * Set initial values  and configurations for each component
     */
    public void settings()
    {
        setBorder(BorderFactory.createTitledBorder("Search Parameters"));
        labelPath = new JLabel("** Path:");
        labelFileName = new JLabel("File Name:");
        labelExtension = new JLabel("Extension:");
        labelDateCriteria = new JLabel("Date Criteria:");
        labelSelectedMDate = new JLabel("Modified Date less than:");
        labelSelectedADate = new JLabel("Last Access Date less than:");
        labelSelectedCDate = new JLabel("Created Date less than:");
        labelSize = new JLabel("Size (Bytes):");
        labelKind = new JLabel("Kind:");
        labelAdvancedOptions = new JLabel("Advanced Options");
        empty = new JLabel();

        textPath = new JTextField(20);
        fileName = new JTextField(20);
        extension = new JTextField(20);
        fileSize = new JFormattedTextField();
        buttonSearch = new JButton("Search");
        buttonSearch.setEnabled(false);
        new Thread(target).start();
        disableAction();
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
        comboFileOperator = new JComboBox(setSizeOperator());
        comboFileKind = new JComboBox(setKindList());
        checkBoxHidden = new JCheckBox("Hidden Files?", false);
        checkBoxDirectory = new JCheckBox("Directory Only?", false);
        checkBoxReadOnly = new JCheckBox("Read Only Files?", false);

        panelFieldNames = new JPanel();
        panelInputFields = new JPanel();
        panelUp = new JPanel();
        panelButtons = new JPanel();
    }
    /**
     * Configure the Field names and input  fields  panels in 2 columns
     * Add fields and buttons to  panels
     */
    public void init()
    {
        panelFieldNames.setLayout(new GridLayout(15,0));
        panelFieldNames.add(labelPath);
        panelFieldNames.add(labelFileName);
        panelFieldNames.add(labelExtension);
        panelFieldNames.add(labelSelectedMDate);
        panelFieldNames.add(labelSelectedADate);
        panelFieldNames.add(labelSelectedCDate);
        panelFieldNames.add(labelSize);
        panelFieldNames.add(empty);

        panelFieldNames.add(labelAdvancedOptions);

        panelInputFields.setLayout(new GridLayout(15,0));
        panelInputFields.add(textPath);
        panelInputFields.add(fileName);
        panelInputFields.add(extension);
        panelInputFields.add(datePickerM);
        panelInputFields.add(datePickerA);
        panelInputFields.add(datePickerC);
        panelInputFields.add(comboFileOperator);
        panelInputFields.add(fileSize);

        panelInputFields.add(checkBoxHidden);
        panelInputFields.add(checkBoxDirectory);
        panelInputFields.add(checkBoxReadOnly);

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

    /**
     * Method: disableAction()
     * Add action listener to a text field: Path,  if text field is empty, Search button is disabled,
     * if text field is not empty, Search button is enabled
     * @param
     * @return
     */
    public void disableAction()
    {
        textPath.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(e.getActionCommand().equalsIgnoreCase("Enable"))
                {
                    buttonSearch.setEnabled(true);
                }
                else if (e.getActionCommand().equalsIgnoreCase("Disable"))
                {
                    buttonSearch.setEnabled(false);
                }
            }
        });
    }
    final Runnable target = new Runnable() {
        @Override
        public void run() {
            while (true)
            {
                final ActionListener[] listeners = textPath.getActionListeners();
                for (ActionListener listener: listeners)
                {
                    if (textPath.getText().trim().length() > 0)
                    {
                        final ActionEvent event = new ActionEvent(textPath,1,"Enable");
                        listener.actionPerformed(event);
                    }
                    else
                        {
                            final ActionEvent event = new ActionEvent(textPath,1,"Disable");
                            listener.actionPerformed(event);
                        }
                }
            }
        }
    };

    /**
     * Add setting for the 'File chooser', confugure to  select and display only directories.
     * Set the selected path to 'Path' text
     */
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
    /**
     * add an action listener to 'Select Path' button nad calls to getSelectedPath() method
     */
    public  void setPathChooser()
    {
        buttonChooser.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                getSelectedPath();
            }
        });
    }

    /**
     * @return JButton Search with all configured properties
     */
    public JButton getButtonSearch()
    {
        System.out.println("On View" );
        return this.buttonSearch;
    }
    /**
     * Methods: getPAtch(), getFileName() and getExtension()
     * Description: Obtain values  of  text fields File Name and Extension
     * @return String
     */
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

    /**
     * Methods: getModifiedDate(), getAccessDate() and getCreatedDate()
     * Description: get the selected value of date picked in Date format and convert to a String
     * @param
     * @return String  date
     */
    public Date getModifiedDate()
    {
        Date selectedDate = (Date) datePickerM.getModel().getValue();
        System.out.println("MDate - view:" + selectedDate);
        return selectedDate;
    }
    public Date getAccessDate()
    {
        Date selectedDate = (Date) datePickerA.getModel().getValue();
        System.out.println(selectedDate);
        return selectedDate;
    }
    public Date getCreatedDate()
    {
        Date selectedDate = (Date) datePickerA.getModel().getValue();
        System.out.println(selectedDate);
        return selectedDate;
    }
    /**
     * Get the value selected in Size text field and convert values to an integer
     * @return int with values selected on size
     */
    public int getFileSize()
    {   int numFileSize;
        if(!fileSize.getText().isEmpty())
        {
            String sFileSize = fileSize.getText();
            numFileSize = Integer.parseInt(sFileSize);
            System.out.println(numFileSize + "ss");

        }else
            {numFileSize=0;
            }
        return numFileSize;
    }
    /**
     * Set the items list for Size operator combo box list
     * @param
     * @return String[] an array of Strings in list items to fill the combo box
     */
    public String[] setSizeOperator()
    {
        String[] sizeList = new String[4];
        sizeList [0] = "Equals";
        sizeList [1] = "Greater than";
        sizeList [2] = "Less than";
        return sizeList;
    }
    /**
     * Set the items list fot a combo box list
     * @param
     * @return String[] an array of Strings in list items to fill the combo box
     */
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
    /**
     * getIf ... methods get the advanced search options: Hidden, Only directories and read Only
     * @return boolean true if option is selected and false if option is not selected
     */
    public boolean getIfHidden()
    {
        return checkBoxHidden.isSelected();
    }
    public boolean getIfOnlyDir()
    {
        return checkBoxDirectory.isSelected();
    }
    public boolean getIfReadOnly()
    {
        return checkBoxReadOnly.isSelected();
    }
    /**
     * Get the selected item list from combo box: comboFileOperator, the default selection is Equals
     * @return int 0,1,2 where 0 means "Equals", 1: "Grater than" and 2: "Less than"
     */
    public int getSelectedSizeOperator()
    {
        String selectedOperator = (String)comboFileOperator.getSelectedItem();
        System.out.println("SizeOperator - view:" + selectedOperator);
        final int e = 0;
        final int g = 1;
        final int t = 2;
        if (selectedOperator.equals("Equals"))
        {
            System.out.println(e);
            return e;
        }else if(selectedOperator.equals("Greater than"))
        {
            System.out.println(g);
            return g;
        }else
            System.out.println(t);
            return t;
    }
    /**
     *  Add action listener every tme that user change the selection of the combo box "Size operator"
     */
    public void setSelectSizeOperator()
     {
         comboFileOperator.addActionListener(new ActionListener() {
                                                 @Override
                                                 public void actionPerformed(ActionEvent e) {
                                                     getSelectedSizeOperator();
                                                 }
                                             }
         );
     }

}
