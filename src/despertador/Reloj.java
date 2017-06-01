/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package despertador;

import java.time.LocalTime;

/**
 *user menu
 * @author acomesanavila
 */
public class Reloj {

   static LocalTime hora, alarma;

    public Reloj() {
        hora = LocalTime.now();
        alarma = LocalTime.now();
        alarma = alarma.plusMinutes(1);
    }
   
    /**
     * Configuración
     */
    public void actualizar(){
        hora = LocalTime.now().plusHours(Botonera.masH).plusMinutes(Botonera.masM);
    }
    
    public void activarDesactivar(){
        if(Botonera.alarmActive==false){
            Botonera.alarmON();
        }else{
            Botonera.alarmOFF();
        }
    }

}
