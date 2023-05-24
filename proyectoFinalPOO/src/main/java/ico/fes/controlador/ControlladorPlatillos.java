package ico.fes.controlador;

import ico.fes.modelo.ModeloTablaPlatillo;
import ico.fes.modelo.Platillo;
import ico.fes.vista.VentanaGastronomia;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControlladorPlatillos extends MouseAdapter {
    private VentanaGastronomia view;
    private ModeloTablaPlatillo modelo;

    public ControlladorPlatillos(VentanaGastronomia view) {
        this.view = view;
        modelo = new ModeloTablaPlatillo();
        this.view.getTblGastronomia().setModel(modelo);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getBtnCargar().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.view.getBtnCargar()){

            modelo.cargarDatos();
            this.view.getTblGastronomia().setModel(modelo);
            this.view.getTblGastronomia().updateUI();
        }
        if(e.getSource() == this.view.getBtnAgregar()){
            Platillo platillo = new Platillo();
            platillo.setId(0);
            platillo.setNombre(this.view.getTxtNombreAgregar().getText());
            platillo.setRegionOrigen(this.view.getTxtRegionAgregar().getText());
            platillo.setTiempoPreparacion(Integer.parseInt(this.view.getTxtTiempoAgregar().getText()));
            platillo.setDificultad(this.view.getTxtDificultadAgregar().getText());
            platillo.setUrl(this.view.getTxtUrlAgregar().getText());
        if (modelo.agregarPlatillo(platillo)){
            JOptionPane.showMessageDialog(view,"Se agrego correctamente","Aviso",JOptionPane.INFORMATION_MESSAGE);
            this.view.getTblGastronomia().updateUI();
        }else {
            JOptionPane.showMessageDialog(view,"No se Agrego","Error al insertar",JOptionPane.ERROR_MESSAGE);
        }
        }
        this.view.limpiar();
    }
}
