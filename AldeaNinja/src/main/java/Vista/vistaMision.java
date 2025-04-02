package Vista;

import Modelo.Mision;

import java.util.List;
import java.util.Scanner;

public class vistaMision {

    public static Mision registrarMision(){
        Scanner scan=new Scanner(System.in);
        Mision m=new Mision();

        System.out.println("Ingresa la descripcion de la mision");
        m.setDescripcion(scan.nextLine());
        System.out.println("Ingresa el rango de la mision");
        m.setRango(scan.nextLine());
        System.out.println("Ingresa la recompensa de la mision");
        m.setRecompensa(scan.nextLong());

        return m;
    }

    public static void verTodasLasMisiones(List<Mision> misionList){
        for (Mision m:misionList){
            System.out.println("-----------------------------------------");
            System.out.println("ID: "+m.getId());
            System.out.println("Descripcion: "+m.getDescripcion());
            System.out.println("Rango: "+m.getRango());
            System.out.println("Recompensa: "+m.getRecompensa());
        }
    }
}
