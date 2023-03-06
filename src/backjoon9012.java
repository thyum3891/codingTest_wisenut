import java.io.*;
import java.util.*;

public class backjoon9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine()," ");

        int a = Integer.parseInt(str.nextToken());


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < a; i++) {
            boolean flag = true;
            String result = br.readLine();
            Stack<Character> stack = new Stack<>();
            for(int j = 0 ; j<result.length();j++){
                char ch = result.charAt(j);
                if(ch == '(') stack.add('(');
                else {
                    if(stack.size() > 0) {
                        stack.pop();
                    }else{
                        flag = false;
                        break;
                    }
                }

            }
            if(stack.size()>0)flag = false;
            if(flag){
                bw.write("YES\n");
            }else{
                bw.write("NO\n");
            }

        }
        bw.flush();
        bw.close();
    }
}
