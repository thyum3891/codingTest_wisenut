import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Star10 {

     /**
      빈 포인트 저장용 인스턴스
      map 안에 Hash맵이 아닌 ArrayList로 저장 후 .contains()를 사용할 땐 시간초과 발생
     */
    static Map<Integer,HashMap<Integer,Boolean>> emptyPoint = new HashMap<>();

     /**
      답 저장용 인스턴스
      print 최소화 및 String의 초기화 최소화용 StringBuilder
     */
    static StringBuilder result = new StringBuilder();

     /**
      빈 포인트 추출용 메서드

      재귀를 통해 모든 3의 배수 포인트 추출 및 key를 통해 바로 찾을 수 있도록 함
     */
    public static void getEmptyPoint(int input){
        HashMap<Integer,Boolean> emptyPointMap = new HashMap<Integer,Boolean>();

        for (int i = 1; i<=input/3;i++) emptyPointMap.put(i+input/3,true);

        emptyPoint.put(input, emptyPointMap);

        if((input/3)%3==0) getEmptyPoint(input/3);

        return;
    }

     /**
      별찍기 지점 값 추출용 메서드
      별찍기 포인트 지점이 다른 사각형 안에 있는지 확인 후 재귀
      */
    public static void starSquare(int x,int y, int input){
        HashMap<Integer,Boolean> thisEmptyPoint = emptyPoint.get(input);
        if(thisEmptyPoint.get(x%input)==null?false:true&&thisEmptyPoint.get(y%input)==null?false:true) result.append(" ");
        else if((input/3)%3==0&&input != 3) starSquare(x, y, input/3);
        else result.append("*");

        return;
    }
    public static void main(String[] args) throws IOException {
        // input 받기용 코드
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        // 메서드 실행
        getEmptyPoint(input);

        // 제일 큰 사각형 생성 및 x포인트와 y포인트 받기
        for(int y = 1;y<=input;y++){
            for(int x = 1;x<=input;x++){
                //해당 지점에 별인지 확인하는 재귀 메서드 실행
                starSquare(x, y, input);
            }
            // Y값마다 줄바꿈
            result.append("\n");
        }

        // 출력
        System.out.println(result.toString());


    }
}
