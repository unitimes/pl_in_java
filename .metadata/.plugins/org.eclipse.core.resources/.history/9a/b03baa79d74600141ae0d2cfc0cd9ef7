package userInterface;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class UserInterfaceTest {

	@Test
	public void testEndingMsg() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		UserInterface userInterface = new UserInterface();
		Class<?> targetClass = userInterface.getClass();
		Method printGoodbyeMsg = targetClass.getDeclaredMethod("printGoodbyeMsg", null);
		printGoodbyeMsg.setAccessible(true);
		System.out.println(printGoodbyeMsg.invoke(userInterface, null));
	}
}
