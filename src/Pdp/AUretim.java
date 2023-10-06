/**
*
* @author Yavuzhan ALBAYRAK --- yavuzhan.albayrak@ogr.sakarya.edu.tr
* @since 23.05.2023
* <p>
* AUretim.java dosyası
* </p>
*/
package Pdp;

import java.util.Random;

public class AUretim extends Uretim {

	public AUretim() {
		super();
	}
	@Override
	public void Uret(Koloni koloni){
		Random rd=new Random();
		super.uretilenYemek=rd.nextInt(10)+1;
		koloni.YemekStoguArttir(uretilenYemek);
	}
}
