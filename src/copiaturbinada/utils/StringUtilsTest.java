package copiaturbinada.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringUtilsTest {

	@Test
	void testTakeExtensionAray1() {
		assertEquals("test", StringUtils.takeExtensionAway("test.txt"));
	}
	
	@Test
	void testTakeExtensionAray2() {
		assertEquals("test", StringUtils.takeExtensionAway("test.cript"));
	}
	
	@Test
	void testTakeExtensionAray3() {
		assertEquals("test", StringUtils.takeExtensionAway("test.zip"));
	}

	@Test
	void testTakeExtensionAray4() {
		assertEquals("test.zip", StringUtils.takeExtensionAway("test.zip.cript"));
	}
	
	@Test
	void testTO16Bytes1() {
		assertEquals("lets test it now", StringUtils.to16Bytes("lets test it now"));
	}
	
	@Test
	void testTO16Bytes2() {
		assertEquals("lets            ", StringUtils.to16Bytes("lets"));
	}
	
	@Test
	void testTO16Bytes3() {
		assertEquals("lets test it now", StringUtils.to16Bytes("lets test it now because i'm tired"));
	}
}
