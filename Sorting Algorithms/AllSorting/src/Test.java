import java.util.Random;

public class Test {


	
	static int[] createArray(int size,char type)
	{
		Random rand = new Random();
		int[] A = new int[size];
		
		
		if(type == 'e') //Equal
		{
			int thenumber = rand.nextInt(200)+1;
			for (int i = 0; i < size; i = i+10)
			{
				A[i] = A[i+1] = A[i+2] = A[i+3] = A[i+4] = A[i+5] = A[i+6] = A[i+7] = A[i+8] = A[i+9] = thenumber;
			}		
			return A;
		}
		else if(type == 'i') //IncreasingArray
		{
			for (int i = 0; i < size; i++)
			{
				A[i] = i+1;
			}		
			return A;
		}
		else if(type == 'd')
		{ //DecreasingArray
		
			int k = size;
			for (int i = 0; i < size; i++)
			{
				A[i] = k;
				k--;
			}		
			return A;
		}
		else if(type == 'r') //Random
		{
			for (int i = 0; i < size; i++)
			{
				A[i] = rand.nextInt(200)+1;
			}		
			return A;
		}
		else
		{
			System.out.println("Input Error");
			return null;
		}
	
	}
	

	public static void main(String[] args)
	{	
	// TODO Auto-generated method stub	
		
	//  1.000	10.000	100.000
	//	SortingClass sorts = new SortingClass();		
	//	a = createArray(50, 'e');	b = createArray(50, 'i');   c = createArray(50, 'd'); 	d = createArray(50, 'r');
    //              555555                 12345         				54321				28913
		//	printTheArray(arr);
		//	IntroSort.sort(arr);
		//SortingClass.QuickMFMLDynamicto(arr);
	
		long startTime,stopTime,elapsedTime;
		int[] arr =createArray(10000, 'e');

		startTime = System.nanoTime();

		//SortingClass.QuickMFMLDynamicto(arr);
		
		stopTime = System.nanoTime();
		elapsedTime = stopTime - startTime;
		System.out.println("The Sort System Running Time : " + (elapsedTime * Math.pow(10, 6)) + " milliseconds");



	}

}
