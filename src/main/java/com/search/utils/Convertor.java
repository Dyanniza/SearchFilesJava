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

    /*
     * Method:converDateToLong
     * Description: This method will return a long given a Date format.
     */

    public long converDateToLong (Date datef)
    {
        if(datef!=null)
        {
            long longDate=datef.getTime();
            return longDate;
        }else
        {
            return 0;
        }


    }
    /*
     * Method:converToBytes
     * Description: This method will return a long value that represent the bytes of the size passed on KB
     */

    public long converToBytes(int sizef)
    {
        if(sizef!=0)
        {
            long res=sizef;
            return res;
        }else
        {
            return 0;
        }
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
