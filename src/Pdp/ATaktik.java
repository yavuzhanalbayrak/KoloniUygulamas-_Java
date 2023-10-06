/**
*
* @author Yavuzhan ALBAYRAK --- yavuzhan.albayrak@ogr.sakarya.edu.tr
* @since 23.05.2023
* <p>
* ATaktik.java dosyası
* </p>
*/
package Pdp;

import java.util.Random;

public class ATaktik extends Taktik {
	
	public ATaktik() {
		super();
	}
	@Override
	public void Savas(Koloni koloni) {
		Random rd=new Random();
		super.uretilenSavasDegeri=rd.nextInt(1001);
		koloni.SavasDegeriEkle(uretilenSavasDegeri);
	}
	
}
