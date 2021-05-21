package bo.edu.ucb.ingsoft.demorest.dto;

import java.util.Date;

public class Perfil {
    private Integer id_owner;
    private Integer id_person;
    private String first_name;
    private String last_name;
    private String email;
    private String namep;
    private String sex;
    private Date date_of_birthp;
    private String type_pet;
    private String namer;
    private String nroSS;

    public Perfil(){
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

    public void setId_person(Integer id_person) {
        this.id_person = id_person;
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


    public String getNamep(String name) {
        return namep;
    }

    public void setNamep(String namep) {
        this.namep = namep;
    }

    public String getSex(String sex) {
        return this.sex;
    }

    public Date getDate_of_birthp(java.sql.Date date_of_birth) {
        return date_of_birthp;
    }

    public String getType_pet(String type_pet) {
        return this.type_pet;
    }

    public void setType_pet(String type_pet) {
        this.type_pet = type_pet;
    }

    public void setDate_of_birthp(Date date_of_birthp) {
        this.date_of_birthp = date_of_birthp;
    }

    public void setSex(String sex) {
        this.sex = sex;
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
