package com.thinking.machines.hr.bl;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import java.util.*;
import java.text.*;//simpledateformat ke liye
public class EmployeeBL
{
public List<EmployeeBean> getAll()
{
List<EmployeeBean> employees=new LinkedList<>();
try
{
EmployeeDAO EmployeeDAO=new EmployeeDAO();
List<EmployeeDTO> dlEmployees=EmployeeDAO.getAll();
EmployeeBean employeeBean;
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
for(EmployeeDTO dlEmployee:dlEmployees)
{
employeeBean=new EmployeeBean();
employeeBean.setEmployeeId(dlEmployee.getEmployeeId());
employeeBean.setName(dlEmployee.getName());
employeeBean.setDesignationCode(dlEmployee.getDesignationCode());
employeeBean.setDesignation(dlEmployee.getDesignation());
employeeBean.setDateOfBirth(simpleDateFormat.format(dlEmployee.getDateOfBirth()));
employeeBean.setGender(dlEmployee.getGender());
employeeBean.setIsIndian(dlEmployee.isIndian());
employeeBean.setBasicSalary(dlEmployee.getBasicSalary().toPlainString());
employeeBean.setAadharCardNumber(dlEmployee.getAadharCardNumber());
employeeBean.setPanNumber(dlEmployee.getPANNumber());
employees.add(employeeBean);
}
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());//to be changed later on
}
return employees;
}
}