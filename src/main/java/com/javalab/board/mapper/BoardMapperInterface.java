package com.javalab.board.mapper;

import java.util.List;


import com.javalab.board.vo.BoardVo;


/**
 * 보드 매퍼 인터페이스
 * - 리파지토리 레이어와 매퍼XML(쿼리문)을 연결해주는 연결자 역할
 * - 비록 인터페이스이지만 마이바티스가 인터페이스를 감싸는 대리인 객체(프록시)를
 *   만들어서 요청을 가로채고 그 이름에 맞는 매퍼XML의 메소드를 호출한다.
 * - 마이바티스 이 매퍼인터페이스를 인식할 수 있도록 root-context.xml에
 *   <mybatis-spring:scan>이라는 태그로 위치를 지정해놓아야 한다.
 * - 매퍼XML에서는 다음과 같이 설정해놓아야 한다. 그래야 매퍼인터페이스와 매퍼XML이 연결된다.
 *   <mapper namespace="com.javalab.mybatis.mapper.BoardMapperInterface">
 */

public interface BoardMapperInterface {
	// 게시물 상세 보기 추상메소드
	public BoardVo getBoard(int bno);
	// 게시물 목록 보기 추상메소드
	public List<BoardVo> listBoard();
	// 게시물 등록 추상메소드
	public int createBoard(BoardVo boardVo);
	// 게시물 업데이트 매퍼메소드
	public int updateBoard(BoardVo boardVo);
	// 게시물 삭제 매퍼메소드
	public int deleteBoard(int bno);
	// selectKey 사용 메소드
	public int createBoardSelectKey(BoardVo boardVo);
	
	
}
