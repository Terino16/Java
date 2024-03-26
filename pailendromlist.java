import java.util.Scanner;

class Node{
    int val;
    Node next;
    public Node(int val)
    {
        this.val=val;
        this.next=null;
    }
}
public class pailendromlist {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Node temp=null; Node head=null;
        for(int i=0;i<n;i++)
        {
            int input=sc.nextInt();
            Node newnode=new Node(input);
            if(temp==null)
            {
                head=newnode;
                temp=newnode;
            }
            else
            {
                temp.next=newnode;
                temp=newnode;
            }
        }

        Node slow=head;
        Node fast=head;
        Node prev=head;
        while(fast!=null && fast.next!=null)
        {
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        Node r=null;
        if(n%2==0)
        r=reverse(slow);
        else
        r=reverse(slow.next);

        while(r!=null)
        {
            if(r.val!=head.val){System.out.println(false);break;}
            r=r.next;
            head=head.next;
        }
        System.out.println(true);

    }
    public static Node reverse( Node slow)
    {
        Node prev=null;
        while(slow!=null)
        {
            Node temp=slow.next;
            slow.next=prev;
            prev=slow;
            slow=temp;
        }
        return prev;
    }
}
