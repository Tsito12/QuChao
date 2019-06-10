package vista;

import controlador.ControladorHistorialPiloto;
import modelo.Carrera;
import modelo.Piloto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VistaHistorialPiloto extends JFrame {
    //Clase de la que sacaremos la informacion
    private Piloto piloto;
    //Clase que usaremos para dar informacion a la pantalla anterior
    private Carrera carrera;
    //Panel principal
    private JPanel contenedor;
    //Labels
    private JLabel titulo;
    private JLabel tituloCarreras;
    private JLabel tituloParticipantes;
    //Botones
    private JButton btnRegresar;
    //Tablas
    //Tabla de las carreras
    public JTable tablaCarrera;
    public DefaultTableModel dtmCarrea;
    private JScrollPane scrollCarrera;
    protected String [] cabeceraCarrera;
    protected Object [][] datosCarrera;
    //Tabla de los participantes en esa carrera
    public JTable tablaParticipantes;
    public DefaultTableModel dtmParticipantes;
    private JScrollPane scrollParticipantes;
    protected String [] cabeceraParticipantes;
    protected Object [][] datosParticipantes;

    public VistaHistorialPiloto(Piloto p,Carrera carrera)
    {
        this.piloto = p;
        this.carrera=carrera;
        //Metodos de JFrame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Detalle carrera");
        setBounds(100, 100,650,650);
        contenedor = new JPanel();
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        getContentPane().add(contenedor);
        contenedor.setLayout(gb);
        setVisible(true);

        //Labels
        titulo = new JLabel("Historial carreras de "+this.piloto.getapodo());
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth=2;
        constraints.weightx=1.0;
        constraints.insets = new Insets(10,0,10,0);
        contenedor.add(titulo,constraints);

        tituloCarreras = new JLabel("Carreras");
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.weightx=1.0;
        constraints.insets = new Insets(10,10,10,10);
        contenedor.add(tituloCarreras,constraints);

        tituloParticipantes = new JLabel("Participantes");
        constraints.gridx=1;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.weightx=1.0;
        constraints.insets = new Insets(10,10,10,10);
        contenedor.add(tituloParticipantes,constraints);

        //Tablas
        //Tabla Carreras
        scrollCarrera      = new JScrollPane();
        cabeceraCarrera    = new String[] {"Fecha","Hora","Número de vueltas","Número de Participantes","Resultado final"};
        dtmCarrea          = new DefaultTableModel(datosCarrera,cabeceraCarrera);
        tablaCarrera       = new JTable(dtmCarrea);
        scrollCarrera.setViewportView(tablaCarrera);
        constraints.gridx=0;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.gridheight=1;
        constraints.weightx=0.0;
        constraints.weighty=0.0;
        constraints.insets = new Insets(10,10,10,10);
        constraints.fill=GridBagConstraints.BOTH;
        contenedor.add(scrollCarrera,constraints);

        //Tabla Participantes
        scrollParticipantes      = new JScrollPane();
        cabeceraParticipantes    = new String[] {"Apodo"};
        dtmParticipantes         = new DefaultTableModel(datosParticipantes,cabeceraParticipantes);
        tablaParticipantes       = new JTable(dtmParticipantes);
        scrollParticipantes.setViewportView(tablaParticipantes);
        constraints.gridx=1;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.gridheight=1;
        constraints.weightx=0.0;
        constraints.weighty=0.0;
        constraints.insets = new Insets(10,10,10,10);
        constraints.fill=GridBagConstraints.BOTH;
        contenedor.add(scrollParticipantes,constraints);

        btnRegresar = new JButton("Regresar");
        constraints.gridx=0;
        constraints.gridy=3;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.insets = new Insets(10,0,10,0);
        contenedor.add(btnRegresar,constraints);
        pack();
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void conectarControlador(ControladorHistorialPiloto c)
    {
        btnRegresar.setActionCommand("Regresar");
        btnRegresar.addActionListener(c);
        tablaCarrera.addMouseListener(c);
    }
}
