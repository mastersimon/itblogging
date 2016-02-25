package builder;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import student.Student;

public class XmlBuilder
{
	
	public void createXml() throws JAXBException
	{
		Student student = new Student();
		student.setFirstName("Simon");
		student.setLastName("Michel");
		student.setBirthday(new GregorianCalendar(1984,Calendar.DECEMBER,22).getTime());
		
		JAXBContext context = JAXBContext.newInstance(Student.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		marshaller.marshal(student, System.out);
		
		
	}

	public static void main(String[] args) throws JAXBException
	{
		new XmlBuilder().createXml();
	}
}
