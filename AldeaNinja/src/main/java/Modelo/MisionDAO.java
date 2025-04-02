package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MisionDAO {

    public static List<Mision> verMisiones() throws SQLException {
        List<Mision> misionList = new ArrayList<>();

        String sql="SELECT * FROM Mision";

        try(Connection con= Conect.getCon();
            PreparedStatement ps= con.prepareStatement(sql)) {
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                Mision m=new Mision();
                m.setId(rs.getInt(1));
                m.setDescripcion(rs.getString(2));
                m.setRango(rs.getString(3));
                m.setRecompensa(rs.getLong(4));
                misionList.add(m);
            }

        } catch (SQLException e) {
            throw new SQLException("Error al listar habilidades: "+ e.getMessage());
        }


        return misionList;

    }

    public static void RegistrarMision(Mision m) throws SQLException {


        String sql="INSERT INTO Mision(descripcion,rango,recompensa) VALUES(?,?,?);";

        try(Connection con= Conect.getCon();
            PreparedStatement ps= con.prepareStatement(sql)) {
            ps.setString(1,m.getDescripcion());
            ps.setString(2,m.getRango());
            ps.setLong(3,m.getRecompensa());

            int res=ps.executeUpdate();
            if (res>0){
                System.out.println("Mision registrada con exito");
            }

        } catch (SQLException e) {
            throw new SQLException("Error al registrar una mision: "+ e.getMessage());
        }
    }
}
