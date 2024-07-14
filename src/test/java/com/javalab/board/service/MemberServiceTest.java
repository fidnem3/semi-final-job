package com.javalab.board.service;

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
import com.javalab.board.vo.MemberVo;

import lombok.extern.slf4j.Slf4j;

/**
 * 단위테스트 - SpringJUnit4ClassRunner 의존성이 안들어오는 경우 pom.xml에 spring-test 확인할것.
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@Slf4j // import lombok.extern.slf4j.Slf4j;
public class MemberServiceTest {

	@Autowired
	private MemberService memberService;

//    @Autowired
//    private MemberService memberService;

	@Test
	@Ignore
	public void testMemberService() {
		assertNotNull(memberService);
		log.info("memberService 인터페이스 : " + memberService);
	}

	@Test
	@Ignore
	public void testCreateMember() {
		// 저장할 객체 생성
		MemberVo memberVo = new MemberVo();
		memberVo.setMemberId("java3"); // 새로운 사용자로 반드시 변경
		memberVo.setPassword("1234");
		memberVo.setName("hong2");
		memberVo.setEmail("abcd@ab.com"); // email unique 제약으로 반드시 변경

		// 객체 저장
		int result = memberService.createMember(memberVo);
		assertTrue(result > 0);
		log.info("저장된 행수 : " + result);
	}

//	
//	@Test
//	//@Ignore
//	public void testCreateBoardSelectKey() {
//		// 저장할 객체 생성
//		BoardVo boardVo = new BoardVo();
//		boardVo.setTitle("마이바티스3");
//		boardVo.setContent("내용");
//		boardVo.setMemberId("java");
//		
//		// 객체 저장
//		int result = boardService.createBoard(boardVo);
//		assertTrue(result > 0);
//		log.info("저장된 행수 : " + result);
//	}
//
//
//	@Test
//	@Ignore
//	public void testCreateBoardWithPoint() {
//		// 저장할 객체 생성
//		BoardVo boardVo = new BoardVo();
//		boardVo.setTitle("포인트 테스트 제목");
//		boardVo.setContent("포인트 테스트 내용");
//		boardVo.setMemberId("java");
//
//		// 기존 포인트 조회
//		MemberVo memberVo = memberService.getMember("java");
//		int initialPoint = memberVo.getPoint();
//
//		// 게시물 작성
//		int result = boardService.createBoard(boardVo);
//		assertTrue(result > 0);
//
//		// 포인트 증가 확인
//		MemberVo updatedMemberVo = memberService.getMember("java");
//		int updatedPoint = updatedMemberVo.getPoint();
//		assertTrue(updatedPoint == initialPoint + 1);
//
//		log.info("저장된 행수 : " + result);
//		log.info("초기 포인트 : " + initialPoint);
//		log.info("업데이트된 포인트 : " + updatedPoint);
//	}
}
