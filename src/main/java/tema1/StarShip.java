package tema1;

public class StarShip {
    static void main(String[] args) {
        String planeta = System.getenv("PLANETA");

        if (planeta == null || planeta.trim().isEmpty()){
            planeta = "Tierra";
        }

        String mensaje = (args.length > 0) ? args[0] : "Exploración en curso.";

        System.out.println("StarShip: Rumbo hacia el planeta " + planeta);
        System.out.println("StarShip: Misión asignada: " + mensaje);
    }
}
