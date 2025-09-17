package utilitaire;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils{
    public static LocalDateTime obtenirDateActuelle(){
    return LocalDateTime.now();
    }

    public static String formaterDate(LocalDateTime date){
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        
    }
}