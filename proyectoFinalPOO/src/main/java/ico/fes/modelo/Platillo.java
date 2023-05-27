package ico.fes.modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Platillo {
    private int id;
    private String nombre;
    private String regionOrigen;
    private int tiempoPreparacion;
    private String dificultad;
    private String url;

    public Platillo() {
    }

    public Platillo(int id, String nombre, String regionOrigen, int tiempoPreparacion, String dificultad, String url) {
        this.id = id;
        this.nombre = nombre;
        this.regionOrigen = regionOrigen;
        this.tiempoPreparacion = tiempoPreparacion;
        this.dificultad = dificultad;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRegionOrigen() {
        return regionOrigen;
    }

    public void setRegionOrigen(String regionOrigen) {
        this.regionOrigen = regionOrigen;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(int tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Platillo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", regionOrigen='" + regionOrigen + '\'' +
                ", tiempoPreparacion=" + tiempoPreparacion +
                ", dificultad='" + dificultad + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
    public ImageIcon getImagen() throws MalformedURLException {
        URL urlImagen = new URL(this.url);
        return new ImageIcon(urlImagen);
    }
}
