
import java.util.PriorityQueue;
import java.util.Scanner;

class Data
{
    int data;
    ListNode node;
    public Data(int data, ListNode node)
    {
        this.data=data;
        this.node=node;
    }
}

class ListNode{
    int val;
    ListNode next;
    public  ListNode(int val)
    {
        this.val=val;
        this.next=null;
    }
}

class mergekll {

    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of linked list");
        int n=sc.nextInt();
        ListNode lists[]=new ListNode[n];
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter size of LL 1");
            int s=sc.nextInt();ListNode head=null;ListNode prev=null;
            for(int j=0;j<s;j++)
            {
                int val=sc.nextInt();
                ListNode newnode=new ListNode(val);
                if(head==null)
                {
                    prev=newnode;
                    head=newnode;
                }
                else
                {
                    prev.next=newnode;
                    prev=newnode;
                }
            }
            lists[i]=head;
        }
        System.out.println(mergeKLists(lists).val);

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Data> q=new PriorityQueue<>((a, b) -> a.data - b.data);

        for(ListNode node:lists)
        if (node != null)
        q.add(new Data(node.val, node));

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (!q.isEmpty()) {
            Data f=q.poll();
            tail.next=f.node;
            tail=tail.next;
            if(f.node.next!=null)
            q.add(new Data(f.node.next.val, f.node.next));
        }
        return dummy.next;
    }


}