import java.io.*;

class msort{
	public void merge(int a[], int l, int m,int r) {
		int n1=m-l+1;
		int n2=r-m;
		
		int L[]=new int[n1];
		int R[]=new int[n2];
		
        for (int i = 0; i < n1; ++i)
            L[i] = a[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = a[m +1+ j];
		
		int i=0,j=0,k=l;
		while(i<n1&&j<n2)
		{
			if(L[i]<=R[j])
			{
				a[k]=L[i];
				i++;
			}
			else 
			{
				a[k]=R[j];
				j++;
			}
			k++;
		}
		while(i<n1)
		{
			a[k]=L[i];
			i++;
			k++;
		}
		while(j<n2)
		{
			a[k]=R[j];
			j++;
			k++;
		}
	}
	public void sort(int a[], int l, int r)
	{
		if(l<r) {
			int m=l+(r-l)/2;
			sort(a,l,m);
			sort(a,m+1,r);
			
			merge(a,l,m,r);	
		}
		
	}
	public void print(int a[]) {
		
		System.out.print("Sorted Array: ");
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+ " ");

	}
}

public class MergeSort {
	public static void main(String args[])throws IOException{
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		
		System.out.println("Enter length: ");
		int n=Integer.parseInt(br.readLine());
		
		int a[]=new int[n];
		System.out.println("Enter Nos:");
		for(int i=0;i<n;i++)
			a[i]=Integer.parseInt(br.readLine());
		
		msort obj=new msort();
		obj.sort(a, 0, n-1);
		obj.print(a);
	}
}
//Time complexity : Nlog(N) (All cases)
//Auxiliary Space: O(n)
//In merge sort all elements are copied into an auxiliary array. So N auxiliary space is required for merge sort