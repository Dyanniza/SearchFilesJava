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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.BorderLayout;
/**
 * Description: JPanel class that contains the panel with the results table
 * @version 1.0
 * @autor Cecilia Chalar
 */
public class PanelSearchResults extends JPanel
{
    private JLabel labelResults;
    private DefaultTableModel tableModel;
    private JTable tableResults;

    private JScrollPane tableScroll;
    private Object columnNames [] = {"Location", "File Name","Extension","Size (Bytes)","Modified Date","Last Access Date","Created Date","Hidden File","Read Only"};
    private Object tableData[][]= {};


    public PanelSearchResults()
    {
        settings();
    }
    /**
     * Description: Set default model for the tables and initial configurations
     */
    public void settings()
    {
        setBorder(BorderFactory.createTitledBorder("Search Results"));
        labelResults = new JLabel("No results found!!");
        tableModel = new DefaultTableModel(tableData, columnNames);
        tableResults = new JTable(tableModel);
        setLayout(new BorderLayout());
        tableScroll = new JScrollPane(tableResults);
        add(tableScroll, BorderLayout.CENTER);
        setVisible(true);
    }

    public DefaultTableModel getTableModel()
    {
        return tableModel;
    }
}
