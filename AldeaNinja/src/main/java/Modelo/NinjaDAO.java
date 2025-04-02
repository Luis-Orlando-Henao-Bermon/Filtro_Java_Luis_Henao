package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NinjaDAO {

    public static List<Ninja> verNinjas() throws SQLException {
        List<Ninja> ninjas = new ArrayList<>();

        String sql="SELECT * FROM Ninja";

        try(Connection con= Conect.getCon();
            PreparedStatement ps= con.prepareStatement(sql)) {
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                Ninja n=new Ninja();
                n.setId(rs.getInt(1));
                n.setNombre(rs.getString(2));
                n.setRango(rs.getString(3));
                n.setId_aldea(rs.getInt(4));
                ninjas.add(n);
            }

        } catch (SQLException e) {
            throw new SQLException("Error al listar habilidades: "+ e.getMessage());
        }


        return ninjas;

    }

    public static void AgregarNinja(Ninja ninja) throws SQLException {


        String sql="INSERT INTO Ninja(nombre,rango,id_aldea) VALUES(?,?,?);";

        try(Connection con= Conect.getCon();
            PreparedStatement ps= con.prepareStatement(sql)) {
            ps.setString(1,ninja.getNombre());
            ps.setString(2,ninja.getRango());
            ps.setInt(3,ninja.getId_aldea());

            int res=ps.executeUpdate();
            if (res>0){
                System.out.println("Ninja agregado con exito");
            }

        } catch (SQLException e) {
            throw new SQLException("Error al agregar un ninja: "+ e.getMessage());
        }
    }
}
