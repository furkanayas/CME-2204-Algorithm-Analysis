import java.util.Arrays;
import java.util.Random;

public class SortingClass
{
	// Accessory methods
	
	//Swap
	
	//printTheArray
	
	public static void printTheArray(int[] arr)
	{
		for (int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println("-> ");
	}
	//controlTheArray
	public static void controltheArray(int[] arr)
	{
		System.out.println("Control Starting ----- *");
		
		boolean flag = true;
		for (int i = 0; i < arr.length-1; i++) {
			if(arr[i] > arr[i+1])
			{
				 flag = false;
			}
		}
		System.out.println("Control flag -> "+flag);
	}
	
	
	/*** HeapSort****************************************/
	public static void SortHeapto(int A[])
	{
	int size = A.length;
	for (int i = size / 2 - 1; i >= 0; i--)
	{
	    HeapSort(A, size, i);
	}
	for (int i=size-1; i>=0; i--)
	{
	    int temp = A[0];

	    A[0] = A[i];

	    A[i] = temp;
	    HeapSort(A, i, 0);
	}
	}
	public static void HeapSort(int[] A,int size,int parent)
	{
	int largest = parent;  
	int left = 2*parent + 1;   
	int right = 2*parent + 2;  

	if (left < size && A[left] > A[largest])
	    largest = left;
	if (right < size && A[right] > A[largest])
	    largest = right;
	if (largest != parent)
	{
	    int tempparent = A[parent];
	    A[parent] = A[largest];
	    A[largest] = tempparent;
	    HeapSort(A, size, largest);
	} 
	}


	
	/*** QuickFirstElement*******************************/
	public static void QuickSortFirstto(int A[])

	{

	QuickSortFirst(A, 0, A.length-1);

	}
	public static int[] QuickSortFirst(int[] list, int start, int end) {

	if (end - start <= 1) { //aynı yer veya arada eleman yoksa

	  return list; 

	}

	int pivot = split(list, start, end);   

	QuickSortFirst(list, start, pivot);

	QuickSortFirst(list, pivot + 1, end);

	return list;

	}

	private static int split(int[] list, int start, int end) {

	//Random rand = new Random();

//		int pla = rand.nextInt(end);

	//int place = list[start];

	//System.out.println(pla);

	int pivot = list[start];

	//System.out.println("pivot konumu :"+start+" değeri :"+ list[start]);

	/*for (int i = 0; i < list.length; i++) {

	System.out.print(" "+list[i]);

	}*/

//		System.out.println();

	int i = start;

	for (int j = start + 1; j <= end; j++) {

	  int current = list[j];

	  if (current < pivot) {

	    degis(list, i + 1, j);

	    i++;

	  }

	}

	degis(list, start, i);

	return i;

	}

	private static void degis(int[] list, int i, int j) {

	int temp = list[i];

	list[i] = list[j];

	list[j] = temp;

	}



	/*** QuickMiddle*******************************/
	public static void QuickSortMiddleto(int A[])

	{

		QuickSortMiddle(A, 0, A.length-1);

	}
	
	public static void QuickSortMiddle(int A[],int p, int r)

	{

	    int q;

	    if(p<r)

	    {

	        q=PartitionMiddle(A,p, r);

	        QuickSortMiddle(A,p, q-1);

	        QuickSortMiddle(A,q+1, r);

	    }

	}

	public static int PartitionMiddle(int A[],int p, int r){

	    int tmp;

	    int x = A[r];

	    int i = p-1;



	    for(int j=p; j<=r-1; j++)

	    {

	        if(A[j]<=x)

	        {

	            i++;

	            tmp=A[i];

	            A[i]=A[j];

	            A[j]=tmp;

	        }

	    }

	    tmp=A[i+1];

	    A[i+1]=A[r];

	    A[r]=tmp;

	   

	    return i+1;

	}



	/*** QuickLast*******************************/
	public static int[] QuickSortLastto(int[] array) {

	    //corner cases

	    if(array == null) return array;

	   

	    QuickSortLast(array, 0, array.length-1);

	    return array;

	  }

	public static void QuickSortLast(int[] array, int left, int right) {

	    if(left < right) {

	      //get pivot actual index and modify array base on pivot

	      int p = partitionLastPivot(array, left, right);

	     

	      //divide from pivot index to two halves and quicksort each half

	      QuickSortLast(array, left, p-1);

	      QuickSortLast(array, p+1, right);

	    }

	  }

	public static int partitionLastPivot(int[] array, int left, int right) {

	    int piv = array[right]; //pivot value (right most element)

	    int i =  left; //position the smaller (than pivot) values go until

	   

	    for(int j = left; j < right; j++) {

	      //if current value is less than pivot

	      //swap the value with value at a small-value-position

	      //set small-val-pos to the next position

	      if(array[j] < piv) {  

	        int temp = array[j];

	        array[j] = array[i];

	        array[i] = temp;

	        i++;

	      }

	      //if not, do nothing

	    }

	    //switch the value after all the small values with pivot

	    //pivot goes after all the values smaller than it

	    array[right] = array[i];

	    array[i] = piv;

	 

	    return i;

	  }	
	
	
	/**Quick with random*/	
	public static void QuickSortRandomPivotto(int A[])
	{
		QuickSortRandomPivot(A,0,A.length-1);
	}

	public static void QuickSortRandomPivot(int A[], int p, int r) {

	      int index = randompartition(A, p, r);

	      if (p < index - 1)

	    	  QuickSortRandomPivot(A, p, index - 1);

	      if (index < r)

	    	  QuickSortRandomPivot(A, index, r);

	}
		
	public static int randompartition(int A[], int p, int r)

	{

	      int i = p, j = r;

	      int tmp;

	      Random rnd = new Random();

	      int pivot = A[p + rnd.nextInt(r - p)];



	     // System.out.println(pivot);

	      while (i <= j) {

	            while (A[i] < pivot)

	                  i++;

	            while (A[j] > pivot)

	                  j--;

	            if (i <= j) {

	                  tmp = A[i];

	                  A[i] = A[j];

	                  A[j] = tmp;

	                  i++;

	                  j--;

	            }

	      };



	      return i;

	}

	
	/*** MergeTwoParts*******************************/
	public static void MergeTwoPartsto(int[] A)

	{

	int length = A.length;

	MergeTwoParts(A,0, length - 1);

	}

	public static void MergeTwoParts(int[] A,int left,int right)

	{

	if (left < right)

	{

	int m = (left+right)/2;  

	        MergeTwoParts(A, left, m);	     

	        MergeTwoParts(A, m+1, right);

	        MergeForTwo(A, left, m, right);

	}

	}

	public static void  MergeForTwo(int A[], int l, int m, int r)

	{

	// mergeden gelen alt 2 arrayi belirleyelim

	  int n1 = m - l + 1;

	  int n2 = r - m;

	 

	  //Temp arrayleri oluşturalım 

	int L[] = new int [n1];

	int R[] = new int [n2];

	 

	 

	  //*Templeri verilerle dolduralım*/

	for (int i=0; i<n1; ++i)

	{

	L[i] = A[l + i];

	}

	for (int j=0; j<n2; ++j)

	{

	R[j] = A[m + 1+ j];

	}

	 

	 

	// Temp arrayleri merge yapalım

	 

	// i j 0 0

	  int i = 0, j = 0;

	 

	// birleştirmeye başlıyoruz

	int k = l;

	while (i < n1 && j < n2)

	{

	if (L[i] <= R[j])// r büyükse bu istenen durum, l yi direk yerien koyarız ve l yi +1 yaparız

	{

	A[k] = L[i]; //direk eşit

	i++;

	}

	else

	{

	A[k] = R[j]; // ama right raki değer büyükse i ye dokunmadan right j den alırız, r +1 yaparız

	j++;

	}

	k++;

	}

	 

	/*Test step

	for (int a = 0; a < L.length; a++) {

	 

	 	System.out.print(" "+L[a]);

	}

	 	System.out.println();

	 	for (int a = 0; a < R.length; a++) {

	 

	 	System.out.print(" "+R[a]);

	}

	 	System.out.println();

	 	System.out.println("//////////////////////");

	 	*/

	 

	// Left ve Right array artık

	// düzenlenmiş arrayden düzenli olarak doldurulabilir

	 	while (i < n1)

	 	{

	 	A[k] = L[i];

	 	i++;

	 	k++;

	 	}

	 

	//

	while (j < n2)

	{

	A[k] = R[j];

	j++;

	k++;

	} 

	/*Test step

	for (int a = 0; a < A.length; a++) {

	 

	 	System.out.print(" "+A[a]);

	}

	System.out.println();

	System.out.println("---------------");

	*/

	}

	void sort(int A[], int l, int r)

	{

	if (l < r)

	{

	// tekrar merge

	int m = (l+r)/2;

	 

	// left ve right

	sort(A, l, m);

	sort(A, m+1, r);

	 

	// burada mergeleniyor

	MergeForTwo(A, l, m, r);

	 	}

	 	}

	 
	/***InsertionSort*******************************/
	 public static void InsertionSortto(int[] A)
	 {
		 int n = A.length; 
	        for (int i = 1; i < n; ++i) { 
	            int key = A[i]; 
	            int j = i - 1; 
	  
	            /* Move elements of arr[0..i-1], that are 
	               greater than key, to one position ahead 
	               of their current position */
	            while (j >= 0 && A[j] > key) { 
	                A[j + 1] = A[j]; 
	                j = j - 1; 
	            } 
	            A[j + 1] = key; 
	        }
	 }

	 
	/***RadixSort*******************************/
	 
	 
	   static void RadixSortto(int[] A)
	   {
		   getMax(A,A.length-1);
	   } 
	   static int getMax(int arr[], int n) 
	    { 
	        int mx = arr[0]; 
	        for (int i = 1; i < n; i++) 
	            if (arr[i] > mx) 
	                mx = arr[i]; 
	        return mx; 
	    } 
	  
	    // A function to do counting sort of arr[] according to 
	    // the digit represented by exp. 
	    static void countSort(int arr[], int n, int exp) 
	    { 
	        int output[] = new int[n]; // output array 
	        int i; 
	        int count[] = new int[10]; 
	        Arrays.fill(count,0); 
	  
	        // Store count of occurrences in count[] 
	        for (i = 0; i < n; i++) 
	            count[ (arr[i]/exp)%10 ]++; 
	  
	        // Change count[i] so that count[i] now contains 
	        // actual position of this digit in output[] 
	        for (i = 1; i < 10; i++) 
	            count[i] += count[i - 1]; 
	  
	        // Build the output array 
	        for (i = n - 1; i >= 0; i--) 
	        { 
	            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i]; 
	            count[ (arr[i]/exp)%10 ]--; 
	        } 
	  
	        // Copy the output array to arr[], so that arr[] now 
	        // contains sorted numbers according to curent digit 
	        for (i = 0; i < n; i++) 
	            arr[i] = output[i]; 
	    } 
	  
	    // The main function to that sorts arr[] of size n using 
	    // Radix Sort 
	    static void radixsort(int arr[], int n) 
	    { 
	        // Find the maximum number to know number of digits 
	        int m = getMax(arr, n); 
	  
	        // Do counting sort for every digit. Note that instead 
	        // of passing digit number, exp is passed. exp is 10^i 
	        // where i is current digit number 
	        for (int exp = 1; m/exp > 0; exp *= 10) 
	            countSort(arr, n, exp); 
	    }

	    /***QuickSort MidOfFirstMidLast Element*******************************/
	    public static void QuickMFMLDynamicto(int A[])
	    {
	    int state = MFMLDynamic(A, 0, A.length-1);
	    if(state == 0)
	    {
	    QuickSortFirstto(A);
	    }
	    else if(state == 1)
	    {
	    QuickSortMiddleto(A);
	    }
	    else if(state == 2)
	    {
	    QuickSortLastto(A);
	    }
	    


	    }
	    static int MFMLDynamic(int[] A,int p,int r)

	    {



	    int pivot = 0;

	    int first = A[p];

	    int middle = 0;

	    int last = A[r];

	    int state = -1;

	    //0 first 1middle 2 last

	    //12345 index 2 = 3

	    //123456 index 2 = 3 

	    if(r-p % 2 == 0)

	    {

	    middle = A[  p+ ((r-p-1)/2)];

	    }

	    else

	    {

	    middle = A[  p+ ((r-p)/2)];

	    }

	    int dumbarr[] = new int[] {first, middle, last};

	    int biggest = Integer.MIN_VALUE;

	    int lowest = Integer.MAX_VALUE;

	    for (int i = 0; i < dumbarr.length; i++) {

	    if(dumbarr[i] >= biggest)

	    {

	    biggest = dumbarr[i];

	    }

	    if(dumbarr[i] <= lowest)

	    {

	    lowest = dumbarr[i];

	    }

	    }

	    for (int i = 0; i < dumbarr.length; i++)

	    {

	    if(dumbarr[i] != biggest && dumbarr[i] != lowest)

	    {

	    pivot = dumbarr[i];

	    }

	    }


	 //   System.out.println("pivot :" +pivot);

	 //   System.out.println("first : " + first + "  middle :" + middle + "  last  : " + last );


	    if(pivot == first)

	    {

	    state = 0;

	    }

	    else if(pivot == middle)

	    {

	    state = 1;

	    }

	    else if(pivot == last)

	    {

	    state = 2;

	    }

	    return state;

	    }

	   

	    

	    /*
	     *  2 pivot var ilk ve sondaki
		// ilk sondakinden büyükse arrayde yer değiştirirler
		// bunun ardından ilkinden küçük olanlar onun önüne geçer
		// ikinciden büyük olanlarsa onun arkasına geçer
		// orta kısımda ilk ve ikincinin arasındaki sayılar rastgele dizilir
		//küçükler ve büyükler arrayinde de sayılar hala rastgeledir, tam bir sıralamaya sahip değillerdir
		// methodun kendini tekrar çağırması lazım
		// küçükler arrayi, bu kez bunun sonu ve ilki pivotlarıdır
		// ortancalar arrayi, yine ilki ve sonu pivotlarıdır
		// büyükler arrayi, yine ilki ve sonu pivotlarıdır
		// kritik nokta 3 array çevirmekte, bunu için 2 pivot değeri çevirmeli
		// ilk  orta-1  orta+1    orta2-1  orta 2+1 son
		// orta tek pivotta bir tane olduğu için rahatça alınabiliyor ama burada 2 farklı orta şeklinde pivot alınmalı
		
		//    123456789
		// 1 ve 9 la
		// 1 3  4 6  7 9 la pivotlanır
		// yani 3 ve 6 yı geri çevirmemiz gerekir.
		// kritik nokta array noktalarını doğru çevirmek, pivotlar zaten ilk ve son değerler.
		
		//  412359876 mantığında
		//  12345 6879  6879
		//  4 3 kere kaydığı için sol pivot budur
		// sağ ise gittiği yer 
		
		//pivotların gittiğin pozisyonlar yeni parçalama noktalarıdır
		 * 
		 * */




	    static void swap(int val1, int val2) 

	    { 

	    int temp = val1; 

	    val1 = val2; 

	    val2 = temp; 

	    } 

	    public static void QuickdoublePivotto(int[] A)

	    {int x = 0;
		while(control2(A) != true)
		{
			doublePivot(A,0,A.length-1);
			x++;
			
			if(x > 20)
			{
				break;
			}
			
		}

	    }

	    /*

	    * void DualPivotQuickSort(int* arr, int low, int high) 

	    { 

	        if (low < high) { 

	            // lp means left pivot, and rp means right pivot. 

	            int lp, rp;  

	            rp = partition(arr, low, high, &lp); 

	            DualPivotQuickSort(arr, low, lp - 1); 

	            DualPivotQuickSort(arr, lp + 1, rp - 1); 

	            DualPivotQuickSort(arr, rp + 1, high); 

	        } 

	    }

	    * */

	    public static void doublePivot(int[] A,int p,int r)

	    {

	    if(p<r)

	    {

	        int[] pivots = partitiondoublePivot(A, p, r);

	        int leftpivot = pivots[0];
	        int rightpivot = pivots[1];

	        doublePivot(A, p, leftpivot-1);
	        doublePivot(A, leftpivot+1, rightpivot-1);
	        doublePivot(A, rightpivot+1, r);

	    }

	    }



	    public static int[] partitiondoublePivot(int[] A, int p, int r) {



	    	int left = 0;
	    	int right = 0;
	        int pivotleft = A[p];

	        int pivotright = A[r]; //pivot value (right most element)



	        if(pivotleft > pivotright)

	        {

	        A[r] = pivotleft;

	        A[p] =  pivotright;

	        pivotleft =  A[p];

	        pivotright = A[r];

	        }



	        int i =  p; //position the smaller (than pivot) values go until



	        int k = r;

	        //  234567

	        //  428123

	        // 4    3

	        // 3    4

	       

	        //   2  j<7

	        int m = r;

	        for(int j = p; j < r; j++) 

	        {
	        	//23 8124
	        if(A[j] < pivotleft)

	        {
	        int temp = A[j];
	            A[j] = A[i];
	            //2

	            A[i] = temp;

	            i++;
	        }

	        // 8       4

	        if(A[j] > pivotright)

	        {

	        //  8

	        int temp = A[j];



	        //4

	            A[j] = A[m];



	            //8

	            A[m] = temp;



	            m--;

	        }
	        
	        
	        
	        if( pivotleft <= A[j] && A[j] <= pivotright)
	        {
	        	//nothing
	        }
	       
	        
	        }
	    // 413798
	        // 143798
	        //134798
	        //1234789
	        

	        

	       //i++;
	        int[] ret = new int[] {i,m};
	        
	        return ret;



	          }



	    static boolean control2(int[] arr)

	    {

	    System.out.println("kontrol");

	    boolean flag = true;

	    for (int i = 0; i < arr.length-1; i++) {

	    if(arr[i] > arr[i+1])

	    {

	    flag = false;

	    }

	    }

	    System.out.println("-> "+flag);

	    return flag;
	    }






	    /***QuickSort MidOfFirstMidLast Element*******************************/
	    public static void QuickMFMLStaticto(int A[])
	    {
	    int state = MFMLStatic(A, 0, A.length-1);

	    


	    }
	    static int MFMLStatic(int[] A,int p,int r)

	    {



	    int pivot = 0;

	    int first = A[p];

	    int middle = 0;

	    int last = A[r];

	    int state = -1;

	    //0 first 1middle 2 last

	    //12345 index 2 = 3

	    //123456 index 2 = 3 

	    if(r-p % 2 == 0)

	    {

	    middle = A[  p+ ((r-p-1)/2)];

	    }

	    else

	    {

	    middle = A[  p+ ((r-p)/2)];

	    }

	    int dumbarr[] = new int[] {first, middle, last};

	    int biggest = Integer.MIN_VALUE;

	    int lowest = Integer.MAX_VALUE;

	    for (int i = 0; i < dumbarr.length; i++) {

	    if(dumbarr[i] >= biggest)

	    {

	    biggest = dumbarr[i];

	    }

	    if(dumbarr[i] <= lowest)

	    {

	    lowest = dumbarr[i];

	    }

	    }

	    for (int i = 0; i < dumbarr.length; i++)

	    {

	    if(dumbarr[i] != biggest && dumbarr[i] != lowest)

	    {

	    pivot = dumbarr[i];

	    }

	    }


	 //   System.out.println("pivot :" +pivot);

	 //   System.out.println("first : " + first + "  middle :" + middle + "  last  : " + last );


	    if(pivot == first)

	    {

	    state = 0;

	    }

	    else if(pivot == middle)

	    {

	    state = 1;

	    }

	    else if(pivot == last)

	    {

	    state = 2;

	    }

	    return state;

	    }    
	    
	    
	    
	    
	    
	    
	    
	    



	    
}





























