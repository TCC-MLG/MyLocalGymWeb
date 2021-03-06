package br.com.app.gym.web.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Luciano
 */
public class DateUtil {

    public static LocalDate convertDateToLocalDate(Date date) {

        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();

    }

    public static LocalDate convertStringToLocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate;
    }

    public static Date convertStringToDate(String periodo) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date data = null;
        try {
            data = new Date(format.parse(periodo).getTime());
        } catch (ParseException ex) {
        }
        return data;
    }

}
