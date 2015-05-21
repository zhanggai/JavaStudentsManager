package com.java.model;

/**
 * <p>
 * Description:Students
 * </p>
 *
 * @author XuDing
 * @version 1.0
 * @date 2015/4/21
 */
public class Student
{
	private String name;
	private String birthday;
	private String nativePlace;
	private String id;
	private String sex;

	public Student()
	{
		this("2014011176", "王晓明", "男", "河北", "1996.1.1");
	}

	public Student(String id, String name, String sex, String nativePlace, String birthday)
	{
		this.name = name;
		this.birthday = birthday;
		this.nativePlace = nativePlace;
		this.id = id;
		this.sex = sex;
	}

	public Object[] getData()
	{
		return new Object[]{getId(), getName(), getSex(), getNativePlace(), getBirthday()};
	}

	public String getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSex()
	{
		return sex;
	}

	public String getNativePlace()
	{
		return nativePlace;
	}

	public String getBirthday()
	{
		return birthday;
	}

	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}

	public void setNativePlace(String nativePlace)
	{
		this.nativePlace = nativePlace;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public void setId(String id)
	{
		this.id = id;
	}
}
