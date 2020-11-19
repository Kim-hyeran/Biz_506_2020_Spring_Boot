# Spring-Boot thymeleaf view
 * HTML, CSS, JS가 적용된 static web HTML 파일에 Controller로부터 전달되어 온 데이터를 기본 모양 범위 내에서 자유롭게 표현하는 view
 * JSP와 비교했을 때, JSP는 서버를 거쳐 rendering이 되지 않으면 화면이 어떻게 구성되는지 결과를 알기 어렵다.
 * 표준 web browser에서 open했을 때는 마치 static HTML처럼 보여지고, 서버에서 데이터가 전달되면 실제 데이터를 포함하여 rendering한 후 보여지기 때문에 개발과 디자이너가 협업하기에 좋다.
 * Spring-boot WAS에서 표준적으로 사용된다.