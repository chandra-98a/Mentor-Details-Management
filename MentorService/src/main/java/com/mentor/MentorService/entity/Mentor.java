package com.mentor.MentorService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="mentors_list")
public class Mentor {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	  @Column(nullable=false)
	    private String firstName;
	  @Column(nullable=false)
	    private String lastName;
	    @Column(nullable = false, unique = true)
	    private String email;
	    @Column(nullable =false)
	    private String teamCode;
	    
	    //Getters and Setters
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
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
		
		
	    public String getTeamCode() {
			return teamCode;
		}
		public void setTeamCode(String teamCode) {
			this.teamCode = teamCode;
		}
		//constructors
		public Mentor(Long id, String firstName, String lastName, String email, String teamCode) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.teamCode = teamCode;
		}
		public Mentor() {
			super();
			// TODO Auto-generated constructor stub
		}
		
	    
}
