package student;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student
{
	private String firstName;
	private String lastName;
	private Date birthday;
	private String studyPath;
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public Date getBirthday()
	{
		return birthday;
	}
	
	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}
	
	public String getStudyPath()
	{
		return studyPath;
	}
	
	public void setStudyPath(String studyPath)
	{
		this.studyPath = studyPath;
	}
}
