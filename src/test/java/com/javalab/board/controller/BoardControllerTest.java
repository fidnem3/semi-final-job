package com.javalab.board.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.javalab.board.service.BoardService;
import com.javalab.board.vo.BoardVo;

/**
 * 웹 어플리케이션 컨텍스트를 사용하겠다. 즉, 웹 어플리케이션의 설정파일을 사용하겠다. 컨트롤러와 같은 웹 계층을 테스트할 때 사용한다.
 * 컨트롤러 통합 테스트의 필요성 - 실제 데이터베이스나 다른 외부 시스템에 접근하지 않고도 개발이 정상적으로 잘되었는지 검증해볼수있다. -
 * 서블릿 컨테이너를 구동하지 않고 마치 사용자가 실제로 요청을 한것과 같은 효과를 얻을 수 있다. 서블릿 컨테이너는 구동하는 시간도
 * 많이걸린다. 테스트 시간을 훨씬 단축해준다. - 이 테스트를 통해서 개발자가 파라미터를 알맞은 타입을 정의했는지, 순서는 맞는지 등의
 * 다양한 테스트를 할수 있다.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@WebAppConfiguration // 웹 어플리케이션 설정 파일을 사용하겠다.
public class BoardControllerTest {

	// @Mock : 목 객체를 생성한다. 목은 가짜 객체로 실제 객체와 같은 동작을 한다.
	@Mock
	private BoardService service;

	// WebApplicationContext : 웹 어플리케이션의 설정파일을 사용할 수 있게 해준다.
	// @WebAppConfiguration 어노테이션을 사용하면 사용할 수 있다.
	@Autowired
	private WebApplicationContext wac;

	// 가짜 mvc 객체로 역할은 컨트롤러 테스트를 위한 가짜 mvc 객체를 생성한다.
	// 이걸 생성하면 컨트롤러를 테스트할 수 있다.
	private MockMvc mockMvc;

	// @InjectMocks : 테스트 대상이 되는 객체에 목 객체를 주입한다.
	// HomeController 객체에 목 객체를 주입한다. 이 구문을 생략하면 목 객체가 주입되지 않는다.
	@InjectMocks
	private BoardController boardController;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this); // 목 객체를 초기화한다.
		this.mockMvc = MockMvcBuilders.standaloneSetup(boardController).build(); // 가짜 mvc 객체를 생성한다.
	}

	// 게시물 내용 보기 메소드 테스트
	// get은 static import를 한다. 왜? get이라는 메소드를 사용하기 위해서는
	// static import를 해야 한다.
	// static import는 클래스 이름을 생략하고 메소드를 사용할 수 있게 해준다.
	@Test @Ignore
	   public void testGetBoard() throws Exception{
	      // given : 테스트를 위한 전제 조건을 준비 또는 데이터를 준비하는 작업.  
	      //          여기서는 service.getBoard(1) 호출이 boardVo 객체를 반환하도록 설정.
	      BoardVo boardVo = new BoardVo(1, "제목1", "내용1", "java");
	      Mockito.when(service.getBoard(1)).thenReturn(boardVo);
	      
	      // when : 실제 테스트하는 동작을 수행. 여기서는 /getBoard 엔드포인트에 
	      //        bno=1 파라미터를 전달하는 GET 요청을 수행.
	      // get방식으로 "/getBoard"라는 요청을 하면서 파라미터로 /getBoard?bno=1 을 전달하겠다.
	      this.mockMvc.perform(get("/board/detail").param("bno", "1"))   
	      
	      // then
	      // When에서 수행한 행동의 결과를 검증. 기대한 결과가 실제로 발생했는지 확인.
	      // 예: 반환된 값이 예상한 값인지, 상태 코드가 올바른지, 특정 뷰가 렌더링되었는지 확인.
	      .andExpect(status().isOk())      // 응답 상태가 200인지 확인한다.
	      .andExpect(view().name("board/boardDetail"))   // boardDetail.jsp로 이동하는지 확인한다.
	      .andExpect(model().attributeExists("boardVo"))   // model에 boardVo이 있는지 확인한다.
	      .andExpect(model().attribute("boardVo", boardVo));
	   }

	// 게시물 목록 테스트
	@Test
	@Ignore
	public void testListBoard() throws Exception {
		// given : 대전제 - service.getBoardList() 이라는 요청을 하게 되면
		// 그러면 응답으로 boardList 객체가 돌아올 것이다.
		BoardVo boardVo1 = new BoardVo(1, "제목1", "내용1", "java");
		BoardVo boardVo2 = new BoardVo(2, "제목2", "내용2", "java");
		List<BoardVo> boardList = new ArrayList<>();
		boardList.add(boardVo1);
		boardList.add(boardVo2);

		Mockito.when(service.listBoard()).thenReturn(boardList);

		// when
		// get방식으로 "/getBoardList"라는 요청을 한다.
		this.mockMvc.perform(get("/board/list"))

				// then
				.andExpect(status().isOk()) // 응답 상태가 200인지 확인한다.
				.andExpect(view().name("board/boardList")) // boardDetail.jsp로 이동하는지 확인한다.
				.andExpect(model().attributeExists("boardList")) // model에 boardVo이 있는지 확인한다.
				.andExpect(model().attribute("boardList", boardList));
	}

	/**
	 * 컨트롤러에 주입되어 있는 서비스 레이어의 특정 메소드를 테스트한다. - service.insertBoard() 메소드 테스트
	 */
	@Test
	@Ignore
	public void testCreateBoard() throws Exception {
		// 1. 테스트 결과를 위한 전제
		// when() : service.insertBoard()와 같이 호출했을 때
		// Mockito.any(BoardVo.class)) : BoardVo type 객체면 어떤 거라도 무조건 1을 반환하겠다.
		BoardVo boardVo = new BoardVo(0, "컨트롤러에서 등록", "내용", "java");
		Mockito.when(service.createBoard(Mockito.any(BoardVo.class))).thenReturn(1);

		// 2. 테스트를 진행한다.
		// post() 메소드 : /insertBoard라는 요청을 보낸다.
		// status().isOk() : 200번 응답이 돌아올 것이다. 즉, 호출 결과가 성공했다.
		mockMvc.perform(post("/board/create").contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("title", boardVo.getTitle()).param("content", boardVo.getContent())
				.param("memberId", boardVo.getMemberId()))
				// then
				// is3xxRedirection() : 응답이 3xx 인지 확인한다.
				// 메소드가 반환하는 jsp 페이지가 없어요. 대신 다른 컨트롤러를 호출한다.
				.andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("/board/list")); // 게시물 목록 요청 
	}

	// 수정 메소드 테스트
	@Test
	@Ignore
	public void testUpdateBoard() throws Exception {
		// 1. 테스트 결과를 위한 전제
		// when() : service.insertBoard()와 같이 호출했을 때
		// Mockito.any(BoardVo.class)) : BoardVo type 객체면 어떤 거라도 무조건 1을 반환하겠다.
		BoardVo boardVo = new BoardVo(1, "수정된 컨트롤러에서 등록", "내용", "java");
		Mockito.when(service.updateBoard(Mockito.any(BoardVo.class))).thenReturn(1);

		// 2. 테스트를 진행한다.
		// post() 메소드 : /insertBoard라는 요청을 보낸다.
		mockMvc.perform(post("/board/update").contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("bno", String.valueOf(boardVo.getBno())).param("title", boardVo.getTitle())
				.param("content", boardVo.getContent()).param("memberId", boardVo.getMemberId()))
				// then
				// is3xxRedirection() : 응답이 3xx 인지 확인한다.
				// 메소드가 반환하는 jsp 페이지가 없어요. 대신 다른 컨트롤러를 호출한다.
				.andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("/board/list"));
	}

	// 삭제 메소드 테스트
	@Test
	@Ignore
	public void testDeleteBoard() throws Exception {
		// 1. 테스트 결과를 위한 전제
		// when() : service.insertBoard()와 같이 호출했을 때
		int bno = 45;
		Mockito.when(service.deleteBoard(bno)).thenReturn(1);

		// 2. 테스트를 진행한다.
		// post() 메소드 : /insertBoard라는 요청을 보낸다.
		mockMvc.perform(post("/board/delete").contentType(MediaType.APPLICATION_FORM_URLENCODED).param("bno",
				String.valueOf(bno)))
				// then
				// is3xxRedirection() : 응답이 3xx 인지 확인한다.
				// 메소드가 반환하는 jsp 페이지가 없어요. 대신 다른 컨트롤러를 호출한다.
				.andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("/board/list"));
	}
}
