package controller;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.madvirus.spring4.chap07.event.Event;
import net.madvirus.spring4.chap07.event.EventType;
import net.madvirus.spring4.chap07.event.SearchOption;
import service.EventService;

@Controller
			/*back단이다*/
@RequestMapping("/event")
public class EventController {
	private static final String REDIRECT_EVENT_LIST = "redirect:/event/list";
	@Autowired
	private EventService eventService;
	public EventController(){
		eventService = new EventService();
	}
	//Client date format은 String이다 따라서 설정 해 준다.
	//@InitBinder란 Spring Validator를 사용 시 @Valid annotation으로 검증이 필요한 객체를
	//가져오기 전에 수행할 method를 지정해주는 annotation이다
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		CustomDateEditor dateEditor
		= new CustomDateEditor(new SimpleDateFormat("yyyyMMdd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}
	@ModelAttribute("recEventList")
	public List<Event>recommend(){
		return eventService.getRecommendedEventService();
	}
	//Model 객체를 파리미터로 받아서 데이터를 뷰로 넘길 수 있다.
	@RequestMapping("/list")
	public String list(SearchOption option, Model model){ 
		List<Event> eventList = eventService.getOpenedEventList(option);
		model.addAttribute("eventList",eventList);
		model.addAttribute("eventTypes",EventType.values());
		return "event/list";
	}
	//ModelandView
	@RequestMapping("/list2")
	public ModelAndView list2(SearchOption option){
		List<Event> eventList = eventService.getOpenedEventList(option);
		ModelAndView modelView = new ModelAndView();
		//뷰의 경로
		modelView.setViewName("event/list");
		//addObject() method를 이용한다.
		modelView.addObject("eventList",eventList);
		modelView.addObject("eventTypes",EventType.values());
		//그리고 modelView객체를 반환한다.
		return modelView;
	}
	@RequestMapping("/detail")
	public String detail(HttpServletRequest request, Model model) throws IOException{
		String id = request.getParameter("id");
		if(id==null) return REDIRECT_EVENT_LIST;
		Long eventId = null;
		try{
			eventId = Long.parseLong(id);
		} catch(NumberFormatException e){
			return REDIRECT_EVENT_LIST;
		}
		Event event = getEvent(eventId);
		if(event==null) return REDIRECT_EVENT_LIST;
		
		model.addAttribute("event", event); return "event/detail";
	}
	public Event getEvent(Long eventId){
		return eventService.getEvent(eventId);
	}
											//defaultValue="1"
											//존재하지 않다면 default값으로 지정 가능하다.
					//required=false일 경우에는 키값이 존재하지 않다고 해서 BadRequest가 발생하지 않고,
					//지정한 error화면으로 이동
	@RequestMapping("/detail2")
	public String detail2(@RequestParam(value="id", required=false) long eventId, Model model){
		Event event = getEvent(eventId);
		if(event==null) 
			return REDIRECT_EVENT_LIST;
		model.addAttribute("event",event);
		return "event/detail";
	}

}
