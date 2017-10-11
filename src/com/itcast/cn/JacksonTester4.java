package com.itcast.cn;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class JacksonTester4 {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> userDataMap = new HashMap<String, Object>();
		UserData userdata = new UserData();
		int[] marks = {1,2,3};
		Emp e = new Emp();
		e.setName("jerry");
		e.setAge(45);
		userdata.setEmp(e);
		userdata.setName("Tom");
		userdata.setVerified(Boolean.FALSE);
		userdata.setIns(marks);
		
		TypeReference<UserData> ref = new TypeReference<UserData>() {
		};
		userDataMap.put("userDataMap", userdata);
		
		try {
			mapper.writeValue(new File("emp1.json"), userDataMap);
			Map m = mapper.readValue(new File("emp1.json"), ref);
			System.out.println(m.get("userDataMap"));
			
			
		} catch (JsonGenerationException e1) {
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
