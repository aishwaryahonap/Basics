import java.io.*;
class nodes{
	int no;
	nodes next;
}
class linkedlists{
	nodes head=new nodes();
	nodes temp=head;
	int c=0;				
	
	public void input()throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Enter Value: ");
		head.no=Integer.parseInt(br.readLine());
		c++;
		
		System.out.print("Do you want to add more nodes? (y/n): ");
		String choice=br.readLine();
		
		while(choice.equals("Y")||choice.equals("y"))
		{
			head.next=new nodes();
			head=head.next;
			
			System.out.print("\nEnter Value: ");
			head.no=Integer.parseInt(br.readLine());
			c++;
			
			System.out.print("Do you want to add more nodes? (y/n): ");
			choice=choice=br.readLine();
		}
		head.next=null;				
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
	void insertAfterNode(int target, int N)
	{
		head=temp;
		int z=0;
		nodes address=new nodes();
		while(head!=null)
		{
			if(head.no==target)
			{
				address.next=head.next;
				head.next=new nodes();
				head=head.next;
				
				head.no=N;
				head.next=address.next;
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
		nodes h=new nodes();
		
		if(head.no==target) {		//inserting before head node
			h.no=N;
			h.next=head;
			
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
					h.next=head.next;
					head.next=h;
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
		int z=0;
		if(head.no==target) {		//deleting head
			temp=head.next;
			head=null;
			c--;
			z++;
			display();
		}
		else						//deleting other nodes
		{
			while(head.next.no!=target) {
				if(head.next.next==null) {
					System.out.print("Number Not Found!");
					break;
				}	
				head=head.next;
			}
			if(head.next.no==target) {
				head.next=head.next.next;
				c--;
				z++;
				display();		
			}		
		}
	}
	public void display()
	{
		head=temp;
		while(head!=null)
		{
			System.out.print("\n"+head.no);
			head=head.next;
		}
		
	}
}
public class InsertionDeletion {
	public static void main(String args[])throws IOException{
		BufferedReader br=new BufferedReader (new InputStreamReader (System.in));
		linkedlists obj=new linkedlists();
		
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
