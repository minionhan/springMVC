<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<img src="images/minions.png">
<ul>
	<li>헬로우월드:
		<ul>
		<li><a href="hello.do">/hello.do</a> :스프링 MVC 일단 해보기 HelloController.hello()</li>
		<li><a href="hello-raw.do">/hello-raw.do</a> :void 리턴 타입 컨트롤러 메서드 HelloController.hello()</li>
		</ul>
	</li>
	<li> 모델:
		<ul>
		<li><a href="event/list">/event/list</a>: Model 예시, EventController.list()</li>
		<li><a href="event/list2">/event/list2</a>: ModelAndView 예시, EventController.list2()</li>
		</ul>
	</li>
	<li>@RequestMapping, @PathVariable:
		<ul>
		<li><a href="member/regist">/member/regist</a>: GET/POST 예, RegistrationController</li>
		
		<li><a href="members">/members</a>: @PathVariable 사용 위한 목록 출력, MemberController.members()</li>
		<li><a href="members/m2">/members/m2</a>: @PathVariable 예, MemberController.memberDetail()</li>
		<li><a href="members/m2/orders/1">/member/m2/orders/1</a>: @PathVariable 예, MemberController.memberOrderDetail()</li>
		<li><a href="members/m2/orders/1a">/member/m2/orders/1a</a>: @PathVariable 400응답 예, MemberController.memberOrderDetail()</li>

		</ul>
	</li>
	<li>요청 파라미터 처리:
		<ul>
		<li><a href="event/detail?id=1">event/detail?id=1</a>: HttpServletRequest을 이용한 파라미터 구하기, EventController.detail()</li>
		<li><a href="event/detail2?id=1">event/detail2?id=1</a>: @RequestParam을 이용한 파라미터 구하기, EventController.detail2()</li>
		<li><a href="event/detail2">event/detail2</a>: @RequestParam 필수 파라미터 400 에러, EventController.detail2()</li>
		<li><a href="search">search</a>: @RequestParam 필수 아님 설정, SearchController.search()</li>
		</ul>
	</li>
	<li>커맨트 객체, @ModelAttribute:
		<ul>
		<li><a href="member/regist">/member/regist</a>: 커맨드 객체, @ModelAttribute로 커맨트 객체 이름 지정, RegistrationController</li>
		<li><a href="acl/list">/acl/list</a>: 커맨드 객체 리스트 처리, AclController
			<ul>
				<li>로그인 기능 수행 후, 실행</li>
				<li>또는, sample.xml이나 Sa-mpleConfig.java에서 핸들러 인터셉서 설정을 주석 처리 후 실행</li>
			</ul>
		</li>
		<li><a href="member/modify?mid=m1">/member/modify?mid=m1</a>: GET/POST에서 동일 타입 커맨드 객체 사용하기, MemberModificationCOntroller</li>
		<li><a href="event/list">/event/list</a>: @ModelAttribute를 이용한 공통 모델, EventController.recommend()</li>
		</ul>
	</li>
	<li>요청 헤더 값:
	<ul>
		<li><a href="header/simple">/header/sample</a>:
		@RequestHeader와 @COokieValue, SimpleHeaderController.simple()</li>
		<li><a href="header/createauth">/header/createauth</a>:
		@CookieValue 테스트를 위한 쿠키 생성, SimpleHeaderController.createAuth()</li>
	</ul>
	<li>리다이렉트:
			<ul>
				<li><a href="header/createauth">/header/createauth</a>: 리다이렉트, SimpleHeaderController.createAuth()</li>
			</ul>
	</li>
	<li>값 검증
		<ul>
			<li><a href="member/regist">/member/regist</a>:
			값 검증, &lt;spring:hasBindErrors name="memberInfo"/&gt;를 이용한 에러 미시지, RegistrationCotroller</li>
			<li><a href="auth/login">/auth/login</a>:
			@Valid 이용 값 검증, &lt;form:form commandName="loginCommand"&gt;를 이용한 에러 미시지, 글로벌에러메시지, LoginController</li>
			<li><a href="member/modify?mid=m2">/member/modify?mid=m2</a>:
			@Valid 및 JSR3-3 이용 값 검증, MemberModificationController</li>
		</ul>
	</li>
	<li>값 변환:
		<ul>
		<li><a href="member/regist">/member/regist</a>:
		@DateTimeFormat, RegistrationController/MemberRegistRequest</li>
		<li><a href="event/list">/event/list</a>:
		@InitBinder와 CustomDateEditor, EventController.list()</li>
		</ul>
	</li>
	<li>HTTP 세션:
		<ul>
		<li><a href="auth/login">/auth/login</a>:
		HttpServletRequest를 통해 HttpSession 사용, LoginController</li>
		<li><a href="auth/login">/auth/logout</a>:
		HttpSession 직접 사용, LogoutController</li>
		<li><a href="newevent/step1">/newevent/step1</a>:
		@SessionAttributes 사용, EvnetCreationController</li>
		</ul>
	</li>
	<li>익셉션 처리
		<ul>
		<li><a href="cal/divide?op1=10&op2=0">/cal/divide?op1=10&amp;op2=0</a>:
		@ExceptionHandler, CalculationCOntroller</li>
		<li><a href="event/detail2">/event/detail2</a>: 로그인을 하면 error안뜸!!
		@ControllerAdvice 사용, CommonExceptionHandler. 설정(sample.xml, SampleConfig.java)에서
		CommonExceptionHandler 부분의 주석 해제 후</li>
		<li><a href="files/a111">/files/a111</a>: 익셉션 클래스에 @ResponseStatus 사용,
		FileController.fileInfo()/NoFileInfoException</li>
		</ul>
	</li>
	<li>requestMapping(pattern 이용)
		<ul>
		<li><a href="files/a111">/files/a111</a>: 익셉션 클래스에 @ResponseStatus 사용,
		FileController.fileInfo()/noFileInfoException</li>
		<li><a href="files/aaa.download">/files/?*.download</a>:</li>
		<li><a href="folders/aaa/bbb/ccc/files">/folders/**/files</a>:</li>
		</ul>
	</li>
	<li>스프링 설정
		<ul>
		<li><a href="index">/index</a>: 뷰 전용 컨트롤러</li>
		<li><a href="images/javalogo.jpg">/images/javalogo.jsp</a>: 정적 지원</li>
		</ul>
	</li>
</ul>

</body>
</html>