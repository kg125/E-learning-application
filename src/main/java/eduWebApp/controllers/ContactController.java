package eduWebApp.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import eduWebApp.domain.Contact;
import eduWebApp.service.MailService;

@Controller
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	private MailService mailService;
	
	@RequestMapping(value ="/",method = RequestMethod.GET)
		public String contact(Model model) {
		model.addAttribute("contact", new Contact());
		return "Contact";
	}
	
	// allows users to send email 
	@RequestMapping(value ="/send", method = RequestMethod.POST)
	public String send(@ModelAttribute("contact") Contact contact ,ModelMap model) {
	
	try {

		String content = "Name: "+ contact.getName();
		content += "<br>Address " + contact.getFromAddress();
		content += "<br>Content " + contact.getContent();
		content += "<br>UserEmail " + contact.getEmail();
		
		mailService.send(contact.getEmail(), "topmarksfinalproject@gmail.com", contact.getSubject(), content);
		 model.put("msg", "Email has been sent successfully");

	} catch (Exception e) {
		 model.put("msg", e.getMessage());

	}
	return "Contact";
}



}


