package swintegration.emp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee implements Serializable{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "airst_name")
    private String airstName;

    @Column(name = "last_name")
    private String lastName;
    
    private String email;

    private String phone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAirstName() {
		return airstName;
	}

	public void setAirstName(String airstName) {
		this.airstName = airstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
