package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.beans.*;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.math.*;
import java.text.*;
public class UpdateEmployee extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
doPost(request,response);
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
HttpSession ss=request.getSession();
if(ss.getAttribute("username")==null)
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request,response);
}
EmployeeBean employeeBean;
employeeBean=(EmployeeBean)request.getAttribute("employeeBean");
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
String employeeId=employeeBean.getEmployeeId();
String name=employeeBean.getName();
int designationCode=employeeBean.getDesignationCode();
String dateOfBirth=employeeBean.getDateOfBirth();
String basicSalary=employeeBean.getBasicSalary();
String gender=employeeBean.getGender();
boolean isIndian=employeeBean.getIsIndian();
String panNumber=employeeBean.getPanNumber();
String aadharCardNumber=employeeBean.getAadharCardNumber();
boolean designationCodeExists=false;
boolean panNumberExists=false;
boolean aadharCardNumberExists=false;
EmployeeDAO employeeDAO=new EmployeeDAO();
try
{
designationCodeExists=new DesignationDAO().codeExists(designationCode);
panNumberExists=employeeDAO.panNumberExists(panNumber);
aadharCardNumberExists=employeeDAO.aadharCardNumberExists(aadharCardNumber);
EmployeeErrorBean employeeErrorBean=new EmployeeErrorBean();
if(panNumberExists)
{
if(employeeDAO.getByPANNumber(panNumber).getEmployeeId().equals(employeeId))panNumberExists=false;
}
if(aadharCardNumberExists)
{
if(employeeDAO.getByAadharCardNumber(aadharCardNumber).getEmployeeId().equals(employeeId))aadharCardNumberExists=false;
}
if(!designationCodeExists||panNumberExists||aadharCardNumberExists)
{
if(designationCodeExists==false)employeeErrorBean.setDesignationCodeError("Invalid designation code");
if(panNumberExists==true)employeeErrorBean.setPanNumberError("PAN Number already exists");
if(aadharCardNumberExists==true)employeeErrorBean.setAadharCardNumberError("Aadhar card number already exists");
request.setAttribute("employeeErrorBean",employeeErrorBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/EmployeeEditForm.jsp");
requestDispatcher.forward(request,response);
return;
}
EmployeeDTO employeeDTO=new EmployeeDTO();
employeeDTO.setEmployeeId(employeeId);
employeeDTO.setName(name);
employeeDTO.setDesignationCode(designationCode);
employeeDTO.setBasicSalary(new BigDecimal(basicSalary));
employeeDTO.setDateOfBirth(simpleDateFormat.parse(dateOfBirth));
if(gender.equals("M"))
{
employeeDTO.setGender(EmployeeDTO.MALE);
}
else
{
employeeDTO.setGender(EmployeeDTO.FEMALE);
}
employeeDTO.isIndian(isIndian);
employeeDTO.setPANNumber(panNumber);
employeeDTO.setAadharCardNumber(aadharCardNumber);
employeeDAO.update(employeeDTO);
MessageBean messageBean;
messageBean=new MessageBean();
messageBean.setHeading("Notification");
messageBean.setMessage("Employee updated");
messageBean.setGenerateButtons(true);
messageBean.setGenerateTwoButtons(false);
messageBean.setButtonOneText("Ok");
messageBean.setButtonOneAction("Employees.jsp");
request.setAttribute("messageBean",messageBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
System.out.println(daoException);
}
}catch(Exception exception)
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/ErrorPage.jsp");
try
{
requestDispatcher.forward(request,response);
}catch(Exception e)
{
// do nothing
}
}
}
} 
