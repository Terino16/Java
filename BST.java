
public class BST {


static class Node {
    int value;
    Node left;
    Node right;

    public  Node(int v)
    {
        this.value=v;
    }
}

public static  Node root;

public Node insert(int n) {
    root = insert(root, n);
    return root;
}

    public Node insert(Node node,int n)
    {
        Node newnode=new Node(n);
        if(node==null)
        return newnode;

        else if(n<node.value)
        node.left=insert(node.left,n);    

        else if (n>node.value)
        node.right=insert(node.right,n);

        return node;
       
    }
    public void display(Node node, int level) {
        if (node == null)
            return;
        
        display(node.right, level + 1);
        for (int i = 0; i < level; i++)
            System.out.print("    ");
        System.out.println(node.value);
        display(node.left, level + 1);
    }

    public static void main(String[] args) {
        BST bst=new BST();
        if(root==null)
        bst.insert(10);

        bst.insert(4);
        bst.insert(2);
        bst.insert(9);
        bst.insert(8);
        bst.insert(56);
        bst.insert(32);


        bst.display(root,2);

    }



}
    
 

