import java.util.ArrayList;
import java.util.Collections;

import org.omg.Messaging.SyncScopeHelper;

public class TheAlgorithm {
	
	
	
	static void DynamicProgrammingAlgorithm(Market Marketallplayers, double Money, int K, int ap )
	{	
		ArrayList<Player> players = new ArrayList<Player>();
		ArrayList<Player> team = new ArrayList<Player>();
		
		for (int i = 1; i < K+1; i++)
		{
			//Test.prinT(Marketallplayers.playersatPosition(i));
			for (int j = 0; j < ap; j++) {			
			//System.out.println("i : "+ i +"j : "+j+ "   "+Marketallplayers.playersatPosition(i).get(j).getName());
			players.add(Marketallplayers.playersatPosition(i).get(j));
			}
			
		}
		
		int c = 1;
			for (int j = 0; j < players.size(); j++) {
								
				players.get(j).setYerorder(c);
				System.out.println(c);
				c++;
				if( c == (ap+1))
						c = 1;
			
			
			}
			
			//Test.prinT(players);
			
			int l = (int) Money;
			
			// 4 aşağı doğru, 5 sağa doğru
			// 4 satır 5 sutun
			int[][] DParr = new int[players.size()+1][l+1];
			
			for (int i = 0; i < DParr[0].length; i++) {
				DParr[0][i] = 0;
			}
			
			for (int i = 0; i < DParr.length; i++) {
				DParr[i][0] = 0;
			}
			
		
			// THE DP ALGORTIHM 
			
			
			
			
			
			
			double cost = 0;
			int ratings = 0;
			for (int i = 0; i < team.size(); i++) {
				
				cost = cost + team.get(i).getPrices();
				ratings = ratings + team.get(i).getRating();
			}
			
			System.out.println("\nDP results:");
			System.out.println("K:" + (K));
			System.out.println("N:" + (ap));
			System.out.println("Total rantings:" + ratings);
			System.out.println("Total cost:" + cost);
			System.out.println("Players:");
			for (int i = 0; i < team.size(); i++) {
				
				System.out.println((i+1)+" - "+ team.get(i).getName());
			}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	static void GreedyAlgorithm(Market Marketallplayers, double Money, int K, int ap)
	{
		//ArrayList<Player> allplayers = new ArrayList<Player>();
		ArrayList<Player> players = new ArrayList<Player>();
		ArrayList<Player> team = new ArrayList<Player>();

		
		
		
		// k 3 ise  1 2 ve 3 oyuncu alıyoruz.
		
		// bizden 4 oyuncu istiyorsa
		// önce 4 poziyonun en iyileri iyiden kötüye fiyatkalite sıralaması yaparız
		// en yüksek fiyat kaliteyi alırız, sonra yine en yüksek olanı alırız
		// para azaldığı için sırada bunu alamayacağımız için, 3. de paranın yettiği fiyatkaliteyi alırız
		// ve 4 te de aynı şekilde
		
		//bize istenen her pozisyonun fiyatkalite arrayleri lazım
		
	
		//Marketallplayers.playersatPosition(i).size()
			//Listeler en iyi PriceQuality olarak sıralanıyor, fiyata göre performansı en iyi olanlar üstte.
		
		for (int i = 1; i < K+1; i++)
		{
			//Test.prinT(Marketallplayers.playersatPosition(i));
			for (int j = 0; j < ap; j++) {			
			//System.out.println("i : "+ i +"j : "+j+ "   "+Marketallplayers.playersatPosition(i).get(j).getName());
			players.add(Marketallplayers.playersatPosition(i).get(j));
			}
			
		}
		//System.out.println("\n\n");
		//Test.prinT(players);
		players =  Marketallplayers.orderdecreasingPlayerQualityRatioWithList(players);
		//System.out.println("\n\n");
		Test.prinT(players);
		/*
		System.out.println("\n");
			for (int i = 1; i < K+1; i++)
			{
				for (int j = 0; j < ap; j++) {
					
				players.add(Marketallplayers.playersatPosition(i).get(j));
				System.out.println("i : "+ i +"j : "+j+ "   "+Marketallplayers.playersatPosition(K).get(j).getName());
				//players.add(Marketallplayers.orderdecreasingPlayerQualityRatio(i).get(j));
				//p[i-1][j] = Marketallplayers.orderdecreasingPlayerQualityRatio(i).get(j);				
				}
				
			}*/
			
			//Test.prinT(players);
			
			
			
			
			/// amaç en iyi fiyat performans oyuncusunu almak ve o poziyondaki herkesi listeden atmak
			// yeni 1. fiyat performans olanı almak
			// para yeni olana yetersiz gelirse o listede daha altlardan birini alıp buna istenen oyuncu sayısı kadar devam etmeke
			// listemizdeki en iyi oyuncuyu alıp, onun poziyonundaki tüm oyuncuları listeden atmalıyız
			// her oyuncu alıp liste temizledikten sonra en iyiler sıralanmalı
			// eğer 1. ye para yetmiyorsa en iyi 1.ler atılıp, 2. lere göre tekrar sıralanmalı
			// 
			
	
			//Test.prinT(players);
			
			//ArrayList<Player> temp = new ArrayList<Player>();
			int position = -1;
			int al = 0;
			int alınan = 0;
			double moneytemp = Money;
			boolean aldıkmı = false;
			System.out.println("\n\n"+Money+"\n");
			
			while(alınan != K) // k tane oyuncu seçilecek
			{
				if(Money < 0)
				{
					System.out.println("para bitti");
					break;
				}
				else
				{
				
				System.out.println(al +"  deneniyor  " +  players.get(al).getPosition() +"   "+ players.get(al).getName()+ "   "+ players.get(al).getPrices());
				double temp = Money;
				if(temp - players.get(al).getPrices() >= 0)
				{
				position = players.get(al).getPosition(); //en iyi alındı
				alınan++;
				aldıkmı = true;
				team.add(players.get(al)); 
				players.get(al).printPlayer();
				System.out.println(Money);// eklendi. Artık o pozisyondakiler listeden atılabilir
				Money = Money - players.get(0).getPrices();
				
				for (int l = 0; l < 10; l++)
				{				
				
				for (int j = 0; j < players.size(); j++)
				{
					if(players.get(j).getPosition() == position) // listedeki pozisyon eşitse at
					{
						players.remove(j);				
						
					}

				}
				
				
				}
				}
				else
				{
					if(aldıkmı == false)
					{
						al++;
						if(al == players.size())
						{
							break;
						}
					}
					else if(aldıkmı == true)
					{
						al = 0;
						aldıkmı = false;
					}
					
				}
				}
				//System.out.println("temp");
				//Test.prinT(temp);
				//System.out.println("players");
				//Test.prinT(players);
				
			}
			
			
			
			double cost = 0;
			int ratings = 0;
			for (int i = 0; i < team.size(); i++) {
				
				cost = cost + team.get(i).getPrices();
				ratings = ratings + team.get(i).getRating();
			}
			
			
			System.out.println("\nGreedy Approach results:");
			System.out.println("K:" + (K));
			System.out.println("N:" + (ap));
			System.out.println("Total cost:" + cost);
			System.out.println("Players:");
			for (int i = 0; i < team.size(); i++) {
				
				System.out.println((i+1)+" - "+ team.get(i).getName());
			}
			
			//Test.prinT(players);
		
		
		
	}
	


}

