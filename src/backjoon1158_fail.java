import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class backjoon1158_fail {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<Integer> list =new ArrayList<>();
    static int K = 0;
    // 1 2 4 5 6 7
    static int N = 0;
    public static void yosepuse(int startIndex) throws IOException {
        int index = startIndex;
        for(int i = 0 ; i<K;i++){
            if(list.size() <= ++index){
                index = 0;
            }
        }
        if (list.size() != N){
            bw.write(", ");
        }
        bw.write(list.remove(index)+ "");
        if(list.size() > 1){
            if(index >= list.size()) index = 0;
            yosepuse(index);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1])-1;

        // 1 2 3 4 5 6 7
        //

        for(int i = 1 ; i <= N;i++){
            list.add(i);
        }


        bw.write("<");
        yosepuse(0);

        bw.write(", "+list.get(0)+">");


        bw.flush();
        bw.close();

    }
}
