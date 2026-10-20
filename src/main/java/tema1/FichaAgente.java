package tema1;

public class FichaAgente {
    static void main(String[] args) {
        String alias;

        if (args.length > 0 && !args[0].trim().isEmpty()){
            alias = args[0];
        }else {
            alias = "<<No disponible>>";
        }

        ProcessHandle proActual = ProcessHandle.current();
        ProcessHandle.Info info = proActual.info();

        long pid = proActual.pid();

        String pidPadre = "<<No disponible>>";
        if (proActual.parent().isPresent()){
            pidPadre = String.valueOf(proActual.parent().get().pid());
        }

        String usuario = info.user().orElse("<<No disponible>>");

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
