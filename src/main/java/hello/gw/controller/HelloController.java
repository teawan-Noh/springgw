package hello.gw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import hello.gw.dto.ArtistBaseInfo;
import hello.gw.service.ArtistBaseInfoService;

@Controller
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
	@ResponseBody
	public String helloString(@RequestParam("nm") String nm) {
		return "hello "+nm; 
	}
	
	@GetMapping("hello-all")
	@ResponseBody
	public List<ArtistBaseInfo> helloString(HttpServletResponse response) {
		
		return service.artistBaseInfoAll(); 
	}
	
//	@GetMapping("hello-all")
//	@ResponseBody
//	public void helloString2(@RequestParam("type") String type,HttpServletResponse response) {
//		//타입이 json일경우
//		String resultType = type;
//		//String resultType = "xml"
//
//		if("xml".equals(resultType)) {
//
//		response.setContentType("application/xml");
//		response.setCharacterEncoding("UTF-8");
//		try {
//			response.getWriter().write(new XmlMapper().writeValueAsString(service.artistBaseInfoAll()));
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		}
//
//		//타입이 json일경우
//		else {
//		response.setContentType("application/json");
//		response.setCharacterEncoding("UTF-8");
//		try {
//			response.getWriter().write(new ObjectMapper().writeValueAsString(service.artistBaseInfoAll()));
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		}
//	}
	
	@GetMapping("hello-api")
	@ResponseBody
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
