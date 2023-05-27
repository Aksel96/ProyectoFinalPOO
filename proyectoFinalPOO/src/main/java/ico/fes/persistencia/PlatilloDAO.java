package ico.fes.persistencia;

import ico.fes.modelo.Platillo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PlatilloDAO implements InterfazDAO{
    public PlatilloDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        int rowCount = 0;
        String sqlInsert = "INSERT INTO gItaliana(nombre,regionOrigen,tiempoPreparacion,dificultad,url) VALUES(?,?,?,?,?)";
        PreparedStatement pstm = ConexionSingleton.getInstance("GastronomiaDB.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1,((Platillo)obj).getNombre());
        pstm.setString(2,((Platillo)obj).getRegionOrigen());
        pstm.setInt(3,((Platillo)obj).getTiempoPreparacion());
        pstm.setString(4,((Platillo)obj).getDificultad());
        pstm.setString(5,((Platillo)obj).getUrl());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        int colCount = 0;
        String sqlUpdate = "UPDATE gItaliana SET nombre = ?, regionOrigen = ?, tiempoPreparacion = ?, dificultad = ?, url = ? WHERE id = ?";
        PreparedStatement pstm = ConexionSingleton.getInstance("GastronomiaDB.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1,((Platillo)obj).getNombre());
        pstm.setString(2,((Platillo)obj).getRegionOrigen());
        pstm.setInt(3,((Platillo)obj).getTiempoPreparacion());
        pstm.setString(4,((Platillo)obj).getDificultad());
        pstm.setString(5,((Platillo)obj).getUrl());
        pstm.setInt(6,((Platillo)obj).getId());
        colCount = pstm.executeUpdate();
        return colCount > 0;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        int colCount = 0;
        String sqlDelete = "DELETE FROM gItaliana WHERE id = ?";
        PreparedStatement pstm = ConexionSingleton.getInstance("GastronomiaDB.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1, Integer.parseInt(id));
        colCount = pstm.executeUpdate();
        return colCount > 0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM gItaliana;";
        ArrayList<Platillo> resultado = new ArrayList<>();

        Statement stm = ConexionSingleton.getInstance("GastronomiaDB.db").getConnection().createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()){
            resultado.add(new Platillo(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getString(5),rst.getString(6)));
        }

        return resultado;
    }


}
