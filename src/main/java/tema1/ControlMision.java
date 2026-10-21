package tema1;

import java.io.File;
import java.io.IOException;

public class ControlMision {
    static void main() {
        try {
            //Buscamos la carpeta de clases apuntandola a build y
            File clases = new File("build/classes/java/main").getCanonicalFile();

            //Guardamos el ejecutable java en la variable despues de obtenerla del metodo.
            String ejecutarJava = obtenerEjecutableJava();

            //Process Builder con los comandos y argumentos necesarios.
            ProcessBuilder processBuilder = new ProcessBuilder(
                    ejecutarJava,
                    "-cp",
                    clases.getPath(),
                    "tema1.StarShip",
                    "Aterrizaje suave en cráter"
            );


            //Recopilamos datos del proceso hijo y añadimos en StarShip con el nombre del planeta.
            processBuilder.environment().put("PLANETA", "Kepler-452b");

            // Se conecta con el hijo y se inicia.
            processBuilder.inheritIO();
            Process hijo = processBuilder.start();

            //Cuando termine la misión, espera  y guarda el codigo.
            int codigoSalida = hijo.waitFor();
            System.out.println("Control: Nave finalizada con código: " + codigoSalida);
        } catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }

    private static String obtenerEjecutableJava(){
        boolean esWindows = System.getProperty("os.name").toLowerCase().contains("windows");
        String nombre = esWindows ? "java.exe" : "java";
        return new File(new File(System.getProperty("java.home"), "bin"), nombre).getPath();
    }
}
