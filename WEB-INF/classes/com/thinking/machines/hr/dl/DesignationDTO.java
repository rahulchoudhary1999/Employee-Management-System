package com.thinking.machines.hr.dl;
public class DesignationDTO implements java.io.Serializable,Comparable<DesignationDTO>
{
private int code;
private String title;
public DesignationDTO()
{
this.code=0;
this.title="";
}
public void setCode(int code)
{
this.code=code;
}
public int getCode()
{
return this.code;
}
public void setTitle(String title)
{
this.title=title;
}
public String getTitle()
{
return this.title;
}
//deep comparision
public boolean equals(Object object)
{
if(!(object instanceof DesignationDTO))return false;
DesignationDTO designationDTO;
designationDTO=(DesignationDTO)object;
return this.code==designationDTO.getCode();
}
//lexicographical comparison ya comaparable interface ke bare mai pdhle
public int compareTo(DesignationDTO designationDTO)
{
//return this.code-designationDTO.getCode();
return this.title.compareToIgnoreCase(designationDTO.title);
}
//collections classes mai internally inka heavy use hota hai
public int hashCode()
{
return this.code;
}
}