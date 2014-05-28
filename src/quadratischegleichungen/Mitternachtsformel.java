package quadratischegleichungen;

/**
 * @author kevinschmidiger
 * @version 1.5
 * 
 *          Diese Klasse nimmt drei Variablen entgegen. Diese werden dann in die
 *          Grundform einer quadratischen Gleichung eingesetzt und ausgerechnet.
 *          Sollte die Gleichung nicht quadratisch sein wuerde, wird sie
 *          trotzdem ausgerechnet. Die einzelnen Koeffizienten und die
 *          Diskriminante koennen mittels Gettermethode natuerlich aufgerufen
 *          werden oder mittels Settermethode veraendert werden, allerdings wird
 *          beim Instanziieren der Klasse direkt nach den Koeffizienten
 *          verlangt. Die Ergebnisse koennen mittels String zurueckgegeben
 *          werden.
 * 
 */
public class Mitternachtsformel {

	private double a;
	private double b;
	private double c;
	private double diskriminante;
	private double loesung1;
	private double loesung2;
	private boolean nureineLoesung = false;
	private boolean keineLoesung = false;
	private boolean xKannAlleZahlenAusRSein = false;
	private boolean xMuss0Sein = false;
	private boolean parameterAungleich0 = true;
	private boolean parameterBungleich0 = true;
	private boolean parameterCungleich0 = true;
	private boolean diskriminantegroesser0 = false;
	private boolean diskriminantegleich0 = false;
	private boolean diskriminantekleiner0 = false;

	public Mitternachtsformel(double koeffizientA, double koeffizientB,
			double koeffizientC) {

		// Setzt die Parameter mit den boolschen Werten
		setParameterABC(koeffizientA, koeffizientB, koeffizientC);

		// Rechnet direkt das Ergebnis aus
		rechneQuadratischeGleichungAus(this.a, this.b, this.c);

	}

	/**
	 * Liest die Parameter ein von ax2 + bx + c = 0 und setzt boolsche Werte die
	 * Aussagen ob die Parameter ungleich 0 sind
	 * 
	 * @param a
	 *            ax2 Parameter vor x2
	 * @param b
	 *            bx Parameter vor x
	 * @param c
	 *            c Parameter vor x0
	 */
	public void setParameterABC(double a, double b, double c) {

		this.a = a;
		this.b = b;
		this.c = c;

		// Ueberprueft ob die Parameter undgleich 0 sind und setzt
		// mir die boolschen Werte
		if (this.a == 0) {
			this.parameterAungleich0 = false;
		}
		if (this.b == 0) {
			this.parameterBungleich0 = false;
		}
		if (this.c == 0) {
			this.parameterCungleich0 = false;
		}

	}

	/**
	 * Gibt den Parameter a zurueck von: ax2 + bx + c
	 * 
	 * @return Parameter a
	 */
	public double getParametera() {
		return this.a;
	}

	/**
	 * Gibt den Prameter b zurueck von: ax2 + bx + c
	 * 
	 * @return Parameter b
	 */
	public double getParameterb() {
		return this.b;
	}

	/**
	 * Gibt den Parameter c zurueck von: ax2 + bx + c
	 * 
	 * @return Paramter c
	 */
	public double getParameterc() {
		return this.c;
	}

	/**
	 * Gibt den Wert der Diskriminante zurueck
	 * 
	 * @return Wert der Diskriminante
	 */
	public double getDiskriminante() {
		return this.diskriminante;
	}

	/**
	 * Gibt das Ergebnis der Diskriminante als String zurueck
	 * 
	 * @return String Der Ergebnisstring der Diskriminante
	 */
	public String getDiskriminanteWithString() {

		String status = new String();

		// Ueberprueft den Wert der Diskriminante und gibt den Status
		// in einem Satz aus und wenn der Wert != 0 ist den Wert
		if (this.diskriminantekleiner0) {
			status = "Die Diskriminante ist kleiner als 0, \nnaemlich: "
					+ getDiskriminante()
					+ "\nDas bedeutet es gibt keine reelle Loesung!";
		} else if (this.diskriminantegleich0) {
			status = "Die Diskriminante ist gleich:\n\t " + getDiskriminante();
		} else if (this.diskriminantegroesser0) {
			status = "Die Diskriminante ist groesser 0, naemlich:\n\t"
					+ getDiskriminante();
		}

		return status;
	}

	/**
	 * Gibt die Loesungen der quadratischen Gleichung als String zurueck
	 * 
	 * @return String Der Ergebnisstring der Loesung(en)
	 */
	public String getLoesungenWithString() {

		String loesung = new String();

		// Ausgabe bei keiner Loesung
		if (this.keineLoesung) {
			loesung = "Unlogische Aussage! Da c nicht gleich " + this.c;
		}

		// Nur eine Loesung, aber x = 0
		else if (!this.nureineLoesung && this.xMuss0Sein) {
			loesung = "Es gibt nur eine Loesung:\n\tx = 0";
		}

		// Nur eine Loesung, aber nicht x = 0
		// Achtung Zweizeilig!!
		else if (this.nureineLoesung && !this.xMuss0Sein) {
			loesung = "Es gibt nur eine Loesung:\n\tx = " + this.loesung1;
		}

		// Gibt alle moeglichen Werte der Losung aus als String
		else if (this.xKannAlleZahlenAusRSein) {
			loesung = "x kann alle Zahlen aus R sein, da 0 = 0";
		}

		// Setzt die Loesungen, wenn die Gleichung quadratisch ist
		else if (!this.keineLoesung && !this.nureineLoesung
				&& !this.diskriminantekleiner0) {
			loesung = "x1 = " + this.loesung1 + "\nx2 = " + this.loesung2;
		}

		return loesung;

	}

	/**
	 * Nimmt die Parameter und setzt diese in die Grundform einer quadratischen
	 * Gleichung ein und rechnet das Ergenis aus, sofern es ueberhaupt eine
	 * quadratische Gleichnung ist. Ist die Gleichnung nicht quadratisch wird
	 * sie trotzdem ausgerechnet.
	 * 
	 * @param koeffizientA
	 *            ax2 Parameter vor x2
	 * @param koeffizientB
	 *            bx Parameter vor x
	 * @param koeffizientC
	 *            c Parameter vor x0
	 */
	public void rechneQuadratischeGleichungAus(double koeffizientA,
			double koeffizientB, double koeffizientC) {

		// Die Koeffizienten werden eingelesen und geprueft, ob diese den Wert 0
		// haben
		this.setParameterABC(koeffizientA, koeffizientB, koeffizientC);

		// Rechnet Fall 1 fuer a = 0 und b & c != 0
		if (!parameterAungleich0
				&& (parameterBungleich0 && parameterCungleich0)) {
			this.loesung1 = c / b * -1;
		}

		// Rechnet Fall 2 fuer a & b = 0 und c != 0
		// Achtung Keine Loesung!!!
		else if ((!parameterAungleich0 && !parameterBungleich0)
				&& parameterCungleich0) {
			this.keineLoesung = true;
		}

		// Rechnet Fall 3 fuer a & b & c = 0
		// x kann alle Zahlen aus R sein
		// Gut moeglich, dass dieser Fall gar nie vorkommt, wegen vorpruefung
		// der Eingabe
		else if (!parameterAungleich0 && !parameterBungleich0
				&& !parameterCungleich0) {
			this.xKannAlleZahlenAusRSein = true;
		}

		// Rechnet Fall 4 fuer a & c = 0 und b != 0
		// x muss in diesem Fall 0 sein, auch nur eine Loesung
		else if ((!parameterAungleich0 && !parameterCungleich0)
				&& parameterBungleich0) {
			this.xMuss0Sein = true;
			this.nureineLoesung = true;
		}

		// Rechnet den Fall fuer eine quadratische Gleichung
		else if (parameterAungleich0) {

			// Rechnet die Diskriminante aus
			this.diskriminante = Math.pow(this.b, 2) - (4 * this.a * this.c);

			// Setzt die boolsche Werte, ob die Diskriminante kleiner
			// 0 ist oder gleich oder groesser

			// Es gibt dafuer keine reelle Loesung
			if (this.diskriminante < 0) {
				this.diskriminantekleiner0 = true;
			}

			// Es gibt nur eine Loesung, wenn die Diskriminante = 0 ist
			// naehmlich -b / 2a
			else if (this.diskriminante == 0) {

				this.loesung1 = -1 * this.b / (this.a * 2);

				this.nureineLoesung = true;
				this.diskriminantegleich0 = true;

			}

			// Einsetzen in die Mitternachtsformel
			else if (this.diskriminante > 0) {

				// Erste Loesung
				this.loesung1 = (-1 * this.b + Math.sqrt(this.diskriminante))
						/ (2 * this.a);

				// Zweite Loesung
				this.loesung2 = (-1 * this.b - Math.sqrt(this.diskriminante))
						/ (2 * this.a);

				this.diskriminantegroesser0 = true;

			}

		}

	}

}
