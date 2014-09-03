package net.slipp.qna;

import java.util.List;

public class QnAService {
	private Database database = new Database();
	
	public void create(Question question, String plainTags) {
		// TODO 쉼표로 구분되는 tags를 분리한다.
		// TODO 분리한 문자열을 활용해 Tag 인스턴스를 생성한다.
		// TODO question에 Tag를 추가해야 한다.
		database.insert(question);
	}
	
	public Question findQuestionById(int questionId) {
		return database.findQuestionById(questionId);
	}
	
	public void answer(int questionId, Answer answer) {
		Question question = database.findQuestionById(questionId);
		// TODO Question에 Answer 인스턴스를 추가한다.
	}
	
	public void update(Question question, String plainTags) {
		Question existedQuestion = database.findQuestionById(question.getId());
		existedQuestion.update(question);
		
	}

	public List<Question> findsQuestionByIdDesc() {
		return null;
	}
}
