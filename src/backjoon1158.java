import java.io.*;
import java.util.*;
import java.util.Queue;

public class backjoon1158 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int K = 0;
    // 1 2 4 5 6 7
    static int N = 0;
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1 ; i <= N;i++){
            queue.offer(i);
        }
        bw.write("<");
        while (queue.size() != 1){
            for(int i = 1 ; i < K;i++){
                queue.offer(queue.poll());
            }

            bw.write(queue.poll()+", ");
        }
        bw.write(queue.poll()+">");


        bw.flush();
        bw.close();

    }
}
