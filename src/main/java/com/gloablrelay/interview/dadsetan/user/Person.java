package com.gloablrelay.interview.dadsetan.user;

public class Person {
  private String first_name;
  private String last_name;
  private String company_name;
  private String address;
  private String city;
  private String province;
  private String postal;
  private String phone1;
  private String phone2;
  private String email;
  private String web;

  public Person(String first_name, String last_name, String company_name, String address, String city, String province,
      String postal, String phone1, String phone2, String email, String web) {
    this.first_name = first_name;
    this.last_name = last_name;
    this.company_name = company_name;
    this.address = address;
    this.city = city;
    this.province = province;
    this.postal = postal;
    this.phone1 = phone1;
    this.phone2 = phone2;
    this.email = email;
    this.web = web;
  }

  public String getFirstName(){
    return this.first_name;
  }

  public String getLastName(){
    return this.last_name;
  }

  public String getCompanyName(){
    return this.company_name;
  }

  public String getAddress(){
    return this.address;
  }

  public String getCity(){
    return this.city;
  }

  public String getProvince(){
    return this.province;
  }

  public String getPostal(){
    return this.postal;
  }

  public String getPhone1(){
    return this.phone1;
  }

  public String getPhone2(){
    return this.phone2;
  }

  public String getEmail(){
    return this.email;
  }

  public String getWeb(){
    return this.web;
  }
}