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
import java.util.Date;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.Files;
import java.nio.file.attribute.FileTime;
import com.search.controller.Criteria;
import com.search.model.Asset;


public class Search
{
    private List<Asset> result = new ArrayList();

    public Search()
    {
    }
    // This method searches by path and filename, returns a list of FileResult objects
    public List<Asset> initSearch(Criteria criteria) {
        File fileP = new File(criteria.getPath());
        File[] fileList = fileP.listFiles();
        String fileN;
        String onlyFileName;
        String onlyFileExtension;
        int modDate;

        for (File f : fileList) {
            // If f is directory the method is called again with the path and the filename
            if (f.isDirectory()) {
                criteria.setPath(f.getPath());
               // initSearch(f.getPath(), criteria.getFileName, criteria.getExt);
                initSearch(criteria);
            } else {
                fileN = f.getName();
                onlyFileName=fileN.substring(0,fileN.lastIndexOf('.'));
                onlyFileExtension=fileN.substring(fileN.lastIndexOf('.'),fileN.length());
                // If filename is empty or filename found is equal to the parameter given the
                // path and file name is added to the result

                if (fileN.endsWith(criteria.getExt()) || criteria.getExt().isEmpty())
                {
                    if (criteria.getFileName().isEmpty() || onlyFileName.contains(criteria.getFileName()))
                    {
                        modDate= Long.compare(f.lastModified(),criteria.getModDate());
                        if ((criteria.getModDate()==0) || (modDate==0))
                        {
                           // BasicFileAttributes attrs = Files.readAttributes(f.toPath(), BasicFileAttributes.class);
                           // FileTime creDate = attrs.creationTime();
                           // if ((criteria.getCreDate().toString()).isEmpty() || creDate.compareTo(criteria.getCreDate()))
                           // {
                            //    FileTime accDate = attrs.lastAccessTime();
                              //  if ((criteria.getAccDate().toString()).isEmpty() || accDate.compareTo(criteria.getAccDate()))
                               // {
                                    Asset fr = new Asset();
                                    fr.setPath(f.getPath());
                                    fr.setFileName(onlyFileName);
                                    fr.setExt(onlyFileExtension);
                                    fr.setModifiedDate(f.lastModified());
                                  //  fr.setCreatedDate(creDate);
                                   // fr.setAccessDate(accDate);
                                    fr.setHidden(f.isHidden());
                                    fr.setReadOnly(!f.canWrite());
                            if (criteria.getFHidden() == false && criteria.getFReadOnly() == false) {
                                result.add(fr);
                            } else {
                                if ((criteria.getFHidden() == true) && (criteria.getFReadOnly() == false))
                                    if (f.isHidden())
                                        result.add(fr);
                                if ((criteria.getFHidden() == false) && (criteria.getFReadOnly() == true))
                                    if (!f.canWrite())
                                        result.add(fr);
                                if ((criteria.getFHidden() == true) && (criteria.getFReadOnly() == true))
                                    if (!f.canWrite() && f.isHidden())
                                        result.add(fr);

                            }


                        //  }
                           // }
                        }
                    }
                }
            }
        }

        return result;
    }

}
