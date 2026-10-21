package tema1;

import java.io.File;
import java.io.IOException;

public class ControlMision {
    static void main() {
        try {
            File clases = new File("build/classes/java/main").getCanonicalFile();
            String ejecutableJava = obtenerEjecutableJava();

            ProcessBuilder processBuilder = new ProcessBuilder(
                    ejecutableJava,
                    "-cp",
                    clases.getPath(),
                    "tema1.StarShip",
                    "Aterrizaje suave en cráter"
            );

            processBuilder.environment().put("PLANETA", "Kepler-452b");
            processBuilder.inheritIO();

            Process hijo = processBuilder.start();

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
