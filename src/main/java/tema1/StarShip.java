package tema1;

public class StarShip {
    static void main(String[] args) {
        /*
        BUsca si existe una variable y la guarda en una variable de texto.
         */
        String planeta = System.getenv("PLANETA");

        //Si la variable es null o esta vacia, por defecto se le asigna Tierra,
        if (planeta == null || planeta.trim().isEmpty()){
            planeta = "Tierra";
        }

        //Construccion de mensaje de mision, si hay argumentos los muestra, sino por default.
        String mensaje;
        if (args.length > 0){
            mensaje = args[0];
        }else {
            mensaje = "Exploración en curso.";
        }

        System.out.println("StarShip: Rumbo hacia el planeta " + planeta);
        System.out.println("StarShip: Misión asignada: " + mensaje);
    }
}
