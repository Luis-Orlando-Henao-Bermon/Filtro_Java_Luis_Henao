package Vista;

import Modelo.Ninja;

import java.util.Scanner;

public class vistaNinja {

    public static Ninja agragarNinja(){
        Scanner scan=new Scanner(System.in);
        Ninja ninja=new Ninja();

        System.out.println("Ingresa el nombre del ninja");
        ninja.setNombre(scan.nextLine());

        System.out.println("Ingresa el rango del ninja");
        ninja.setRango(scan.nextLine());

        System.out.println("Ingresa el id de la aldea");
        ninja.setId_aldea(scan.nextInt());
        scan.nextLine();

        return ninja;
    }
}
