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
import java.io.IOException;

public class Search {
    private List<Asset> result = new ArrayList();

    public Search() {
    }

    /**
     * @param criteria
     * @return
     */
    public List<Asset> initSearch(Criteria criteria) {
        File fileP = new File(criteria.getPath());
        File[] fileList = fileP.listFiles();
        String fileN;
        String onlyFileName;
        String onlyFileExtension;
        int modificationDate;
        int creationDate;
        int accessDate;

        for (File f : fileList)
        {
            if (criteria.getFIsDirectory() == false)
            {
                if (f.isDirectory())
                {
                    criteria.setPath(f.getPath());
                    initSearch(criteria);
                } else
                    {
                      try
                      {
                        fileN = f.getName();
                        onlyFileName = fileN.substring(0, fileN.lastIndexOf('.'));
                        onlyFileExtension = fileN.substring(fileN.lastIndexOf('.'), fileN.length());
                        if (fileN.endsWith(criteria.getExt()) || criteria.getExt().isEmpty())
                        {
                            if (criteria.getFileName().isEmpty() || onlyFileName.contains(criteria.getFileName()))
                            {
                                BasicFileAttributes attrs = Files.readAttributes(f.toPath(), BasicFileAttributes.class);
                                long modDate = attrs.lastModifiedTime().toMillis();
                                modificationDate = Long.compare(modDate, criteria.getModDate());
                                if ((Long.valueOf(criteria.getModDate()) == 0) || (modificationDate <= 0))
                                {
                                    long creDate = attrs.creationTime().toMillis();
                                    creationDate = Long.compare(creDate, criteria.getCreDate());
                                    if ((Long.valueOf(criteria.getCreDate()) == 0) || (creationDate <= 0))
                                    {
                                        long accDate = attrs.lastAccessTime().toMillis();
                                        accessDate = Long.compare(accDate, criteria.getAccDate());
                                        if ((Long.valueOf(criteria.getCreDate()) == 0) || (accessDate <= 0))
                                        {
                                            Asset fr = new Asset();
                                            fr.setPath(f.getPath());
                                            fr.setFileName(onlyFileName);
                                            fr.setExt(onlyFileExtension);
                                            fr.setSize(f.length());
                                            fr.setModifiedDate(modDate);
                                            fr.setCreatedDate(creDate);
                                            fr.setAccessDate(accDate);
                                            fr.setHidden(f.isHidden());
                                            fr.setReadOnly(!f.canWrite());
                                            if (criteria.getFHidden() == false && criteria.getFReadOnly() == false)
                                             {
                                               if (criteria.getFsize()!=0)
                                                 {
                                                   if (criteria.getFoperator() == 0 && (criteria.getFsize() == f.length()))
                                                        result.add(fr);
                                                   else{
                                                       if (criteria.getFoperator() == 1 && (criteria.getFsize() < f.length()))
                                                           result.add(fr);
                                                       else if (criteria.getFoperator() == 2 && (criteria.getFsize() > f.length()))
                                                           result.add(fr);
                                                   }
                                                 } else
                                                 result.add(fr);
                                             } else
                                                {
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
                                        }
                                    }
                                }
                            }
                        }
                      } catch (IOException e)
                       {
                        e.printStackTrace();
                       }
                    }
            } else
                {
                  if (f.isDirectory())
                  {
                      criteria.setPath(f.getPath());
                      initSearch(criteria);
                      try
                      {
                          BasicFileAttributes attrs = Files.readAttributes(f.toPath(), BasicFileAttributes.class);
                          long modDate = attrs.lastModifiedTime().toMillis();
                          long creDate = attrs.creationTime().toMillis();
                          long accDate = attrs.lastAccessTime().toMillis();
                          Asset fr = new Asset();
                          fr.setPath(f.getPath());
                          fr.setFileName(f.getName());
                          fr.setSize(f.length());
                          fr.setModifiedDate(modDate);
                          fr.setCreatedDate(creDate);
                          fr.setAccessDate(accDate);
                          fr.setHidden(f.isHidden());
                          fr.setReadOnly(!f.canWrite());
                          result.add(fr);
                      } catch (IOException e)
                         {
                           e.printStackTrace();
                         }
                  }
                }
        }

        return result;
    }
}
