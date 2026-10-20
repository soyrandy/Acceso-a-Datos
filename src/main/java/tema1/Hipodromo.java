package tema1;

import java.io.File;
import java.io.IOException;

public class Hipodromo {
    static void main() throws IOException {
        try {
            File clases = new File("build/classes/java/main").getCanonicalFile();
            String ejecutableJava = obtenerEjecutableJava();

            String[] nombres = {"Pepe", "Ramón", "Osama"};
            int[] pasos = {5, 4, 3};

            Process[] procesos = new Process[3];

            for (int i = 0; i < 3; i++){
                ProcessBuilder processBuilder = new ProcessBuilder(
                        ejecutableJava,
                        "-cp",
                        clases.getPath(),
                        "tema1.Mascota",
                        nombres[i],
                        String.valueOf(pasos[i])
                );

                processBuilder.inheritIO();
                procesos[i] = processBuilder.start();
            }

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
