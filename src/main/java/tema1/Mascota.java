package tema1;

public class Mascota {
    static void main(String[] args) {
        if (args.length <2){
            System.err.println("Error: Faltan argumentos.");
            System.exit(1);
        }

        String nombre = args[0];
        int pasos = Integer.parseInt(args[1]);
        long pid = ProcessHandle.current().pid();

        for (int i = 1; i <= pasos; i++){
            System.out.println("PID: " + pasos + " / Mascota: " + nombre + " / Paso: " +i);
        }
    }
}
