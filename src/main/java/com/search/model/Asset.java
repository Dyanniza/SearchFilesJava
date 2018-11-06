package com.search.model;

import java.nio.file.attribute.FileTime;
import java.util.Date;

public class Asset
{
    private String path;
    private String fileName;
    private String ext;
    private String mDate;
    private String cDate;
    private String aDate;
    private boolean hidden;
    private boolean readOnly;
    private long size;

    public Asset()
    {
    }

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

    public String getModifiedDate()
    {
        return this.mDate;
    }

    public void setModifiedDate(String mDate)
    {
        this.mDate = mDate;
    }

    public String getCreatedDate()
    {
        return this.cDate;
    }

    public void setCreatedDate(String cDate)
    {
        this.cDate = cDate;
    }

    public String getAccessDate()
    {
        return this.aDate;
    }

    public void setAccessDate(String aDate)
    {
        this.aDate = aDate;
    }

    public boolean getHidden()
    {
        return this.hidden;
    }

    public void setHidden(Boolean hidden)
    {
        this.hidden = hidden;
    }

    public boolean getReadOnly()
    {
        return this.readOnly;
    }

    public void setReadOnly(Boolean readOnly)
    {
        this.readOnly = readOnly;
    }

    public long getSize()
    {
        return this.size;
    }

    public void setSize(long size)
    {
        this.size = size;
    }

}
