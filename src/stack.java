import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.StringTokenizer;


//정수를 저장하는 스택
public class stack {

    static int base = 100; //기본 배열
    static int up = 100; //배열이 꽉 찰시에 이 숫자만큼 증가시키기
    static int location = -1; //나중에 들어온 배열의 위치
    static int[] array = new int[base];

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine()," ");
        int a = Integer.parseInt(str.nextToken());

        for(int i = 0; i < a; i++) { //사용자에게 입력받은 만큼 반복할거임
            String result = br.readLine();
            if(result.length() > 5){
                int num = Integer.parseInt(result.substring(5,result.length()));
                push(num);
            }

            if (result.contains("pop")){
                pop();
            }else if(result.contains("size")){
                size();
            }else if(result.contains("empty")){
                empty();
            }else if(result.contains("top")){
                top();
            }

        }
    }

    private static void push(int num){
        location++;
        if(location == array.length){
            int[] temp = new int[location+up];
            for(int i = 0; i < array.length;i++){
                temp[i] = array[i];
            }
            array = temp;
        }
        array[location] = num;
    }
    public static void pop(){
        if(location > -1){
            System.out.println(array[location]);
            location--;
        }
        else{
            System.out.println(-1);
        }
    }

    public static void size(){
        System.out.println(location+1);
    }

    public static void empty(){
        if(location > -1) System.out.println(0);
        else System.out.println(1);
    }

    public static void top(){
        if(location > -1) System.out.println(array[location]);
        else System.out.println(location);
    }

}