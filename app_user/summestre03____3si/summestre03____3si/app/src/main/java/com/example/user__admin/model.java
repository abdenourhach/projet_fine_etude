package com.example.user__admin;

public class model
{
  String name,age,nombre_pere,purl;
    model()
    {

    }
    public model(String name, String age, String nombre_pere, String purl) {
        this.name = name;
        this.age = age;
        this.nombre_pere = nombre_pere;
        this.purl = purl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getage() {
        return age;
    }

    public void setage(String age) {
        this.age = age;
    }

    public String getnombre_pere() {
        return nombre_pere;
    }

    public void setnombre_pere(String nombre_pere) {
        this.nombre_pere = nombre_pere;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }
}
