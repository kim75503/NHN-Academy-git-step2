# Step 2: 콘솔 입력

---

**학습 목표**:
- 변수 선언 및 초기화
- Primitive type과 Reference type 구분
- Wrapper class 이해
- BufferedReader를 통한 콘솔 입력 처리
- `while` 반복문으로 반복 입력 처리
- 종료 조건 검사

**핵심 내용**:
- 변수 선언: `타입 변수명 = 값;`
- Primitive type vs Reference type (값 vs 참조)
- `int` vs `Integer`, `boolean` vs `Boolean` (Primitive vs Wrapper)
- `==` vs `equals()` 비교 연산의 차이
- `String → int` 형변환: `Integer.parseInt()`
- `String → boolean` 형변환: `Boolean.parseBoolean()`
- `BufferedReader.readLine()`을 통한 입력, IOException 처리
- `while(true)` 무한 루프 패턴
- `break`로 루프 탈출

**실습 과제**:
1. BufferedReader로 사용자 입력 받기
2. 입력받은 문자열 출력하기
3. "quit" 입력 시 프로그램 종료

**산출물**:
- BufferedReader로 입력 처리
- 입력받은 값 출력
- 반복 입력 동작
- 종료 조건 검사 및 정상 종료

## 개념 정리

<details>
<summary><strong>Step 2-1. Variable Declaration and Initialization</strong></summary>

**변수란?**
- 데이터를 저장하는 **메모리 공간**에 붙인 이름
- 프로그램 실행 중 값을 저장하고 변경할 수 있음

**변수 선언 문법**:
```java
타입 변수명;           // 선언만
타입 변수명 = 값;      // 선언과 동시에 초기화
```

**기본 예시**:
```java
// 정수형
int age;              // 선언
age = 25;             // 초기화
int count = 10;       // 선언과 초기화 동시에

// 실수형
double price = 19.99;

// 문자열
String name = "홍길동";

// 논리형
boolean isActive = true;
```

**변수명 규칙**:
| 규칙                  | 올바른 예                  | 잘못된 예         |
| --------------------- | -------------------------- | ----------------- |
| 문자, `_`, `$`로 시작 | `name`, `_count`, `$price` | `1name`, `-count` |
| 숫자로 시작 불가      | `item1`, `count2`          | `1item`, `2count` |
| 예약어 사용 불가      | `myClass`, `intValue`      | `class`, `int`    |
| 대소문자 구분         | `Name` ≠ `name`            | -                 |

**camelCase 명명 규칙**:
```java
// 변수명: 첫 단어 소문자, 이후 단어 첫 글자 대문자
int totalCount;
String userName;
boolean isCompleted;

// 상수: 모두 대문자, 단어 구분은 밑줄
final int MAX_SIZE = 100;
final String DEFAULT_NAME = "Guest";
```

**변수 초기화 중요성**:
```java
int x;
System.out.println(x);  // 컴파일 에러! 초기화되지 않은 지역 변수

int y = 0;
System.out.println(y);  // OK: 0 출력
```

</details>

<details>
<summary><strong>Step 2-2. Primitive Types vs Reference Types</strong></summary>

**Java의 두 가지 타입 분류**:

Java의 모든 타입은 **Primitive type (기본형)**과 **Reference type (참조형)**으로 나뉩니다.

| 구분       | Primitive (기본형)         | Reference (참조형)                     |
| ---------- | -------------------------- | -------------------------------------- |
| **저장**   | 값 자체를 저장             | 객체의 주소(참조)를 저장               |
| **메모리** | Stack                      | Stack (참조변수) + Heap (객체)         |
| **비교**   | `==`로 값 비교             | `==`는 주소 비교, `equals()`로 값 비교 |
| **null**   | 불가능                     | 가능                                   |
| **예시**   | `int`, `double`, `boolean` | `String`, `Integer`, 배열, 클래스      |

**메모리 구조 차이**:
```java
// Primitive: Stack에 값 직접 저장
int num = 10;        // Stack: [num = 10]

// Reference: Stack에 참조, Heap에 객체 저장
String str = "Hello"; // Stack: [str = 0x100] → Heap: ["Hello"]
```

**비교 연산의 차이**:
```java
// Primitive: == 로 값 비교
int a = 10;
int b = 10;
System.out.println(a == b);  // true (값이 같음)

// Reference: == 는 주소 비교, equals()는 값 비교
String s1 = new String("Hello");
String s2 = new String("Hello");
System.out.println(s1 == s2);      // false (다른 객체)
System.out.println(s1.equals(s2)); // true (값이 같음)
```

**Reference type의 종류**:
- **클래스 타입**: `String`, `Integer`, 사용자 정의 클래스
- **인터페이스 타입**: `List`, `Map` 등
- **배열 타입**: `int[]`, `String[]` 등
- **열거 타입**: `enum`

**String은 Reference type!**:
```java
// String은 primitive처럼 보이지만 Reference type입니다
String name = "홍길동";  // 실제로는 String 객체의 참조

// 따라서 문자열 비교는 equals()를 사용해야 합니다
String input = reader.readLine();
if (input.equals("quit")) {  //  올바른 비교
    // ...
}
```

</details>

<details>
<summary><strong>Step 2-3. Wrapper Classes</strong></summary>

**Primitive type (기본형)**:
- Java에서 제공하는 8가지 기본 데이터 타입
- 값 자체를 저장 (스택 메모리)
- `null` 값을 가질 수 없음

| 분류 | 타입      | 크기    | 기본값   | 범위             |
| ---- | --------- | ------- | -------- | ---------------- |
| 정수 | `byte`    | 1 byte  | 0        | -128 ~ 127       |
| 정수 | `short`   | 2 bytes | 0        | -32,768 ~ 32,767 |
| 정수 | `int`     | 4 bytes | 0        | 약 -21억 ~ 21억  |
| 정수 | `long`    | 8 bytes | 0L       | 매우 큰 범위     |
| 실수 | `float`   | 4 bytes | 0.0f     | -                |
| 실수 | `double`  | 8 bytes | 0.0      | -                |
| 문자 | `char`    | 2 bytes | '\u0000' | 유니코드 문자    |
| 논리 | `boolean` | 1 bit   | false    | true/false       |

**Wrapper class (래퍼 클래스)**:
- 기본형을 객체로 감싼 클래스
- `java.lang` 패키지에 포함
- `null` 값을 가질 수 있음
- 컬렉션(ArrayList 등)에서 사용 가능

| Primitive | Wrapper     | 기본값 |
| --------- | ----------- | ------ |
| `int`     | `Integer`   | `null` |
| `double`  | `Double`    | `null` |
| `boolean` | `Boolean`   | `null` |
| `char`    | `Character` | `null` |
| `long`    | `Long`      | `null` |

**Autoboxing과 Unboxing**:
```java
// Autoboxing: primitive → Wrapper (자동 변환)
int num = 10;
Integer wrapped = num;  // int → Integer 자동 변환

// Unboxing: Wrapper → primitive (자동 변환)
Integer wrapped2 = 20;
int num2 = wrapped2;    // Integer → int 자동 변환
```

**문자열 → Primitive 변환**:
```java
// String → int
String numStr = "42";
int number = Integer.parseInt(numStr);  // 42

// String → double
String doubleStr = "3.14";
double pi = Double.parseDouble(doubleStr);  // 3.14

// String → boolean
String boolStr = "true";
boolean flag = Boolean.parseBoolean(boolStr);  // true
// 주의: "true"(대소문자 무관) 외의 모든 문자열은 false
```

**Primitive vs Wrapper 기본값 비교**:
```java
// 필드(인스턴스 변수)일 때의 기본값
class Example {
    int primitiveInt;      // 기본값: 0
    Integer wrapperInt;    // 기본값: null

    boolean primitiveBoolean;  // 기본값: false
    Boolean wrapperBoolean;    // 기본값: null
}
```

**주의사항**:
```java
// Wrapper는 null일 수 있으므로 주의!
Integer value = null;
int result = value;  // NullPointerException 발생!

// 안전한 방법
if (value != null) {
    int result = value;
}
```

**언제 어떤 것을 사용할까?**:
| 상황                | 권장        | 이유                  |
| ------------------- | ----------- | --------------------- |
| 일반 계산, 반복문   | Primitive   | 성능이 더 좋음        |
| ArrayList 등 컬렉션 | Wrapper     | 제네릭은 객체만 허용  |
| null 가능성 필요    | Wrapper     | Primitive는 null 불가 |
| 메서드 파라미터     | 상황에 따라 | 성능 vs 유연성        |

</details>

<details>
<summary><strong>Step 2-4. Input Handling with BufferedReader</strong></summary>

**BufferedReader 클래스**:
- `java.io.BufferedReader` 패키지에서 제공
- 콘솔, 파일 등에서 입력을 읽는 도구

**기본 사용법**:
```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 문자열 입력
        System.out.print("이름: ");
        String name = reader.readLine();

        System.out.println("입력한 이름: " + name);

        reader.close();
    }
}
```

**숫자 입력 받기**:
```java
BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

System.out.print("나이: ");
String ageStr = reader.readLine();  // "25" (문자열)
int age = Integer.parseInt(ageStr); // 25 (정수)

System.out.println("입력한 나이: " + age);
```

**여러 값 한 번에 입력받기**:
```java
System.out.print("이름과 나이를 입력하세요 (예: 홍길동 25): ");
String line = reader.readLine();
String[] parts = line.split(" ");  // 공백으로 분리
String name = parts[0];
int age = Integer.parseInt(parts[1]);
```

</details>

<details>
<summary><strong>Step 2-5. String Comparison</strong></summary>

**== vs equals()**:
```java
String input = reader.readLine();  // 사용자가 "quit" 입력

// ❌ 잘못된 방법: == 는 주소(참조)를 비교
if (input == "quit") {
    // 동작하지 않을 수 있음!
}

// ✅ 올바른 방법: equals()는 값을 비교
if (input.equals("quit")) {
    System.out.println("종료합니다.");
}
```

**왜 ==를 사용하면 안 되는가?**:
- `==`는 두 변수가 **같은 객체(메모리 주소)**를 가리키는지 비교
- `equals()`는 두 문자열의 **내용(값)**이 같은지 비교
- 사용자 입력은 새로운 String 객체로 생성되므로 `==`가 실패할 수 있음

**Null-safe 비교**:
```java
String input = reader.readLine();

// input이 null이면 NullPointerException 발생!
if (input.equals("quit")) { ... }

// ✅ 안전한 방법: 리터럴을 앞에
if ("quit".equals(input)) { ... }
```

**대소문자 무시 비교**:
```java
String input = "Quit";

// 대소문자 구분
input.equals("quit");        // false

// 대소문자 무시
input.equalsIgnoreCase("quit");  // true
```

</details>

<details>
<summary><strong>Step 2-6. While Loop and Exit Conditions</strong></summary>

**while 기본 구조**:
```java
while (조건) {
    // 조건이 true인 동안 반복 실행
}
```

**while(true) 무한 루프 패턴**:
```java
BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

while (true) {
    System.out.print("입력: ");
    String input = reader.readLine();

    if (input.equals("quit")) {
        System.out.println("프로그램을 종료합니다.");
        break;  // 반복문 탈출
    }

    System.out.println("입력한 값: " + input);
}
```

**종료 조건 검사**:
```java
// 패턴 1: break 사용
while (true) {
    String input = reader.readLine();
    if ("quit".equals(input)) {
        break;  // 루프 탈출
    }
    // 처리 로직
}

// 패턴 2: 조건식 사용
String input = "";
while (!input.equals("quit")) {
    input = reader.readLine();
    if (!input.equals("quit")) {
        // 처리 로직
    }
}
```

**break vs return**:
| 키워드   | 동작                      | 사용 시점                             |
| -------- | ------------------------- | ------------------------------------- |
| `break`  | 가장 가까운 반복문만 탈출 | 반복문 탈출 후 추가 코드 실행 필요 시 |
| `return` | 메서드 전체 종료          | 메서드를 바로 끝낼 때                 |

```java
// break 사용 예시
while (true) {
    if (조건) break;
}
System.out.println("반복문 끝난 후 실행됨");

// return 사용 예시 (main 메서드에서)
public static void main(String[] args) {
    while (true) {
        if (조건) return;  // 프로그램 종료
    }
    // 이 코드는 실행 안 됨
}
```

</details>

---

