/**
*
* @author Yavuzhan ALBAYRAK --- yavuzhan.albayrak@ogr.sakarya.edu.tr
* @since 23.05.2023
* <p>
* Oyun.java dosyası
* </p>
*/
package Pdp;

import java.util.ArrayList;

public class Oyun {
	private int turSayisi;
	private int aktifKoloniSayisi;
	
	public Oyun() {
		this.turSayisi=0;
		this.aktifKoloniSayisi=0;
	}
	public void Basla(ArrayList<Koloni> koloniler) {
		AUretim Auretim = new AUretim();
	    BUretim Buretim = new BUretim();
	    ATaktik Ataktik = new ATaktik();
	    BTaktik Btaktik = new BTaktik();
	    Ekran ekran = new Ekran();
	    this.aktifKoloniSayisi=koloniler.size();
	    ekran.TurYazdir(turSayisi,koloniler,aktifKoloniSayisi);
	    while (true)
	    {
	        this.turSayisi++;
	        //KONTROL
	        Kontrol(koloniler);
	        //SAVAS
	        for (int i = 0; i < koloniler.size()-1; i++)//iç içe for döngüsü ile tüm koloniler savaştırılır.
	        {
	        	Kontrol(koloniler);
	            if (koloniler.get(i).PopulasyonGetir()!="--")//Koloni hayatta mı kontrolü.
	            {
	                for (int j = i+1; j < koloniler.size(); j++)
	                {
	                	Kontrol(koloniler);
	                    if (koloniler.get(i).PopulasyonGetir()!="--"&&koloniler.get(j).PopulasyonGetir()!="--")
	                    {
	                        if(j%2==0)//taktiklerin rastgele seçilmesi.
	                        {
	                            Ataktik.Savas(koloniler.get(i));
	                            Btaktik.Savas(koloniler.get(j));
	                        }
	                        else{
	                        	Ataktik.Savas(koloniler.get(j));
	                        	Btaktik.Savas(koloniler.get(i));
	                        }
	                        if(koloniler.get(i).SavasDegeriGetir()>koloniler.get(j).SavasDegeriGetir())//Kimin puanı yüksekse kazanır. i
	                        {
	                            Kazanan(koloniler,i,j);
	                        }
	                        else if(koloniler.get(i).SavasDegeriGetir()<koloniler.get(j).SavasDegeriGetir()) //j
	                        {
	                        	Kazanan(koloniler,j,i);
	                        }
	                        else if(koloniler.get(i).SavasDegeriGetir()==koloniler.get(j).SavasDegeriGetir() && Integer.parseInt(koloniler.get(i).PopulasyonGetir())!=Integer.parseInt(koloniler.get(j).PopulasyonGetir()))//Berabere kalma durumunda popülasyona bakılır.
	                        {
	                            if(Integer.parseInt(koloniler.get(i).PopulasyonGetir())>Integer.parseInt(koloniler.get(j).PopulasyonGetir())){ //i
	                            	Kazanan(koloniler,i,j);
	                            }
	                            else{ //j
	                            	Kazanan(koloniler,j,i);
	                            }
	                        }
	                        else//popülasyonlar da eşitse rastgele biri kazanır.
	                        {
	                            if(koloniler.get(i).SavasDegeriGetir()%2==0){ //i
	                            	Kazanan(koloniler,i,j);
	                            }
	                            else{ //j
	                            	Kazanan(koloniler,j,i);
	                            }
	                            
	                        }
	                    }
	                }
	            }
	        }
	        
	        Kontrol(koloniler);
	        //URETİM
	        for (int i = 0; i < koloniler.size(); i++)
	        {
	            if (koloniler.get(i).PopulasyonGetir()!="--")//Rastgele bir üretim tekniği ile üretim yapılır.
	            {
	                if(i%2==0){
	                    Auretim.Uret(koloniler.get(i));
	                }
	                else{
	                	Buretim.Uret(koloniler.get(i));
	                }
	                //TUR SONU
	                koloniler.get(i).TurSonu();
	            }
	        }
	        Kontrol(koloniler);
	        ekran.TurYazdir(turSayisi, koloniler, aktifKoloniSayisi);
	        if(this.aktifKoloniSayisi<=1) break;
	    } 
	}

	public void Kontrol(ArrayList<Koloni> koloniler) {//Kolonilerin Hayatta olup olmadığını kontrol eder.
		for (int i = 0; i < koloniler.size(); i++)
	    {
	        if (koloniler.get(i).PopulasyonGetir()!="--"){
	            if(Integer.parseInt(koloniler.get(i).PopulasyonGetir()) <=0 ||Integer.parseInt(koloniler.get(i).YemekStoguGetir()) <=0  ){
	                koloniler.get(i).PopulasyonBitir();
	                koloniler.get(i).YemekStoguBitir();
	                koloniler.get(i).KazanmaBitir();
	                koloniler.get(i).KaybetmeBitir();
	                this.aktifKoloniSayisi--;
	            }
	        }
	           
	    }
	}
	public void Kazanan(ArrayList<Koloni> koloniler,int i,int j) {//Bu sıralamada i kazanan, j kaybeden
		int oran = (koloniler.get(i).SavasDegeriGetir()-koloniler.get(j).SavasDegeriGetir())/10;
	    int yagmalananStok;
	    koloniler.get(j).PopulasyonAzalt(oran);
	    yagmalananStok = Integer.parseInt(koloniler.get(j).YemekStoguGetir())*oran/100;
	    koloniler.get(j).YemekStoguAzalt(oran);
	    koloniler.get(i).YemekStoguArttir(yagmalananStok);
	    koloniler.get(i).Kazan();
	    koloniler.get(j).Kaybet();
	}
}
