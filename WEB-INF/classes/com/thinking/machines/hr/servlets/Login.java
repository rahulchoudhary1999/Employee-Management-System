package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Login extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
AdministratorBean administratorBean;
administratorBean=(AdministratorBean)request.getAttribute("administratorBean");
if(administratorBean==null)
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request,response);
}
AdministratorDTO administratorDTO;
AdministratorDAO administratorDAO=new AdministratorDAO();
try
{
administratorDTO=administratorDAO.getByUsername(administratorBean.getUsername());
if(administratorBean.getPassword().equals(administratorDTO.getPassword()))
{
HttpSession session=request.getSession();
session.setAttribute("username",administratorDTO.getUsername());
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/index.jsp");
requestDispatcher.forward(request,response);
}
else
{
ErrorBean errorBean=new ErrorBean();
errorBean.setError("Invalid username / password");
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request,response);
}
}catch(DAOException daoException)
{
ErrorBean errorBean=new ErrorBean();
errorBean.setError(daoException.getMessage());
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
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
}
}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}
}