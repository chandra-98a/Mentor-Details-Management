package com.mentor.MentorService.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MentorDto {
	
	  private Long id;
	    private String firstName;
	    private String lastName;
	    private String email;
	    private String teamCode;
	   
//Getters and setters
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
		//constructor
		public MentorDto(Long id, String firstName, String lastName, String email, String teamCode) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.teamCode = teamCode;
		}
		public MentorDto() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
}
