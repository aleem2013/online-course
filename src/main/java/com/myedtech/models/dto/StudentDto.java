package com.myedtech.models.dto;

import java.io.Serializable;
import java.util.List;

public class StudentDto implements Serializable {

    private int id;

	private String nameInEnglish;

    private String nameInArabic;

    private String email;

    private long telephone;

    private String address;

    private List<SelectedCourseDto> selectedCourses; 

    
    

    public StudentDto(int id, String nameInEnglish, String nameInArabic, String email, long telephone, String address,
            List<SelectedCourseDto> selectedCourses) {
        this.id = id;
        this.nameInEnglish = nameInEnglish;
        this.nameInArabic = nameInArabic;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
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

    public List<SelectedCourseDto> getSelectedCourses() {
        return selectedCourses;
    }

    public void setSelectedCourses(List<SelectedCourseDto> selectedCourses) {
        this.selectedCourses = selectedCourses;
    }

    

    
}
