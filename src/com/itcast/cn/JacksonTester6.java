package com.itcast.cn;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;

/**
 * 创建Tree，将树读取成json文件，再读取json文件。
 * @author JINXIN
 *
 */
public class JacksonTester6 {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			
			ObjectNode rootNode =  mapper.createObjectNode();
			ArrayNode marks =  mapper.createArrayNode();
			
//			JsonNode rootTree =  mapper.createObjectNode();
			//JsonNode marks =  mapper.createArrayNode();
			marks.add(12);
			marks.add(45);
			marks.add(96);
			rootNode.put("name", "jerry");
			rootNode.put("verfield", Boolean.FALSE);
			rootNode.put("age", 35);
			rootNode.put("marks", marks);
			mapper.writeValue(new File("emp2.json"), rootNode);
			System.out.println("ok");
			JsonNode jsonTree =  mapper.readTree(new File("emp2.json"));
			JsonNode nameNode = jsonTree.path("name");
			System.out.println(nameNode.getTextValue());
			JsonNode booleanNode = jsonTree.path("verfield");
			System.out.println(booleanNode.getBooleanValue());
			JsonNode ageNode = jsonTree.path("age");
			System.out.println(ageNode.getIntValue());
			JsonNode arrayNode = jsonTree.path("marks");
			System.out.print("Marks: [");
			Iterator it = arrayNode.getElements();
			while(it.hasNext()){
				JsonNode jsonNode= (JsonNode) it.next();
				System.out.print(jsonNode.getIntValue() + " ");
			}
			System.out.println("]");
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
