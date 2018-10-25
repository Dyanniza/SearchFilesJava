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

import java.io.File;
import java.util.List;

public class Controller
{
    // private PanelSearchParameters view;
    private MainWindow SearchC;
    private Search search;
    private File FileResult;

    public Controller()
    {
        SearchC = new MainWindow();
        search= new Search();
        SearchC.getPanel().getButtonSearch().addActionListener(e -> getCriteriaView() );   // getCriteriaView is the name of the button

       /*SearchC.getPanel().getButtonSearch().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(view,
                        "Search Results:\n" + " No files found");
                System.out.println("Action from Search button" );
            }
        });*/

    }

    //This is what the View will return when the button is pressed
    private void getCriteriaView()
    {

        //obtaining what the view is passing for the parameters
        String path = SearchC.getPanel().getPath();
        String fileName =SearchC.getPanel().getFileName(); //filename

        // String ext =view.getPanel().getExt();//extension
        // Date dateA = view.getPanel().getDateA();//creationdate

        //This is the object that will pass to the Model the data
        //List<FileResult> filesR=search.initSearch(path,fileName);
        List<com.search.model.FileResult> filesR=search.initSearch(path,fileName);
        //List<FileResult> filesR=search.initSearch(path,fileName, ext, dateA); //this is what the model is returned// sobrecargar el constructor

        //this is what the controller made for iterate all what the model is passed and set the result table

        //add un clean default model
       /* DefaultTableModel model = (DefaultTableModel) table.getModel();
        while( model.getRowCount() > 0 )
        {
            model.removeRow(0);
        }
*/
        //this cycle will go throw the objects returned by the model
        // FileResult fileR= new FileResult();

        for(FileResult f: filesR)
        {

            //this.SearchC.getTableModel().addRow(data);
            String p = f.getPath();
            String fn = f.getFileName();
            String t = "date";
            String g = "dddd";
            String[] data= {p,fn,t,g};
            this.SearchC.getTableModel().addRow(data);
            //this.SearchC.getPanel().getModel().addRow("{"+f.getPath()+","+f.getFileName()+"}"); // this is for return the added rows in the table the values wll return.
            System.out.println("path:"+ f.getPath()+"; filename="+ f.getFileName());
        }

    }

}
