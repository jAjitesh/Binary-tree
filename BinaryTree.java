
import java.util.*;
public class BinaryTree {
	Node root;
	
	BinaryTree(int key){
		root = new Node(key);
	}
	BinaryTree(){
		root = null;
	}
	public static void inOrder(Node root){
		if(root != null){
			inOrder(root.left);
			System.out.print(root.key + " ");
			inOrder(root.right);
		}
	}
	// check with this recurrsion
	public static int height(Node root){
		 if (root == null)
	           return 0;
	        else
	        {
	            /* compute  height of each subtree */
	        	
	        	int lheight = height(root.left);
	        	
	            int rheight = height(root.right);
	             
	            /* use the larger one */
	            if (lheight > rheight)
	                return(lheight+1);
	            else return(rheight+1); 
	        }
	}
	
	public static void inOrderWithoutRec(Node root){
		if(root == null){
			return;
		}
		Node current = root;
		Stack<Node> s = new Stack<Node>();
		while(current != null){
			s.push(current);
			current = current.left;
		}
		while(!s.isEmpty()){
			System.out.print(s.peek().key+" ");
			current = s.pop().right;
			while(current != null){
				s.push(current);
				current = current.left;
			}
		}
		
	}
	
	public static void preOrderWithoutRec(Node root){
		if(root == null){
			return;
		}
		Node current = root;
		Stack<Node> s = new Stack<Node>();
		while(current != null){
			s.push(current);
			System.out.print(current.key+" ");
			current = current.left;
		}
		while(!s.isEmpty()){
			
			current = s.pop().right;
			
			while(current != null){
				s.push(current);
				System.out.print(current.key+" ");
				current = current.left;
				
			}
		}
		
	}
	
	public static void levelOrder(Node root){
		Queue<Node> q = new LinkedList<Node>();
		Node current = root;
		q.add(current);
		while(!q.isEmpty()){
			System.out.print(q.peek().key+" ");
			if(q.peek().left != null){
			q.add(q.peek().left);
			}
			if(q.peek().right != null){
				q.add(q.peek().right);	
			}
			q.poll();
			current = q.peek();
		}
	}
	
// printing level order on each line
	public static void levelOrderLine(Node root){
		Queue<Node> q = new LinkedList<Node>();
		Node current = root;
		q.add(current);
		
		while(true){
		int level = q.size();
		if(level == 0){
			break;
		}
		while(!q.isEmpty() && level >0){
			System.out.print(q.peek().key+" ");
			if(q.peek().left != null){
			q.add(q.peek().left);
			}
			if(q.peek().right != null){
				q.add(q.peek().right);	
			}
			q.poll();
			current = q.peek();
			level--;
		}
		System.out.println();
		}
	}
	
	public static void main(String[] args){
	BinaryTree tree = new BinaryTree();
	tree.root = new Node(1);
	tree.root.left = new Node(2);
	tree.root.left.left = new Node(4);
	tree.root.left.right = new Node(5);
	tree.root.right = new Node(3);
	tree.root.right.right = new Node(6);
	tree.root.right.right.left = new Node(8);
	tree.root.right.right.right = new Node(10);
	inOrder(tree.root);
	System.out.print("\n");
	levelOrder(tree.root);
	System.out.print("\n");
	//height(tree.root);
	levelOrderLine(tree.root);
	inOrderWithoutRec(tree.root);
	System.out.print("\n");
	preOrderWithoutRec(tree.root);
	}
}
