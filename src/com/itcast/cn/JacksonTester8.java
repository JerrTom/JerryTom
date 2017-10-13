package com.itcast.cn;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

/**
 * 使用流式API中的jsonParser类读取json
 * @author JINXIN
 *
 */
public class JacksonTester8 {

	public static void main(String[] args) {
		try {
			JsonFactory factory = new JsonFactory();
			JsonParser jsonParser = factory.createJsonParser(new File("emp3.json"));
			while(jsonParser.nextToken() != JsonToken.END_OBJECT){
				String fieldName = jsonParser.getCurrentName();
				if("name".equals(fieldName)){
					//move to next token
					jsonParser.nextToken();
					System.out.println(jsonParser.getText());
				}
				if("age".equals(fieldName)){
		            //move to next token
		            jsonParser.nextToken();
		            System.out.println(jsonParser.getNumberValue());        	 
		        }
		        if("verified".equals(fieldName)){
		            //move to next token
		            jsonParser.nextToken();
		            System.out.println(jsonParser.getBooleanValue());        	 
		        }
				if("marks".equals(fieldName)){
					//move to next token
					jsonParser.nextToken();
					System.out.print("[");
					while(jsonParser.nextToken() != JsonToken.END_ARRAY){
						System.out.print(jsonParser.getNumberValue()+" ");
					}
					System.out.println("]");
				}
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
