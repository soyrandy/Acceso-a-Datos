package tema1;

public class Oraculo {
    static void main(String[] args) {
        if (args.length < 2){
            System.err.println("Errror: Faltan argumentos. Has usado: Oraculo <nombre> <pregunta>");
            System.exit(1);
        }

        String nombre = args[0];
        String pregunta = args[1];

        String[] excusas = {
                "Eso no es un bug.",
                "En mi ordenador si funciona.",
                "F5 y arreglado.",
                "La culpa es del servidor."
        };

        int indice = Math.abs(pregunta.length()) % excusas.length;
        String respuesta = excusas[indice];

        System.out.println("Hola " + nombre + ". Para tu pregunta ('" + pregunta + "'), el oráculo dice: ");
        System.out.println("=> " + respuesta);
    }
}
