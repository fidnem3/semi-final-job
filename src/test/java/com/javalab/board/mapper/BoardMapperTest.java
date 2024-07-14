package com.javalab.board.mapper;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javalab.board.mapper.BoardMapperInterface;
import com.javalab.board.vo.BoardVo;

import lombok.extern.slf4j.Slf4j;

/**
 * 단위테스트 - SpringJUnit4ClassRunner 의존성이 안들어오는 경우 pom.xml에 spring-test 확인할것.
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@Slf4j // import lombok.extern.slf4j.Slf4j;
public class BoardMapperTest {

	@Autowired
	private DataSource dataSource;

	// 매퍼 인터페이스 의존성 주입
	@Autowired
	private BoardMapperInterface boardMapper;
	// boardMapper 객체 : org.apache.ibatis.binding.MapperProxy@14ac77b9

	/*
	 * @Autowired public BoardMapperTest(DataSource dataSource, BoardMapperInterface
	 * boardMapper) { this.dataSource = dataSource; this.boardMapper = boardMapper;
	 * }
	 */

	@Test
	@Ignore
	public void testDataSource() {
		try (Connection conn = dataSource.getConnection()) {
			assertNotNull(conn);
			System.out.println("획득한 커넥션: " + conn);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 매퍼 인터페이스의 의존성 주입이 정상적으로 되는지 확인하는 테스트 메소드
	 */
	@Test
	@Ignore
	public void testBoardMapper() {
		assertNotNull(boardMapper);
		// boardMapper 객체 : org.apache.ibatis.binding.MapperProxy@14ac77b9
		log.info("boardMapper 객체 : " + boardMapper); // MapperProxy
	}

	// 게시물 상세보기 테스트
	@Test
	@Ignore
	public void testListBoard() {
		int bno = 30; // 실제 게시물 번호(rboard 계정의 board table의 bno)
		BoardVo boardVo = boardMapper.getBoard(bno);
		log.info("게시물 : " + boardVo);
	}

	// 게시물 목록보기 테스트
	@Test
	@Ignore
	public void testGetBoardList() {
		List<BoardVo> boardList = boardMapper.listBoard();
		assertNotNull(boardList);
		assertTrue(boardList.size() > 0);
		boardList.forEach(board -> System.out.println(board));
	}

	// 게시물 등록 테스트
	@Test
	@Ignore
	public void testcreateBoard() {
		// 저장할 객체 생성
		BoardVo boardVo = new BoardVo();
		boardVo.setTitle("마이바티스7");
		boardVo.setContent("내용7");
		boardVo.setMemberId("java");

		// 객체 저장
		int result = boardMapper.createBoard(boardVo);
		assertTrue(result > 0);
		log.info("저장된 행수 : " + result);
	}

	// 게시물 수정 테스트
	@Test
	@Ignore
	public void testUpdateBoard() {
		// 수정할 객체 생성
		BoardVo boardVo = new BoardVo();
		boardVo.setBno(1); // 실제로 DB에 있는 bno
		boardVo.setTitle("수정한 제목 마이바티스2");
		boardVo.setContent("수정한 내용");

		// 객체 수정
		int result = boardMapper.updateBoard(boardVo);
		assertTrue(result > 0);
		log.info("수정된 행수 : " + result);
	}

	// 게시물 삭제 테스트
	@Test
	//@Ignore
	public void testDeleteBoard() {
		int bno = 262; // 삭제할 bno, DB에 있는 번호

		// 객체 삭제
		int result = boardMapper.deleteBoard(bno);
		assertTrue(result > 0);
		log.info("삭제된 행수 : " + result);
	}

}
