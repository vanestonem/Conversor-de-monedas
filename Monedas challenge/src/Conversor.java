import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.awt.Color;

public class Conversor {

	private JFrame frame;
	private JButton btn;
	private JComboBox cmb;
	private JLabel lbl;
	private JTextField txt;
	
	public enum Moneda{
		pesos_dolar,
		pesos_euro,
		pesos_Libra,
		pesos_Yen,
		pesos_Won,
		dolar_pesos,
		euro_pesos,
		Libra_pesos,
		Yen_pesos,
		Won_pesos
	}
	
	public double dolar = 16.76;
	public double euro = 18.43;
	public double Libra = 21.52;
	public double Yen = 0.12;
	public double Won = 0.013;
	
	public double valorInput = 0.00;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conversor window = new Conversor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Conversor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(248, 248, 255));
		frame.setBounds(100, 100, 342, 160);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txt = new JTextField();
		txt.setBackground(new Color(248, 248, 255));
		txt.setBounds(10, 11, 116, 20);
		frame.getContentPane().add(txt);
		txt.setColumns(10);
		
		cmb = new JComboBox<Moneda>();
		cmb.setBackground(new Color(0, 191, 255));
		cmb.setModel(new DefaultComboBoxModel<>(Moneda.values()));
		cmb.setBounds(10, 42, 116, 22);
		frame.getContentPane().add(cmb);
		
		//evento de funcionalidad del boton 
		btn = new JButton("Convertir");
		btn.setBackground(new Color(0, 191, 255));
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Convertir();
			}
		});
		btn.setBounds(152, 42, 89, 23);
		frame.getContentPane().add(btn);
		
		lbl = new JLabel("00.00");
		lbl.setBounds(152, 14, 125, 14);
		frame.getContentPane().add(lbl);
	}
	
	public void Convertir() {
		if(Validar(txt.getText())) {
			Moneda moneda = (Moneda) cmb.getSelectedItem();
			
			switch (moneda) {
			
			case pesos_dolar: 
				PesosAMoneda(dolar);
				break;
			case pesos_euro: 
				PesosAMoneda(euro);
				break;
			case pesos_Libra: 
				PesosAMoneda(Libra);
				break;
			case pesos_Yen: 
				PesosAMoneda(Yen);
				break;
			case pesos_Won: 
				PesosAMoneda(Won);
				break;
			case dolar_pesos: 
				MonedaAPesos(dolar);
				break;
			case euro_pesos: 
				MonedaAPesos(euro);
				break;
			case Libra_pesos: 
				MonedaAPesos(Libra);
				break;
			case Yen_pesos: 
				MonedaAPesos(Yen);
				break;
			case Won_pesos: 
				MonedaAPesos(Won);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + moneda);
		}

		}
	}
	
	public void PesosAMoneda(double moneda) {
		double res = valorInput / moneda;
		lbl.setText(Redondear(res));
	}
	
	public void MonedaAPesos(double moneda) {
		double res = valorInput * moneda;
		lbl.setText(Redondear(res));
	}
	
	public String Redondear(double valor) {
		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_UP);
		return df.format(valor);
	}
	
	public boolean Validar(String texto) {
		try {
			double x = Double.parseDouble(texto);
			if(x > 0);
			valorInput = x;
			return true;
		}catch(NumberFormatException e) {
			lbl.setText("Solamente Números !!");
			return false;
		}
	}
}
