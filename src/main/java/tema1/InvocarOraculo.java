package tema1;

import java.io.File;
import java.io.IOException;

public class InvocarOraculo {
    static void main() throws IOException {
        try {
            String nombre = "Randy";
            String pregunta = "¿Por qué el codigo me sale mal?";

            File clases = new File("build/classes/java/main");

            ProcessBuilder processBuilder = new ProcessBuilder(
                    "java",
                    "-cp",
                    clases.getAbsolutePath(),
                    "tema1.Oraculo",
                    nombre,
                    pregunta
            );

            processBuilder.inheritIO();

            Process hijo = processBuilder.start();

            int salida = hijo.waitFor();

            System.out.println("Código de salida del hijo: " + salida);
        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
}
