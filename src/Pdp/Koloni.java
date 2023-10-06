/**
*
* @author Yavuzhan ALBAYRAK --- yavuzhan.albayrak@ogr.sakarya.edu.tr
* @since 23.05.2023
* <p>
* Koloni.java dosyası
* </p>
*/
package Pdp;

public class Koloni {
	private int savasDegeri;
	private char sembol;
	private String populasyon;
	private String yemekStogu;
	private String kazanma;
	private String kaybetme;
	
	Koloni(char sembol,String populasyon,String yemekStogu){
		this.savasDegeri=0;
		this.sembol=sembol;
		this.populasyon=populasyon;
		this.yemekStogu=yemekStogu;
		this.kazanma="0";
		this.kaybetme="0";
	}
	public void PopulasyonAzalt(int oran) {
		this.populasyon=Integer.toString((int)(Double.parseDouble(this.populasyon)-(Double.parseDouble(this.populasyon)*oran/100)));
	}
	public void TurSonu() {//Yemek stoğunu azaltıp popülasyonu arttırır.
		this.yemekStogu=Integer.toString(Integer.parseInt(this.yemekStogu)-(Integer.parseInt(this.populasyon)*2));
		this.populasyon=Integer.toString(Integer.parseInt(this.populasyon)+(Integer.parseInt(this.populasyon)*20/100));
	}
	public void YemekStoguAzalt(int oran) {
		this.yemekStogu=Integer.toString((int)(Double.parseDouble(this.yemekStogu)-(Double.parseDouble(this.yemekStogu)*oran/100)));
	}
	public void YemekStoguArttir(int yagmalanan) {
		this.yemekStogu=Integer.toString(Integer.parseInt(this.yemekStogu)+yagmalanan);
	}
	public void Kazan() {
		this.kazanma=Integer.toString(Integer.parseInt(this.kazanma)+1);
	}	
	public void Kaybet() {
		this.kaybetme=Integer.toString(Integer.parseInt(this.kaybetme)+1);
	}
	public void SavasDegeriEkle(int savasDegeri) {
		this.savasDegeri=savasDegeri;
	}
	public void PopulasyonBitir() {
		this.populasyon="--";
	}
	public void YemekStoguBitir() {
		this.yemekStogu="--";
	}
	public void KazanmaBitir() {
		this.kazanma="--";
	}
	public void KaybetmeBitir() {
		this.kaybetme="--";
	}
	public int SavasDegeriGetir() {
		return this.savasDegeri;
	}
	public char SembolGetir() {
		return this.sembol;
	}
	public String PopulasyonGetir() {
		return this.populasyon;
	}
	public String YemekStoguGetir() {
		return this.yemekStogu;
	}
	public String KazanmaGetir() {
		return this.kazanma;
	}
	public String KaybetmeGetir() {
		return this.kaybetme;
	}
}
