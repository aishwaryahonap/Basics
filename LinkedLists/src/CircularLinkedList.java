import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Nodess{
	int no;
	Nodess next;
	Nodess prev;
}
public class CircularLinkedList {
	public
		Nodess head=new Nodess();
		Nodess temp=head;
		Nodess back;
		int c=0;
	public void input()throws IOException
	{
		BufferedReader br=new BufferedReader (new InputStreamReader (System.in));
		String choice;
		
		System.out.print("Enter Value: ");
		head.no=Integer.parseInt(br.readLine());
		head.prev=null;
		c++;
		
		System.out.print("Do you want to add more nodes? (y/n): ");
		choice=br.readLine();

		while(choice.equals("Y")||choice.equals("y"))
		{
			head.next=new Nodess();
			head.next.prev=head;
			head=head.next;
			
			System.out.print("\nEnter Value: ");
			head.no=Integer.parseInt(br.readLine());
			c++;
			
			System.out.print("Do you want to add more nodes? (y/n): ");
			choice=choice=br.readLine();
		}
		head.next=null;	
		back=head;
		
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
		System.out.print("\nForward Traversal of Linked List:");
		while(head!=null)
		{
			System.out.print(" "+head.no);
			head=head.next;
		}
		head=back;
		System.out.print("\nBackward Traversal of Linked List:");
		while(head!=null)
		{
			System.out.print(" "+head.no);
			head=head.prev;
		}
		
	}
	public static void main(String []args)throws IOException
	{
		BufferedReader br=new BufferedReader (new InputStreamReader (System.in));
		
		CircularLinkedList obj=new CircularLinkedList();
		obj.input();
		obj.display();
		obj.search();
	}
}
