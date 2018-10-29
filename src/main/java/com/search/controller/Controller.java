/*
 * Copyright (c) 2018 Jalasoft.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * This software is the confidential and proprietary information of  Jalasoft, ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into  with Jalasoft.
 */
package com.search.controller;

import com.search.model.FileResult;
import com.search.model.Search;
import com.search.view.MainWindow;
import main.java.com.search.controller.Criteria;

import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.util.List;

public class Controller
{
    private MainWindow SearchC;
    private Search search;
    private File FileResult;
    private Criteria FCriteria;

    /*
     * Method:Controller
     * Description: This method is the constructor from the instances of View and Model classes. Also set the action
     * after press the button Search
     */
    public Controller()
    {
        SearchC = new MainWindow();
        search = new Search();
        SearchC.getPanel().getButtonSearch().addActionListener(e -> getCriteriaView());
    }


    /*
     * Method:getCriteriaView
     * Description: This method will return the actions from the view and the model packages. On view will capture the
     * criteria and pass them to the mode.
     * On Model will capture the results and pass them to the view
     * Additionally will also clean the table before showing the results or perform a new search
     */
    private void getCriteriaView()
    {
        FCriteria=new Criteria();
        FCriteria.setPath(SearchC.getPanel().getPath());
        FCriteria.setFileName(SearchC.getPanel().getFileName());

        List<FileResult> filesR=search.initSearch(FCriteria.getPath(),FCriteria.getFileName());

        SearchC.getTableModel().setRowCount(0);

        for(FileResult fresult: filesR)
        {
            String p = fresult.getPath();
            String fn = fresult.getFileName();
            String t = "date";
            String g = "dddd";
            String[] dataresult= {p,fn,t,g};
            this.SearchC.getTableModel().addRow(dataresult);
        }
    }
}

