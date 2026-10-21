package tema1;

import java.io.File;
import java.io.IOException;

public class InvocarOraculo {
    static void main() throws IOException {
        try {
            //Argumentos para el Oraculo.
            String nombre = "Randy";
            String pregunta = "¿Por qué el codigo me sale mal?";

            //Buscamos la carpeta de clases apuntandola a build y
            File clases = new File("build/classes/java/main");

            //Guardamos el ejecutable java en la variable despues de obtenerla del metodo.
            String ejecutarJava = obtenerEjecutableJava();

            //ProcessBuilder con los comandos necesarios.
            ProcessBuilder processBuilder = new ProcessBuilder(
                    ejecutarJava,
                    "-cp",
                    clases.getAbsolutePath(),
                    "tema1.Oraculo",
                    nombre,
                    pregunta
            );

            //COnectamos la consola del Oraculo con InvocarOraculo.
            //Se lanza la ejecucion del Oraculo.
            processBuilder.inheritIO();
            Process hijo = processBuilder.start();

            //Cuando el proceso termine, se captura el codigo.
            int salida = hijo.waitFor();

            System.out.println("Código de salida del hijo: " + salida);
        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }

    private static String obtenerEjecutableJava() {
        boolean esWindows = System.getProperty("os.name").toLowerCase().contains("windows");
        String nombre = esWindows ? "java.exe" : "java";
        return new File(new File(System.getProperty("java.home"), "bin"), nombre).getPath();
    }
}
