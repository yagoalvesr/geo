package com.geo.Util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DataUtil {

    public static String recuperarDiaAtual() {

        SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");

        Calendar gc = Calendar.getInstance();

        gc.add((GregorianCalendar.DAY_OF_MONTH), -1);
        String diaAtual = df.format(gc.getTime());

        return diaAtual;
    }
}
