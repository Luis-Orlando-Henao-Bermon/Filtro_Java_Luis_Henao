package Vista;

import Modelo.MisionNinja;
import Modelo.*;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class vistaMisionesNinja {
    private List<Mision> misiones;

    public vistaMisionesNinja() {
        try {
            this.misiones = MisionDAO.verMisiones();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void VerMisionesDeNija(List<MisionNinja> misionNinjaList){

        System.out.println("Por favor ingresa el id del ninja del que quieres ver las misiones");
        int numValido=0;
        int idNinja=0;
        while (numValido==0){

            try {
                Scanner scan=new Scanner(System.in);
                idNinja=0;
                idNinja=scan.nextInt();
                scan.nextLine();
                numValido=1;
            } catch (Exception e) {
                System.out.println("Por favor ingresa un id valido");
            }
        }

        for (MisionNinja mn:misionNinjaList){
            if (mn.getId_ninja()==idNinja){
                System.out.println("----------------------------------------------");

                for (Mision m:misiones){
                    if (mn.getId_mision()==m.getId()){
                        System.out.println("Descripcion: "+m.getDescripcion());
                        System.out.println("Rango: "+m.getRango());
                        System.out.println("Recompensa: "+m.getRecompensa()+"$");
                    }
                }
                System.out.println();

            }
        }
    }


    public void verMisionesCompletadasPorNinja(List<MisionNinja> misionNinjaList){

        System.out.println("Por favor ingresa el id del ninja del que quieres ver las misiones");
        int numValido=0;
        int idNinja=0;
        while (numValido==0){
            try {
                Scanner scan=new Scanner(System.in);
                idNinja=scan.nextInt();
                scan.nextLine();
                numValido=1;
            } catch (Exception e) {
                System.out.println("Por favor ingresa un id valido");
            }
        }

        for (MisionNinja mn:misionNinjaList){

            if (mn.getId_ninja()==idNinja && !mn.getFecha_fin().isEmpty()){
                System.out.println("----------------------------------------------");
                for (Mision m:misiones){
                    if (mn.getId_mision()==m.getId()){
                        System.out.println("Descripcion: "+m.getDescripcion());
                        System.out.println("Rango: "+m.getRango());
                        System.out.println("Recompensa: "+m.getRecompensa()+"$");
                    }
                }
                System.out.println();
            }

        }
    }

    public MisionNinja asignarMisionANinja() throws SQLException {
        MisionNinja mn=new MisionNinja();

        System.out.println("Ingresa el id del ninja");
        int numValido=0;
        while (numValido==0){
            try {
                Scanner scan=new Scanner(System.in);
                mn.setId_ninja(scan.nextInt());
                numValido=1;
            } catch (Exception e) {
                System.out.println("Por favor ingresa un id valido");
            }
        }

        System.out.println("Ingresa el id de la mision");
        numValido=0;
        while (numValido==0){
            try {
                Scanner scan=new Scanner(System.in);
                mn.setId_mision(scan.nextInt());
                numValido=1;
            } catch (Exception e) {
                System.out.println("Por favor ingresa un id valido");
            }
        }


        Date hoy=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        mn.setFecha_inicio(simpleDateFormat.format(hoy));
        mn.setFecha_fin("");
        misiones = MisionDAO.verMisiones();
        return mn;
    }

    public MisionNinja marcarMisionComoCompletada(){
        MisionNinja mn=new MisionNinja();

        System.out.println("Ingresa el id del ninja");
        int numValido=0;
        while (numValido==0){
            try {
                Scanner scan=new Scanner(System.in);
                mn.setId_ninja(scan.nextInt());
                numValido=1;
            } catch (Exception e) {
                System.out.println("Por favor ingresa un id valido");
            }
        }

        System.out.println("Ingresa el id de la mision");
        numValido=0;
        while (numValido==0){
            try {
                Scanner scan=new Scanner(System.in);
                mn.setId_mision(scan.nextInt());
                numValido=1;
            } catch (Exception e) {
                System.out.println("Por favor ingresa un id valido");
            }
        }

        Date hoy=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        mn.setFecha_fin(simpleDateFormat.format(hoy));

        return mn;
    }


    public void verMisionesCompletadas(List<MisionNinja> misionNinjaList){


        for (MisionNinja mn:misionNinjaList){

            if (!mn.getFecha_fin().isEmpty()){
                System.out.println("----------------------------------------------");
                for (Mision m:misiones){
                    if (mn.getId_mision()==m.getId()){
                        System.out.println("Descripcion: "+m.getDescripcion());
                        System.out.println("Rango: "+m.getRango());
                        System.out.println("Recompensa: "+m.getRecompensa()+"$");
                    }
                }
                System.out.println();
            }

        }
    }
}
