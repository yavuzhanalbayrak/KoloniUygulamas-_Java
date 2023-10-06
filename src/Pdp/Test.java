/**
*
* @author Yavuzhan ALBAYRAK --- yavuzhan.albayrak@ogr.sakarya.edu.tr
* @since 23.05.2023
* <p>
* Test.java dosyası
* </p>
*/
package Pdp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		ArrayList<Koloni> koloniler=new ArrayList<Koloni>();
		TusTakimi tuslar = new TusTakimi();
		Ekran ekran=new Ekran();
		Oyun oyun=new Oyun();
		Random rd=new Random();
		int sembol=0;
		
		ekran.Yazdir("Sayıları giriniz: ");
		String koloniPopulasyonlari = tuslar.sayiAl();
		String[] populasyonlar=koloniPopulasyonlari.trim().split("\\s+");
		
		Pattern controlCharPattern = Pattern.compile("\\p{Cntrl}");//Boşluk, tab atma gibi char işlemlerini çıkarmak için yazılmış regex komutu.
		for(int i=0;i<populasyonlar.length;i++) {
			do{
				sembol=rd.nextInt(255);
			}while (Character.isWhitespace((char) sembol) || !Character.isDefined((char) sembol) || Character.isISOControl((char) sembol));//Boşluk, tab atma gibi char işlemlerini çıkarma.

			Koloni koloni=new Koloni((char)sembol,populasyonlar[i], Integer.toString(Integer.parseInt(populasyonlar[i])*Integer.parseInt(populasyonlar[i])));
			koloniler.add(koloni);
		}
		oyun.Basla(koloniler);
	}
}
