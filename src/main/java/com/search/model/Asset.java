package com.search.model;

public class Asset
{
    private String path;
    private String fileName;
    private String ext;
    private long mDate;

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
}
