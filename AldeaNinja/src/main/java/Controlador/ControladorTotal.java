package Controlador;

import java.sql.SQLException;
import java.util.Scanner;

import Modelo.*;
import  Vista.*;
public class ControladorTotal {

    public static void Iniciar() throws SQLException {
        Scanner scan=new Scanner(System.in);
        vistaMisionesNinja VM=new vistaMisionesNinja();

        boolean salir=false;

        while (salir==false){
            System.out.println( "1. Listar todos los ninjas junto con sus habilidades.\n" +
                                "2. Mostrar las misiones disponibles para un ninja específico.\n" +
                                "3. Mostrar las misiones completadas para un ninja específico.\n" +
                                "4. Asignar una misión a un ninja.\n" +
                                "5. Marcar una misión como completada.\n" +
                                "6. Mostrar todas las misiones completadas.\n"+
                                "7. Registrar una mision. \n"+
                                "8. Ver Todas las misiones.\n"+
                                "9. Agregar un ninja\n"+
                                "10. Salir.");

            System.out.println("Ingresa una opcion");

            int numValido=0;
            int opcion=0;
            while (numValido==0){
                try {
                    opcion=scan.nextInt();
                    scan.nextLine();
                    numValido=1;
                } catch (NumberFormatException e) {
                    System.out.println("Por favor ingresa una opcion valida");
                }
            }

            switch (opcion){
                case 1:
                    vistaVerninjasYHabilidades.verNinjas(HabilidadDAO.verHabilidades(), NinjaDAO.verNinjas(), AldeaDao.verAldeas());
                    System.out.println("Preciona Enter para continuar");
                    scan.nextLine();
                    break;
                case 2:

                    VM.VerMisionesDeNija(MisionNinjaDAO.verMisiones());
                    System.out.println("Preciona Enter para continuar");
                    scan.nextLine();

                    break;

                case 3:

                    VM.verMisionesCompletadasPorNinja(MisionNinjaDAO.verMisiones());
                    System.out.println("Preciona Enter para continuar");
                    scan.nextLine();

                    break;

                case 4:

                    MisionNinja mn=VM.asignarMisionANinja();
                    MisionNinjaDAO.asignarMisionANinja(mn);
                    System.out.println("Preciona Enter para continuar");
                    scan.nextLine();

                    break;

                case 5:

                    MisionNinja mn2=VM.marcarMisionComoCompletada();
                    MisionNinjaDAO.marcarMisionComoCompletada(mn2);
                    System.out.println("Preciona Enter para continuar");
                    scan.nextLine();

                    break;

                case 6:

                    VM.verMisionesCompletadas(MisionNinjaDAO.verMisiones());
                    System.out.println("Preciona Enter para continuar");
                    scan.nextLine();
                    break;

                case 7:
                    Mision m=vistaMision.registrarMision();
                    MisionDAO.RegistrarMision(m);
                    System.out.println("Preciona Enter para continuar");
                    scan.nextLine();

                    break;

                case 8:

                    vistaMision.verTodasLasMisiones(MisionDAO.verMisiones());
                    System.out.println("Preciona Enter para continuar");
                    scan.nextLine();
                    break;


                case 9:

                    NinjaDAO.AgregarNinja(vistaNinja.agragarNinja());

                    break;
                case 10:
                    salir=true;
                    break;

            }

        }
    }
}
