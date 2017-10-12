package com.itcast.cn;
/**
 * 利用树模型解析Json字符串(把json解析成树)
 */
import java.io.IOException;
import java.util.Iterator;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JacksonTester5 {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = "{\"name\":\"Mahesh Kumar\", \"age\":21,"
			 		+ "\"verified\":false,\"marks\": [100,90,85]}";
			JsonNode jsonTree = mapper.readTree(jsonString);
			JsonNode nameNode = jsonTree.path("name");
			System.out.println(nameNode.getTextValue());
			
			JsonNode ageNode = jsonTree.path("age");
			System.out.println(ageNode.getIntValue());
			
			JsonNode booleanNode = jsonTree.path("verified");
			System.out.println(booleanNode.getBooleanValue());
			
			JsonNode marksNode = jsonTree.path("marks");
			System.out.print("Marks: [");
			Iterator it = marksNode.getElements();
			while(it.hasNext()){
				JsonNode marks = (JsonNode)it.next();
				System.out.print(marks.getIntValue() + " ");
			}
			System.out.println("]");
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
