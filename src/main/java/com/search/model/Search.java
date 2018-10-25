/*
 * Copyright (c) 2018 Jalasoft.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * This software is the confidential and proprietary information of  Jalasoft, ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into  with Jalasoft.
 */package com.search.model;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Search
{
    private List<FileResult> result = new ArrayList();

    public Search()
    {
    }
    // This method searchs by path and filename, returns a list of FileResult objects



    public List<FileResult> initSearch(String path, String filename)
    {
        File fileP = new File(path);
        File[] fileList= fileP.listFiles();
        String fileN;

        for(File f : fileList)
        {
            // If  f is directory the method is called again with the path and the filename
            if (f.isDirectory())
            {
                initSearch(f.getPath(), filename) ;
            }
            else
            {
                fileN = f.getName();
                // If filename is empty or filename found is equal to the parameter given the path and file name is added to the result
                if (filename.isEmpty() || fileN.equals(filename))
                {
                    FileResult fr = new FileResult();
                    fr.setPath(f.getPath());
                    fr.setFileName(f.getName());
                    result.add(fr);
                }

            }
        }

        return result;
    }
}
