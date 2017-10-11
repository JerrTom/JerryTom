package com.itcast.cn;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * 将Java对象序列化到一个JSON文件，然后再读取JSON文件获取转换为对象。
 * @author JINXIN
 *
 */
public class JacksonTester2 {

	public static void main(String[] args) {
		JacksonTester2 tester2 = new JacksonTester2();
		try {
			Emp e = new Emp();
			e.setName("jerry");
			e.setAge(20);
			tester2.writeJson(e);
			
			Emp emp = tester2.readJson();
			System.out.println(emp.toString());
		} catch (JsonGenerationException e1) {
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public void writeJson(Emp e) throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("emp.json"), e);
	}
	public Emp readJson() throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		Emp e = mapper.readValue(new File("emp.json"), Emp.class);
		return e;
	}
}
