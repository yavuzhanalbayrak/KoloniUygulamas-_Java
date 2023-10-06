/**
*
* @author Yavuzhan ALBAYRAK --- yavuzhan.albayrak@ogr.sakarya.edu.tr
* @since 23.05.2023
* <p>
* BTaktik.java dosyası
* </p>
*/
package Pdp;

import java.util.Random;

public class BTaktik extends Taktik {
	
	public BTaktik() {
		super();
	}
	@Override
	public void Savas(Koloni koloni) {
		Random rd=new Random();
		super.uretilenSavasDegeri=rd.nextInt(1001);
		koloni.SavasDegeriEkle(uretilenSavasDegeri);
	}
}
