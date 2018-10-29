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
import com.search.model.Asset;
import com.search.view.MainWindow;
import com.search.controller.Criteria;

import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.util.List;

public class Controller
{
    private MainWindow searchC;
    private Search search;
    //private Asset asset;
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
     * criteria on an Object and pass them to the model.
     * On Model will capture the results checking if is an instance of FileResult and pass them to the view
     * Additionally will also clean the table before showing the results or perform a new search
     */
    private void getCriteriaView()
    {
        fCriteria=new Criteria();
        fCriteria.setPath(searchC.getPanel().getPath());
        fCriteria.setFileName(searchC.getPanel().getFileName());
        fCriteria.setExt(searchC.getPanel().getExtension());
        fCriteria.setModDate(searchC.getPanel().getModifiedDate());

        System.out.println(fCriteria.getModDate());

        //List<Asset> filesR=search.initSearch(fCriteria.getPath(),fCriteria.getFileName(),fCriteria.getExt());
        List<Asset> filesR=search.initSearch(fCriteria);
        
        searchC.getTableModel().setRowCount(0);


        for(Asset fresult: filesR)
        {
            //if(filesR instanceof FileResult)
            //{
                String spath = fresult.getPath();
                String sfilename = fresult.getFileName();
                String sextension = "date";
                String sdate = "dddd";
                String[] dataresult= {spath,sfilename,sextension,sdate};
                this.searchC.getTableModel().addRow(dataresult);
            //}

        }
        filesR.clear();
    }
}

