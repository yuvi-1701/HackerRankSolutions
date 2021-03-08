import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'possibleChanges' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY usernames as parameter.
     */

    public static List<String> possibleChanges(List<String> usernames) 
    {
        List<String> result = new ArrayList<String>();
        
        for(int i =0;i<usernames.size();i++)
        {
            String str = usernames.get(i);
            char ch[] = str.toCharArray();
            int flag=0;
            for(int j=0; j<str.length();j++)
            {
                for(int k =j+1; k<str.length();k++)
                {
                    if(ch[j]>ch[k])
                    {
                       flag=1;
                       break;
                    }
                }
                if(flag==1)
                {
                    break;
                }
            }
            if(flag==1)
            {
                result.add("YES");
            }
            else
            {
                result.add("NO");
            }
            
        }
        return result;
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int usernamesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> usernames = IntStream.range(0, usernamesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = Result.possibleChanges(usernames);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
