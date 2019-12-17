/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.franklin.comp655.group5.gradebook.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Data object that represents a GradeBook in the DGB (Distributed GradeBooks).
 *
 * @author Alcir David
 */
@Entity
public class GradeBook implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private StudentList students = new StudentList();
    private boolean isSecondary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isIsSecondary() {
        return isSecondary;
    }

    public void setIsSecondary(boolean isSecondary) {
        this.isSecondary = isSecondary;
    }

    public StudentList getStudentList() {
        return students;
    }

    public void setStudentList(StudentList studentList) {
        this.students = studentList;
    }
    
    public Student getStudent(String name) {
        return students.getStudentByName(name);
    }
    
    public void add(@NotNull Student student){
        students.add(student);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GradeBook)) {
            return false;
        }
        GradeBook other = (GradeBook) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder writer = new StringBuilder();
        writer.append("<gradebook>\n");
        writer.append("   <id>");
        writer.append(id);
        writer.append("</id>\n");
        writer.append("   <name>");
        writer.append(name);
        writer.append("</name>\n");
        writer.append("</gradebook>");
        
        return writer.toString();
    }

}