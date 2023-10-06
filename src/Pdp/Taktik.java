/**
*
* @author Yavuzhan ALBAYRAK --- yavuzhan.albayrak@ogr.sakarya.edu.tr
* @since 23.05.2023
* <p>
* Taktik.java dosyası
* </p>
*/
package Pdp;

import java.util.Random;

public abstract class Taktik {
	protected int uretilenSavasDegeri;
	public Taktik() {
		uretilenSavasDegeri=0;
	}
	public abstract void Savas(Koloni koloni);
	
}
