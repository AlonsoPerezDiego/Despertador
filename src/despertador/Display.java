/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package despertador;

import java.time.LocalTime;

/**
 * 
 * @author acomesanavila
 */
public class Display {

    static boolean ledclock, ledalarm, ledset;

    /**
     * show the hour
     */
    public static void showHr(int hora, int minutos) {
        System.out.println(hora+":"+minutos);
    }

    /**
     * show the alarm hour
     */
    public static void showAlarm(int hora, int minutos) {
        System.out.println(hora+":"+minutos);
    }

    /**
     * put on/off the clock leds
     *
     * @param ledclock
     * @param ledAlarm
     * @param ledset
     */
    public static void showLED(boolean ledclock, boolean ledAlarm, boolean ledset) {
        Display.ledclock = ledclock;
        Display.ledalarm = ledAlarm;
        Display.ledset = ledset;
    }

}
