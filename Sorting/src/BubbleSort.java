import java.io.*;
class sort{
	
	public void func(int a[]) 
	{
		Boolean swapped;
		for(int i=0;i<a.length;i++)
		{
			swapped=false;
			for (int j=0;j<a.length-1-i;j++)	//At the end of the first parse, the largest no will be at the
			{									//end of the array. No need to compare it again in the second parse. Hence -i
				if(a[j]>a[j+1])	
				{
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
					swapped=true;
				}
			}
			if(swapped ==false)				//if swapped is false, that means no swapping has happened in the last parse.
				break;						//Hence array sorted

		}
		System.out.println("\nSorted Array: ");
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+ " ");
	}
}

public class BubbleSort {
	public static void main(String []args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter Length of array: ");
		int n=Integer.parseInt(br.readLine());
		
		int a[]=new int[n];
		
		System.out.println("Enter Nos: ");
		for(int i=0;i<n;i++)
			a[i]=Integer.parseInt(br.readLine());
		
		sort obj=new sort();
		obj.func(a);
		
	}

}
/*
Time Complexity: 
Worst and Average Case Time Complexity: O(N^2).
Best Case Time Complexity: O(N)
Auxiliary Space: O(1)  (i.e. the amount of memory that you use is constant and does not depend on the data that it is processing)
(Auxiliary Space: The extra space that is taken by an algorithm temporarily to finish its work)
*/