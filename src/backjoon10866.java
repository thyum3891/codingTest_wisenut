import java.io.*;
import java.util.*;

public class backjoon10866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine()," ");

        int a = Integer.parseInt(str.nextToken());
        Deque<String> deq = new ArrayDeque<>();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < a; i++) {
            String[] result = br.readLine().split(" ");
            String cmd = result[0];
            switch (cmd) {
                case "push_back" :
                    deq.offerLast(result[1]);
                    break;
                case "push_front" :
                    deq.offerFirst(result[1]);
                    break;
                case "pop_front" :
                    if(deq.isEmpty()){
                        bw.write("-1"+"\n");
                    }else{
                        bw.write(deq.pollFirst()+"\n");
                    }

                    break;
                case "pop_back" :
                    if(deq.isEmpty()){
                        bw.write("-1"+"\n");
                    }else{
                        bw.write(deq.pollLast()+"\n");
                    }
                    break;
                case "size" :
                    bw.write(deq.size()+"\n");
                    break;
                case "empty" :
                    if(deq.isEmpty()){
                        bw.write("1\n");
                    }else{
                        bw.write("0\n");
                    }
                    break;
                case "front" :
                    if(deq.isEmpty()){
                        bw.write("-1"+"\n");
                    }else{
                        bw.write(deq.peekFirst()+"\n");
                    }
                    break;
                case "back" :
                    if(deq.isEmpty()){
                        bw.write("-1"+"\n");
                    }else{
                        bw.write(deq.peekLast()+"\n");
                    }
                    break;
            }

        }
        bw.flush();
        bw.close();
    }
}
