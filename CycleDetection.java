//https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/copy-from/203739092

package solution;
import java.util.*;
import java.io.*;

public class CycleDetection 
{
	static class SinglyLinkedListNode
	{
		public int data;
		public SinglyLinkedListNode next;
		
		public SinglyLinkedListNode(int nodeData)
		{
			this.data = nodeData;
			this.next = null;
		}
		
	}
	static class SinglyLinkedList
	{
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;
		
		public SinglyLinkedList()
		{
			head = null;
			tail = null;
		}
		
		public void insertNode(int nodeData)
		{
			SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);
			
			if(this.head == null)
			{
				this.head = node;
			}
			else
			{
				this.tail.next = node;
			}
			this.tail = node;
		}
	}
	public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException
	{
		while(node != null)
		{
			bufferedWriter.write(String.valueOf(node.data));
			
			node = node.next;
			
			if(node !=null)
			{
				bufferedWriter.write(sep);
			}
		}
	}
	// main logic of hasCycle in code ,
	//LOGIC
	//imagine 2 boys starts the race on linked list track
	//slower starts at start and faster starts next to first one. if faster covers 2 places at on loop and slower
	// covers only one place then if there is the cycle in the path then they will eventually 
	// collide at same place again then there will be cycle in the linked list otherwise not.
	// :) peas :)
	// 
	static boolean hasCycle(SinglyLinkedListNode head)
	{
		if(head==null)
		{
			return false;
		}
		SinglyLinkedListNode slow = head;
		SinglyLinkedListNode fast = head.next;
		
		while(fast!=null && fast.next!=null)
		{
			if(slow == fast)
			{
				return true;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
		
	}
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException
	{
	//	env OUTPUT_PATH = "C:\Users\Yuvraj Darekar\Desktop\HackerrankSolution\CycleDetection.java"
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("\"C:\\Users\\Yuvraj Darekar\\Desktop\\HackerrankSolution\\CycleDetection.java\"")));
		
		int tests = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		for(int testItr = 0; testItr < tests; testItr++)
		{
			int index = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			
			SinglyLinkedList llist = new SinglyLinkedList();
			
			int llistCount = scanner.nextInt();
			
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			for(int i =0; i< llistCount; i++)
			{
				int llistItem = scanner.nextInt();
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
				llist.insertNode(llistItem);
			}
			
			SinglyLinkedListNode extra = new SinglyLinkedListNode(-1);
			SinglyLinkedListNode temp = llist.head;
			
			for(int i = 0; i<llistCount; i++)
			{
				if(i == index)
				{
					extra = temp;
				}
				if(i!= llistCount-1)
				{
					temp = temp.next;
				}
			}
			temp.next = extra;
			
			boolean result = hasCycle(llist.head);
			
			bufferedWriter.write(String.valueOf(result ? 1 : 0));
			bufferedWriter.newLine();
		}
		
		bufferedWriter.close();
		
		scanner.close();
			
	}
}
