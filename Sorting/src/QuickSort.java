import java.io.*;

class qsort{
	
	public int partition(int a[], int low, int high) {
		int pivot=high;
		int i=low;
		
		for(int j=low;j<=high;j++)
		{
			if(a[j]<a[pivot])
			{
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
				
				i++;
				
				//for(int z=low;z<=high;z++)
		        //    	System.out.print(a[z]+" ");
				//System.out.println();    
			}
		}
		int temp=a[i];
		a[i]=a[pivot];
		a[pivot]=temp;
		
		return i;
		
	}
	public void quick(int a[], int low,int high)
	{
		if(low<high) {
			int p=partition(a,low,high);
			quick(a,low, p-1);
			quick(a,p+1,high);
		}	
	}
	public void print(int a[]) {
		
		System.out.print("Sorted Array: ");
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+ " ");

	}
}

public class QuickSort {
	public static void main(String []args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter Length: ");
		int n=Integer.parseInt(br.readLine());
		
		int a[]=new int[n];
		System.out.println("Enter Nos: ");
		for(int i=0;i<n;i++)
			a[i]=Integer.parseInt(br.readLine());
		qsort obj=new qsort();
		obj.quick(a,0,n-1);
		obj.print(a);
		
	}

}
//Time Complexity: 
//avg and best:  O(nLogn)
//worst: O(N^2) 

//Auxiliary Space: O(n)
