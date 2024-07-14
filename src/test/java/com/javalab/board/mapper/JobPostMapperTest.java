package com.javalab.board.mapper;

// 필요한 클래스들을 import합니다.
import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.javalab.board.vo.JobPostVo;
import lombok.extern.slf4j.Slf4j;

// JUnit 테스트를 Spring과 함께 실행하기 위한 설정
@RunWith(SpringJUnit4ClassRunner.class)
// Spring 설정 파일의 위치를 지정합니다.
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
// Lombok을 사용하여 로깅 기능을 추가합니다.
@Slf4j
public class JobPostMapperTest {

	// DataSource 빈을 주입받습니다.
	@Autowired
	private DataSource dataSource;

	// JobPostMapperInterface 빈을 주입받습니다.
	@Autowired
	private JobPostMapperInterface jobPostMapper;

	// 데이터베이스 연결을 테스트하는 메서드
	@Test
	@Ignore // 이 테스트를 실행하지 않도록 설정합니다.
	public void testDataSource() {
		try (Connection conn = dataSource.getConnection()) {
			// 연결이 null이 아닌지 확인합니다.
			assertNotNull(conn);
			// 연결 정보를 로그로 출력합니다.
			log.info("획득한 커넥션: " + conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// JobPostMapper 빈이 제대로 주입되었는지 테스트하는 메서드
	@Test
	@Ignore
	public void testJobPostMapper() {
		// jobPostMapper가 null이 아닌지 확인합니다.
		assertNotNull(jobPostMapper);
		// jobPostMapper 객체 정보를 로그로 출력합니다.
		log.info("jobPostMapper 객체 : " + jobPostMapper);
	}

	// 모든 채용 공고를 조회하는 기능을 테스트하는 메서드
	@Test
	//@Ignore
	public void testGetAllJobPosts() {
		// 모든 채용 공고를 조회합니다.
		List<JobPostVo> jobPosts = jobPostMapper.getAllJobPosts();
		// 조회 결과가 null이 아닌지 확인합니다.
		assertNotNull(jobPosts);
		// 조회된 공고가 1개 이상인지 확인합니다.
		assertTrue(jobPosts.size() > 0);
		// 각 공고 정보를 로그로 출력합니다.
		jobPosts.forEach(jobPost -> log.info(jobPost.toString()));
	}

	// 특정 ID의 채용 공고를 조회하는 기능을 테스트하는 메서드
	@Test
	@Ignore
	public void testGetJobPostById() {
		// 테스트할 채용 공고 ID (실제 존재하는 ID로 변경해야 함)
		String jobPostId = "JP001";
		// ID로 채용 공고를 조회합니다.
		JobPostVo jobPost = jobPostMapper.getJobPostById(jobPostId);
		// 조회 결과가 null이 아닌지 확인합니다.
		assertNotNull(jobPost);
		// 조회된 공고 정보를 로그로 출력합니다.
		log.info("조회된 채용 공고: " + jobPost);
	}

	// 새로운 채용 공고를 등록하는 기능을 테스트하는 메서드
	@Test
	@Ignore
	public void testInsertJobPost() {
		// 새로운 JobPostVo 객체를 생성합니다.
		JobPostVo jobPost = new JobPostVo();
		// 채용 공고 정보를 설정합니다.
		jobPost.setJobPostId("JP003");
		jobPost.setCompId("COMP003");
		jobPost.setTitle("신입 설계자 채용");
		jobPost.setContent("신입 설계자를 모집합니다.");
		jobPost.setPosition("개발자");
		jobPost.setSalary("3000만원");
		jobPost.setExperience("신입");
		jobPost.setEducation("학사");
		jobPost.setAddress("서울시 강남구");
		// 현재 시간으로부터 30일 후를 마감일로 설정합니다.
		jobPost.setEndDate(new Timestamp(System.currentTimeMillis() + 30L * 24 * 60 * 60 * 1000));
		jobPost.setHomePage("http://www.example.com");

		// 채용 공고를 삽입하고 영향받은 행의 수를 받습니다.
		int result = jobPostMapper.insertJobPost(jobPost);
		// 삽입 결과가 1(한 행이 삽입됨)인지 확인합니다.
		assertEquals(1, result);
		// 삽입된 채용 공고의 ID를 로그로 출력합니다.
		log.info("삽입된 채용 공고 ID: " + jobPost.getJobPostId());
	}


	// 기존 채용 공고 정보를 수정하는 기능을 테스트하는 메서드
	@Test
	@Ignore
	public void testUpdateJobPost() {
		// 수정할 JobPostVo 객체를 생성합니다.
		JobPostVo jobPost = new JobPostVo();
		// 수정할 채용 공고의 ID를 설정합니다 (실제 존재하는 ID로 변경해야 함).
		jobPost.setJobPostId("JP001"); // 수정할 공고의 ID
		jobPost.setTitle("개발자");
		jobPost.setSalary("7000만원");
		// 다른 필드들은 null로 둡니다.

		// 채용 공고를 수정하고 영향받은 행의 수를 받습니다.
		int result = jobPostMapper.updateJobPost(jobPost);
		// 수정 결과가 1(한 행이 수정됨)인지 확인합니다.
		assertEquals(1, result);
		// 수정된 행의 수를 로그로 출력합니다.
		log.info("수정된 행 수: " + result);
	}

	// 특정 ID의 채용 공고를 삭제하는 기능을 테스트하는 메서드
	@Test
	@Ignore
	public void testDeleteJobPost() {
		// 삭제할 채용 공고의 ID (실제 존재하는 ID로 변경해야 함)
		String jobPostId = "JP001";
		// 채용 공고를 삭제하고 영향받은 행의 수를 받습니다.
		int result = jobPostMapper.deleteJobPost(jobPostId);
		// 삭제 결과가 1(한 행이 삭제됨)인지 확인합니다.
		assertEquals(1, result);
		// 삭제된 행의 수를 로그로 출력합니다.
		log.info("삭제된 행 수: " + result);
	}

	// 주어진 필터 조건에 맞는 채용 공고를 조회하는 기능을 테스트하는 메서드
	@Test
	@Ignore
	public void testGetFilteredJobPosts() {
		// 필터 조건을 담을 Map 객체를 생성합니다.
		Map<String, Object> filters = new HashMap<>();
		// 필터 조건을 설정합니다.
		filters.put("position", "개발자");
		filters.put("experience", "신입");
		filters.put("education", "학사");

		// 필터 조건에 맞는 채용 공고를 조회합니다.
		List<JobPostVo> filteredJobPosts = jobPostMapper.getFilteredJobPosts(filters);
		// 조회 결과가 null이 아닌지 확인합니다.
		assertNotNull(filteredJobPosts);
		// 조회된 각 공고 정보를 로그로 출력합니다.
		filteredJobPosts.forEach(jobPost -> log.info(jobPost.toString()));
	}

	// 특정 채용 공고의 조회수를 증가시키는 기능을 테스트하는 메서드
	@Test
	@Ignore
	public void testIncrementHitCount() {
		// 조회수를 증가시킬 채용 공고의 ID (실제 존재하는 ID로 변경해야 함)
		String jobPostId = "JP001";
		// 조회수를 증가시키고 영향받은 행의 수를 받습니다.
		int result = jobPostMapper.incrementHitCount(jobPostId);
		// 증가 결과가 1(한 행이 수정됨)인지 확인합니다.
		assertEquals(1, result);
		// 영향받은 행의 수를 로그로 출력합니다.
		log.info("조회수 증가 영향 받은 행 수: " + result);

		// 수정된 채용 공고를 다시 조회합니다.
		JobPostVo updatedJobPost = jobPostMapper.getJobPostById(jobPostId);
		// 증가된 조회수를 로그로 출력합니다.
		log.info("증가된 조회수: " + updatedJobPost.getHitNO());
	}
}