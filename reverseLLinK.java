import java.util.Scanner;

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val)
    {
        this.val=val;
        this.next=null;
    }
}
public class reverseLLinK {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of LL");
        int n=sc.nextInt();
        ListNode prev=null;
        ListNode head=null;
        for(int i=0;i<n;i++)
        {
         int val=sc.nextInt();
         ListNode newnode=new ListNode(val);
         if(head==null)
         {
            head=newnode;
            prev=newnode;
         }
         else{
            prev.next=newnode;
            prev=newnode;
         }
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current=head;
        int count=0;

        while( current!=null && count!=k)
        {
            current=current.next;
            count++;
        }
        if(count==k)
        {
            current=reverseKGroup(current,k);
             while(count>0)
             {
              ListNode temp=head.next;
              head.next=current;
              current=head;
              head=temp;
              count--;
              }
              head=current;

        }
        return head;
    }
}
