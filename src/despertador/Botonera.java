/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package despertador;

import java.time.LocalTime;

/**
 * interfaz methods
 *
 * @author acomesanavila
 */
public class Botonera {

    static boolean alarmActive, setHR, setAlarm;
    static int masH = 0, masM = 0,masAH = 0, masAM = 0;

    /**
     * set the alarm ON
     */
    public static void alarmON() {
        alarmActive = true;
        Altavoz.ringON = true;
        Display.showLED(false, true, false);
    }

    /**
     * set the alarm OFF
     */
    public static void alarmOFF() {
        alarmActive = false;
        Display.showLED(false, false, false);
    }

    /**
     * config the clock hour
     */
    public static void configHr() {
        Display.showLED(true, false, true);
        Display.showAlarm(Reloj.hora.getHour(),Reloj.hora.getMinute());

    }

    /**
     * config the alarm hour
     */
    public static void configAlarm() {
        Display.showLED(false, true, true);
        Display.showHr(Reloj.hora.getHour(),Reloj.hora.getMinute(), Reloj.hora.getSecond());
    }

    /**
     * increase the hour
     */
    public static void plusHr() {
        if(Display.ledclock==true){
            masH++;
        }else if(Display.ledalarm==true){
            masAH++;
        }
        
        Display.showHr(Reloj.hora.getHour(),Reloj.hora.getMinute(), Reloj.hora.getSecond());
    }

    /**
     * increase the minutes
     */
    public static void plusMin() {
        if(Display.ledclock==true ){
            masM++;
        }else if(Display.ledalarm==true){
            masAM++;
        }
        Display.showHr(Reloj.hora.getHour(),Reloj.hora.getMinute(), Reloj.hora.getSecond());
    }

    /**
     * stop the alarm melody
     */
    public static void stopAlarm() {
        if (Altavoz.ringON == true) {
            Altavoz.ringON = false;
        }
    }
}
