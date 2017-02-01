/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ENTIDAD;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author LORENA
 */
public class fecha {
    public static synchronized java.util.Date stringSpanishtoDate(String fecha) {
	//amb format "07/06/2013"
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			 
		try {
	 
			Date date = formatter.parse(fecha);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
    }
    public static synchronized java.util.Date stringAmericantoDate(String fecha) {
            //amb format "2013/06/14"
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

                    try {

                            Date date = formatter.parse(fecha);
                            return date;
                    } catch (ParseException e) {
                            e.printStackTrace();
                            return null;
                    }
    }
    public static synchronized String DatetoAmericanString(Date data) {
            //retorna amb format "2013/06/14"
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

            String date = formatter.format(data);
        return date;
    }
    public static synchronized String DatetoSpanishString(Date data) {
            //retorna amb format "2013/06/14"
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

            String date = formatter.format(data);
        return date;
    }
}
