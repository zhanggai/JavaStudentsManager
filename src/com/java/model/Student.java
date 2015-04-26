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

	/* constructor */
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
		Object[] data = {getId(), getName(), getSex(), getNativePlace(), getBirthday()};
		return data;
	}

	/* getter and setter */
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getBirthday()
	{
		return birthday;
	}

	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}

	public String getNativePlace()
	{
		return nativePlace;
	}

	public void setNativePlace(String nativePlace)
	{
		this.nativePlace = nativePlace;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	@Override
	public String toString()
	{
		return "Student [name=" + name + ", birthday=" + birthday + ", nativePlace=" + nativePlace + ", id=" + id + ", sex=" + sex + "]";
	}

}
