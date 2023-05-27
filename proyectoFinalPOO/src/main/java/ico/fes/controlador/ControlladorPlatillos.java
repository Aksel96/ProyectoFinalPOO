package ico.fes.controlador;

import ico.fes.modelo.ModeloTablaPlatillo;
import ico.fes.modelo.Platillo;
import ico.fes.vista.VentanaGastronomia;

import javax.swing.*;
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
                JOptionPane.showMessageDialog(view,"ERROR NINGUN CAMPO PUEDE ESTAR VACIO",
                        "Aviso!",
                        JOptionPane.ERROR_MESSAGE);
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
                            JOptionPane.showMessageDialog(view,"Se agrego correctamente","Aviso",JOptionPane.INFORMATION_MESSAGE);
                            modelo.cargarDatos();
                            this.view.getTblGastronomia().setModel(modelo);
                            this.view.getTblGastronomia().updateUI();
                        }else {
                            JOptionPane.showMessageDialog(view,"No se Agrego","Error al insertar",JOptionPane.ERROR_MESSAGE);
                        }
                    }else {
                        JOptionPane.showMessageDialog(view,"Error datos invalidos",
                                "Aviso!",
                                JOptionPane.ERROR_MESSAGE);
                    }

                }else {
                    JOptionPane.showMessageDialog(view,"Error el tiempo tiene que ser un numero entero",
                            "Aviso!",
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
                JOptionPane.showMessageDialog(view,"ERROR NINGUN CAMPO PUEDE ESTAR VACIO",
                        "Aviso!",
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
                        int respuesta = JOptionPane.showConfirmDialog(view,"Queres modificar el registro?",
                                "Confirmacion",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                        if (respuesta == JOptionPane.YES_NO_OPTION){
                            if (modelo.updatePlatillo(platilloMod)){
                                JOptionPane.showMessageDialog(view,"Se actualizo correctamente","Aviso",JOptionPane.INFORMATION_MESSAGE);
                                modelo.cargarDatos();
                                this.view.getTblGastronomia().setModel(modelo);
                                this.view.getTblGastronomia().updateUI();
                            }else {
                                JOptionPane.showMessageDialog(view,"No se actualizo","Error al actualizar",JOptionPane.ERROR_MESSAGE);
                            }
                        }else {
                            System.out.println("No se actualizo");
                        }
                    }else {
                        JOptionPane.showMessageDialog(view,"Error datos invalidos",
                                "Aviso!",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }else {
                    JOptionPane.showMessageDialog(view,"Error el tiempo tiene que ser un numero entero",
                            "Aviso!",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (e.getSource() == view.getBtnEliminar()){
            System.out.println("Click boton eliminar");
            int index = this.view.getTblGastronomia().getSelectedRow();
            Platillo platilloDelete = modelo.getPlatilloAtIndex(index);
            int respuesta = JOptionPane.showConfirmDialog(view,"Estas seguro de borrar el registro?",
                    "Confirmacion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
            if (respuesta == JOptionPane.YES_NO_OPTION){
                if(modelo.deletePlatillo(platilloDelete)){
                    JOptionPane.showMessageDialog(view,"Se elimino correctamente","Aviso",JOptionPane.INFORMATION_MESSAGE);
                    modelo.cargarDatos();
                    this.view.getTblGastronomia().setModel(modelo);
                    this.view.getTblGastronomia().updateUI();
                } else{
                    JOptionPane.showMessageDialog(view,"No se elimino","Error al eliminar",JOptionPane.ERROR_MESSAGE);
                }
            }else {
                System.out.println("No se elimino");
            }
        }

        this.view.limpiar();
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
