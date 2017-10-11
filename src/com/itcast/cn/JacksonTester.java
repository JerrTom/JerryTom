package com.itcast.cn;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JacksonTester {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "{\"name\":\"jinxin\",\"age\":\"25\"}";
		try {
			//将json字符串序列化成POJO类。
			Emp s = mapper.readValue(jsonString, Emp.class);
			System.out.println(s.toString());
			//将POJO类转换成json字符串。
			String jsonstring = mapper.writeValueAsString(s);
			System.out.println(jsonstring);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
