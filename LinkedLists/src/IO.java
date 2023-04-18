import java.io.*;
class Node{
	int no;
	Node next;
}
public class IO {
	public
		Node head=new Node();
		Node temp=head;
		int c=0;
	public void input()throws IOException
	{
		BufferedReader br=new BufferedReader (new InputStreamReader (System.in));
		String choice;
		
		System.out.print("Enter Value: ");
		head.no=Integer.parseInt(br.readLine());
		c++;
		
		System.out.print("Do you want to add more nodes? (y/n): ");
		choice=br.readLine();
		//System.out.println(choice);
		while(choice.equals("Y")||choice.equals("y"))
		{
			head.next=new Node();
			head=head.next;
			
			System.out.print("\nEnter Value: ");
			head.no=Integer.parseInt(br.readLine());
			c++;
			
			System.out.print("Do you want to add more nodes? (y/n): ");
			choice=choice=br.readLine();
		}
		head.next=null;	
	}
	public void search()throws IOException
	{
		BufferedReader br=new BufferedReader (new InputStreamReader (System.in));
		head=temp;
		System.out.print("\n\nEnter Number to be searched: ");
		int target=Integer.parseInt(br.readLine());
		
		int z=0;
		while(head!=null)
		{
			if(head.no==target)
			{
				System.out.print("Number Found!");
				z++;
				break;
			}
			head=head.next;
		}
		if(z==0)
			System.out.print("Not Found!");
	}
	public void display()
	{
		head=temp;
		System.out.print("\nLinked List: ");
		while(head!=null)
		{
			
			System.out.print("\n"+head.no);
			head=head.next;
		}
		
	}
	public static void main(String []args)throws IOException
	{
		BufferedReader br=new BufferedReader (new InputStreamReader (System.in));
		
		IO obj=new IO();
		obj.input();
		obj.display();
		obj.search();
	}
}
