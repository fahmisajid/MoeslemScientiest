package com.example.moeslemscientiest;

public class Scientist {
    private String Name;
    private String Desc;
    private String photo;

    public String getTTL() {
        return TTL;
    }

    public void setTTL(String TTL) {
        this.TTL = TTL;
    }

    public String getDied() {
        return Died;
    }

    public void setDied(String died) {
        Died = died;
    }

    public String getExpert() {
        return Expert;
    }

    public void setExpert(String expert) {
        Expert = expert;
    }

    public String getKarya() {
        return Karya;
    }

    public void setKarya(String karya) {
        Karya = karya;
    }

    private String TTL;
    private String Died;
    private String Expert;
    private String Karya;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
