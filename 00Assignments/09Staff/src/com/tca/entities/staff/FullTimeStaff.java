package com.tca.entities.staff;

public class FullTimeStaff extends Staff {

    private String staffDepartment;
    private double staffSalary;

    public FullTimeStaff() {
        super("NA", "NA");
        this.staffDepartment = "NA";
        this.staffSalary = 0.00;
    }

    public FullTimeStaff(String staffName, String staffAddress, String staffDepartment, double staffSalary) {
        super(staffName, staffAddress);
        this.staffDepartment = staffDepartment;
        this.staffSalary = staffSalary;
    }

    public String getStaffDepartment() {
        return staffDepartment;
    }

    public void setStaffDepartment(String staffDepartment) {
        this.staffDepartment = staffDepartment;
    }

    public double getStaffSalary() {
        return staffSalary;
    }

    public void setStaffSalary(double staffSalary) {
        this.staffSalary = staffSalary;
    }


    public void displayStaffInformation() {
        System.out.println("Staff Name          : "+super.getStaffName());
        System.out.println("Staff Address       : "+super.getStaffAddress());
        System.out.println("Staff Department    : "+this.staffDepartment);
        System.out.println("Staff Salary        : "+this.staffSalary);
        System.out.println("----------------------------------------");
    }
}
