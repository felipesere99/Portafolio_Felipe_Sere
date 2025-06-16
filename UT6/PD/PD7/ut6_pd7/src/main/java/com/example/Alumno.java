package com.example;
import java.util.Objects;

public class Alumno {
    private int ID;
    private String fullName;
    private String email;

    public int getID() {
        return ID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return ID == alumno.ID && Objects.equals(fullName, alumno.fullName) && Objects.equals(email, alumno.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, fullName, email);
    }
}