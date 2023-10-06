/**
*
* @author Yavuzhan ALBAYRAK --- yavuzhan.albayrak@ogr.sakarya.edu.tr
* @since 23.05.2023
* <p>
* Ekran.java dosyası
* </p>
*/
package Pdp;

import java.io.IOException;
import java.util.ArrayList;

public class Ekran {
	void Yazdir(String cikti) {
		System.out.println(cikti);
	}
	void TurYazdir(int turSayisi,ArrayList<Koloni> koloniler,int aktifKoloniSayisi) {
		System.out.print("---------------------------------------------------------------------------------------------\n");
		System.out.println("Tur Sayisi: "+turSayisi);
		System.out.println("Sembol  Populasyon  Yemek Stogu  Kazanma  Kaybetme");
	    for (int i = 0; i < koloniler.size(); i++)
	    {
	    	System.out.println("  "+String.format("%-10s", koloniler.get(i).SembolGetir())+String.format("%-12s", koloniler.get(i).PopulasyonGetir())+String.format("%-12s", koloniler.get(i).YemekStoguGetir())+String.format("%-9s", koloniler.get(i).KazanmaGetir())+String.format("%-10s", koloniler.get(i).KaybetmeGetir()));
	    }
	    System.out.println("---------------------------------------------------------------------------------------------");
	    if (aktifKoloniSayisi > 1) {
	        try {
	            Thread.sleep(100);//Turlar arası gecikme verir.
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();//Cmd Konsolunu temizler.
	        } catch (InterruptedException | IOException e) {
	            e.printStackTrace();
	        }
	    }


	}
}
