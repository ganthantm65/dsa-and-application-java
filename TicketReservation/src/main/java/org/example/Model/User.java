package org.example.Model;

public class User {
    private int user_id;
    private String name;
    private int age;
    private String sex;
    private String phoneno;
    private String bookedTrainName;
    private String bookedTrainNo;
    private String coach;
    private int[] seat;

    public User(String name,int age,String sex,String phoneno,String bookedTrainName,String bookedTrainNo){
        this.name=name;
        this.age=age;
        this.sex=sex;
        this.phoneno=phoneno;
        this.bookedTrainName=bookedTrainName;
        this.bookedTrainNo=bookedTrainNo;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getBookedTrainName() {
        return bookedTrainName;
    }

    public void setBookedTrainName(String bookedTrainName) {
        this.bookedTrainName = bookedTrainName;
    }

    public String getBookedTrainNo() {
        return bookedTrainNo;
    }

    public void setBookedTrainNo(String bookedTrainNo) {
        this.bookedTrainNo = bookedTrainNo;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public int[] getSeat() {
        return seat;
    }

    public void setSeat(int[] seat) {
        this.seat = seat;
    }
}
