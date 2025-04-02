package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HabilidadDAO {

    public static List<Habilidad> verHabilidades() throws SQLException {
        List<Habilidad> habilidads = new ArrayList<>();

        String sql="SELECT * FROM habilidad";

        try(Connection con= Conect.getCon();
            PreparedStatement ps= con.prepareStatement(sql)) {
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                Habilidad h=new Habilidad();
                h.setId_ninja(rs.getInt(1));
                h.setNombre(rs.getString(2));
                h.setDescripcion(rs.getString(3));
                habilidads.add(h);
            }

        } catch (SQLException e) {
            throw new SQLException("Error al listar habilidades: "+ e.getMessage());
        }


        return habilidads;

    }

}
