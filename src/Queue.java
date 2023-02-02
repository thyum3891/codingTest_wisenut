import java.io.*;
import java.util.StringTokenizer;


//정수를 저장하는 스택
public class Queue {

    static int location = -1;
    static int point = 0;
    static int size = 0;


    static int[] array = null;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine()," ");
        int a = Integer.parseInt(str.nextToken());
        array = new int[a];
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < a; i++) {
            String result = br.readLine();
            if(result.length() > 5){
                int num = Integer.parseInt(result.substring(5,result.length()));
                push(num);
                continue;
            }

            switch (result){
                case "pop":
                    bw.write(pop()+"\n");
                    break;
                case "size":
                    bw.write(size()+"\n");
                    break;
                case "empty":
                    bw.write(empty()+"\n");
                    break;
                case "front":
                    bw.write(front()+"\n");
                    break;
                case "back":
                    bw.write(back()+"\n");
                    break;
            }

        }
        bw.flush();
        bw.close();
    }

    private static void push(int num){
        location++;
        size++;
        array[location] = num;
    }
    public static int pop(){
        if(size > 0){
            size--;
            return array[point++];
        }
        else{
            return -1;
        }
    }

    private static int size(){
        return size;
    }

    public static int empty(){
        if(size > 0) return 0;
        else return 1;
    }

    public static int back(){
        if(size > 0) return array[location];
        else return -1;
    }
    public static int front(){
        if(size > 0) return array[point];
        else return -1;
    }

}