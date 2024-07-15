/*
 * package com.javalab.board.mapper;
 * 
 * import static org.junit.Assert.assertNotNull; import static
 * org.junit.Assert.assertTrue;
 * 
 * import java.sql.Connection; import java.util.List;
 * 
 * import javax.sql.DataSource;
 * 
 * import org.junit.Ignore; import org.junit.Test; import
 * org.junit.runner.RunWith; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.test.context.ContextConfiguration; import
 * org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 * 
 * import com.javalab.board.vo.MemberVo;
 * 
 * import lombok.extern.slf4j.Slf4j;
 * 
 *//**
	 * 단위테스트 - SpringJUnit4ClassRunner 의존성이 안들어오는 경우 pom.xml에 spring-test 확인할것.
	 *
	 */
/*
 * @RunWith(SpringJUnit4ClassRunner.class)
 * 
 * @ContextConfiguration(locations = {
 * "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
 * 
 * @Slf4j // import lombok.extern.slf4j.Slf4j; public class MemberMapperTest {
 * 
 * @Autowired private DataSource dataSource;
 * 
 * // 매퍼 인터페이스 의존성 주입
 * 
 * @Autowired private JobSeekerMapperInterface memberMapper;
 * 
 * 
 * @Autowired public BoardMapperTest(DataSource dataSource, BoardMapperInterface
 * boardMapper) { this.dataSource = dataSource; this.boardMapper = boardMapper;
 * }
 * 
 * 
 * @Test
 * 
 * @Ignore public void testDataSource() { try (Connection conn =
 * dataSource.getConnection()) { assertNotNull(conn);
 * System.out.println("획득한 커넥션: " + conn); } catch (Exception e) {
 * e.printStackTrace(); }
 * 
 * }
 * 
 *//**
	 * 매퍼 인터페이스의 의존성 주입이 정상적으로 되는지 확인하는 테스트 메소드
	 *//*
		 * @Test
		 * 
		 * @Ignore public void testMemberMapper() { assertNotNull(memberMapper); //
		 * boardMapper 객체 : org.apache.ibatis.binding.MapperProxy@14ac77b9
		 * log.info("boardMapper 객체 : " + memberMapper); // MapperProxy }
		 * 
		 * 
		 * // 회원 등록 테스트
		 * 
		 * @Test
		 * 
		 * @Ignore public void testcreateMember() { // 저정할 객체 생성 MemberVo memberVo = new
		 * MemberVo(); memberVo.setMemberId("java2"); memberVo.setPassword("1234");
		 * memberVo.setName("hong2"); memberVo.setEmail("abcd@a.com");
		 * 
		 * // 객체 저장 int result = memberMapper.createMember(memberVo); assertTrue(result
		 * > 0); log.info("저장된 행숭 : " + result); }
		 * 
		 * 
		 * 
		 * 
		 * // 게시물 수정 테스트
		 * 
		 * @Test
		 * 
		 * @Ignore public void testUpdateMember() { // 수정할 객체 생성 BoardVo boardVo = new
		 * 
		 * 
		 * }
		 * 
		 * 
		 * 
		 * }
		 */