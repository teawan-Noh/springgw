package hello.gw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import hello.gw.dto.ArtistBaseInfo;
import hello.gw.service.ArtistBaseInfoService;

@RestController
public class HelloController {
	
	public static final String APPLICATION_JSON_VALUE = "application/json";
	public static final String APPLICATION_XML_VALUE = "application/xml";
	
	@Autowired
	private ArtistBaseInfoService service;

	@GetMapping("hello")
	public String hello(Model model) {
		model.addAttribute("data", "hello!!");
		
		return "hello";
	}
	
	@GetMapping("hello-mvc")
	public String helloMvc(@RequestParam(value = "nm") String nm, Model model) {
		model.addAttribute("nm", nm);
		
		return "hello-template";
	}
	
	@GetMapping("hello-string")
	public String helloString(@RequestParam("nm") String nm) {
		return "hello "+nm; 
	}
	
	@GetMapping(path = "hello-all", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public List<ArtistBaseInfo> helloString(HttpServletResponse response, HttpServletRequest request) {
		try {
			if(request.getParameter("type").equals("json") || request.getParameter("type") == null) {
				System.out.println("json 호출1 : " + request.getHeader("Accept")); 
				response.setHeader("Accept", APPLICATION_JSON_VALUE);
//				response.setContentType(APPLICATION_JSON_VALUE);
				System.out.println("json 호출2 : " + request.getHeader("Accept")); 
			}
			else if(request.getParameter("type").equals("xml")) {
				System.out.println("xml 호출1 : " + request.getHeader("Accept")); 
				response.setHeader("Accept", APPLICATION_XML_VALUE);
//				response.setContentType(APPLICATION_XML_VALUE);
				System.out.println("xml 호출2 : " + request.getHeader("Accept")); 
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return service.artistBaseInfoAll(); 
	}
	
	@GetMapping("hello-api")
	public Hello helloApi(@RequestParam("nm") String nm) {
		Hello hello = new Hello();
		hello.setNm(nm);
		return hello;
	}
	
	static class Hello{
		private String nm;

		public String getNm() {
			return nm;
		}

		public void setNm(String nm) {
			this.nm = nm;
		}
		
		
	}
}
