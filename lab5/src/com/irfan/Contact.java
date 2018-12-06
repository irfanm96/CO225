package com.irfan;

public class Contact {
    private  String firstName;
    private  String lastName;
    private String phoneNumber;

    public Contact(String firstName, String lastName, String phoneNumber) {
       this.firstName=firstName;
       this.lastName=lastName;
       this.phoneNumber=phoneNumber;
    }

    // function to print the contact information
    public void printDetails(){
        System.out.println(firstName+" "+lastName+" : "+phoneNumber);
    }

}
