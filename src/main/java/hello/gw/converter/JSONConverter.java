package hello.gw.converter;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import hello.gw.service.ArtistBaseInfoService;

public class JSONConverter {

	private static final String APPLICATION_JSON_VALUE = "application/json";

	public static void json(HttpServletResponse response, ArtistBaseInfoService service) {
		JSONObject jo = new JSONObject(service.artistBaseInfoAll());
		response.setHeader("Accept", APPLICATION_JSON_VALUE);
		System.out.println(jo);
		
//		JSONArray jsonArray = JSONArray.toJSONObject(service.artistBaseInfoAll());
	}
}
