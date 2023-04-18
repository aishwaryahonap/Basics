import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class nod{
	int no;
	nod next;
	nod prev;
}
class Circularlinkedlists{
	public
	nod head=new nod();
	nod temp=head;
	nod back;
	int c=0;			//count number of nodes in linked list
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
			head.next=new nod();
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
	public void search(int target)throws IOException
	{

		head=temp;
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
	void insertAfterNode(int target, int N)
	{
		head=temp;
		int z=0;
		nod TEMP=new nod();
		while(head!=null)
		{
			if(head.no==target)
			{
				TEMP.next=head.next;
				TEMP.prev=head;
				head.next=new nod();
				head=head.next;
				
				head.no=N;
				head.next=TEMP.next;
				head.prev=TEMP.prev;
				
				if(head.next!=null)
					head.next.prev=head;
				else 
					back=head;
				z++;
				c++;
			}
			head=head.next;
		}
		if(z==0)
			System.out.print("Number Not Found!");
		else
			display();
	}
	void insertBeforeNode(int target, int N)throws NullPointerException
	{
		head=temp;
		int z=0,x=1;
		nod h=new nod();
		
		if(head.no==target) {		//inserting before head node
			h.no=N;
			h.next=head;
			h.prev=null;
			head.prev=h;
			
			temp=h;
			head=head.next;
			z++;
			c++;
		}
		else					//inserting before other nodes
		{
			while(x<c) {
				
				if((head.next).no==target) {
					h.no=N;
					h.prev=head;
					h.next=head.next;
					head.next=h;
					if(h.next!=null)
						h.next.prev=h;
					z++;
					c++;
					x++;
					break;	
				}
				head=head.next;
				x++;
			}
			
		}
		if(z==0)
			System.out.print("Number Not Found!");
		else
			display();
	}
	public void deletion(int target)throws NullPointerException {
		head=temp;
		int z=0,x=1;
		if(head.no==target) {		//deleting head
			temp=head.next;
			head.next.prev=null;
			head=null;
			c--;
			z++;
		}
		else						//deleting other nodes
		{
			while(x<c) {
				if(head.next.no==target) {
					if(head.next.next!=null)	//deleting nodes except head and last
					{
						head.next.next.prev=head;
						head.next=head.next.next;
					}
					else						//deleting last node
					{
						head.next=null;
						back=head;
					}
					c--;
					x--;
					z++;
					break;
				}
				head=head.next;
				x++;
			}		
		}
		if(z==0)
			System.out.print("Number Not Found!");
		else
		{
			System.out.print("\nNumber Deleted!");
			display();
		}
			
	}
	
}
public class InsertionDeletionCircular {
	public static void main(String args[])throws IOException{
		BufferedReader br=new BufferedReader (new InputStreamReader (System.in));
		Circularlinkedlists obj=new Circularlinkedlists();
		
		String choice="y";
		while(choice.equals("Y")||choice.equals("y"))
		{
			System.out.println("\nEnter 1 for creating linked list ");
			System.out.println("Enter 2 for displaying linked list ");
			System.out.println("Enter 3 for searching linked list ");
			System.out.println("Enter 4 for insert after a node ");
			System.out.println("Enter 5 for insert before a node ");
			System.out.println("Enter 6 for deleting a node ");
			System.out.print("Enter choice: ");
			int ch=Integer.parseInt(br.readLine());
			
			switch(ch){
			case 1: 
				obj.input();
				break;
			case 2: 
				obj.display();
				break;
			case 3: 
				System.out.print("\nEnter Number to be searched: ");
				int target=Integer.parseInt(br.readLine());
				obj.search(target);
				break;
			case 4: 
				System.out.print("\nEnter Number after which a new number is to be added: ");
				target=Integer.parseInt(br.readLine());
				
				System.out.print("\nEnter Number to be added: ");
				int N=Integer.parseInt(br.readLine());
				obj.insertAfterNode(target,N);
				break;
			case 5: 
				System.out.print("\nEnter Number before which a new number is to be added: ");
				target=Integer.parseInt(br.readLine());
				
				System.out.print("\nEnter Number to be added: ");
				N=Integer.parseInt(br.readLine());
				obj.insertBeforeNode(target,N);
				break;
			case 6: 
				System.out.print("\nEnter Number to be deleted: ");
				target=Integer.parseInt(br.readLine());

				obj.deletion(target);
				break;
			default:
				System.out.print("\nEnter correct choice!");
			}
			
			System.out.print("\n\nDo you want to continue? (y/n): ");
			choice=br.readLine();
		}
		
	}
}
