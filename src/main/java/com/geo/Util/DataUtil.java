package com.geo.Util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DataUtil {

    public static String recuperarDiaAtual() {

//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.DATE, 1);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy", new Locale("pt", "Br"));
        String diaAtual = sdf.format(date);

        return diaAtual;
    }
}
