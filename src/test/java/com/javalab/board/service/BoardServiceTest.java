package com.javalab.board.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javalab.board.vo.BoardVo;

import lombok.extern.slf4j.Slf4j;

/**
 * 단위테스트 - SpringJUnit4ClassRunner 의존성이 안들어오는 경우 pom.xml에 spring-test 확인할것.
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@Slf4j // import lombok.extern.slf4j.Slf4j;
public class BoardServiceTest {

	// BoardService 인터페이스 의존성 주입
	// 인터페이스 타입으로 의존성 주입했지만 실제로는 그 자식인 BoardServiceImpl 주입됨.
	@Autowired
	private BoardService boardService;

	@Test
	@Ignore
	public void testBoardService() {
		assertNotNull(boardService);
		log.info("boardService 인터페이스 : " + boardService); // BoardServiceImpl@7063686f
	}

	@Test
	@Ignore
	public void testGetBoard() {
		int bno = 30;
		BoardVo boardVo = boardService.getBoard(bno);
		assertNotNull(boardVo);
		log.info("서비스에서 조회한 getBoard() : " + boardVo);
	}

	@Test
	@Ignore
	public void testListBoard() {
		assertTrue(boardService.listBoard().size() > 0);
		List<BoardVo> boardList = boardService.listBoard();
		boardList.forEach(board -> log.info(board.toString()));
	}
	@Test
	//@Ignore
	public void testCreateBoardSelectKey() {
		// 저장할 객체 생성
		BoardVo boardVo = new BoardVo();
		boardVo.setTitle("마이바티스3");
		boardVo.setContent("내용");
		boardVo.setMemberId("java");

		// 객체 저장
		int result = boardService.createBoard(boardVo);
		assertTrue(result > 0);
		log.info("저장된 행수 : " + result);
	}

	@Test
	@Ignore
	public void testCreateBoard() {
		// 저장할 객체 생성
		BoardVo boardVo = new BoardVo();
		boardVo.setTitle("마이바티스3");
		boardVo.setContent("내용");
		boardVo.setMemberId("java");

		// 객체 저장
		int result = boardService.createBoard(boardVo);
		assertTrue(result > 0);
		log.info("저장된 행수 : " + result);
	}

	@Test
	@Ignore
	public void testUpdateBoard() {
		// 수정할 객체 생성
		BoardVo boardVo = new BoardVo();
		boardVo.setBno(30); // 실제로 DB에 있는 bno
		boardVo.setTitle("서비스에서 수정한 제목 마이바티스5");
		boardVo.setContent("서비스에서 수정한 제목 마이바티스5");

		// 객체 수정
		int result = boardService.updateBoard(boardVo);
		assertTrue(result > 0);
		log.info("수정된 행수 : " + result);
	}

	@Test
	@Ignore
	public void testDeleteBoard() {
		int bno = 50; // 삭제할 bno, DB에 있는 번호

		// 객체 삭제
		int result = boardService.deleteBoard(bno);
		assertTrue(result > 0);
		log.info("삭제된 행수 : " + result);
	}

}
