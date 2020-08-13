package com.badbadcode.application.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ChangePasswordForm {

	@NotNull
	private Long id;
	
	@NotBlank(message = "Current password mustn't be blank")
	private String currentPassword;
	
	@NotBlank(message = "New password mustn't be blank")
	private String newPassword;
	
	@NotBlank(message = "Confirm password mustn't be blank")
	private String confirmPassword;
	
	public ChangePasswordForm() {
		
	}
	public ChangePasswordForm(Long id){
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public String getCurrentPassword() {
		return currentPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
}
