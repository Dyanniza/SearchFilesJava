package com.search.model;

import java.nio.file.attribute.FileTime;
import java.util.Date;

public class Asset
{
    private String path;
    private String fileName;
    private String ext;
    private long mDate;
    private FileTime cDate;
    private FileTime aDate;
    private boolean hidden;
    private boolean readOnly;

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

    public long getModifiedDate()
    {
        return this.mDate;
    }

    public void setModifiedDate(long mDate)
    {
        this.mDate = mDate;
    }

    public FileTime getCreatedDate()
    {
        return this.cDate;
    }

    public void setCreatedDate(FileTime cDate)
    {
        this.cDate = cDate;
    }

    public FileTime getAccessDate()
    {
        return this.aDate;
    }

    public void setAccessDate(FileTime aDate)
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

}
