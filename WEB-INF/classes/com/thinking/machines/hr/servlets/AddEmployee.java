package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.beans.*;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.math.*;
import java.text.*;
public class AddEmployee extends HttpServlet
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
if(!designationCodeExists||panNumberExists||aadharCardNumberExists)
{
EmployeeErrorBean employeeErrorBean=new EmployeeErrorBean();
if(designationCodeExists==false)employeeErrorBean.setDesignationCodeError("Invalid designation code");
if(panNumberExists==true)employeeErrorBean.setPanNumberError("PAN Number alreay exists");
if(aadharCardNumberExists==true)employeeErrorBean.setAadharCardNumberError("Aadhar card number already exists");
request.setAttribute("employeeErrorBean",employeeErrorBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/EmployeeAddForm.jsp");
requestDispatcher.forward(request,response);
return;
}
EmployeeDTO employeeDTO=new EmployeeDTO();
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
employeeDAO.add(employeeDTO);
MessageBean messageBean;
messageBean=new MessageBean();
messageBean.setHeading("Employee (Add Module)");
messageBean.setMessage("Employee added,Add more?");
messageBean.setGenerateButtons(true);
messageBean.setGenerateTwoButtons(true);
messageBean.setButtonOneText("Yes");
messageBean.setButtonOneAction("EmployeeAddForm.jsp");
messageBean.setButtonTwoText("No");
messageBean.setButtonTwoAction("Employees.jsp");
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
