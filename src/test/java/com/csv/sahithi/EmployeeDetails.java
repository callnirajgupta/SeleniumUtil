package com.csv.sahithi;

public class EmployeeDetails {
	

	
	      private String SSN;
	 
	     private String Employee;
	 
	     private String Assignment;
	 
	     private String FilingStatus;
	 
	     private String WithHolding;
	     private String Exempt;
	 
	     public EmployeeDetails(String SSN, String Employee, String Assignment, String FilingStatus , String WithHolding , String Exempt) {
	  
	         super();
	 
	         this.SSN = SSN;
	 
	         this.Employee = Employee;
	 
	         this.Assignment = Assignment;
	 
	         this.FilingStatus = FilingStatus;
	 
	         this.WithHolding = WithHolding;
	         this.Exempt=Exempt;
	 
	     }
	 
	
	   
	 
	     public String getSSN() {
			return SSN;
		}




		public String getEmployee() {
			return Employee;
		}




		public String getAssignment() {
			return Assignment;
		}




		public String getFilingStatus() {
			return FilingStatus;
		}




		public String getWithHolding() {
			return WithHolding;
		}




		public String getExempt() {
			return Exempt;
		}




		public void setSSN(String sSN) {
			SSN = sSN;
		}




		public void setEmployee(String employee) {
			Employee = employee;
		}




		public void setAssignment(String assignment) {
			Assignment = assignment;
		}




		public void setFilingStatus(String filingStatus) {
			FilingStatus = filingStatus;
		}




		public void setWithHolding(String withHolding) {
			WithHolding = withHolding;
		}




		public void setExempt(String exempt) {
			Exempt = exempt;
		}




		@Override
	 
	     public String toString() {
	 
	         return "Student [SSN=" + SSN + ", Employee=" + Employee
	 
	                 + ", Assignment=" + Assignment + ", FilingStatus=" + FilingStatus + ", WithHolding="
	 
	                 + WithHolding + "Exempt="+Exempt+"]";
	 
	     }


}
