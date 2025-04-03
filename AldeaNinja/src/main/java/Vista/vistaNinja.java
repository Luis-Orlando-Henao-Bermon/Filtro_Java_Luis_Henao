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
        int numValido=0;
        while (numValido==0){
            try {
                Scanner scan2=new Scanner(System.in);
                ninja.setId_aldea(scan2.nextInt());
                scan.nextLine();
                numValido=1;
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingresa un id de aldea valido");
            }
        }
        return ninja;
    }
}
