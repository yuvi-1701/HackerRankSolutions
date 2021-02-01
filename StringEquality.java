package Practise;
import java.util.*;
class StringEquality
{
	static int[] matchingStrings(String[] strings, String[] queries)
	{
		Map<String, Integer> map = new HashMap<>();
		int result[] = new int[queries.length];
		
		for(int i =0; i < strings.length; i++)
		{
			String inputString = strings[i];
			if(map.containsKey(inputString))
			{
				map.put(inputString, map.get(inputString)+1);
			}
			else
			{
				map.put(inputString, 1);
			}
		}
		
		for(int i = 0 ; i < queries.length; i++)
		{
			String queryString = queries[i];
			if(map.containsKey(queryString))
			{
				result[i] = map.get(queryString);
			}
		}
		return result;
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int size1 = sc.nextInt();// size of Strings array
		
		String str[] = new String[size1];
		
		for(int i = 0 ; i < size1; i++)	
		{
			str[i] = sc.next();
		}
		int size2 = sc.nextInt();// Size of queries array
		
		String strQ[] = new String[size2];
		
		for(int i =0; i<size2;i++)
		{
			strQ[i] = sc.next();
		}
		int[] counter = matchingStrings(str, strQ);
		System.out.println(Arrays.toString(counter));
		sc.close();
	}
}
