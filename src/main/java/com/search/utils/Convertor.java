/*
 * Copyright (c) 2018 Jalasoft.
 *  2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 *  All rights reserved.
 *  This software is the confidential and proprietary information of  Jalasoft, ("Confidential Information").
 *  You shall not disclose such Confidential Information and shall use it only in accordance with the terms of the license agreement you entered into  with Jalasoft.
 *
 */

package com.search.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Convertor
{
    /*
     * Method:converToStringWithFormat
     * Description: This method will return an String given a long format. Additionally the date is formatted with
     * "yyyy-MM-dd HH:mm:ss" format
     */

    public String converToStringWithFormat(long datef)
    {
        Date d = new Date(datef);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String sdate=df.format(d);
        return sdate;
    }

    public String converDateToStringWithFormat(Date fdate)
    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String newDate=df.format(fdate.toString());
        return newDate;
    }
    /*
     * Method:converToBytes
     * Description: This method will return a double value that represent the bytes of the size passed
     */

    public long converToBytes(int sizef,String oper)
    {
        long res=0;
        if(oper=="KB")
        {
            res=sizef*1024;

        }else
        {
            if(oper=="MB")
            {
                res=sizef*(1024*1024);
            }else
            {
                if(oper=="GB")
                {
                    res=sizef*(1024*1024*1024);
                }

            }
        }
        return res;
    }
    /*
     * Method:converBooleanToString
     * Description: This method will return an String that represent the value given by the view
     */
    public String converBooleanToString(Boolean boolValue)
    {
        String res;
        if(boolValue)
        {
            res="Yes";
        }else
        {
            res="No";
        }

        return res;
    }
}
