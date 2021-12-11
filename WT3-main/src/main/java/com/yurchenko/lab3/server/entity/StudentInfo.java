package com.labovichl.lab3.server.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class StudentInfo implements Serializable {

    private String name;
    private String surname;
    private String patronymic;
    private Date birthday;
    private String sex;
    private String gradeBookNumber;
    private String speciality;

    public StudentInfo() {
    }

    public StudentInfo(String name, String surname, String patronymic, Date birthday, String sex, String gradeBookNumber, String speciality) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.sex = sex;
        this.gradeBookNumber = gradeBookNumber;
        this.speciality = speciality;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGradeBookNumber() {
        return gradeBookNumber;
    }

    public void setGradeBookNumber(String gradeBookNumber) {
        this.gradeBookNumber = gradeBookNumber;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+" {" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday=" + new SimpleDateFormat("dd.MM.yyyy").format(birthday) +
                ", sex='" + sex + '\'' +
                ", gradeBookNumber='" + gradeBookNumber + '\'' +
                ", speciality='" + speciality + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentInfo that = (StudentInfo) o;
        return name.equals(that.name) && surname.equals(that.surname)
                && patronymic.equals( that.patronymic) && birthday.equals(that.birthday)
                && sex.equals(that.sex) && gradeBookNumber.equals(that.gradeBookNumber)
                && speciality.equals(that.speciality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, patronymic, birthday, sex, gradeBookNumber, speciality);
    }
}
