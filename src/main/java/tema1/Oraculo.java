package tema1;

public class Oraculo {
    static void main(String[] args) {
        /*
        Si el array tiene menos de 2 elementos saldrá error.
        Usamos un System exit para que avise la padre con codigo 1.
         */
        if (args.length < 2){
            System.err.println("Errror: Faltan argumentos. Has usado: Oraculo <nombre> <pregunta>");
            System.exit(1);
        }

        // Leemos los argumentos pasados.
        String nombre = args[0];
        String pregunta = args[1];

        //Creamos nuestra array con las excusas.
        String[] excusas = {
                "Eso no es un bug.",
                "En mi ordenador si funciona.",
                "F5 y arreglado.",
                "La culpa es del servidor."
        };

        /*
        Se observa la longitud de la pregunta y se aplica un modulo
        del numero de las excusas y que sean positivas.
         */
        int indice = Math.abs(pregunta.length()) % excusas.length;
        String respuesta = excusas[indice];

        System.out.println("Hola " + nombre + ". Para tu pregunta ('" + pregunta + "'), el oráculo dice: ");
        System.out.println("=> " + respuesta);
    }
}
