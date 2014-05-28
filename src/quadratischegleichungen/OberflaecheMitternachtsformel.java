package quadratischegleichungen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 * @version 1.5
 * @author kevinschmidiger
 * 
 *         Die Klasse ist hauptsaechlich generierter Code von dem grafischen
 *         Editor. Wobei einige der Anzeigeobjekte nicht Angezeigt werden ausser
 *         sie werden gebraucht, was im Falle einer Action sein wuerde. Nur die
 *         Actionlistener Klassen sind selber geschrieben. Beim Button berechnen
 *         ist in der Actionlistener Klasse ein Pruefverfahren um zu sehen, ob
 *         etwas eingegeben wurde oder ob die Eingabe keine Zahl ist. Wenn alles
 *         Okay ist wird die quadratische Gleichung ausgerechnet. Beim Button
 *         zuruecksetzen wird das Fenster wieder so eingestellt, wie es beim
 *         Starten aussah.
 * 
 */
public class OberflaecheMitternachtsformel extends JFrame {
	
	private static final long	serialVersionUID	= -5763729515552266940L;
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnZuruecksetzen;
	private JTextArea textAreaLoesung;
	private JTextArea textAreaDiskriminante;
	private JLabel lblDiskriminante;
	private JLabel lblLoesung;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OberflaecheMitternachtsformel frame = new OberflaecheMitternachtsformel();
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
	public OberflaecheMitternachtsformel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel(
				"Programm zur berechnung quadratischer Gleichungen\n");
		lblNewLabel.setBounds(6, 6, 438, 16);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(
				"Bitte die Koeffizienten der Grundform eingeben:");
		lblNewLabel_1.setBounds(6, 34, 438, 16);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBounds(6, 62, 68, 28);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblx2Koeffizient = new JLabel("x2");
		lblx2Koeffizient.setBounds(72, 62, 16, 28);
		contentPane.add(lblx2Koeffizient);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setBounds(86, 62, 68, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblxKoeffizient = new JLabel("x");
		lblxKoeffizient.setBounds(154, 62, 16, 28);
		contentPane.add(lblxKoeffizient);

		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_2.setBounds(161, 62, 68, 28);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblgleichnull = new JLabel("= 0");
		lblgleichnull.setBounds(241, 62, 28, 28);
		contentPane.add(lblgleichnull);

		JButton btnBerechne = new JButton("Berechne");
		btnBerechne.setBounds(281, 62, 117, 29);
		btnBerechne.addActionListener(new ActionListener() {

			// Variablen die die Klasse braucht
			double koeffizientA;
			double koeffizientB;
			double koeffizientC;

			public void actionPerformed(ActionEvent e) {

				// Es ist noch zu pruefen ob ueberhaupt was eingegeben wurde
				boolean rechnenNichtOkay = false;
				boolean keineEingabe = false;

				// Faengt eventuelle Numberformatexceptions ab
				try {
					koeffizientA = Double.parseDouble(textField.getText());
					koeffizientB = Double.parseDouble(textField_1.getText());
					koeffizientC = Double.parseDouble(textField_2.getText());
				} catch (NumberFormatException exception) {

					// Setzt alle noetigen Objekte sichtbar
					textAreaDiskriminante.setVisible(true);
					btnZuruecksetzen.setVisible(true);

					// Anzeige bei keiner Eingabe
					// Ist auch hier weil eine Exception geworfen wird
					if ((textField.getText().equals(""))
							&& (textField_1.getText().equals(""))
							&& (textField_2.getText().equals(""))) {
						textAreaDiskriminante
								.setText("Bitte gib zuerst die Koeffizienten ein!");
						keineEingabe = true;
					}

					// Anzeige wenn eine der Eingaben keine Zahl ist
					if (!keineEingabe) {
						textAreaDiskriminante
								.setText("Einer der Koeffizienten ist keine Zahl!!!");
						rechnenNichtOkay = true;
					}
					
					textAreaDiskriminante.setForeground(Color.RED);

				}

				// Uebergabe der Parameter an die Mitternachtsformel
				// und deren berechnung
				if (!keineEingabe && !rechnenNichtOkay) {

					// Setzt die noetigen Objekte sichtbar
					lblDiskriminante.setVisible(true);
					textAreaDiskriminante.setVisible(true);
					lblLoesung.setVisible(true);
					textAreaLoesung.setVisible(true);
					btnZuruecksetzen.setVisible(true);

					// Die Zahlen werden der Mitternachtsformel uebergeben
					Mitternachtsformel mitternachtsformel = new Mitternachtsformel(
							koeffizientA, koeffizientB, koeffizientC);

					// Ausgabe der Ergebnisse, wobei es auch keine Loesung fuer
					// die Gleichung geben kann
					textAreaDiskriminante.setText(mitternachtsformel
							.getDiskriminanteWithString());
					textAreaLoesung.setText(mitternachtsformel
							.getLoesungenWithString());

				}
				
				textAreaDiskriminante.setForeground(Color.BLACK);

			}
		});
		contentPane.add(btnBerechne);

		btnZuruecksetzen = new JButton("Neue Werte eingeben");
		btnZuruecksetzen.setBounds(6, 271, 438, 29);
		btnZuruecksetzen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lblDiskriminante.setVisible(false);
				textAreaDiskriminante.setVisible(false);
				lblLoesung.setVisible(false);
				textAreaLoesung.setVisible(false);
				btnZuruecksetzen.setVisible(false);

				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textAreaDiskriminante.setText("");
				textAreaLoesung.setText("");
			}
		});
		contentPane.add(btnZuruecksetzen);
		btnZuruecksetzen.setVisible(false);

		textAreaLoesung = new JTextArea();
		textAreaLoesung.setBounds(6, 210, 425, 49);
		textAreaLoesung.setEditable(false);
		textAreaLoesung.setVisible(false);
		contentPane.add(textAreaLoesung);

		textAreaDiskriminante = new JTextArea();
		textAreaDiskriminante.setBounds(6, 124, 425, 46);
		textAreaDiskriminante.setEditable(false);
		textAreaDiskriminante.setVisible(false);
		contentPane.add(textAreaDiskriminante);

		lblDiskriminante = new JLabel("Die Diskriminante:");
		lblDiskriminante.setBounds(6, 96, 425, 16);
		contentPane.add(lblDiskriminante);
		lblDiskriminante.setVisible(false);

		lblLoesung = new JLabel("Die Loesung:");
		lblLoesung.setBounds(6, 182, 425, 16);
		contentPane.add(lblLoesung);
		lblLoesung.setVisible(false);
	}
}
