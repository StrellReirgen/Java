package com.strell.dojo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.strell.dojo.models.Answer;
import com.strell.dojo.models.Question;
import com.strell.dojo.models.Tag;
import com.strell.dojo.services.AnswerService;
import com.strell.dojo.services.QuestionService;
import com.strell.dojo.services.TagService;

@RestController
public class DojoApi {
	private final QuestionService QuestServ;
	private final AnswerService AnsServ;
	private final TagService TagServ;
	public DojoApi(QuestionService a, AnswerService b, TagService c){
        this.QuestServ = a;
        this.AnsServ = b;
        this.TagServ = c;
    }
	@RequestMapping("/api/questions")
    public List<Question> indexA() {
        return QuestServ.allQuestion();
    }
	@RequestMapping(value="/api/questions/{id}", method=RequestMethod.DELETE)
    public void destroyP(@PathVariable("id") Long id) {
		QuestServ.deleteQuestion(id);
    }
	
	@RequestMapping("/api/tags")
    public List<Tag> indexB() {
        return TagServ.allTag();
    }
	
	@RequestMapping(value="/api/tags/{id}", method=RequestMethod.DELETE)
    public void destroyL(@PathVariable("id") Long id) {
		TagServ.deleteTag(id);
    }
	
	@RequestMapping("/api/answers")
    public List<Answer> indexC() {
        return AnsServ.allAnswer();
    }
	
	@RequestMapping(value="/api/answers/{id}", method=RequestMethod.DELETE)
    public void destroyC(@PathVariable("id") Long id) {
		AnsServ.deleteAnswer(id);
    }
}
