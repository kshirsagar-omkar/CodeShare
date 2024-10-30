package com.tca.entities.staff;

public class PartTimeStaff extends Staff{

    private double noOfHoursStaffWorks;
    private double staffHourlyRate;
    private double staffSalary;

    public PartTimeStaff()
    {
        super("NA", "NA");
        this.noOfHoursStaffWorks = 0.00;
        this.staffHourlyRate = 0.00;
        this.staffSalary = 0.00;
    }

    public PartTimeStaff(String staffName, String staffAddress, double noOfHoursStaffWorks, double staffHourlyRate) {
        super(staffName, staffAddress);
        this.noOfHoursStaffWorks = noOfHoursStaffWorks;
        this.staffHourlyRate = staffHourlyRate;
        this.staffSalary = this.noOfHoursStaffWorks * this.staffHourlyRate;
    }

    public double getNoOfHoursStaffWorks() {
        return noOfHoursStaffWorks;
    }

    public void setNoOfHoursStaffWorks(double noOfHoursStaffWorks) {
        this.noOfHoursStaffWorks = noOfHoursStaffWorks;
    }

    public double getStaffHourlyRate() {
        return staffHourlyRate;
    }

    public void setStaffHourlyRate(double staffHourlyRate) {
        this.staffHourlyRate = staffHourlyRate;
    }

    public double getStaffSalary() {
        return staffSalary;
    }

    public void setStaffSalary() {
        this.staffSalary = this.noOfHoursStaffWorks * this.staffHourlyRate;
    }

    public void displayStaffInformation() {
        System.out.println("Staff Name                        : " + super.getStaffName());
        System.out.println("Staff Address                     : " + super.getStaffAddress());
        System.out.println("Staff no. of Hours Staff Works    : "+this.noOfHoursStaffWorks);
        System.out.println("Staff staff Work Rate             : "+this.staffHourlyRate);
        System.out.println("Staff staff Salary                : "+this.staffSalary);
        System.out.println("----------------------------------------");
    }  
}
