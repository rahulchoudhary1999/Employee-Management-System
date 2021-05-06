package com.thinking.machines.hr.beans;
public class EmployeeErrorBean implements java.io.Serializable
{
private String designationCodeError;
private String panNumberError;
private String aadharCardNumberError;
public EmployeeErrorBean()
{
this.designationCodeError="";
this.panNumberError="";
this.aadharCardNumberError="";
}
public void setDesignationCodeError(String designationCodeError)
{
this.designationCodeError=designationCodeError;
}
public void setPanNumberError(String panNumberError)
{
this.panNumberError=panNumberError;
}
public void setAadharCardNumberError(String aadharCardNumberError)
{
this.aadharCardNumberError=aadharCardNumberError;
}
public String getDesignationCodeError()
{
return this.designationCodeError;
}
public String getPanNumberError()
{
return this.panNumberError;
}
public String getAadharCardNumberError()
{
return this.aadharCardNumberError;
}
}