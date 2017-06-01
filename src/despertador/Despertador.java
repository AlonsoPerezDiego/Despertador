/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package despertador;

import java.time.LocalTime;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author acomesanavila
 */
public class Despertador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Timer timer = new Timer();
        Reloj obj = new Reloj();
        Boolean quedarse = true;
        Scanner input = new Scanner(System.in);
        TimerTask task = new TimerTask() {
            // tarea
            @Override
            public void run() {
                // si los minutos actuales son iguales a la alarma imprimo
                // TODO: comparar tambien la hora
                if (Reloj.alarma.getMinute() == LocalTime.now().getMinute() && Altavoz.ringON == true && Botonera.alarmActive == true) {
                    Altavoz.playSound();
                    // si el tiempo actual es diferente que la alarma imprimo la hora
                } else {
                    obj.actualizar();
                    Display.showHr(Reloj.hora.getHour(), Reloj.hora.getMinute(), Reloj.hora.getSecond());
                }
            }
        };
        // Empezamos dentro de 10ms y luego lanzamos la tarea cada 10000ms
        timer.schedule(task, 10, 1000);
        do {
            System.out.println("\n\nMenu");
            System.out.println("----------------");
            System.out.println("1 - Activar/Desactivar alarma");
            System.out.println("2 - Parar alarma.");
            System.out.println("3 - Configurar hora");
            System.out.println("Option:");
            int option = Integer.parseInt(input.next());
            switch (option) {
                case 1:
                    obj.activarDesactivar();
                    break;
                case 2:
                    Botonera.stopAlarm();
                    break;
                case 3:
                    Botonera.configHr();
                     {
                        boolean listo;
                        do {
                            listo = true;
                            System.out.println("1: Más hora.");
                            System.out.println("2: Mas minuto.");
                            System.out.println("3: Listo.");
                            int opcion = Integer.parseInt(input.next());
                            switch(opcion){
                                case 1: Botonera.plusHr();
                                        break;
                                case 2: Botonera.plusMin();
                                        break;
                                case 3: listo = false;
                            }
                        } while (listo);
                    }
                    break;
                case 4:
                    Botonera.configAlarm();
                     {
                        boolean listo;
                        do {
                            listo = true;
                            System.out.println("1: Más hora.");
                            System.out.println("2: Mas minuto.");
                            System.out.println("3: Listo.");
                            int opcion = Integer.parseInt(input.next());
                            switch(opcion){
                                case 1: Botonera.plusHr();
                                        break;
                                case 2: Botonera.plusMin();
                                        break;
                                case 3: listo = false;
                            }
                        } while (listo);
                    }
                    break;
                case 5:
                    quedarse = false;
            }
        } while (quedarse); // Display the menu until the user closes the 
        // para todas las tareas del timer
        timer.cancel();
    }

}
