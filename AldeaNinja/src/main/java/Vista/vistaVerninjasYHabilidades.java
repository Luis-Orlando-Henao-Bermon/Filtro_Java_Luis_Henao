package Vista;

import Modelo.Aldea;
import Modelo.Habilidad;
import Modelo.Ninja;

import java.util.List;
import java.util.Scanner;

public class vistaVerninjasYHabilidades {

    private static Scanner scan=new Scanner(System.in);

    public static void verNinjas(List<Habilidad> habilidads,List<Ninja> ninjas,List<Aldea> aldeas){

        for (Ninja n:ninjas){
            System.out.println("---------------Ninja---------------");
            System.out.println("ID: "+n.getId());
            System.out.println("Nombre: "+n.getNombre());
            System.out.println("Rango: "+n.getRango());
            for (Aldea a:aldeas){
                if (a.getId()==n.getId_aldea()){
                    System.out.println("Aldea: "+ a.getNombre());
                }
            }
            System.out.println("---------------Habilidad---------------");
            for (Habilidad h: habilidads){
                if (n.getId()==h.getId_ninja()){
                    System.out.println("Nombre de la habilidad: " + h.getNombre());
                    System.out.println("Descripcion de la habilidad: " + h.getDescripcion());
                }
            }
            System.out.println();
        }

    }



}
