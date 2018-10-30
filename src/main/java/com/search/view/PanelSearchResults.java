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

public class PanelSearchResults extends JPanel
{
    private JLabel labelResults;
    private DefaultTableModel tableModel;
    private JTable tableResults;

    private JScrollPane tableScroll;
    private Object columnNames [] = {"Location", "File Name","Extension", "Modified Date"};
    private Object tableData[][]= {};


    public PanelSearchResults()
    {
        settings();
        init();
    }
    public void settings()
    {
        setBorder(BorderFactory.createTitledBorder("Search Results"));
        labelResults = new JLabel("No results found!!");
        tableModel = new DefaultTableModel(tableData, columnNames);
       // DefaultTableModel tableModel = (DefaultTableModel) tableResults.getModel();
        tableResults = new JTable(tableModel);
        setLayout(new BorderLayout());
        tableScroll = new JScrollPane(tableResults);
        add(tableScroll, BorderLayout.CENTER);
        //add(labelResults);
        setVisible(true);

    }

    public void init()
    {

    }
    public DefaultTableModel getTableModel()
    {
        return tableModel;
    }
}
