package com.thinking.machines.hr.beans;
public class ModuleBean implements java.io.Serializable
{
private enum MODULE{HOME,DESIGNATION,EMPLOYEE};
public final static MODULE HOME=MODULE.HOME;
public final static MODULE DESIGNATION=MODULE.DESIGNATION;
public final static MODULE EMPLOYEE=MODULE.EMPLOYEE;
public MODULE module;
public void setModule(String module)
{
if(module.equals("MODULE.HOME"))
{
this.module=MODULE.HOME;
}
}
public MODULE getModule()
{
return this.module;
}
}