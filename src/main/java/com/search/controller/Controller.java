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
import com.search.controller.Criteria;

import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.util.List;

public class Controller
{
    private MainWindow searchC;
    private Search search;
    private File FileResult;
    private Criteria fCriteria;

    /*
     * Method:Controller
     * Description: This method is the constructor from the instances of View and Model classes. Also set the action
     * after press the button Search
     */
    public Controller()
    {
        searchC = new MainWindow();
        search = new Search();
        searchC.getPanel().getButtonSearch().addActionListener(e -> getCriteriaView());
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
        fCriteria=new Criteria();
        fCriteria.setPath(searchC.getPanel().getPath());
        fCriteria.setFileName(searchC.getPanel().getFileName());

        List<FileResult> filesR=search.initSearch(fCriteria.getPath(),fCriteria.getFileName());

        searchC.getTableModel().setRowCount(0);


        for(FileResult fresult: filesR)
        {

            String spath = fresult.getPath();
            String sfilename = fresult.getFileName();
            String sextension = "date";
            String sdate = "dddd";
            String[] dataresult= {spath,sfilename,sextension,sdate};
            this.searchC.getTableModel().addRow(dataresult);
        }
        filesR.clear();
    }
}

