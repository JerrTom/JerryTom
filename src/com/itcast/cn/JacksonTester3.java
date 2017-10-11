package com.itcast.cn;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JacksonTester3 {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> empDataMap = new HashMap<String, Object>();
		Emp e = new Emp();
		e.setName("jerry");
		e.setAge(12);
		int[] ins = {1,2,3};
		
		empDataMap.put("emp", e);
		empDataMap.put("Array", ins);
		empDataMap.put("verified", Boolean.FALSE);
		empDataMap.put("name", "Tom");
		System.out.println(empDataMap.get("emp"));
		try {
			//将map转换成json文件
			/**
			 * {"verified":false,"name":"Tom","Array":[1,2,3],"emp":{"name":"jerry","age":12}}
			 */
			mapper.writeValue(new File("emp.json"), empDataMap);
			
			//将json文件转换成Map类型
			Map m = mapper.readValue(new File("emp.json"), Map.class);
			System.out.println(m.get("emp"));
			System.out.println(m.get("Array"));
			System.out.println(m.get("verified"));
			System.out.println(m.get("name"));
		} catch (JsonGenerationException e1) {
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
