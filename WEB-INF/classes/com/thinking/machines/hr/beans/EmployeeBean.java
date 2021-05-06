package com.thinking.machines.hr.beans;
import java.util.*;//Date ke liye
import java.math.*;//BigDecimal ke liye
public class EmployeeBean implements java.io.Serializable,Comparable<EmployeeBean>
{
private String employeeId;
private String name;
private int designationCode;
private String dateOfBirth;
private String basicSalary;
private boolean isIndian;
private String gender;
private String panNumber;
private String aadharCardNumber;
private String designation;
public EmployeeBean()
{
this.employeeId="";
this.name="";
this.designationCode=0;
this.dateOfBirth="";
this.basicSalary="";
this.isIndian=false;
this.gender="";
this.panNumber="";
this.aadharCardNumber="";
this.designation="";
}
public boolean isMale()
{
return gender.equals("M");
}
public boolean isFemale()
{
return gender.equals("F");
}
public void setDesignation(String designation)
{
this.designation=designation;
}
public String getDesignation()
{
return this.designation;
}
public void setEmployeeId(String employeeId)
{
this.employeeId=employeeId;
}
public String getEmployeeId()
{
return this.employeeId;
}
public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}
public void setDesignationCode(int designationCode)
{
this.designationCode=designationCode;
}
public int getDesignationCode()
{
return this.designationCode;
}
public void setDateOfBirth(String dateOfBirth)
{
this.dateOfBirth=dateOfBirth;
}
public String getDateOfBirth()
{
return this.dateOfBirth;
}
public void setBasicSalary(String basicSalary)
{
this.basicSalary=basicSalary;
}
public String getBasicSalary()
{
return this.basicSalary;
}
public void setIsIndian(boolean isIndian)
{
this.isIndian=isIndian;
}
public boolean getIsIndian()
{
return this.isIndian;
}
public void setGender(String gender)
{
this.gender=gender;
}
public String getGender()
{
return this.gender;
}
public void setPanNumber(String panNumber)
{
this.panNumber=panNumber;
}
public String getPanNumber()
{
return this.panNumber;
}
public void setAadharCardNumber(String aadharCardNumber)
{
this.aadharCardNumber=aadharCardNumber;
}
public String getAadharCardNumber()
{
return this.aadharCardNumber;
}
public boolean equals(Object object)
{
if(!(object instanceof EmployeeBean))return false;
EmployeeBean other;
other=(EmployeeBean)object;
return this.employeeId.equals(other.getEmployeeId());
}
public int compareTo(EmployeeBean employeeBean)
{
return this.employeeId.toUpperCase().compareTo(employeeBean.getEmployeeId().toUpperCase());
}
public int hashCode()
{
return this.employeeId.hashCode();
}
}
