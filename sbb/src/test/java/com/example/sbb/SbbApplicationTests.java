package com.example.sbb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.sbb.question.QuestionRepository;
import com.example.sbb.question.QuestionService;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
    private QuestionService questionService;

//	@Test
//	void testJpa() {
//		Question q1 = new Question();
//		q1.setSubject("sbb가 무엇인가요?");
//		q1.setContent("sbb에 대해서 알고 싶습니다.");
//		q1.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q1);
//
//		Question q2 = new Question();
//		q2.setSubject("스프링부트 모델 질문");
//		q2.setContent("id는 자동으로 생성되나요");
//		q2.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q2);
//
//	}

//	@Test
//	void testJpa() {
//		List<Question> all = this.questionRepository.findAll();
//		assertEquals(2, all.size());
//
//		Question q = all.get(0);
//		assertEquals("sbb가 무엇인가요?", q.getSubject());
//	}

//	@Test
//	void testJpa() {
//		Optional<Question> oq = this.questionRepository.findById(1);
//
//		if (oq.isPresent()) {
//			Question q = oq.get();
//			assertEquals("sbb가 무엇인가요?", q.getSubject());
//		}
//	}
//
//	@Test
//	void testFindBySubject() {
//		Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
//		assertEquals(1, q.getId());
//	}
//
//	@Test
//	void testFindBySubjectAndContent() {
//		Question q = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
//		assertEquals(1, q.getId());
//	}
//
//	@Test
//	void testFindBySubjectLike() {
//		List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
//
//		Question q = qList.get(0);
//		assertEquals("sbb가 무엇인가요?", q.getSubject());
//
//	}

//	@Test
//	void testUpdate() {
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		q.setSubject("수정된 제목");
//		this.questionRepository.save(q);
//	}

//	@Test
//	void testDelete() {
//		assertEquals(2, this.questionRepository.count());
//		Optional<Question> oq = this.questionRepository.findById(1);
//
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//
//		this.questionRepository.delete(q);
//		assertEquals(1, this.questionRepository.count());
//	}
	
//	@Test
//    void testJpa() {
//        for (int i = 1; i <= 300; i++) {
//            String subject = String.format("테스트 데이터입니다:[%03d]", i);
//            String content = "내용무";
//            this.questionService.create(subject, content);
//        }
//    }
	
}
