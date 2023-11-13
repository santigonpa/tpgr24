package presentacion;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import logica_controladores.IControladorOferta;
import logica_datatypes.DataPaquete;
import logica_entidades.OfertaLaboral;
import logica_entidades.TipoPublicacion;
import logica_manejadores.IManejadorOferta;
import logica_manejadores.IManejadorPyT;
import utils.Fabrica;

public class OfertasMasVisitadas extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private  IManejadorOferta IMO;
    private JTable table;
    private ArrayList<OfertaLaboral> ofertas;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Fabrica fabrica = Fabrica.getInstance();
                	IManejadorOferta IMO = fabrica.getInManejadorOferta();
                    OfertasMasVisitadas frame = new OfertasMasVisitadas(IMO);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
   
    /**
     * Create the frame.
     */
    public OfertasMasVisitadas(IManejadorOferta imo) {
    	setClosable(true);
    	IMO = imo;
    	ofertas = new ArrayList<>();
        setTitle("Ofertas mas visitadas");
        setBounds(100, 100, 628, 170);
        getContentPane().setLayout(null);
        
        String no1 = "-";
        String no2 = "-";
        String no3 = "-";
        String no4 = "-";;
        String no5 = "-";
        
        String e1 = "-";
        String e2 = "-";
        String e3 = "-";
        String e4 = "-";
        String e5 = "-";
        
        String tp1 = "-";
        String tp2 = "-";
        String tp3 = "-";
        String tp4 = "-";
        String tp5 = "-";
        
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        int v4 = 0;
        int v5 = 0;
        
        if(ofertas != null) {
        
	        OfertaLaboral o1 = (ofertas.size() > 0) ? ofertas.get(0) : null;
	        OfertaLaboral o2 = (ofertas.size() > 1) ? ofertas.get(1) : null;
	        OfertaLaboral o3 = (ofertas.size() > 2) ? ofertas.get(2) : null;
	        OfertaLaboral o4 = (ofertas.size() > 3) ? ofertas.get(3) : null;
	        OfertaLaboral o5 = (ofertas.size() > 4) ? ofertas.get(4) : null;
	        
	        if(o1 != null) {
	        	no1 = o1.getNombreOferta();
	        	e1 = o1.getEmpresa().getNickName();
	        	tp1 = o1.getTipoPubli().getNombre();
	        	v1 = o1.getVisitas();
	        }
	        
	        if(o2 != null) {
	        	no2 = o2.getNombreOferta();
	        	e2 = o2.getEmpresa().getNickName();
	        	tp2 = o2.getTipoPubli().getNombre();
	        	v2 = o2.getVisitas();
	        }
	        
	        if(o3 != null) {
	        	no3 = o3.getNombreOferta();
	        	e3 = o3.getEmpresa().getNickName();
	        	tp3 = o3.getTipoPubli().getNombre();
	        	v3 = o3.getVisitas();
	        }
	        
	        if(o4 != null) {
	        	no4 = o4.getNombreOferta();
	        	e4 = o4.getEmpresa().getNickName();
	        	tp4 = o4.getTipoPubli().getNombre();
	        	v4 = o4.getVisitas();
	        }
	        
	        if(o5 != null) {
	        	no5 = o5.getNombreOferta();
	        	e5 = o5.getEmpresa().getNickName();
	        	tp5 = o5.getTipoPubli().getNombre();
	        	v5 = o5.getVisitas();
	        }
        }
        
        // Datos para la primera fila y columna (valores fijos)
        Object[] columnNames = {"", "Oferta Laboras", "Empresa", "Tipo de publicacion", "Cantidad de visitas"};
        Object[][] data = {
                {"1", no1, e1, tp1, v1},
                {"2", no2, e2, tp2, v2},
                {"3", no3, e3, tp3, v3},
                {"4", no4, e4, tp4, v4},
                {"5", no5, e5, tp5, v5},
        };

        // Crear el modelo de la tabla con datos iniciales
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Todas las celdas no son editables
            }
        };

        // Crear la tabla con el modelo
        table = new JTable(model);

        // Agregar la tabla a un JScrollPane para permitir el desplazamiento
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 592, 119);
        getContentPane().add(scrollPane);
    }
    
    public void cargarOfertas() {
        this.ofertas = IMO.getOfertasConfimadasOrdenadasPorVisitas();

        // Actualizar la tabla con las nuevas ofertas
        actualizarTabla();
    }

    public void actualizarTabla() {
        String[][] data = new String[5][5];
        String[] columnNames = {"", "Oferta Laboras", "Empresa", "Tipo de publicacion", "Cantidad de visitas"};

        for (int i = 0; i < 5; i++) {
            data[i][0] = String.valueOf(i + 1);  // Números del 1 al 5
        }

        for (int i = 0; i < Math.min(ofertas.size(), 5); i++) {
            OfertaLaboral oferta = ofertas.get(i);

            data[i][1] = oferta.getNombreOferta();
            data[i][2] = oferta.getEmpresa().getNickName();
            data[i][3] = oferta.getTipoPubli().getNombre();
            data[i][4] = String.valueOf(oferta.getVisitas());
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Todas las celdas no son editables
            }
        };

        // Actualizar el modelo de la tabla
        table.setModel(model);
    }
}
