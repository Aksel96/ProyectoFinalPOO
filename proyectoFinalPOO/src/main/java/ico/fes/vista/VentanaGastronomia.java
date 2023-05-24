package ico.fes.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaGastronomia extends JFrame {
    private JLabel lblNombre;
    private JLabel lblRegion;
    private JLabel lblTiempo;
    private JLabel lblDificultad;
    private JLabel lblUrl;
    private  JLabel lblId;
    private  JLabel lblNombreMod;
    private  JLabel lblRegionMod;
    private  JLabel lblTiempoMod;
    private  JLabel lblDificultadMod;
    private  JLabel lblUrlMod;

    private JTextField txtNombreAgregar;
    private JTextField txtRegionAgregar;
    private JTextField txtTiempoAgregar;
    private JTextField txtDificultadAgregar;
    private JTextField txtUrlAgregar;
    private JTextField txtNombreModificar;
    private JTextField txtRegionModificar;
    private JTextField txtTiempoModificar;
    private JTextField txtDificultadModificar;
    private JTextField txtUrlModificar;
    private JTextField txtIdModificar;

    private JButton btnAgregar;
    private JButton btnCargar;
    private JButton btnModificar;
    private JButton btnEliminar;
    private JTable tblGastronomia;
    private JScrollPane scrollPane;
    private GridLayout layout;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JLabel imagenPlatillos;

    public VentanaGastronomia(String title) throws HeadlessException {
        super(title);
        this.setSize(1000,800);
        layout = new GridLayout(2,2);
        this.getContentPane().setLayout(layout);
        //Panel1
        panel1 = new JPanel(new GridLayout(0,2));
        panel1.setBackground(new Color(151, 220, 239));
        lblNombre = new JLabel("        Nombre del Platillo:");
        lblRegion = new JLabel("        Region de origen:");
        lblTiempo =  new JLabel("        Tiempo de Preparacion:");
        lblDificultad = new JLabel("        Dificultad de elaboracion del Platillo:");
        lblUrl = new JLabel("        URL de la Imagen:");
        txtNombreAgregar = new JTextField(10);
        txtRegionAgregar = new JTextField(10);
        txtTiempoAgregar = new JTextField(10);
        txtDificultadAgregar = new JTextField(10);
        txtUrlAgregar = new JTextField(10);
        btnAgregar = new JButton("Agregar");
        panel1.add(lblNombre);
        panel1.add(txtNombreAgregar);
        panel1.add(lblRegion);
        panel1.add(txtRegionAgregar);
        panel1.add(lblTiempo);
        panel1.add(txtTiempoAgregar);
        panel1.add(lblDificultad);
        panel1.add(txtDificultadAgregar);
        panel1.add(lblUrl);
        panel1.add(txtUrlAgregar);
        panel1.add(btnAgregar);


        //Panel2
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(196, 255, 210));
        btnCargar = new JButton("Cargar");
        panel2.add(btnCargar);
        tblGastronomia = new JTable();
        scrollPane = new JScrollPane(tblGastronomia);
        panel2.add(scrollPane);

        //Panel3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(184, 137, 255));
        imagenPlatillos = new JLabel("...");
        panel3.add(imagenPlatillos);
        //Panel4
        panel4 = new JPanel(new GridLayout(0,2));
        panel4.setBackground(new Color(255, 232, 185));
        lblId = new JLabel("       Id:");
        lblNombreMod = new JLabel("        Nombre del Platillo:");
        lblRegionMod = new JLabel("        Region de origen:");
        lblTiempoMod =  new JLabel("        Tiempo de Preparacion:");
        lblDificultadMod = new JLabel("        Dificultad de elaboracion del Platillo:");
        lblUrlMod = new JLabel("        URL de la Imagen:");
        txtIdModificar =new JTextField();
        txtNombreModificar = new JTextField();
        txtRegionModificar = new JTextField();
        txtTiempoModificar = new JTextField();
        txtDificultadModificar = new JTextField();
        txtUrlModificar = new JTextField();
        btnModificar = new JButton("Modificar");
        btnEliminar = new JButton("Eliminar");
        panel4.add(lblId);
        panel4.add(txtIdModificar);
        panel4.add(lblNombreMod);
        panel4.add(txtNombreModificar);
        panel4.add(lblRegionMod);
        panel4.add(txtRegionModificar);
        panel4.add(lblTiempoMod);
        panel4.add(txtTiempoModificar);
        panel4.add(lblDificultadMod);
        panel4.add(txtDificultadModificar);
        panel4.add(lblUrlMod);
        panel4.add(txtUrlModificar);
        panel4.add(btnEliminar);
        panel4.add(btnModificar);

        // Agregando paneles al content pane

        this.getContentPane().add(panel1,0);
        this.getContentPane().add(panel2,1);
        this.getContentPane().add(panel3,2);
        this.getContentPane().add(panel4,3);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    public JLabel getLblRegion() {
        return lblRegion;
    }

    public void setLblRegion(JLabel lblRegion) {
        this.lblRegion = lblRegion;
    }

    public JLabel getLblTiempo() {
        return lblTiempo;
    }

    public void setLblTiempo(JLabel lblTiempo) {
        this.lblTiempo = lblTiempo;
    }

    public JLabel getLblDificultad() {
        return lblDificultad;
    }

    public void setLblDificultad(JLabel lblDificultad) {
        this.lblDificultad = lblDificultad;
    }

    public JLabel getLblUrl() {
        return lblUrl;
    }

    public void setLblUrl(JLabel lblUrl) {
        this.lblUrl = lblUrl;
    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JLabel getLblNombreMod() {
        return lblNombreMod;
    }

    public void setLblNombreMod(JLabel lblNombreMod) {
        this.lblNombreMod = lblNombreMod;
    }

    public JLabel getLblRegionMod() {
        return lblRegionMod;
    }

    public void setLblRegionMod(JLabel lblRegionMod) {
        this.lblRegionMod = lblRegionMod;
    }

    public JLabel getLblTiempoMod() {
        return lblTiempoMod;
    }

    public void setLblTiempoMod(JLabel lblTiempoMod) {
        this.lblTiempoMod = lblTiempoMod;
    }

    public JLabel getLblDificultadMod() {
        return lblDificultadMod;
    }

    public void setLblDificultadMod(JLabel lblDificultadMod) {
        this.lblDificultadMod = lblDificultadMod;
    }

    public JLabel getLblUrlMod() {
        return lblUrlMod;
    }

    public void setLblUrlMod(JLabel lblUrlMod) {
        this.lblUrlMod = lblUrlMod;
    }

    public JTextField getTxtNombreAgregar() {
        return txtNombreAgregar;
    }

    public void setTxtNombreAgregar(JTextField txtNombreAgregar) {
        this.txtNombreAgregar = txtNombreAgregar;
    }

    public JTextField getTxtRegionAgregar() {
        return txtRegionAgregar;
    }

    public void setTxtRegionAgregar(JTextField txtRegionAgregar) {
        this.txtRegionAgregar = txtRegionAgregar;
    }

    public JTextField getTxtTiempoAgregar() {
        return txtTiempoAgregar;
    }

    public void setTxtTiempoAgregar(JTextField txtTiempoAgregar) {
        this.txtTiempoAgregar = txtTiempoAgregar;
    }

    public JTextField getTxtDificultadAgregar() {
        return txtDificultadAgregar;
    }

    public void setTxtDificultadAgregar(JTextField txtDificultadAgregar) {
        this.txtDificultadAgregar = txtDificultadAgregar;
    }

    public JTextField getTxtUrlAgregar() {
        return txtUrlAgregar;
    }

    public void setTxtUrlAgregar(JTextField txtUrlAgregar) {
        this.txtUrlAgregar = txtUrlAgregar;
    }

    public JTextField getTxtNombreModificar() {
        return txtNombreModificar;
    }

    public void setTxtNombreModificar(JTextField txtNombreModificar) {
        this.txtNombreModificar = txtNombreModificar;
    }

    public JTextField getTxtRegionModificar() {
        return txtRegionModificar;
    }

    public void setTxtRegionModificar(JTextField txtRegionModificar) {
        this.txtRegionModificar = txtRegionModificar;
    }

    public JTextField getTxtTiempoModificar() {
        return txtTiempoModificar;
    }

    public void setTxtTiempoModificar(JTextField txtTiempoModificar) {
        this.txtTiempoModificar = txtTiempoModificar;
    }

    public JTextField getTxtDificultadModificar() {
        return txtDificultadModificar;
    }

    public void setTxtDificultadModificar(JTextField txtDificultadModificar) {
        this.txtDificultadModificar = txtDificultadModificar;
    }

    public JTextField getTxtUrlModificar() {
        return txtUrlModificar;
    }

    public void setTxtUrlModificar(JTextField txtUrlModificar) {
        this.txtUrlModificar = txtUrlModificar;
    }

    public JTextField getTxtIdModificar() {
        return txtIdModificar;
    }

    public void setTxtIdModificar(JTextField txtIdModificar) {
        this.txtIdModificar = txtIdModificar;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(JButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JTable getTblGastronomia() {
        return tblGastronomia;
    }

    public void setTblGastronomia(JTable tblGastronomia) {
        this.tblGastronomia = tblGastronomia;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JLabel getImagenPlatillos() {
        return imagenPlatillos;
    }

    public void setImagenPlatillos(JLabel imagenPlatillos) {
        this.imagenPlatillos = imagenPlatillos;
    }
    public void limpiar(){
        txtNombreAgregar.setText("");
        txtRegionAgregar.setText("");
        txtTiempoAgregar.setText("");
        txtDificultadAgregar.setText("");
        txtUrlAgregar.setText("");

    }
}
