package controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import net.madvirus.spring4.chap07.event.EventForm;
import net.madvirus.spring4.chap07.event.EventFormStep1Validator;

//session으로 처리를 해서 뒤로 돌아가도 자료 가 남아 있음
@Controller
@SessionAttributes("eventForm")
public class EvnetCreationController {
	private static final String EVENT_CREATION_STEP1="event/creationStep1";
	private static final String EVENT_CREATION_STEP2="event/creationStep2";
	private static final String EVENT_CREATION_STEP3="event/creationStep3";
	private static final String EVENT_CREATION_DONE="event/creationDone";
	//해당되는 method의 return타입으로 객체화 시켜서 보낸다. eventForm으로 
	//이름이 없는 경우도 있는데 해당 method를 그냥 실행
	@ModelAttribute("eventForm")
	public EventForm formData(){
		return new EventForm();
	}
	@RequestMapping("/newevent/step1")
	public String step1(){
		return EVENT_CREATION_STEP1;
	}
	//같은 이름의 filed안에 같은 값을 저장
	@RequestMapping(value="/newevent/step2",method=RequestMethod.POST)
	public String step2(@ModelAttribute("eventForm") EventForm formData, BindingResult result){
		new EventFormStep1Validator().validate(formData, result);
		if(result.hasErrors())
			return EVENT_CREATION_STEP1;
		return EVENT_CREATION_STEP2;
	}
	@RequestMapping(value="/newevent/step2", method=RequestMethod.GET)
	public String step2FromStep3(@ModelAttribute("eventForm") EventForm formData){
		return EVENT_CREATION_STEP2;
	}
	@RequestMapping(value="/newevent/step3",method=RequestMethod.POST)
	public String step3(@ModelAttribute("eventForm") EventForm formData, BindingResult result){
		ValidationUtils.rejectIfEmpty(result, "target", "required");
		if(result.hasErrors())
			return EVENT_CREATION_STEP2;
		return EVENT_CREATION_STEP3;
	}
	@RequestMapping(value="/newevent/done",method=RequestMethod.POST)
	public String done(@ModelAttribute("eventForm") EventForm formData, SessionStatus sessionStatus){
		//session을 죽인다.
		sessionStatus.setComplete();
		return EVENT_CREATION_DONE;
	}
}
