/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author alihaydar
 */
public class HandleMessage 
{
    public static void ShowCustomMessage (boolean   isSucces,String subject,String message)
    {
        
          if (isSucces)
            {
                if (message=="" || message==null)
                    message="İşlem Başarılı";
                
                     JOptionPane.showMessageDialog(new JFrame(),message , subject,
        JOptionPane.INFORMATION_MESSAGE);
          
            }
                 
            else 
            {
             if (message=="" || message==null)
                    message="İşlem Başarısız";
             JOptionPane.showMessageDialog(new JFrame(), message, "Veri Ekleme İşlemi",
        JOptionPane.ERROR_MESSAGE);
                  
            }
    }
}
