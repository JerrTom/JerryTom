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
			//��json�ַ������л���POJO�ࡣ
			Emp s = mapper.readValue(jsonString, Emp.class);
			System.out.println(s.toString());
			//��POJO��ת����json�ַ�����
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
