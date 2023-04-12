import java.io.*;
class print
{
	public void func(int a[]) {
	
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+ " ");

	}
}
public class IO {
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
		
		System.out.print("Enter the length of array: ");
		int n=Integer.parseInt(br.readLine());
		
		int a[]=new int[n];
		System.out.print("Enter Nos: ");
		for(int i=0;i<n;i++)
			a[i]=Integer.parseInt(br.readLine());
		
		print obj=new print();
		obj.func(a);
	}

}
