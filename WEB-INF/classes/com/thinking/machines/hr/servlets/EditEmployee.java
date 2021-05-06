package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.text.*;
public class EditEmployee extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
String employeeId="";
try
{
employeeId=request.getParameter("employeeId");
EmployeeDAO employeeDAO;
employeeDAO=new EmployeeDAO();
try
{
EmployeeDTO employeeDTO=employeeDAO.getByEmployeeId(employeeId);
EmployeeBean employeeBean;
employeeBean=new EmployeeBean();
employeeBean.setEmployeeId(employeeId);
employeeBean.setName(employeeDTO.getName());
employeeBean.setDesignationCode(employeeDTO.getDesignationCode());
employeeBean.setBasicSalary(employeeDTO.getBasicSalary().toString());
employeeBean.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").format(employeeDTO.getDateOfBirth()));
if(employeeDTO.getGender().equals("Male"))
{
employeeBean.setGender("M");
}
else
{
employeeBean.setGender("F");
}
employeeBean.setIsIndian(employeeDTO.isIndian());
employeeBean.setPanNumber(employeeDTO.getPANNumber());
employeeBean.setAadharCardNumber(employeeDTO.getAadharCardNumber());
request.setAttribute("employeeBean",employeeBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/EmployeeEditForm.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/Employees.jsp");
requestDispatcher.forward(request,response);
}
}catch(Exception e)
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/ErrorPage.jsp");
try
{
requestDispatcher.forward(request,response);
}catch(Exception exception)
{
//nothing
}
}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}
}