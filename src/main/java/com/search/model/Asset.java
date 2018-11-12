package com.search.model;

import java.nio.file.attribute.FileTime;
import java.util.Date;

public class Asset
{
    private String path;
    private String fileName;
    private String ext;
    private long mDate;
    private long cDate;
    private long aDate;
    private boolean hidden;
    private boolean readOnly;
    private long size;

    public Asset()
    {
    }

    /**
     * Methods: Get and  Set methods for all attributes of Asset class
     * @param  path, fileName, ext, mDate(modification Date), cDate(Creation Date), aDate(Last access Date), hidden
     *              readOnly, size(in bytes)
     */

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

    public long getModifiedDate()
    {
        return this.mDate;
    }

    public void setModifiedDate(long mDate)
    {
        this.mDate = mDate;
    }

    public long getCreatedDate()
    {
        return this.cDate;
    }

    public void setCreatedDate(long cDate)
    {
        this.cDate = cDate;
    }

    public long getAccessDate()
    {
        return this.aDate;
    }

    public void setAccessDate(long aDate)
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
