import java.util.Scanner;

class Node{
    int val;
    Node next;

    public  Node(int val)
    {
        this.val=val;
        this.next=null;
    }
}
public class merge2LL {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Node temp=null; Node head1=null;
        for(int i=0;i<n;i++)
        {
            int input=sc.nextInt();
            Node newnode=new Node(input);
            if(temp==null)
            {
                head1=newnode;
                temp=newnode;
            }
            else
            {
                temp.next=newnode;
                temp=newnode;
            }
        }
        int a=sc.nextInt();
         temp=null; Node head2=null;
        for(int i=0;i<a;i++)
        {
            int input=sc.nextInt();
            Node newnode=new Node(input);
            if(temp==null)
            {
                head2=newnode;
                temp=newnode;
            }
            else
            {
                temp.next=newnode;
                temp=newnode;
           
            }
        }

        Node one = head1;
        Node two = head2;
        int rem = 0;
        Node resultHead = null;
        Node current = null;
        while (one != null || two != null || rem != 0) {
            int d1 = one != null ? one.val : 0;
            int d2 = two != null ? two.val : 0;
            int sum = d1 + d2 + rem;
            rem = sum / 10;
            sum = sum % 10;

            Node newNode = new Node(sum);
            if (resultHead == null) {
                resultHead = newNode;
                current = newNode;
            } else {
                current.next = newNode;
                current = newNode;
            }

            if (one != null) one = one.next;
            if (two != null) two = two.next;
        }
        current=resultHead;
      
        System.out.println("Printing values");
        while(current!=null)
        {System.out.println(current.val);
        current=current.next;}
   
    
}
}