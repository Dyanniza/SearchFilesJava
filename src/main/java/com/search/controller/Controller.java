/*
 * Copyright (c) 2018 Jalasoft.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * This software is the confidential and proprietary information of  Jalasoft, ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into  with Jalasoft.
 */
package com.search.controller;

import com.search.model.Search;
import com.search.model.Asset;
import com.search.view.MainWindow;
import com.search.utils.Convertor;
import javax.swing.JOptionPane;

import com.search.view.PanelSearchParameters;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

public class Controller
{
    private MainWindow searchC;
    private Search search;
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
        Convertor confile=new Convertor();
        fCriteria=new Criteria();
        fCriteria.setPath(searchC.getPanel().getPath());
        fCriteria.setFileName(searchC.getPanel().getFileName());
        fCriteria.setExt(searchC.getPanel().getExtension());
        //fCriteria.setModDate(searchC.getPanel().getModifiedDate());
        //fCriteria.setCreDate(searchC.getPanel().getCreatedDate());
        //fCriteria.setAccDate(searchC.getPanel().getAccessDate());
       // fCriteria.setFsize(confile.converToBytes(searchC.getPanel().getFileSize(),"MB"));
        fCriteria.setFHidden(searchC.getPanel().getIfHidden());
        fCriteria.setFReadOnly(searchC.getPanel().getIfReadOnly());
       // fCriteria.setFIsDirectory(searchC.getPanel().getIfOnlyDir());

        List<Asset> filesR=search.initSearch(fCriteria);
        
        searchC.getTableModel().setRowCount(0);

        if(filesR.isEmpty()||filesR==null||filesR.size() == 0 )
        {
            JOptionPane.showMessageDialog(null,"Search Results:\n" + " No files found");

        }else
        {
            for(Asset fresult: filesR)
            {
                String sPath = fresult.getPath();
                String sFilename = fresult.getFileName();
                String sExtension = fresult.getExt();
                String mDate=confile.converToStringWithFormat(fresult.getModifiedDate());
                String sHidden=confile.converBooleanToString(fresult.getHidden());
                String sReadonly=confile.converBooleanToString(fresult.getReadOnly());


                String[] dataresult= {sPath,sFilename,sExtension,mDate,sHidden,sReadonly};
                this.searchC.getTableModel().addRow(dataresult);
            }

        }

        filesR.clear();
    }
}

