package com.nhnacademy.hello;


public class Main {
    public static void main(String[] args) {

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
        num = 10;        // Stack: [num = 10]

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

    }
}
