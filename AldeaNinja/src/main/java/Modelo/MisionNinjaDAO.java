package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MisionNinjaDAO {

    public static List<MisionNinja> verMisiones() throws SQLException {
        List<MisionNinja> misionNinjas = new ArrayList<>();

        String sql="SELECT * FROM Mision_Ninja";

        try(Connection con= Conect.getCon();
            PreparedStatement ps= con.prepareStatement(sql)) {
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                MisionNinja ms=new MisionNinja();
                ms.setId_ninja(rs.getInt(1));
                ms.setId_mision(rs.getInt(2));
                ms.setFecha_inicio(rs.getString(3));
                ms.setFecha_fin(rs.getString(4));
                misionNinjas.add(ms);
            }

        } catch (SQLException e) {
            throw new SQLException("Error al ver misiones de un ninja: "+ e.getMessage());
        }
        return misionNinjas;
    }


    public static void asignarMisionANinja(MisionNinja mn) throws SQLException {


        String sql="INSERT INTO Mision_Ninja(id_ninja,id_mision,fecha_inicio,fecha_fin) VALUES(?,?,?,?);";

        try(Connection con= Conect.getCon();
            PreparedStatement ps= con.prepareStatement(sql)) {
            ps.setInt(1,mn.getId_ninja());
            ps.setInt(2,mn.getId_mision());
            ps.setString(3,mn.getFecha_inicio());
            ps.setString(4,mn.getFecha_fin());

            int res=ps.executeUpdate();
            if (res>0){
                System.out.println("Mision asignada con exito");
            }

        } catch (SQLException e) {
            throw new SQLException("Error al asignar mision a un ninja: "+ e.getMessage());
        }
    }


    public static void marcarMisionComoCompletada(MisionNinja mn) throws SQLException {


        String sql="UPDATE Mision_Ninja SET fecha_fin=? WHERE id_ninja=? AND id_mision=? ;";

        try(Connection con= Conect.getCon();
            PreparedStatement ps= con.prepareStatement(sql)) {
            ps.setString(1,mn.getFecha_fin());
            ps.setInt(2,mn.getId_ninja());
            ps.setInt(3,mn.getId_mision());
            int res=ps.executeUpdate();
            if (res>0){
                System.out.println("Mision Completada");
            }

        } catch (SQLException e) {
            throw new SQLException("Error al marcar mision como completada: "+ e.getMessage());
        }
    }




}
