package com.myedtech.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.myedtech.models.dto.SelectedCourseDto;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_in_english")
    private String nameInEnglish;

    @Column(name = "name_in_arabic")
    private String nameInArabic;

    @Column(name = "image", length = 256)
    private String image;

    @Column(name = "email")
    private String email;

    @Column(name = "telephone")
    private long telephone;

    @Column(name = "address", length = 220)
    private String address;

    @Column(name = "last_update")
    private Date lastUpdate;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private List<UserCourse> selectedCourses;

    public Student() {

    }
    


    public Student(int id, String nameInEnglish, String nameInArabic, String image, String email, long telephone,
            String address, Date lastUpdate, List<UserCourse> selectedCourses) {
        this.id = id;
        this.nameInEnglish = nameInEnglish;
        this.nameInArabic = nameInArabic;
        this.image = image;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
        this.lastUpdate = lastUpdate;
        this.selectedCourses = selectedCourses;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNameInEnglish() {
        return nameInEnglish;
    }


    public void setNameInEnglish(String nameInEnglish) {
        this.nameInEnglish = nameInEnglish;
    }


    public String getNameInArabic() {
        return nameInArabic;
    }


    public void setNameInArabic(String nameInArabic) {
        this.nameInArabic = nameInArabic;
    }


    public String getImage() {
        return image;
    }


    public void setImage(String image) {
        this.image = image;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public long getTelephone() {
        return telephone;
    }


    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public Date getLastUpdate() {
        return lastUpdate;
    }


    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }


    public List<UserCourse> getSelectedCourses() {
        return selectedCourses;
    }


    public void setSelectedCourses(List<UserCourse> selectedCourses) {
        this.selectedCourses = selectedCourses;
    }

    
}