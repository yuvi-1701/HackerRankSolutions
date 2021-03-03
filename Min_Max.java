import java.util.*;
public class FirstProgram1
{
	public static void main(String args[])
	{
		int size;
		int temp,temp1;
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter size of an Array");
		size = sc.nextInt();
		
		int[] ar = new int[size];
		
		System.out.println("Enter elements in an  array:");
		
		for(int i =0; i<size; i++)
		{
			ar[i] = sc.nextInt();
		}
		
		 temp = ar[size-1];
		for(int i =size-1; i>= 0; i--)
		{
				
			if (temp<ar[i])
			{
				temp = ar[i];
			}
		}
		
		 temp1 = ar[size-1];
			for(int i =size-1; i>= 0; i--)
			{
					
				if (temp1>ar[i])
				{
					temp1 = ar[i];
				}
			}
			
		System.out.println("Max of elements are: "+ temp);
		
		System.out.println("min of elements are: ");
		
	}
}