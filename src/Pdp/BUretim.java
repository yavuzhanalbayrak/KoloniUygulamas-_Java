/**
*
* @author Yavuzhan ALBAYRAK --- yavuzhan.albayrak@ogr.sakarya.edu.tr
* @since 23.05.2023
* <p>
* BUretim.java dosyası
* </p>
*/
package Pdp;

import java.util.Random;

public class BUretim extends Uretim {
	
	public BUretim() {
		super();
	}
	@Override
	public void Uret(Koloni koloni){
		Random rd=new Random();
		super.uretilenYemek=rd.nextInt(10)+1;
		koloni.YemekStoguArttir(uretilenYemek);
	}
}
