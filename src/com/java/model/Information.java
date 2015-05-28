package com.java.model;

/**
 * <p>Description: </p>
 *
 * @author XuDing
 * @version 1.0
 */
public class Information
{
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String sex;
    private String nativePlace;
    private String birthday;

    public Information()
    {

    }

    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    @Override
    public String toString()
    {
        return "哈哈Information{" +
                "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", nativePlace='" + nativePlace + '\'' +
                ", id='" + id + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

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

    public int getId()
    {
        return id;
    }

    public void setId(int id)
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

}
