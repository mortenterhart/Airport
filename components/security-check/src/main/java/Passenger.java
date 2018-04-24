package base;

import java.util.ArrayList;

public class Passenger {
    private String name;
    private String content;
    private String birthDate;
    private String street;
    private String postCode;
    private String city;
    private base.CitizenshipCode citizenshipCode;
    private base.Gender gender;
    private base.Passport passport;
    private ArrayList<base.Baggage> baggageList;
    private base.BoardingPass boardingPass;

    public Passenger(String name, String content, String birthDate, String street, String postCode, String city, base.CitizenshipCode citizenshipCode, base.Gender gender, base.Passport passport, ArrayList<base.Baggage> baggageList, base.BoardingPass boardingPass) {
        this.name = name;
        this.content = content;
        this.birthDate = birthDate;
        this.street = street;
        this.postCode = postCode;
        this.city = city;
        this.citizenshipCode = citizenshipCode;
        this.gender = gender;
        this.passport = passport;
        this.baggageList = baggageList;
        this.boardingPass = boardingPass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public base.CitizenshipCode getCitizenshipCode() {
        return citizenshipCode;
    }

    public void setCitizenshipCode(base.CitizenshipCode citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }

    public base.Gender getGender() {
        return gender;
    }

    public void setGender(base.Gender gender) {
        this.gender = gender;
    }

    public base.Passport getPassport() {
        return passport;
    }

    public void setPassport(base.Passport passport) {
        this.passport = passport;
    }

    public ArrayList<base.Baggage> getBaggageList() {
        return baggageList;
    }

    public void setBaggageList(ArrayList<base.Baggage> baggageList) {
        this.baggageList = baggageList;
    }

    public base.BoardingPass getBoardingPass() {
        return boardingPass;
    }

    public void setBoardingPass(base.BoardingPass boardingPass) {
        this.boardingPass = boardingPass;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", street='" + street + '\'' +
                ", postCode='" + postCode + '\'' +
                ", city='" + city + '\'' +
                ", citizenshipCode=" + citizenshipCode +
                ", gender=" + gender +
                ", passport=" + passport +
                ", baggageList=" + baggageList +
                ", boardingPass=" + boardingPass +
                '}';
    }
}
