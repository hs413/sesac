# 웹 기본 동작 방식

## Request / Response

- GET
  - 필요한 데이터를 주소(링크)에 직접 입력하여 요청하는 방식
- POST
  - 주소와 데이터를 분리하여 요청하는 방식


- static 데이터
  - 고정된 데이터를 전송
  - HTML, CSS, 이미지 파일 등
- dynamic 데이터
  - 요청 마다 다른 데이터를 동적으로 구성하여 전송
  - 서버에서 데이터를 만들어서 보냄 -> 서버 사이드 프로그래밍

웹 서버는 정적 데이터만 웹 애플리케이션 서버(WAS)는 동적 데이터를 보냄
WAS는 웹 서버의 역할도 수행

### HTTP
- 웹에서 데이터를 교환하기 위한 프로토콜
- Header와 Body로 구성
- Connectionless(비연결성)
  - 한번의 요청과 응답을 처리한 후 연결을 종료
  - 적은 리소스를 이용해 많은 수의 요청을 처리하기 위함

### 자바 서버 사이드 프로그래밍
- 서버 사이드 프로그래밍
  - 서버에서 데이터를 처리할 수 있도록 구성한 것
  - 고려사항
    - 동시 요청 처리
    - 서버 문제 처리
    - 데이터 전송 최적화
    - 분산 환경, 분산 처리
  - 위 문제들을 처리할 수 있도록 JavaEE를 제공

- Servlet 
  - 동적으로 요청과 응답을 처리할 수 있는 API들을 정의한 것
  - 서블릿 컨테이너
    - 서블릿은 톰캣과 같은 실행 환경이 필요하며 이를 서블릿 컨테이너라고 함
    - 객체 생성 및 호출
    - 서블릿 클래스에서 생성하는 객체의 관리

- JSP
  - HTML 코드를 이용하여 화면을 구현하는 용도로 사용
  - 컴파일 시 서블릿 코드로 변환 됨

## JSP를 이용한 GET/POST 처리
[input.jsp](../src/main/webapp/calc/input.jsp)

[calcResult.jsp](../src/main/webapp/calc/calcResult.jsp)

- JSP에서 쿼리 스트링이나 파라미터를 처리X -> 서블릿을 통해 처리
- JSP는 입력 화면이나 처리 결과를 보여주는 용도로만 사용
- 직접 JSP 경로를 호출하지 않고 서블릿 경로를 통해 JSP 처리

# Web MVC

## MVC 구조

- [InputController](../src/main/java/org/zerock/w1/calc/InputController.java)

- [CalcController](../src/main/java/org/zerock/w1/calc/CalcController.java)

### WEB-INF
- 브라우저에서 직접 접근이 불가능한 경로

## PRG(Post-Redirect-Get)
- POST 호출이 반복 되는 것을 막는다


### TODO
- [TodoDTO](../src/main/java/org/zerock/w1/todo/dto/TodoDTO.java)

- [TodoService](../src/main/java/org/zerock/w1/todo/TodoService.java)


