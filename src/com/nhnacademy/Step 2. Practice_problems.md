## 연습 문제

### 연습: 변수 선언 및 초기화

**문제 1**: 다음 변수 선언 중 올바른 것을 모두 고르시오.
```java
int 1stNumber = 10;      // (a)
String user-name = "Kim"; // (b)
double _price = 99.9;    // (c)
boolean isValid = true;  // (d)
int class = 5;           // (e)
String $message = "Hi";  // (f)
```

<details>
<summary>정답 확인</summary>

올바른 것: **(c), (d), (f)**

- (a) ❌ 숫자로 시작 불가
- (b) ❌ 하이픈(-) 사용 불가
- (c) ✅ 밑줄(_)로 시작 가능
- (d) ✅ 올바른 변수 선언
- (e) ❌ `class`는 예약어
- (f) ✅ 달러($)로 시작 가능

</details>

**문제 2**: 다음 코드의 출력 결과를 작성하시오.
```java
int x = 5;
int y = x;
x = 10;
System.out.println("x = " + x + ", y = " + y);
```

<details>
<summary>정답 확인</summary>

**출력 결과**:
```
x = 10, y = 5
```

**설명**: `y = x`는 x의 **값(5)**을 복사한 것이므로, 이후 x가 변경되어도 y는 영향받지 않습니다.

</details>

**문제 3**: 아래 변수명을 camelCase 규칙에 맞게 수정하시오.
| 원본          | camelCase |
| ------------- | --------- |
| `total_count` | ?         |
| `USERNAME`    | ?         |
| `IsCompleted` | ?         |

<details>
<summary>정답 확인</summary>

| 원본          | camelCase     |
| ------------- | ------------- |
| `total_count` | `totalCount`  |
| `USERNAME`    | `userName`    |
| `IsCompleted` | `isCompleted` |

</details>

---

### 연습: Primitive type vs Reference type

**문제 4**: 다음 코드의 출력 결과를 예측하시오.
```java
int a = 10;
int b = a;
a = 20;
System.out.println("a = " + a + ", b = " + b);

int[] arr1 = {1, 2, 3};
int[] arr2 = arr1;
arr1[0] = 100;
System.out.println("arr1[0] = " + arr1[0] + ", arr2[0] = " + arr2[0]);
```

<details>
<summary>정답 확인</summary>

**출력 결과**:
```
a = 20, b = 10
arr1[0] = 100, arr2[0] = 100
```

**설명**:
- **Primitive (`int`)**: `b = a`는 값을 복사하므로, `a`가 변경되어도 `b`는 영향받지 않음
- **Reference (배열)**: `arr2 = arr1`은 참조(주소)를 복사하므로, 같은 배열을 가리킴. `arr1[0]`을 변경하면 `arr2[0]`도 변경됨

</details>

**문제 5**: 다음 중 Reference type을 모두 고르시오.
```
(a) int
(b) String
(c) double
(d) Integer
(e) boolean
(f) int[]
(g) char
```

<details>
<summary>정답 확인</summary>

**Reference type**: **(b), (d), (f)**

- (a) `int` - Primitive
- (b) `String` - Reference (클래스)
- (c) `double` - Primitive
- (d) `Integer` - Reference (Wrapper 클래스)
- (e) `boolean` - Primitive
- (f) `int[]` - Reference (배열)
- (g) `char` - Primitive

</details>

**문제 6**: 다음 코드의 출력 결과를 예측하시오.
```java
String s1 = "Hello";
String s2 = "Hello";
String s3 = new String("Hello");

System.out.println(s1 == s2);
System.out.println(s1 == s3);
System.out.println(s1.equals(s3));
```

<details>
<summary>정답 확인</summary>

**출력 결과**:
```
true
false
true
```

**설명**:
- `s1 == s2`: `true` - 문자열 리터럴은 String Pool에서 재사용 (같은 객체 참조)
- `s1 == s3`: `false` - `new String()`은 새 객체 생성 (다른 객체)
- `s1.equals(s3)`: `true` - 값 비교는 같음

**핵심**: 문자열 비교는 항상 `equals()`를 사용하세요!

</details>

---

### 연습: Primitive type과 Wrapper class

**문제 7**: primitive type과 Wrapper class의 차이를 설명하고, 각각의 기본값을 작성하시오.
| 타입 | primitive | Wrapper | primitive 기본값 | Wrapper 기본값 |
| ---- | --------- | ------- | ---------------- | -------------- |
| 정수 | int       | Integer | ?                | ?              |
| 실수 | double    | Double  | ?                | ?              |
| 논리 | boolean   | Boolean | ?                | ?              |

<details>
<summary>정답 확인</summary>

| 타입 | primitive | Wrapper | primitive 기본값 | Wrapper 기본값 |
| ---- | --------- | ------- | ---------------- | -------------- |
| 정수 | int       | Integer | 0                | null           |
| 실수 | double    | Double  | 0.0              | null           |
| 논리 | boolean   | Boolean | false            | null           |

**차이점**:
- **Primitive**: 값 자체를 저장, `null` 불가, 성능 우수
- **Wrapper**: 객체로 감싸 저장, `null` 가능, 컬렉션에서 사용 가능

</details>

**문제 8**: 다음 코드의 출력 결과를 작성하시오.
```java
Integer a = 100;
Integer b = 100;
Integer c = 200;
Integer d = 200;

System.out.println(a == b);
System.out.println(c == d);
```

<details>
<summary>정답 확인</summary>

**출력 결과**:
```
true
false
```

**설명**: Java는 -128 ~ 127 범위의 Integer를 캐싱합니다. 100은 캐시 범위 내이므로 같은 객체를 참조하지만, 200은 범위 밖이므로 다른 객체가 생성됩니다. 값 비교시에는 `equals()`를 사용해야 합니다.

</details>

**문제 9**: 다음 코드에서 발생하는 문제와 해결 방법을 설명하시오.
```java
Integer value = null;
int result = value + 10;
```

<details>
<summary>정답 확인</summary>

**문제**: `NullPointerException` 발생

**이유**: `value`가 `null`인데 unboxing(Integer → int 변환)을 시도하면서 예외 발생

**해결 방법**:
```java
Integer value = null;
int result = (value != null) ? value + 10 : 10;  // null 체크 후 사용
```

</details>

---

### 연습: 콘솔 입력 처리

**문제 10**: BufferedReader 사용 시 필요한 import문과 예외 처리를 모두 작성하시오.
```java
// 필요한 import문 3개:
// 1. _______
// 2. _______
// 3. _______

public class Main {
    public static void main(String[] args) _______ {  // 예외 처리
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("이름: ");
        // ...
    }
}
```

<details>
<summary>정답 확인</summary>

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("이름: ");
        // ...
    }
}
```

</details>

**문제 11**: 아래 코드가 동작하도록 빈칸을 완성하시오.
```java
BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
System.out.print("이름: ");
String name = _______;
System.out.println("입력한 이름: " + name);
```

<details>
<summary>정답 확인</summary>

```java
String name = reader.readLine();
```

**실행 예시**:
```
이름: 홍길동
입력한 이름: 홍길동
```

</details>

**문제 12**: 사용자로부터 나이를 입력받아 정수로 변환하는 코드를 완성하시오.
```java
BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
System.out.print("나이: ");
String ageStr = reader.readLine();
int age = _______;
System.out.println("입력한 나이: " + age);
```

<details>
<summary>정답 확인</summary>

```java
int age = Integer.parseInt(ageStr);
```

**실행 예시**:
```
나이: 25
입력한 나이: 25
```

</details>

---

### 연습: while 반복문

**문제 13**: 1부터 10까지 출력하는 while문을 완성하시오.
```java
int i = 1;
while (_______) {
    System.out.println(i);
    _______;
}
```

<details>
<summary>정답 확인</summary>

```java
int i = 1;
while (i <= 10) {
    System.out.println(i);
    i++;
}
```

**출력 결과**:
```
1
2
3
4
5
6
7
8
9
10
```

</details>

**문제 14**: 다음 코드의 출력 결과를 작성하시오.
```java
int n = 5;
int sum = 0;
while (n > 0) {
    sum += n;
    n--;
}
System.out.println("합계: " + sum);
```

<details>
<summary>정답 확인</summary>

**출력 결과**:
```
합계: 15
```

**설명**: 5 + 4 + 3 + 2 + 1 = 15

</details>

**문제 15**: 무한 루프를 사용하여 사용자가 "quit"을 입력할 때까지 입력받은 문자열을 출력하는 프로그램을 작성하시오.

<details>
<summary>정답 확인</summary>

```java
BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

while (true) {
    System.out.print("입력: ");
    String input = reader.readLine();

    if (input.equals("quit")) {
        System.out.println("프로그램을 종료합니다.");
        break;
    }

    System.out.println("입력한 값: " + input);
}
```

**실행 예시**:
```
입력: Hello
입력한 값: Hello
입력: World
입력한 값: World
입력: quit
프로그램을 종료합니다.
```

</details>

---

### 종합 연습

**문제 16**: 다음 요구사항을 만족하는 프로그램을 작성하시오.
1. 사용자에게 "숫자를 입력하세요 (종료: quit): " 메시지를 출력
2. 입력받은 값이 "quit"이면 지금까지 입력한 숫자들의 합을 출력하고 종료
3. 숫자가 입력되면 누적 합계를 출력

**실행 예시**:
```
숫자를 입력하세요 (종료: quit): 10
현재 합계: 10
숫자를 입력하세요 (종료: quit): 20
현재 합계: 30
숫자를 입력하세요 (종료: quit): 5
현재 합계: 35
숫자를 입력하세요 (종료: quit): quit
최종 합계: 35
프로그램을 종료합니다.
```

<details>
<summary>정답 확인</summary>

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;

        while (true) {
            System.out.print("숫자를 입력하세요 (종료: quit): ");
            String input = reader.readLine();

            if ("quit".equals(input)) {
                System.out.println("최종 합계: " + sum);
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            int number = Integer.parseInt(input);
            sum += number;
            System.out.println("현재 합계: " + sum);
        }

        reader.close();
    }
}
```

</details>

---

## 프로젝트: 반복 입력 처리

**구현 목표**: 사용자 입력을 반복적으로 받아 처리하고, 종료 조건을 검사할 수 있다.

**구현할 기능**:
- BufferedReader로 사용자 입력 받기
- 입력받은 값 출력하기
- "quit" 입력 시 프로그램 종료

**실행 예시**:
```
=== 입력 테스트 ===
입력 (종료: quit) > Hello
입력한 값: Hello
입력 (종료: quit) > World
입력한 값: World
입력 (종료: quit) > quit
프로그램을 종료합니다.
```

**산출물 체크리스트**:
- [ ] BufferedReader로 입력 처리
- [ ] 입력받은 값 출력
- [ ] 무한 루프로 반복 입력
- [ ] "quit" 입력 시 정상 종료
