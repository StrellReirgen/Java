package com.strell.dojo.controllers;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.strell.dojo.models.Tag;
import com.strell.dojo.models.Answer;
import com.strell.dojo.models.Question;
import com.strell.dojo.services.TagService;
import com.strell.dojo.services.AnswerService;
import com.strell.dojo.services.QuestionService;

@Controller
public class DojoController {
	private final QuestionService QuestServ;
	private final AnswerService AnsServ;
	private final TagService TagServ;
	public DojoController(QuestionService a, AnswerService c, TagService d){
        this.QuestServ = a;
        this.AnsServ = c;
        this.TagServ = d;
    }
	@RequestMapping("/questions")
    public String index(Model model) {
		List<Question> preguntas = QuestServ.allQuestion();
		model.addAttribute("items", preguntas);
        return "/index.jsp";
    }
	@RequestMapping("/questions/{id}")
    public String ShowQuest(Model model, @PathVariable("id") Long id) {
		Question quest = QuestServ.findQuestion(id);
		model.addAttribute("item", quest);
        return "/quest.jsp";
    }
	@RequestMapping(value="/questions/{id}", method=RequestMethod.POST)
    public String createAnswer(@PathVariable("id") Long id, @RequestParam(value="answer") String respuesta) {
		Question quest = QuestServ.findQuestion(id);
		Answer listo = new Answer(respuesta, quest);
		AnsServ.createAnswer(listo);
		return "redirect:/questions/"+id;
    }
	@RequestMapping("/questions/new")
    public String newQuest() {
        return "/newQuest.jsp";
    }
	@RequestMapping(value="/questions/new", method=RequestMethod.POST)
    public String createQuest(@RequestParam("quest") String pregunta, @RequestParam("tag") String etiqueta, RedirectAttributes errors) {
		List<Tag> eti = new ArrayList<Tag>();
		List<Answer> resp = new ArrayList<Answer>();
		List<Tag> antiguas = TagServ.allTag();
		etiqueta = etiqueta.toLowerCase();
		etiqueta = etiqueta.replace(" ","");
		String[] listo =  etiqueta.split(",");
		if (listo.length>3) {
			errors.addFlashAttribute("errors", "Solo se pueden maximo 3 Etiquetas");
			return "redirect:/questions/new";
		} else {
		boolean nuevo;
		for (int i = 0; i < listo.length;i++) {
			nuevo = true;
			int save = 0;
			for (int e = 0; e < antiguas.size();e++) {
				if(antiguas.get(e).getSubject().equals(listo[i])) {
					nuevo = false;
					save = e;
				}
			}
			if(nuevo) {
				List<Question> quest = new ArrayList<Question>();
				Tag ready = new Tag(listo[i], quest);
				TagServ.createTag(ready);
				eti.add(ready);
				System.out.println("nuevo");
			} else {
				Tag vieja = TagServ.findTag(antiguas.get(save).getId());
				eti.add(vieja);
				System.out.println("viejo");
			}
		}
		Question user = new Question(pregunta, resp, eti);
        QuestServ.createQuestion(user);
		return "redirect:/questions";
    }}
}
