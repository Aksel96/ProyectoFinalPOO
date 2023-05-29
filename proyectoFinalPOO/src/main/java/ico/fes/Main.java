package ico.fes;

import ico.fes.controlador.ControlladorPlatillos;
import ico.fes.vista.VentanaGastronomia;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando Programa");
        VentanaGastronomia view = new VentanaGastronomia("Gastronomia Italiana");
        ControlladorPlatillos controller = new ControlladorPlatillos(view);
        ImageIcon icon = new ImageIcon("iconitaly.png");
        view.setIconImage(icon.getImage());
    }
}