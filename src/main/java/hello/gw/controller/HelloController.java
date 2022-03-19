package hello.gw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import hello.gw.converter.JSONConverter;
import hello.gw.dto.ArtistBaseInfo;
import hello.gw.service.ArtistBaseInfoService;

@RestController
public class HelloController {
	
	public static final String APPLICATION_JSON_VALUE = "application/json";
	public static final String APPLICATION_XML_VALUE = "application/xml";
	
	private ObjectMapper mapper = new ObjectMapper();

	
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
	
//	@GetMapping(path = "hello-all", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@GetMapping(path = "hello-all")
	public void helloString(HttpServletResponse response, HttpServletRequest request) throws IOException {
		try {
			if(request.getParameter("type").equals("json") || request.getParameter("type").equals(null)) {
				
				JSONConverter.json(response, service);
//				System.out.println("json 호출1 : " + request.getHeader("Accept")); 
//				response.addHeader("Accept", APPLICATION_JSON_VALUE);
				response.setContentType(APPLICATION_JSON_VALUE + ";charset=utf-8");
//				response.setHeader("Content-Type", APPLICATION_JSON_VALUE);
//				System.out.println(response.getContentType());
				// response에 contentType 세팅이 되었는데 클라이언트(크롬)으로 보내면 왜 다시 xml로 돌아오는걸까
				System.out.println("json 호출2 : " + request.getHeader("Accept")); 
				
				String result = mapper.writeValueAsString(service.artistBaseInfoAll()); 
				response.getWriter().write(result);

			}
			else if(request.getParameter("type").equals("xml")) {
				System.out.println("xml 호출1 : " + request.getHeader("Accept")); 
				response.setHeader("Accept", APPLICATION_XML_VALUE);
				response.setContentType(APPLICATION_XML_VALUE);
				System.out.println("xml 호출2 : " + request.getHeader("Accept")); 
//				return service.artistBaseInfoAll();
				//xml도 변환해서 보내는거 처리해줘야함
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
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
