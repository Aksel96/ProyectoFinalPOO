package ico.fes.modelo;

import ico.fes.persistencia.PlatilloDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaPlatillo implements TableModel {
    private ArrayList<Platillo> datos;
    public static final int COLUMNS = 6;
    private PlatilloDAO platilloDAO;

    public ModeloTablaPlatillo() {
        datos = new ArrayList<>();
        platilloDAO = new PlatilloDAO();
    }

    public ModeloTablaPlatillo(ArrayList<Platillo> datos) {
        this.datos = datos;
        platilloDAO = new PlatilloDAO();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNS;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex){
            case 0:
                return "Id";
            case 1:
                return "Nombre";
            case 2:
                return "Origen";
            case 3:
                return "Tiempo";
            case 4:
                return "Dificultad";
            case 5:
                return "URL";

        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0, 3:
                return Integer.class;
            case 1, 2, 4, 5:
                return String.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Platillo tmp = datos.get(rowIndex);
        switch (columnIndex){
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getNombre();
            case 2:
                return tmp.getRegionOrigen();
            case 3:
                return tmp.getTiempoPreparacion();
            case 4:
                return tmp.getDificultad();
            case 5:
                return tmp.getUrl();

        }

        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                break;
            case 1:
                datos.get(rowIndex).setNombre((String) aValue);
            case 2:
                datos.get(rowIndex).setRegionOrigen((String) aValue);
            case 3:
                datos.get(rowIndex).setTiempoPreparacion((Integer) aValue);
            case 4:
                datos.get(rowIndex).setDificultad((String) aValue);
            case 5:
                datos.get(rowIndex).setUrl((String) aValue);
            default:
                System.out.println("No se modifico nada");
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
    public void cargarDatos(){
        try{
            datos = platilloDAO.obtenerTodo();
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    }
    public boolean agregarPlatillo(Platillo platillo){
        boolean resultado = false;
        try {
            if (platilloDAO.insertar(platillo)){
                datos.add(platillo);
                resultado = true;
            }else {
                resultado = false;
            }

        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }
}
