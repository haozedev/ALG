package com.dev;

public class DeepCopyExample implements Cloneable {
    private int id;
    private String name;
    private Address address;

    public DeepCopyExample(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public DeepCopyExample clone() throws CloneNotSupportedException {
        DeepCopyExample clone = (DeepCopyExample) super.clone();
        clone.address = new Address(this.address.getStreet(), this.address.getCity());
        return clone;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static void main(String[] args) {
        Address address = new Address("123 Main St", "Anytown");
        DeepCopyExample obj1 = new DeepCopyExample(1, "John", address);

        try {
            DeepCopyExample obj2 = obj1.clone();
            System.out.println(obj1 == obj2); // false
            System.out.println(obj1.getAddress() == obj2.getAddress()); // false
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

class Address {
    private String street;
    private String city;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    // Getters and Setters
}
