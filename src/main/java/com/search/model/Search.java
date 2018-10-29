/*
 * Copyright (c) 2018 Jalasoft.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * This software is the confidential and proprietary information of  Jalasoft, ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into  with Jalasoft.
 */
package com.search.model;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Search
{
    private List<Asset> result = new ArrayList();

    public Search()
    {
    }
    // This method searches by path and filename, returns a list of FileResult objects
    public List<Asset> initSearch(String path, String filename, String ext) {
        File fileP = new File(path);
        File[] fileList = fileP.listFiles();
        String fileN;
        String onlyFileName;

        for (File f : fileList) {
            // If f is directory the method is called again with the path and the filename
            if (f.isDirectory()) {
                initSearch(f.getPath(), filename, ext);
            } else {
                fileN = f.getName();
                onlyFileName=fileN.substring(0,fileN.lastIndexOf('.'));
                // If filename is empty or filename found is equal to the parameter given the
                // path and file name is added to the result
                if (fileN.endsWith(ext) || ext.isEmpty())
                {
                    if (filename.isEmpty() || onlyFileName.equals(filename))
                    {
                        Asset fr = new Asset();
                        fr.setPath(f.getPath());
                        fr.setFileName(f.getName());
                        result.add(fr);
                    }
                }
            }
        }

        return result;
    }
}
