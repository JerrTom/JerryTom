package com.itcast.cn;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * 使用流式API中JsonGenerator写入json(文件)
 * @author JINXIN
 *
 */

public class JacksonTester7 {

	public static void main(String[] args) {
		try {
			JsonFactory factory = new JsonFactory();
			JsonGenerator jsonGenerator = factory.createJsonGenerator(new File("emp3.json"), JsonEncoding.UTF8);
			jsonGenerator.writeStartObject();//{
			jsonGenerator.writeStringField("name", "Jerry");
			jsonGenerator.writeNumberField("age", 78);
			jsonGenerator.writeBooleanField("verified", false); 
			jsonGenerator.writeFieldName("marks");
			jsonGenerator.writeStartArray();//[
			jsonGenerator.writeNumber(100); 
	        jsonGenerator.writeNumber(90); 
	        jsonGenerator.writeNumber(85); 
			jsonGenerator.writeEndArray();//]
			jsonGenerator.writeEndObject();//}
			jsonGenerator.close();
			ObjectMapper mapper = new ObjectMapper();
			Map map = mapper.readValue(new File("emp3.json"), Map.class);
			System.out.println(map.get("name"));
	        System.out.println(map.get("age"));
		    System.out.println(map.get("verified"));
	        System.out.println(map.get("marks"));
	        System.out.println("ok");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
