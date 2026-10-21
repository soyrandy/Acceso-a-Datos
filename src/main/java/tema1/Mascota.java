package tema1;

public class Mascota {
    static void main(String[] args) {
        /*
        Comprobamos que se hayan pasado al menos 2 argumentos.
        Si no, sale y muestra el codigo 1.
         */
        if (args.length < 2){
            System.err.println("Error: Faltan argumentos.");
            System.exit(1);
        }

        /*
        1. Se lee el nombre de la mascota.
        2. Se guardan los pasos como int para saber el numero entero.
        3. Se obtiene el pid dada por el so.
         */
        String nombre = args[0];
        int pasos = Integer.parseInt(args[1]);
        long pid = ProcessHandle.current().pid();

        //Bucle para mostrar los pasos que esta dando la mascota, a parte de su pid y nombre.
        for (int i = 1; i <= pasos; i++){
            System.out.println("PID: " + pid + " / Mascota: " + nombre + " / Paso: " + i);
        }
    }
}
