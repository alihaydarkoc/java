/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author alihaydar
 */
/**
     *  Hide a column from view in the table.
     *
     *  @param  table        the table from which the column is removed
     *  @param  columnName   the column name of the column to be removed
     */
public class Formatter {
    
    public static String dateFormat(Date dateType){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String date = sdf.format(dateType); 
        return date;
    }
    public static Date dateFormat(String dateType){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        try {
           Date date = sdf.parse(dateType); 
           return date;
        } catch (ParseException e) {
        }
         
        return null;
    }
}
