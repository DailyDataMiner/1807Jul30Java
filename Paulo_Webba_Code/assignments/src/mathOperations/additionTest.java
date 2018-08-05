package mathOperations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class additionTest {


	@Test
	public void testAddition() {
		Operations op = new Operations();
		int num = op.addition(4, 3);
		assertEquals(7, num);
		fail("Not yet implemented");
	}

}
