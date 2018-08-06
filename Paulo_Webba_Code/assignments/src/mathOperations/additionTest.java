package mathOperations;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class additionTest {


	@Test
	public void testAddition() {
		Operations op = new Operations();
		double num = op.division(5, 2);
		assertEquals(2.5, num);
		//fail("Not yet implemented");
	}

}
