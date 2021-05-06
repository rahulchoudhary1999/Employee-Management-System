<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm'%>
<tm:Module name='EMPLOYEE'/>
<jsp:include page='/MasterPageTopSection.jsp'/>
<script src='/styletwo/js/EmployeeDeleteForm.js'></script>
<link rel='stylesheet' type='text/css' href='/styletwo/css/employeesAddForm.css'/>
<jsp:useBean id="employeeBean" scope="request" class="com.thinking.machines.hr.beans.EmployeeBean"/>
<jsp:useBean id="employeeErrorBean" scope="request" class="com.thinking.machines.hr.beans.EmployeeErrorBean" />
<h2>Employee (Delete Module)</h2>
<form method='post' action='/styletwo/DeleteEmployee.jsp' onsubmit='return validateForm(this)'>
<!-- alignment shi nhi aa raha isliye table tag ka use krege , br tag ht dege-->
<input hidden id='employeeId' name='employeeId' value='${employeeBean.employeeId}'>
<tm:FormID/>
Name :<b>${employeeBean.name}</b><br>
Designation :<b>${employeeBean.getDesignation()}</b><br>
Date of birth :<b>${employeeBean.dateOfBirth}</b><br>
Gender :
<tm:If condition='${employeeBean.gender=="M"}'>
<b>Male</b>
</tm:If>
<tm:If condition='${employeeBean.gender=="F"}'>
<b>Female</b>
</tm:If>
<br>
Nationality :
<tm:If condition='${employeeBean.isIndian=="true"}'>
<b>Indian</b>
</tm:If>
<tm:If condition='${employeeBean.isIndian=="false"}'>
<b>Not an Indian</b>
</tm:If>
<br>
Basic salary :<b>${employeeBean.basicSalary}</b><br>
PAN Number :<b>${employeeBean.panNumber}</b><br>
Aadhar card number :<b>${employeeBean.aadharCardNumber}</b><br>
Are you sure you want to delete this employee ?<br><br>
<button type='submit'>Yes</button>
<button type='button' onclick='cancelDeletion()'>No</button>
</form>
<form id='cancelDeletionForm' action='/styletwo/Employees.jsp'>
</form>
<jsp:include page='/MasterPageBottomSection.jsp'/>
