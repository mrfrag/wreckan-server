package com.github.wreckan.server;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.Test;

public class PrintWriterTest {

	@Test
	public void testPrintWriter() {

		StringWriter sw = new StringWriter();
		PrintWriter text = new PrintWriter(sw);
		for (int i = 0; i < 3; i++) {
			text.println("key" + i + ": value" + i);
		}
//		text.flush();
		System.out.println(sw.toString());
	}

}
