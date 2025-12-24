package com.nhnacademy.hello;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main  {
    public static void main(String[] args) throws IOException{

        int age; //선언만
        age = 25; //초기화

        int count = 10; // 선언과 초기화 동시에

        double price = 19.99; // 실수형
        
        String name = "김민서"; // 문자열

        boolean isActive = true; // 논리형

    
        /*변수명 규칙
        문자, _, $ 로 시작 ex) name, _count, $price
        숫자로 시작 불가 ex) 1name (X) name1 (O)
        예약어 사용 불가 ex) myClass, intValue
        대소문자 구분 ex) name, Name 다름
        */
                

        //camel case 명명 규칙:
        //첫 단어는 소문자, 이후 단어 첫 글자는 대문자
        int totalCount;
        String userName;
        boolean isCompleted;

        //상수: 모두 대문자, 단어 구분은 _ 사용
        final int MAX_SIZE = 100;
        final String DEFAULT_NAME = "Guest";

        //변수 초기화 중요성:
        int x;
        //System.out.println(x);  // 컴파일 에러! 초기화되지 않은 지역 변수

        int y = 0;
        System.out.println(y);  // OK: 0 출력

        //primitve type과  Wrapper class
        /*
        Primitive type (기본형):
            - Java에서 제공하는 8가지 기본 데이터 타입
            - 값 자체를 저장 (스택 메모리)
            - null 값을 가질 수 없음

        분류	타입	 크기	    기본값	       범위
        정수	byte	1 byte	    0	     -128 ~ 127
        정수	short	2 bytes 	0	    -32,768 ~ 32,767
        정수	int	    4 bytes	    0	     약 -21억 ~ 21억
        정수	long	8 bytes	    0L	     매우 큰 범위        
        long > int > short > byte 작은 수가 큰 수로 자동 형변환 가능 type casting

        실수	float	4 bytes	    0.0f	    -      <- 0.0f를 줘야댐 0.0은 double형
        실수	double	8 bytes	    0.0	        -   
        문자	char	2 bytes	    '\u0000'	유니코드 문자
        논리	boolean	1 bit	    false	    true/false


        Wrapper class (래퍼 클래스):
            - 기본형을 객체로 감싼 클래스
            - java.lang 패키지에 포함
            - null 값을 가질 수 있음
            - 컬렉션(ArrayList 등)에서 사용 가능
            
            Primitive	Wrapper 	기본값
            int	        Integer	    null
            double	    Double	    null
            boolean	    Boolean	    null
            char	    Character	null
            long	    Long	    null

          */
        //Autoboxing과 Unboxing:
        // Autoboxing: primitive → Wrapper (자동 변환)
        int num = 10;
        Integer wrapped = num;  // int → Integer 자동 변환

        // Unboxing: Wrapper → primitive (자동 변환)
        Integer wrapped2 = 20;
        int num2 = wrapped2;    // Integer → int 자동 변환

        //문자열 → Primitive 변환:
        String numStr = "42";        // String → int
        int number = Integer.parseInt(numStr);  // 42
        
        String doubleStr = "3.14";// String → double
        double pi = Double.parseDouble(doubleStr);  // 3.14
         
        String boolStr = "true"; // String → boolean
        boolean flag = Boolean.parseBoolean(boolStr);  // true
        // 주의: "true"(대소문자 무관) 외의 모든 문자열은 false

        //Primitive vs Wrapper 기본값 비교:

        // 필드(인스턴스 변수)일 때의 기본값
        class Example {
            int primitiveInt;      // 기본값: 0
            Integer wrapperInt;    // 기본값: null

            boolean primitiveBoolean;  // 기본값: false
            Boolean wrapperBoolean;    // 기본값: null
        }
        /*
        주의사항:
        // Wrapper는 null일 수 있으므로 주의!
        Integer value = null;
        int result = value;  // NullPointerException 발생!

        // 안전한 방법
        if (value != null) {
            int result = value;
        }


        언제 어떤 것을 사용할까?:

        상황	            권장	        이유
        일반 계산, 반복문	   Primitive	  성능이 더 좋음
        ArrayList 등 컬렉션	 Wrapper	    제네릭은 객체만 허용
        null 가능성 필요	  Wrapper	     Primitive는 null 불가
        메서드 파라미터	       상황에 따라	     성능 vs 유연성
         */

        class Box{
            int value;
            Box(int value){
                this.value = value;;
            }

            @Override
            public String toString(){
                return Integer.toString(value);
            }
        }

        int a = 100;
        Box aa = new Box(100);
        System.out.println("int a = " + a);
        System.out.println("Integer aa = " + aa);

        //Primitive type vs Reference type
        //Java의 두 가지 타입 분류:
        /*
        Java의 모든 타입은 **Primitive type (기본형)**과 **Reference type (참조형)**으로 나뉩니다.

        구분	Primitive (기본형)	      Reference (참조형)
        저장	값 자체를 저장	           객체의 주소(참조)를 저장
        메모리	 Stack	                Stack (참조변수) + Heap (객체)
        비교	==로 값 비교	          ==는 주소 비교, equals()로 값 비교
        null	불가능	                가능
        예시	int, double, boolean	String, Integer, 배열, 클래스
         */

        //메모리 구조 차이:
        // Primitive: Stack에 값 직접 저장
        int num1 = 10;        // Stack: [num1 = 10]

        // Reference: Stack에 참조, Heap에 객체 저장
        String str = "Hello"; // Stack: [str = 0x100] → Heap: ["Hello"]

        //비교 연산의 차이:

        // Primitive: == 로 값 비교
        int a1 = 10;
        int b1 = 10;
        System.out.println(a1 == b1);  // true (값이 같음)

        // Refer ence: == 는 주소 비교, equals()는 값 비교
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        System.out.println(s1 == s2);      // false (다른 객체)
        System.out.println(s1.equals(s2)); // true (값이 같음)

        /*
        Reference type의 종류:

        클래스 타입: String, Integer, 사용자 정의 클래스
        인터페이스 타입: List, Map 등
        배열 타입: int[], String[] 등
        열거 타입: enum
        */
        
        //문자열 비교
        /*
        == vs equals():

        String input = reader.readLine();  // 사용자가 "quit" 입력

        // ❌ 잘못된 방법: == 는 주소(참조)를 비교
        if (input == "quit") {
        // 동작하지 않을 수 있음!
        }

        // ✅ 올바른 방법: equals()는 값을 비교
        if (input.equals("quit")) {
        System.out.println("종료합니다.");
        }

        왜 ==를 사용하면 안 되는가?:

        ==는 두 변수가 **같은 객체(메모리 주소)**를 가리키는지 비교
        equals()는 두 문자열의 **내용(값)**이 같은지 비교
        사용자 입력은 새로운 String 객체로 생성되므로 ==가 실패할 수 있음

        Null-safe 비교:

        String input = reader.readLine();

        // input이 null이면 NullPointerException 발생!
        if (input.equals("quit")) { ... }

        // ✅ 안전한 방법: 리터럴을 앞에
        if ("quit".equals(input)) { ... }
        */
        //대소문자 무시 비교:

        String input = "Quit";

        // 대소문자 구분
        input.equals("quit");        // false

        // 대소문자 무시
        input.equalsIgnoreCase("quit");  // true
         
         //NHN Academy 강사님의 팁: 가능한 최종 프로젝트 전까진 Ai 사용하지 않고 직접 해보기

         //while 기본 구조:

            while (true) {
            // 조건이 true인 동안 반복 실행
            break; // 반복문 탈출
            }
        
        //while(true) 무한 루프 패턴:
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
        System.out.print("입력: ");
         input = reader.readLine(); // 한줄을 입력받기

        if (input.equals("quit")) {
            System.out.println("프로그램을 종료합니다.");
            break;  // 반복문 탈출
        }

         System.out.println("입력한 값: " + input);
        }
/*

        //종료 조건 검사:

        // 패턴 1: break 사용
        while (true) {
         input = reader.readLine();
        if ("quit".equals(input)) {
            break;  // 루프 탈출
            }
        }
        // 처리 로직
        

        // 패턴 2: 조건식 사용
        input = "";
        while (!input.equals("quit")) {
            input = reader.readLine();
            if (!input.equals("quit")) {
            // 처리 로직
            }
        }
*/

        //연습문제

        // 문제 1 : 다음 변수 선언 중 올바른 것을 모두 고르시오.
        /*
        int 1stNumber = 10;      // (a) <-- 숫자로 시작 불가
        String user-name = "Kim"; // (b) <-- 하이픈(-) 사용 불가
        double _price = 99.9;    // (c)
        boolean isValid = true;  // (d)
        int class = 5;           // (e) <-- 예약어 사용 불가
        String $message = "Hi";  // (f)
        */
       // 정답 : (c), (d), (f)

       //문제 2 : 다음 코드의 출력 결과를 작성하시오
        /*
        int x = 5;
        int y = x;
        x = 10;
        System.out.println("x = " + x + ", y = " + y);
         */
        // 정답 : x = 10, y = 5

        // 문제 3: 아래 변수명을 camelCase 규칙에 맞게 수정하시오.

        /*
        원본	        camelCase
        total_count	    ?
        USERNAME	    ?
        IsCompleted	    ?
         */
        // 정답 : totalCount, userName, isCompleted

        //연습: Primitive type vs Reference type
        //문제 4: 다음 코드의 출력 결과를 예측하시오.
        /*
        int a = 10;
        int b = a;
        a = 20;
        System.out.println("a = " + a + ", b = " + b);

        // 정답 : a = 20, b = 10

        int[] arr1 = {1, 2, 3};
        int[] arr2 = arr1; // arr1의 참조를 arr2에 복사 (주소공유)
        arr1[0] = 100;
        System.out.println("arr1[0] = " + arr1[0] + ", arr2[0] = " + arr2[0]);

        // 정답 : arr1[0] = 100, arr2[0] = 100
         */

        //문제 5: 다음 중 Reference type을 모두 고르시오.

        /*
        (a) int
        (b) String  <-- Reference class
        (c) double
        (d) Integer <-- Wrapper class
        (e) boolean
        (f) int[] <-- Reference (배열)
        (g) char
         */

        // 정답 : (b), (d), (f)

        //문제 6: 다음 코드의 출력 결과를 예측하시오.

        /*
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");

        System.out.println(s1 == s2); // Stirng pool에서 같은 리터럴은 같은 주소 참조
        System.out.println(s1 == s3); // new String은 새로운 객체 생성(다른객체)
        System.out.println(s1.equals(s3));  // 값 비교
        + 문자열 비교는 equals() 사용
         */

        // 정답 : true, false, true

        //연습: Primitive type과 Wrapper class
        //문제 7: primitive type과 Wrapper class의 차이를 설명하고, 각각의 기본값을 작성하시오.

        /*
        타입	primitive   	Wrapper	    primitive 기본값	Wrapper 기본값
        정수	int	            Integer 	        ?	            ?
        실수	double	        Double	            ?	            ?
        논리	boolean	        Boolean	            ?	            ?
         */
        
        // 정답 : 0, null, 0.0, null, false, null
        // 차이점 :Primitive: 값 자체를 저장, null 불가, 성능 우수
            //    Wrapper: 객체로 감싸 저장, null 가능, 컬렉션에서 사용 가능


        //문제 8: 다음 코드의 출력 결과를 작성하시오.
        /*
        Integer a = 100;
        Integer b = 100;
        Integer c = 200; // 이유 : -128 ~ 127 범위는 Integer Cache 사용, 같은 객체 참조
        Integer d = 200; //       그 외 값은 새로운 객체 생성, 다른 객체 참조
        

        System.out.println(a == b);
        System.out.println(c == d); // equals() 사용해야 값 비교 가능
        */

        //정답 : true, false

        //문제 9: 문제 9: 다음 코드에서 발생하는 문제와 해결 방법을 설명하시오.

        /*
        Integer value = null;
        int result = value + 10; 
        */

        // 정답 : NullPointerException 발생
        // 이유: value가 null인데 unboxing(Integer → int 변환)을 시도하면서 예외 발생

        Integer value = null;
        int result = (value != null) ? value + 10 : 10;  // null 체크 후 사용


        // 문제 10: BufferedReader 사용 시 필요한 import문과 예외 처리를 모두 작성하시오.

        /*
        // 필요한 import문 3개: // 정답:
        // 1. _______  // 1. import java.io.BufferedReader;
        // 2. _______  // 2. import java.io.InputStreamReader;
        // 3. _______  // 3. import java.io.IOException;


        public class Main {
            public static void main(String[] args) _______ {  // 예외 처리
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("이름: ");
                // ...
            }
        }
       
        //문제 11: 아래 코드가 동작하도록 빈칸을 완성하시오.

        /*
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("이름: ");
        String name = _______;
        System.out.println("입력한 이름: " + name);
         */
       
        // 정답 : reader.readLine();
        //이름: 홍길동
        //입력한 이름: 홍길동
       
         //문제 12: 사용자로부터 나이를 입력받아 정수로 변환하는 코드를 완성하시오.

         /*
         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("나이: ");
        String ageStr = reader.readLine();
        int age = _______;
        System.out.println("입력한 나이: " + age);
          */

        // 정답 : Integer.parseInt(ageStr);
        //나이: 25
        //입력한 나이: 25

        //연습: while 반복문
        //문제 13: 1부터 10까지 출력하는 while문을 완성하시오.

        /*
        int i = 1;
        while (_______) {
            System.out.println(i);
            _______;
        }
         */
        // 정답 : i <= 10, i++


        //문제 14: 다음 코드의 출력 결과를 작성하시오.

        /*
        int n = 5;
        int sum = 0;
        while (n > 0) {
            sum += n;
            n--;
        }
        System.out.println("합계: " + sum);
         */
        // 정답 : 합계: 15

        //문제 15: 무한 루프를 사용하여 사용자가 "quit"을 입력할 때까지 입력받은 문자열을 출력하는 프로그램을 작성하시오

        /*
        BufferedReader redear = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String input = reader.readLine();
            if(input.equals("quit")){
                break;
            }
                System.out.println(input);
        }
         */

        // 종합 연습
        /*문제 16: 다음 요구사항을 만족하는 프로그램을 작성하시오.
            1. 사용자에게 "숫자를 입력하세요 (종료: quit): " 메시지를 출력
            2. 입력받은 값이 "quit"이면 지금까지 입력한 숫자들의 합을 출력하고 종료
            3. 숫자가 입력되면 누적 합계를 출력
         */
        /*
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        while(true){
            System.out.println("숫자를 입력하세요 (종료: quit): ");
            String input = reader.readLine();
            if(input.equals("quit")){
                System.out.println("최종 합계: " + sum);
                break;
            }
        sum += Integer.parseInt(input);
        System.out.println("프로그램을 종료합니다.");
    }
            
         */
        reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        while(true){
            System.out.print("숫자를 입력하세요 (종료: quit): ");
            input = reader.readLine();
            if(input.equals("quit")){
                System.out.println("최종 합계: " + sum);
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        sum += Integer.parseInt(input);
        System.out.println("현재 합계: " + sum);
        
        }

        //프로젝트: 반복 입력 처리
        /*
        구현 목표: 사용자 입력을 반복적으로 받아 처리하고, 종료 조건을 검사할 수 있다.

        구현할 기능:
        BufferedReader로 사용자 입력 받기
        입력받은 값 출력하기
        "quit" 입력 시 프로그램 종료
         */

        reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("=== 입력 테스트 ===");
        while(true){
            System.out.print("입력 (종료: quit) > ");
            input = reader.readLine();
            if(input.equals("quit")){
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            System.out.println("입력한 값: " + input);
        }

    }   
}
