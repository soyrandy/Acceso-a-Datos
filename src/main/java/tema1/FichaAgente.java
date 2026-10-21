package tema1;

public class FichaAgente {
    static void main(String[] args) {
        /*
        Comprobamos si se ha pasado un alias.
        Si el array tiene elementos y no esta vacio, guardamos el alias.
         */
        String alias;
        if (args.length > 0 && !args[0].trim().isEmpty()){
            alias = args[0];
        }else {
            alias = "<<No disponible>>";
        }
        // Obtenemos la referencia para el proceso actual.
        ProcessHandle proActual = ProcessHandle.current();
        // Guardamos el proceso.
        ProcessHandle.Info info = proActual.info();
        //Obtenemos el PID que ha asignado el SO a este proceso
        long pid = proActual.pid();


        /*
        Inicamos PID padre por defecto con error.
        Si el proceso padre existe, se coje su PID y lo convertimos en string.
         */
        String pidPadre = "<<No disponible>>";
        if (proActual.parent().isPresent()){
            pidPadre = String.valueOf(proActual.parent().get().pid());
        }
        // BUscamos el usuario del so, si no esta disponible sale no disponible.
        String usuario = info.user().orElse("<<No disponible>>");

        /*
        Iniciamos con error por si no hay información.
        Si existe la volvemos texto.
         */
        String inicio = "<<No disponible>>";
        if (info.startInstant().isPresent()){
            inicio = info.startInstant().get().toString();
        }

        System.out.println("----- MI FICHA DE AGENTE SECRETO -----");
        System.out.println("Alias: " + alias);
        System.out.println("PID: " + pid);
        System.out.println("PID Padre: " + pidPadre);
        System.out.println("Usuario: " + usuario);
        System.out.println("Inicio: " + inicio);
    }
}
