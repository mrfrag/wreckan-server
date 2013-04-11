package com.github.wreckan.server;

import java.io.StringReader;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonTest {

	@Test
	public void testGson() {
		Gson gson = new Gson();
		Map<String, String> result = gson.fromJson(new StringReader("{\"key1\":\"value1\",\"key2\":\"value2\"}"), new TypeToken<Map<String, String>>() {
		}.getType());
		System.out.println(result.get("key1"));
	}

}
