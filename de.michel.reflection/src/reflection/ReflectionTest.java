package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class ReflectionTest
{
	
	public static void main(String[] args) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException
	{
		reflectionInformation();
	}

	private static void reflectionInformation() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException
	{
//		A a = new A();
//		Class<?> option1 = a.getClass();
		
//		System.out.println(option1.getPackage());
//		System.out.println(option1.getSuperclass());
//		System.out.println(option1.getInterfaces());
//		System.out.println(option1.getName());
//		System.out.println("Mods: " + option1.getModifiers());
//		System.out.println(option1.getConstructors());
//		System.out.println(option1.getAnnotations());
//		System.out.println(option1.getMethods());
//		System.out.println(option1.getFields());
//		System.out.println();
//		System.out.println();
//		
//		java.lang.reflect.Modifier.isStatic(0);

		Person person = new Person();
		Class<?> option1 = person.getClass();
		
		// privates Attribut "helloWorld" laden
		Field password = option1.getDeclaredField("password");
		// Zugriffseinschränkung aufheben
		password.setAccessible(true);
		// Attribut neu setzen
		password.set(person, "weltmeister");
		// Ausgabe des neuen Wertes.
		System.out.println(password.get(person));
		
		// privates Attribut "helloWorld" laden
			Field helloWorld = option1.getDeclaredField("password2");
			// Zugriffseinschränkung aufheben
			helloWorld.setAccessible(true);
			// Attribut neu setzen
			helloWorld.set(null, "weltmeister2222");
			// Ausgabe des neuen Wertes.
			System.out.println(helloWorld.get(person));
			
			
			// Methode laden
			Method method = option1.getDeclaredMethod("getPassword");
			// Zugriffseinschränkung aufheben
			method.setAccessible(true);
			// Methode ausführen und den Rückgabewert speichern
			String personPassword = (String) method.invoke(person);
			// Ausgabe des Passworts
			System.out.println(personPassword);
			
	}

}

class A
{
	private String helloWorld = "halloWelt!!!";
	
}

class Person
{
	private String password = "europameister";
	private static String password2 = "europameister";
	
	private String getPassword()
	{
		return password;
	}
}
