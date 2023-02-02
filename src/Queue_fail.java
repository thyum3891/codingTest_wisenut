import java.io.*;
import java.util.StringTokenizer;


public class Queue_fail {

    static int base = 100; //기본 배열
    static int up = 100; //배열이 꽉 찰시에 이 숫자만큼 증가시키기
    static int location = -1; //나중에 들어온 배열의 위치
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
//        if(location == array.length){
//            int[] temp = new int[location+up];
//            for(int i = 0; i < array.length;i++){
//                temp[i] = array[i];
//            }
//            array = temp;
//        }
        array[location] = num;
    }
    public static int pop(){
        int result = -1;
        if(location > -1){
            int[] temp = new int[array.length];
            result = array[0];
            for(int i = 1;i<location ; i++){
                temp[i] = array[location];
            }
            location--;

            array = temp;

        }
        else{
            System.out.println(-1);
        }
        return result;
    }

    private static int size(){
       return location+1;
    }

    public static int empty(){
        if(location > -1) return 0;
        else return 1;
    }

    public static int back(){
        if(location > -1) return array[location];
        else return location;
    }
    public static int front(){
        if(location > -1) return array[0];
        else return location;
    }


}