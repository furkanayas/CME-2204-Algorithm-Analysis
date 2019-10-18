import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.omg.Messaging.SyncScopeHelper;

import java.util.Scanner;

//import com.sun.java_cup.internal.runtime.Scanner;
//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;


public class Test {
	
	
	static void prinT(ArrayList<Player> players)
	{

		System.out.println("-  Name          Position Rating   Prices  PriceQuality");
		for (int i = 0; i < players.size(); i++) {
			
			System.out.println((i+1)+" . "+ players.get(i).getName() + " - " + players.get(i).getPosition() + " - "
					+ players.get(i).getRating() + " - "+ players.get(i).getPrices() + " - "+ players.get(i).getPriceQuality() + " - " + 
					players.get(i).getYerorder());
		}
	}
	
	static double biggestQualityRatioatPosition(int position, ArrayList<Double> qr, ArrayList<Integer> positions)
	{
		
		ArrayList<Double> attheposition = new ArrayList<Double>();
		
		
		for (int i = 0; i < qr.size(); i++)
		{
			if(positions.get(i) == position)
			{
				attheposition.add(qr.get(i));
			}
		}
		
		double biggest = -1;
		for (int i = 0; i < attheposition.size(); i++)
		{
			if(biggest <= attheposition.get(i))
			{
				biggest = attheposition.get(i);
			}
		}
		
		return biggest;
	}

	public static void main(String[] args) throws IOException {
	

		FileReader fileReader = new FileReader("input.txt");
		String line;

		BufferedReader br = new BufferedReader(fileReader);

		ArrayList<String> parts = new ArrayList<String>();
		int count = 0;
		while ((line = br.readLine()) != null) {
			parts.add(line);
    
		}

		br.close();

		String header = parts.get(0);
		parts.remove(0); // new list slide one left. List index can't be null.

		//Takım bilgileri 
		// bir satırda Yansı Hilal Çınaroğlu	1	88	10000 gibi 4 bilgi var
		//for (int i = 0; i < parts.size(); i++) {
			//System.out.println(parts.get(i));
		//}
		
		//Name Position Rating Price 
		
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> positions = new ArrayList<Integer>();
		ArrayList<Integer> ratings = new ArrayList<Integer>();
		ArrayList<Integer> prices = new ArrayList<Integer>();
		ArrayList<Double> pricequalityratio = new ArrayList<Double>();
		String[] test = new String[4];
		
		ArrayList<Player> marketplayers = new ArrayList<Player>();
		
		for (int i = 0; i < parts.size(); i++) {
			test = parts.get(i).split(" ");
			
			
			names.add(test[0]);
			positions.add(Integer.parseInt(test[1]));
			ratings.add(Integer.parseInt(test[2]));
			prices.add(Integer.parseInt(test[3]));
			pricequalityratio.add((double) (prices.get(i)/ratings.get(i)));
			
			Player add = new Player(test[0],Integer.parseInt(test[1]),
					Integer.parseInt(test[2]),Integer.parseInt(test[3]),(double) (prices.get(i)/ratings.get(i)));
			marketplayers.add(add);
		}

		//print
		//playermarket.printPlayers();
		// Position K players
		///playersatPosition(k);
		// Best quality if equal cheap one; (at this test values, there is no equals)
		//bestPlayeratPositionandCheapOne
		// Best Price Rate,  Higher rate one
		//bestPriceQualityPlayeratPositionAndHigherRatingOne
		// Best Price Rate,  Chepar one
		//bestPriceQualityPlayeratPositionAndCheaperOne
		//order position players to best PQ ratio and keep cheaps at top
		//orderdecreasingPlayerQualityRatio
		
		//Player p = playermarket.bestPriceQualityPlayeratPositionAndHigherRatingOne(k);
		//p.printPlayer();
		
		Market playermarket = new Market(marketplayers);
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please Enter Club Money : ");
		double money = scan.nextDouble();
			
		System.out.println("How many Positions Club need : ");
		int needpositions = scan.nextInt();
		
		System.out.println("How many Player Available : ");
		int ap = scan.nextInt();
	
		
		//TheAlgorithm.DynamicProgrammingAlgorithm(playermarket,money,needpositions,ap);
		TheAlgorithm.GreedyAlgorithm(playermarket,money,needpositions,ap);
		
		
		
		
		
		//TheAlgorithm.Algorithm(playermarket, needpositions, money);
		//TheAlgorithm.GreedyAlgorithm(playermarket, 27100, 3,4);
		
	
	
		//money like a backpack volume, we should use this volume smartly 
		
		// if money is enough , the best quality ratio gives us best but, if money is left, we can choose higher ratio
		
		// take all need positions, higher pricequarlity ratio, and choose best ratios firstly. Until we havent any money for
	// best PQ, than we choose next best PQ at left players. 
		
		//ArrayList<Player> deneme =  playermarket.orderdecreasingPlayerQualityRatio(1);
		

		//prinT(deneme);
		
		// en iyi ratio yu satın al, o poziyonu kapat, sonra kalanla en iyi ratio ya bak onu al sonra en iyi ratio ya bak
		// 
		
		
		
	}

}



















/**
 Amaç; Sözleşmesi serbest olan oyunculara ücretlerini ederek takıma almaya çalışıyoruz
 Kulüp bize X miktarda para sağlıyor ve K pozisyona oyuncu istiyor
 X in üstüne çıkmamız yasak
 X in altında kalarak, olabildiğince X e yakın harcayarak o pozisyonlara oyuncu alımı yapacağız
 
  1 oyuncu alacaksak, o fiyattaki en iyi oyuncuyu alırız
  2 oyuncu alacaksak, en iyi oyuncuların fiyatları toplamı limitimizi geçebilir.
  Fiyat performansı en yüksek 2 oyuncuyu alırsakta sorun olabilir çünkü, bir oyuncu biraz pahalı ama çok iyi olur
  diğeri biraz ucuz ama iyi olursa, bu iki iyiden daha iyi olabilir
  2 + 2 değil,  4 + 1 i amaçlayabiliriz. Bu nedenle sadece fiyat performans a göre seçemeyiz, farklı olasalıklar en 
  iyi sonucu verebiliyor olabilir
  10 farklı oyuncu almamız istendiğined bu olasılıkların sayısı oldukça artacaktır, bu olasalıklar arasından en iyisini
  bulmamızı sağlayacak bir Algoritma arıyoruz.
 
 * */





