package copiaturbinada.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringUtilsTest {

	@Test
	void test1() {
		assertEquals("test", StringUtils.takeExtensionAway("test.txt"));
	}
	
	@Test
	void test2() {
		assertEquals("test", StringUtils.takeExtensionAway("test.cript"));
	}
	
	@Test
	void test3() {
		assertEquals("test", StringUtils.takeExtensionAway("test.zip"));
	}

	@Test
	void test4() {
		assertEquals("test.zip", StringUtils.takeExtensionAway("test.zip.cript"));
	}
}
