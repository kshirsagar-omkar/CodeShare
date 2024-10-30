    package com.tca.entities.student;

    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.time.Period;

    public class Student {
        private int studentRollNumber;
        private String studentName;
        private double studentPercentage;
        private LocalDate studentJoinDate;
        private LocalDate studentBirthDate;
        private LocalDateTime studentTimeStamp;
        private byte studentAge;               // Calculate From studentBirthDate

        public Student() {
            this.studentRollNumber = 0;
            this.studentName = null;
            this.studentPercentage = 0.00;
            this.studentJoinDate = null;
            this.studentBirthDate = null;
            this.studentTimeStamp = null;
            this.studentAge = 0;
        }

        public Student(int studentRollNumber, String studentName, double studentPercentage, LocalDate studentJoinDate, LocalDate studentBirthDate, LocalDateTime studentTimeStamp) {
            this.studentRollNumber = studentRollNumber;
            this.studentName = studentName;
            this.studentPercentage = studentPercentage;
            this.studentJoinDate = studentJoinDate;
            this.studentBirthDate = studentBirthDate;
            this.studentTimeStamp = studentTimeStamp;
            this.studentAge = Byte.parseByte ( String.valueOf( ( Period.between( studentBirthDate , LocalDate.now() ) ).getYears() ) );
        }


        public int getStudentRollNumber() {
            return studentRollNumber;
        }

        public void setStudentRollNumber(int studentRollNumber) {
            this.studentRollNumber = studentRollNumber;
        }

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public double getStudentPercentage() {
            return studentPercentage;
        }

        public void setStudentPercentage(double studentPercentage) {
            this.studentPercentage = studentPercentage;
        }

        public LocalDate getStudentJoinDate() {
            return studentJoinDate;
        }

        public void setStudentJoinDate(LocalDate studentJoinDate) {
            this.studentJoinDate = studentJoinDate;
        }

        public LocalDate getStudentBirthDate() {
            return studentBirthDate;
        }

        public void setStudentBirthDate(LocalDate studentBirthDate) {
            this.studentBirthDate = studentBirthDate;
        }

        public LocalDateTime getStudentTimeStamp() {
            return studentTimeStamp;
        }

        public void setStudentTimeStamp(LocalDateTime studentTimeStamp) {
            this.studentTimeStamp = studentTimeStamp;
        }

        public byte getStudentAge() {
            return studentAge;
        }

        public void setStudentAge(byte studentAge) {
            this.studentAge = studentAge;
        }

        public void setStudentAge() {
            this.studentAge = Byte.parseByte ( String.valueOf( ( Period.between( studentBirthDate , LocalDate.now() ) ).getYears() ) );
        }



    }


























