/**
*
* @author Yavuzhan ALBAYRAK --- yavuzhan.albayrak@ogr.sakarya.edu.tr
* @since 23.05.2023
* <p>
* Uretim.java dosyası
* </p>
*/
package Pdp;

public abstract class Uretim {
	protected int uretilenYemek;
	public Uretim() {
		this.uretilenYemek=0;
	}
	public abstract void Uret(Koloni koloni);
}
