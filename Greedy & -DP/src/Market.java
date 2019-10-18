import java.util.ArrayList;
import java.util.Collection;

public class Market {

	ArrayList<Player> players = new ArrayList<Player>();

	public Market(ArrayList<Player> players) {
		this.players = players;
	}
	
	
	void printPlayers()
	{
		System.out.println("-  Name          Position Rating   Prices  PriceQuality");
		for (int i = 0; i < players.size(); i++) {
			
			System.out.println((i+1)+" . "+ players.get(i).getName() + " - " + players.get(i).getPosition() + " - "
					+ players.get(i).getRating() + " - "+ players.get(i).getPrices() + " - "+ players.get(i).getPriceQuality());
		}
	}
	
	
	ArrayList<Player> playersatPosition(int position)
	{
		ArrayList<Player> ret = new ArrayList<Player>();
		for (int i = 0; i < players.size(); i++) {
			if(players.get(i).getPosition() == position)
			{
				ret.add(players.get(i));
			}
		}
		
		return ret;		
	}

	
	

	
	ArrayList<Player> orderRatio(int position)
	{
		
ArrayList<Player> takeatposition = playersatPosition(position);
		
		
		
		for (int i = 0; i < takeatposition.size()-1; i++) { //Dizimizin değerlerini sırası ile alıyoruz
			 
            Player sayi = takeatposition.get(i); //sıradaki değeri sayi değişkenine atıyoruz
            int temp = i; //sayi 'nin indeksini temp değerine atıyoruz
 
            for (int j = i+1; j < takeatposition.size() ; j++) { //dizimizde i' den sonraki elemanlara bakıyoruz
                if(takeatposition.get(j).getRating() < sayi.getRating()){ //sayi değişkeninden küçük sayı var mı
                    sayi = takeatposition.get(j); //varsa sayi değişkenimizide değiştiriyoruz
                    temp = j; //indeks değerinide değiştiriyoruz
                }
            }
 
            if(temp != i){ //temp değeri başlangıç değeri ile aynı değil ise , yani list[i]'nin değerinden küçük sayı varsa onları yer değiştiriyoruz
            	takeatposition.set(temp, takeatposition.get(i));
            	takeatposition.set(i, sayi);
            }
 
        }
		
		
		//eşit PQ larda fiyatı düşük olan üstte olmalı
		
		int k = 0;
		for (int i = 1; i < takeatposition.size(); i++,k++) {
			
			if(takeatposition.get(k).getRating() == takeatposition.get(i).getRating())
			{
				if(takeatposition.get(k).getPrices() > takeatposition.get(i).getPrices())
				{
					Player temp = takeatposition.get(k);
					Player temp2 = takeatposition.get(i);
					
					takeatposition.set(k, temp2);
					takeatposition.set(i, temp);
					
				}
			}
			
			
		}
	
		return takeatposition;
        
		
	}
	
	ArrayList<Player> orderPrice(int position)
	{
		
ArrayList<Player> takeatposition = playersatPosition(position);
		
		
		
		for (int i = 0; i < takeatposition.size()-1; i++) { //Dizimizin değerlerini sırası ile alıyoruz
			 
            Player sayi = takeatposition.get(i); //sıradaki değeri sayi değişkenine atıyoruz
            int temp = i; //sayi 'nin indeksini temp değerine atıyoruz
 
            for (int j = i+1; j < takeatposition.size() ; j++) { //dizimizde i' den sonraki elemanlara bakıyoruz
                if(takeatposition.get(j).getPrices() < sayi.getPrices()){ //sayi değişkeninden küçük sayı var mı
                    sayi = takeatposition.get(j); //varsa sayi değişkenimizide değiştiriyoruz
                    temp = j; //indeks değerinide değiştiriyoruz
                }
            }
 
            if(temp != i){ //temp değeri başlangıç değeri ile aynı değil ise , yani list[i]'nin değerinden küçük sayı varsa onları yer değiştiriyoruz
            	takeatposition.set(temp, takeatposition.get(i));
            	takeatposition.set(i, sayi);
            }
 
        }
		
		
		//eşit PQ larda fiyatı düşük olan üstte olmalı
		
		int k = 0;
		for (int i = 1; i < takeatposition.size(); i++,k++) {
			
			if(takeatposition.get(k).getPrices() == takeatposition.get(i).getPrices())
			{
				if(takeatposition.get(k).getRating() > takeatposition.get(i).getRating())
				{
					Player temp = takeatposition.get(k);
					Player temp2 = takeatposition.get(i);
					
					takeatposition.set(k, temp2);
					takeatposition.set(i, temp);
					
				}
			}
			
			
		}
	
		return takeatposition;
        
		
	}
	
	ArrayList<Player> orderdecreasingPlayerQualityRatio(int position)
	{
		
		ArrayList<Player> takeatposition = playersatPosition(position);
		
		
		
		for (int i = 0; i < takeatposition.size()-1; i++) { //Dizimizin değerlerini sırası ile alıyoruz
			 
            Player sayi = takeatposition.get(i); //sıradaki değeri sayi değişkenine atıyoruz
            int temp = i; //sayi 'nin indeksini temp değerine atıyoruz
 
            for (int j = i+1; j < takeatposition.size() ; j++) { //dizimizde i' den sonraki elemanlara bakıyoruz
                if(takeatposition.get(j).getPriceQuality() > sayi.getPriceQuality()){ //sayi değişkeninden küçük sayı var mı
                    sayi = takeatposition.get(j); //varsa sayi değişkenimizide değiştiriyoruz
                    temp = j; //indeks değerinide değiştiriyoruz
                }
            }
 
            if(temp != i){ //temp değeri başlangıç değeri ile aynı değil ise , yani list[i]'nin değerinden küçük sayı varsa onları yer değiştiriyoruz
            	takeatposition.set(temp, takeatposition.get(i));
            	takeatposition.set(i, sayi);
            }
 
        }
		
		
		//eşit PQ larda fiyatı düşük olan üstte olmalı
		
		int k = 0;
		for (int i = 1; i < takeatposition.size(); i++,k++) {
			
			if(takeatposition.get(k).getPriceQuality() == takeatposition.get(i).getPriceQuality())
			{
				if(takeatposition.get(k).getPrices() > takeatposition.get(i).getPrices())
				{
					Player temp = takeatposition.get(k);
					Player temp2 = takeatposition.get(i);
					
					takeatposition.set(k, temp2);
					takeatposition.set(i, temp);
					
				}
			}
			
			
		}
	
		return takeatposition;
		
		
		
	}
	
	Player bestPlayeratPositionandCheapOne(int position)
	{
		Player ret = new Player();
		ArrayList<Player> takeatposition = playersatPosition(position);	
	
		ArrayList<Player> bests = new ArrayList<Player>();
		
		
		int rating = -1;
		for (int i = 0; i < takeatposition.size(); i++) {
			if(rating < takeatposition.get(i).getRating())
			{
				rating = takeatposition.get(i).getRating();
				ret = takeatposition.get(i);
			}
		}
	
		
		for (int i = 0; i < takeatposition.size(); i++) 
		{
			if(rating == takeatposition.get(i).getRating())
			{
				ret = takeatposition.get(i);
				bests.add(ret);
			}
		}
	
		
		int price = Integer.MAX_VALUE;
		
		
		for (int i = 0; i < bests.size(); i++) 
		{
			if(price > bests.get(i).getRating())
			{
				price = bests.get(i).getRating();
				ret = bests.get(i);
			}
		}
		
		return ret;
		
	}
	
	
	
	
	Player bestPriceQualityPlayeratPositionAndHigherRatingOne(int position)
	{
		Player ret = new Player();
		ArrayList<Player> takeatposition = playersatPosition(position);	
		ArrayList<Player> bests = new ArrayList<Player>();
		
		double pricequality = -1;
		for (int i = 0; i < takeatposition.size(); i++) {
			if(pricequality <= takeatposition.get(i).getPriceQuality())
			{
				pricequality = takeatposition.get(i).getPriceQuality();
				ret = takeatposition.get(i);
			}
		}
		
		for (int i = 0; i < takeatposition.size(); i++) 
		{
			if(pricequality == takeatposition.get(i).getPriceQuality())
			{
				
				ret = takeatposition.get(i);
				bests.add(ret);
			}
		}
		
		double rate = 0.0;
		
		
		for (int i = 0; i < bests.size(); i++) 
		{
			if(bests.get(i).getRating() > rate)
			{
				rate = bests.get(i).getRating();
				ret = bests.get(i);
			}
		}
		
		return ret;
		
	}
	
	Player bestPriceQualityPlayeratPositionAndCheaperOne(int position)
	{
		Player ret = new Player();
		ArrayList<Player> takeatposition = playersatPosition(position);	
		ArrayList<Player> bests = new ArrayList<Player>();
		
		double pricequality = -1;
		for (int i = 0; i < takeatposition.size(); i++) {
			if(pricequality <= takeatposition.get(i).getPriceQuality())
			{
				pricequality = takeatposition.get(i).getPriceQuality();
				ret = takeatposition.get(i);
			}
		}

		for (int i = 0; i < takeatposition.size(); i++) 
		{
			if(pricequality == takeatposition.get(i).getPriceQuality())
			{
				
				ret = takeatposition.get(i);
				bests.add(ret);
			}
		}

		int price = Integer.MAX_VALUE;
		
		
		for (int i = 0; i < bests.size(); i++) 
		{
			if(bests.get(i).getPrices() < price)
			{
				price = bests.get(i).getPrices();
				ret = bests.get(i);
			}
		}
		
		return ret;
		
	}
	
	
 //********
	
	
	
	Player CheapestatthePosition(int position)
	{
		
		Player ret = new Player();
		ArrayList<Player> takeatposition = playersatPosition(position);
		double price = 100000;
		
		for (int i = 0; i < takeatposition.size(); i++)
		{
			if(price > takeatposition.get(i).getPrices())
			{
				price = takeatposition.get(i).getPrices();
				ret =  takeatposition.get(i);
			}
		}
		
		return ret;
		
	}
	
	//can be static
	ArrayList<Player> orderdecreasingPlayerQualityRatioWithList(ArrayList<Player> takeatposition)
	{
		
		
		
		
		for (int i = 0; i < takeatposition.size()-1; i++) { //Dizimizin değerlerini sırası ile alıyoruz
			 
            Player sayi = takeatposition.get(i); //sıradaki değeri sayi değişkenine atıyoruz
            int temp = i; //sayi 'nin indeksini temp değerine atıyoruz
 
            for (int j = i+1; j < takeatposition.size() ; j++) { //dizimizde i' den sonraki elemanlara bakıyoruz
                if(takeatposition.get(j).getPriceQuality() > sayi.getPriceQuality()){ //sayi değişkeninden küçük sayı var mı
                    sayi = takeatposition.get(j); //varsa sayi değişkenimizide değiştiriyoruz
                    temp = j; //indeks değerinide değiştiriyoruz
                }
            }
 
            if(temp != i){ //temp değeri başlangıç değeri ile aynı değil ise , yani list[i]'nin değerinden küçük sayı varsa onları yer değiştiriyoruz
            	takeatposition.set(temp, takeatposition.get(i));
            	takeatposition.set(i, sayi);
            }
 
        }
		
		
		//eşit PQ larda fiyatı düşük olan üstte olmalı
		
		int k = 0;
		for (int i = 1; i < takeatposition.size(); i++,k++) {
			
			if(takeatposition.get(k).getPriceQuality() == takeatposition.get(i).getPriceQuality())
			{
				if(takeatposition.get(k).getPrices() > takeatposition.get(i).getPrices())
				{
					Player temp = takeatposition.get(k);
					Player temp2 = takeatposition.get(i);
					
					takeatposition.set(k, temp2);
					takeatposition.set(i, temp);
					
				}
			}
			
			
		}
	
		return takeatposition;
		
		
		
	}
}




























