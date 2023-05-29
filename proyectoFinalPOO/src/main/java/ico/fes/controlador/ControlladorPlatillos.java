package ico.fes.controlador;

import ico.fes.modelo.ModeloTablaPlatillo;
import ico.fes.modelo.Platillo;
import ico.fes.vista.VentanaGastronomia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;

public class ControlladorPlatillos extends MouseAdapter {
    private VentanaGastronomia view;
    private ModeloTablaPlatillo modelo;



    public ControlladorPlatillos(VentanaGastronomia view) {
        this.view = view;
        modelo = new ModeloTablaPlatillo();
        this.view.getTblGastronomia().setModel(modelo);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getBtnCargar().addMouseListener(this);
        this.view.getTblGastronomia().addMouseListener(this);
        this.view.getBtnModificar().addMouseListener(this);
        this.view.getBtnEliminar().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.view.getBtnCargar()){

            modelo.cargarDatos();
            this.view.getTblGastronomia().setModel(modelo);
            this.view.getTblGastronomia().updateUI();
        }
        if(e.getSource() == this.view.getBtnAgregar()){
            System.out.println("Click boton agregar");
            Platillo platillo = new Platillo();
            if (vacio()){
                JOptionPane.showMessageDialog(view,
                        "ERROR LOS CAMPOS NO PUEDEN ESTAR VACIOS.",
                        "AVISO!",
                        JOptionPane.WARNING_MESSAGE);
            }else {
                if (verificarEsNumeroAdd()){
                    if (verificarEsString()){
                        platillo.setId(0);
                        platillo.setNombre(this.view.getTxtNombreAgregar().getText());
                        platillo.setRegionOrigen(this.view.getTxtRegionAgregar().getText());
                        platillo.setTiempoPreparacion(Integer.parseInt(this.view.getTxtTiempoAgregar().getText()));
                        platillo.setDificultad(this.view.getTxtDificultadAgregar().getText());
                        platillo.setUrl(this.view.getTxtUrlAgregar().getText());
                        if (modelo.agregarPlatillo(platillo)){
                            ImageIcon iconCheck = new ImageIcon("checkicon.png");
                            JOptionPane.showMessageDialog(view,
                                    "Se agrego correctamente.",
                                    "AVISO!",
                                    JOptionPane.INFORMATION_MESSAGE,
                                    iconCheck);
                            modelo.cargarDatos();
                            this.view.getTblGastronomia().setModel(modelo);
                            this.view.getTblGastronomia().updateUI();
                        }else {
                            JOptionPane.showMessageDialog(view,
                                    "Error, No se pudo agregar el registro.",
                                    "Error al insertar",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }else {
                        JOptionPane.showMessageDialog(view,"Error, Los datos introducidos no son validos, intente nuevamente.\n" +
                                        "Recuerda que los elemetos solo aceptan letras a exceptcion del campo \"Tiempo\"",
                                "AVISO!",
                                JOptionPane.ERROR_MESSAGE);
                    }

                }else {
                    JOptionPane.showMessageDialog(view,
                            "Error, El cuadro de texto \" Tiempo de preparacion \" tiene que ser un numero entero.",
                            "AVISO!",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

        }
        if (e.getSource() == view.getTblGastronomia()){
            System.out.println("Click en la tabla");
            int index = this.view.getTblGastronomia().getSelectedRow();
            Platillo tmp = modelo.getPlatilloAtIndex(index);
            try {
                this.view.getImagenPlatillos().setIcon(tmp.getImagen());
            }catch (MalformedURLException mfue){
                System.out.println(mfue.getMessage());
            }
            this.view.getTxtIdModificar().setText(Integer.toString(tmp.getId()));
            this.view.getTxtNombreModificar().setText(tmp.getNombre());
            this.view.getTxtRegionModificar().setText(tmp.getRegionOrigen());
            this.view.getTxtTiempoModificar().setText(Integer.toString(tmp.getTiempoPreparacion()));
            this.view.getTxtDificultadModificar().setText(tmp.getDificultad());
            this.view.getTxtUrlModificar().setText(tmp.getUrl());
        }
        if (e.getSource() == view.getBtnModificar()){
            System.out.println("Click boton modificar");
            Platillo platilloMod = new Platillo();
            if (vacioMod()){
                JOptionPane.showMessageDialog(view,
                        "ERROR LOS CAMPOS NO PUEDEN ESTAR VACIOS.",
                        "AVISO!",
                        JOptionPane.WARNING_MESSAGE);
            }else {
                if (this.view.getTxtIdModificar().getText().isEmpty()){
                    JOptionPane.showMessageDialog(view,
                            "Error,No se puede modificar sin antes seleccionar un registro \nSeleccione un registro de la tabla para modificar.",
                            "AVISO!",
                            JOptionPane.ERROR_MESSAGE);
                }else {
                    if (verificarEsNumeroMod()){
                        if (verificarEsStringMod()){
                            platilloMod.setId(Integer.parseInt(this.view.getTxtIdModificar().getText()));
                            platilloMod.setNombre(this.view.getTxtNombreModificar().getText());
                            platilloMod.setRegionOrigen(this.view.getTxtRegionModificar().getText());
                            platilloMod.setTiempoPreparacion(Integer.parseInt(this.view.getTxtTiempoModificar().getText()));
                            platilloMod.setDificultad(this.view.getTxtDificultadModificar().getText());
                            platilloMod.setUrl(this.view.getTxtUrlModificar().getText());
                            int respuesta = JOptionPane.showConfirmDialog(view,
                                    "Estas seguro de que quieres modificar este registro?, Esta accion no se puede deshacer.",
                                    "Confirmacion",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE);
                            if (respuesta == JOptionPane.YES_NO_OPTION){
                                if (modelo.updatePlatillo(platilloMod)){
                                    ImageIcon icon = new ImageIcon("checkicon.png");
                                    JOptionPane.showMessageDialog(view,
                                            "Se actualizo correctamente",
                                            "AVISO",
                                            JOptionPane.INFORMATION_MESSAGE,
                                            icon);
                                    modelo.cargarDatos();
                                    this.view.getTblGastronomia().setModel(modelo);
                                    this.view.getTblGastronomia().updateUI();
                                }else {
                                    JOptionPane.showMessageDialog(view,
                                            "Error, No se pudo actualizar el registro",
                                            "Error al actualizar",
                                            JOptionPane.ERROR_MESSAGE);
                                }
                            }else {
                                System.out.println("No se actualizo");
                            }
                        }else {
                            JOptionPane.showMessageDialog(view,
                                    "Error, Los datos introducidos no son validos, intente nuevamente.",
                                    "AVISO!",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }else {
                        JOptionPane.showMessageDialog(view,
                                "Error, El cuadro de texto \" Tiempo de preparacion \" tiene que ser un numero entero.",
                                "AVISO!",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        if (e.getSource() == view.getBtnEliminar()){
            System.out.println("Click boton eliminar");
            if (vacioMod()){
                JOptionPane.showMessageDialog(view,
                        "ERROR LOS CAMPOS NO PUEDEN ESTAR VACIOS.",
                        "AVISO!",
                        JOptionPane.WARNING_MESSAGE);
            }else {
                if (this.view.getTxtIdModificar().getText().isEmpty()){
                    JOptionPane.showMessageDialog(view,
                            "Error,No se puede eliminar sin antes seleccionar un registro \n Primero seleccione un registro por favor.",
                            "AVISO!",
                            JOptionPane.ERROR_MESSAGE);
                }else {
                    int index = this.view.getTblGastronomia().getSelectedRow();
                    Platillo platilloDelete = modelo.getPlatilloAtIndex(index);
                    int respuesta = JOptionPane.showConfirmDialog(view,
                            "Estas seguro de borrar el registro?, Esta accion no se puede deshacer.",
                            "Confirmacion",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE);
                    if (respuesta == JOptionPane.YES_NO_OPTION){
                        if(modelo.deletePlatillo(platilloDelete)){
                            ImageIcon icon = new ImageIcon("checkicon.png");
                            JOptionPane.showMessageDialog(view,
                                    "Se elimino correctamente",
                                    "AVISO!",
                                    JOptionPane.INFORMATION_MESSAGE,
                                    icon);
                            modelo.cargarDatos();
                            this.view.getTblGastronomia().setModel(modelo);
                            this.view.getTblGastronomia().updateUI();
                        } else{
                            JOptionPane.showMessageDialog(view,
                                    "Error, No se pudo eliminar el registro.",
                                    "Error al eliminar",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }else {
                        System.out.println("No se elimino");
                    }
                }
            }
        }
        this.view.limpiar();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == this.view.getBtnEliminar()){
            this.view.getBtnEliminar().setBackground(Color.RED);
            this.view.getBtnEliminar().setForeground(Color.WHITE);
        }
        if (e.getSource() == this.view.getBtnAgregar()){
            this.view.getBtnAgregar().setBackground(Color.BLACK);
            this.view.getBtnAgregar().setForeground(Color.WHITE);
        }
        if (e.getSource() == this.view.getBtnModificar()){
            this.view.getBtnModificar().setForeground(Color.WHITE);
            this.view.getBtnModificar().setBackground(Color.BLACK);
        }
        if (e.getSource() == this.view.getBtnCargar()){
            this.view.getBtnCargar().setForeground(Color.WHITE);
            this.view.getBtnCargar().setBackground(Color.BLACK);

        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == this.view.getBtnEliminar()){
            this.view.getBtnEliminar().setBackground(new Color(255, 156, 160));
            this.view.getBtnEliminar().setForeground(Color.BLACK);
        }
        if (e.getSource() == this.view.getBtnAgregar()){
            this.view.getBtnAgregar().setBackground(Color.WHITE);
            this.view.getBtnAgregar().setForeground(Color.BLACK);
        }
        if (e.getSource() == this.view.getBtnModificar()){
            this.view.getBtnModificar().setForeground(Color.BLACK);
            this.view.getBtnModificar().setBackground(Color.WHITE);
        }
        if (e.getSource() == this.view.getBtnCargar()){
            this.view.getBtnCargar().setForeground(Color.BLACK);
            this.view.getBtnCargar().setBackground(Color.WHITE);
        }
    }

    private boolean vacio(){
        if (this.view.getTxtNombreAgregar().getText().isEmpty() || this.view.getTxtRegionAgregar().getText().isEmpty() ||
        this.view.getTxtDificultadAgregar().getText().isEmpty() || this.view.getTxtUrlAgregar().getText().isEmpty() ||
        this.view.getTxtTiempoAgregar().getText().isEmpty()){
            return true;
        }
        return false;
    }
    private boolean vacioMod(){
        if (this.view.getTxtNombreModificar().getText().isEmpty() || this.view.getTxtRegionModificar().getText().isEmpty() ||
                this.view.getTxtDificultadModificar().getText().isEmpty() || this.view.getTxtUrlModificar().getText().isEmpty() ||
                this.view.getTxtTiempoModificar().getText().isEmpty()){
            return true;
        }
        return false;
    }
    private boolean verificarEsNumeroAdd(){
        try {
            Integer.parseInt(this.view.getTxtTiempoAgregar().getText());
            return true;
        }catch (NumberFormatException nfe){
            return false;
        }
    }
    private boolean verificarEsNumeroMod(){
        try {
            Integer.parseInt(this.view.getTxtTiempoModificar().getText());
            return true;
        }catch (NumberFormatException nfe){
            return false;
        }
    }
    private boolean verificarEsString(){
        if (this.view.getTxtNombreAgregar().getText().matches("[a-zA-Z\\s!@#$%^&*()_+{}|\":<>?\\[\\];',.]+") &&
                this.view.getTxtDificultadAgregar().getText().matches("[a-zA-Z\\s!@#$%^&*()_+{}|\":<>?\\[\\];',.]+") &&
                this.view.getTxtRegionAgregar().getText().matches("[a-zA-Z\\s!@#$%^&*()_+{}|\":<>?\\[\\];',.]+")){
            return true;
        }else {
            return false;
        }
    }
    private boolean verificarEsStringMod(){
        if (this.view.getTxtNombreModificar().getText().matches("[a-zA-Z\\s!@#$%^&*()_+{}|\":<>?\\[\\];',.]+") &&
                this.view.getTxtDificultadModificar().getText().matches("[a-zA-Z\\s!@#$%^&*()_+{}|\":<>?\\[\\];',.]+") &&
                this.view.getTxtRegionModificar().getText().matches("[a-zA-Z\\s!@#$%^&*()_+{}|\":<>?\\[\\];',.]+")){
            return true;
        }else {
            return false;
        }
    }
}
