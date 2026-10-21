package tema1;

import java.io.File;
import java.io.IOException;

public class Hipodromo {
    static void main(String[] args) throws IOException {
        try {
            //Buscamos la carpeta de clases apuntandola a build y
            File clases = new File("build/classes/java/main");

            //Guardamos el ejecutable java en la variable despues de obtenerla del metodo.
            String ejecutarJava = obtenerEjecutableJava();

            //Datos de las mascotas en array.
            String[] nombres = {"Pepe", "Ramón", "Osama"};
            int[] pasos = {9, 12, 6};

            //Array para almacenar los procesos.
            Process[] procesos = new Process[3];

            //Bucle para que los procesos vayan a la vez y no 1 po 1.
            for (int i = 0; i < 3; i++){
                ProcessBuilder processBuilder = new ProcessBuilder(
                        ejecutarJava,
                        "-cp",
                        clases.getPath(),
                        "tema1.Mascota",
                        nombres[i],
                        String.valueOf(pasos[i])
                );

                //COnectamos la consola de Mascotas con Hipodromo.
                //Se lanza la ejecucion de Mascotas.
                processBuilder.inheritIO();
                procesos[i] = processBuilder.start();
            }

            //Bucle para cuando una mascota termine, espere al resto.
            for (int i = 0; i < 3; i++){
                int codigoSalida = procesos[i].waitFor();
                System.out.println("[LLEGADA] Mascota " + nombres[i] + " finalizada con código de salida: " + codigoSalida);
            }
        } catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }

    static String obtenerEjecutableJava(){
        boolean esWindows = System.getProperty("os.name").toLowerCase().contains("windows");
        String nombre = esWindows ? "java.exe" : "java";
        return new File(new File(System.getProperty("java.home"), "bin"), nombre).getPath();
    }
}
