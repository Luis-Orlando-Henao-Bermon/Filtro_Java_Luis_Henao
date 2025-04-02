package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AldeaDao {

    public static List<Aldea> verAldeas() throws SQLException {
        List<Aldea> aldeas = new ArrayList<>();

        String sql="SELECT * FROM Aldea";

        try(Connection con= Conect.getCon();
            PreparedStatement ps= con.prepareStatement(sql)) {
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                Aldea a=new Aldea();
                a.setId(rs.getInt(1));
                a.setNombre(rs.getString(2));
                aldeas.add(a);
            }

        } catch (SQLException e) {
            throw new SQLException("Error al listar habilidades: "+ e.getMessage());
        }


        return aldeas;

    }
}
