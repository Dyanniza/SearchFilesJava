/*
 * Copyright (c) 2018 Jalasoft.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * This software is the confidential and proprietary information of  Jalasoft, ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into  with Jalasoft.
 */
package com.search.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;


public class MainWindow extends JFrame
{
    private PanelSearchParameters panelSearch;
    private PanelSearchResults panelResults;

    public MainWindow()
    {
        settings();
        init();
    }

    public void settings()
    {
        setIconImage((new ImageIcon("resources/Images/filefind.png") ).getImage());
        setTitle("SearchC  - File searcher");
        setSize(1000,800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void init()
    {
        panelSearch = new PanelSearchParameters();
        panelResults = new PanelSearchResults();
        getContentPane().setLayout(new GridLayout(1,2));
        getContentPane().add(panelSearch);
        getContentPane().add(panelResults);
        setVisible(true);
    }

    public PanelSearchParameters getPanel()
    {
        return panelSearch;
    }
    public PanelSearchResults getModel()
    {
        return panelResults;
    }

    public DefaultTableModel getTableModel(){ return panelResults.getTableModel();}

}
