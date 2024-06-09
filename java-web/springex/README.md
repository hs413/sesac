# Spring Web MVC

### 특징
- Front-Controller 패턴 이용 -> 흐름의 전/후 처리 가능
- 어노테이션 활용으로 코드 작성 최소화
- 추상화된 방식으로 개발 가능

### DispatcherServlet
- 모든 요청은 DispatcherServlet을 통해 실행
- 퍼사드(facade) 패턴
    - 모든 흐름이 하나의 객체를 통해 진행되는 패턴
    - 웹 구조에서는 Front-Controller 패턴이라고 함
    - DispatcherServlet이 해당 역할을 수행

### Spring MVC Controller
- 상속이나 인터페이스를 구현하는 방식을 사용하지 않고 어노테이션으로 처리
- 오버라이드 없이 필요한 메서드 정의

