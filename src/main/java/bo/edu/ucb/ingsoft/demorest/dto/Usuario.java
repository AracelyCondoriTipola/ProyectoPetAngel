package bo.edu.ucb.ingsoft.demorest.dto;

import java.util.Date;

public class Usuario {
    private Integer id_owner;
    private Integer id_person;
    private String first_name;
    private String last_name;
    private String email;
    private String user_o;
    private String password_o;
    private Date date_of_birth;
    private String phone_number;
    private String address;
    private String city;
    private String namep;
    private String sex;
    private Date date_of_birthp;
    private String type_pet;
    private String namer;
    private String nroSS;


    public Usuario(){
    }

    public Integer getId_owner() {
        return id_owner;
    }

    public void setId_owner(Integer id_owner) {
        this.id_owner = id_owner;
    }

    public Integer getId_person() {
        return id_person;
    }

    public void setId_person(Integer id_owner) {
        this.id_person = id_owner;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_o() {
        return user_o;
    }

    public void setUser_o(String user_o) {
        this.user_o = user_o;
    }

    public String getPassword_o() {
        return password_o;
    }

    public void setPassword_o(String password_o) {
        this.password_o = password_o;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public  void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public  void setCity(String city) {
        this.city = city;
    }

    public String getNamep(String name) {
        return namep;
    }

    public void setNamep(String namep) {
        this.namep = namep;
    }

    public String getSex(String sex) {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDate_of_birthp(java.sql.Date date_of_birth) {
        return date_of_birthp;
    }

    public void setDate_of_birthp(Date date_of_birthp) {
        this.date_of_birthp = date_of_birthp;
    }

    public String getType_pet(String type_pet) {
        return this.type_pet;
    }

    public void setType_pet(String type_pet) {
        this.type_pet = type_pet;
    }

    public String getNamer() {
        return namer;
    }

    public void setNamer(String namer) {
        this.namer = namer;
    }

    public String getNroSS() {
        return nroSS;
    }

    public void setNroSS(String nroSS) {
        this.nroSS = nroSS;
    }


}

