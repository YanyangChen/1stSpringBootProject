
package com.cyy.springboot.web.springbootfirstwebapplication.web.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.springframework.boot.autoconfigure.domain.EntityScan;


@Entity
public class Todo {
	//use alt + shift + s to auto generate functions
	@Id
	@GeneratedValue
    private int id;
    private String user;
    
    @Size(min=10, message="Enter at least 10 characters...")
    private String descr;
    private Date targetDate;
    private boolean isDone;

    public Todo() {
    	super();
    }
    
    public Todo(int id, String user, String descr, Date targetDate,
            boolean isDone) {
        super();
        this.id = id;
        this.user = user;
        this.descr = descr;
        this.targetDate = targetDate;
        this.isDone = isDone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getdescr() {
        return descr;
    }

    public void setdescr(String descr) {
        this.descr = descr;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Todo other = (Todo) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format(
                "Todo [id=%s, user=%s, descr=%s, targetDate=%s, isDone=%s]", id,
                user, descr, targetDate, isDone);
    }

}