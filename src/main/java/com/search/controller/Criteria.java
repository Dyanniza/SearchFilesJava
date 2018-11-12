/*
 * Copyright (c) 2018 Jalasoft.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * This software is the confidential and proprietary information of  Jalasoft, ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into  with Jalasoft.
 */

package com.search.controller;

import java.util.Date;

public class Criteria
{
    private String path;
    private String fileName;
    private String ext;
    private long moddate;
    private long accdate;
    private long credate;
    private long fsize;
    private int foperator;
    private boolean fhidden;
    private boolean freadonly;
    private boolean fonlydir;

    public void setPath(String path)
    {
        this.path = path;
    }

    public String getPath()
    {
        return this.path;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public String getFileName()
    {
        return this.fileName;
    }

    public void setExt(String ext)
    {
        this.ext = ext;
    }

    public String getExt()
    {
        return this.ext;
    }

    public void setModDate(long datev)
    {
        this.moddate = datev;
    }

    public long getModDate()
    {
        return this.moddate;
    }

    public void setAccDate(long datea)
    {
        this.accdate = datea;
    }

    public long getAccDate()
    {
        return this.accdate;
    }

    public void setCreDate(long datec)
    {
        this.credate = datec;
    }

    public long getCreDate()
    {
        return this.credate;
    }

    public void setFsize(long size)
    {
        this.fsize = size;
    }

    public long getFsize()
    {
        return this.fsize;
    }

    public void setFoperator(int operator)
    {
        this.foperator = operator;
    }

    public int getFoperator()
    {
        return this.foperator;
    }

    public void setFHidden(boolean hidden)
    {
        this.fhidden = hidden;
    }

    public boolean getFHidden()
    {
        return this.fhidden;
    }

    public void setFReadOnly(boolean readOnly)
    {
        this.freadonly = readOnly;
    }

    public boolean getFReadOnly()
    {
        return this.freadonly;
    }

    public void setFIsDirectory(boolean isDirectory)
    {
        this.fonlydir = isDirectory;
    }

    public boolean getFIsDirectory()
    {
        return this.fonlydir;
    }

}
