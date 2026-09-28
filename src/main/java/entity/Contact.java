package entity;

import java.time.LocalDateTime;

public class Contact {
	
	    private int contactId;
	    private String contactName;
	    private String email;
	    private long mobileNumber;
	    private String address;
	    private LocalDateTime createdDate;
	    
		public Contact() {
			super();
		}


		public Contact(int contactId, String contactName, String email, long mobileNumber, String address,
				LocalDateTime createdDate) {
			super();
			this.contactId = contactId;
			this.contactName = contactName;
			this.email = email;
			this.mobileNumber = mobileNumber;
			this.address = address;
			this.createdDate = createdDate;
		}


		public int getContactId() {
			return contactId;
		}


		public void setContactId(int contactId) {
			this.contactId = contactId;
		}


		public String getContactName() {
			return contactName;
		}


		public void setContactName(String contactName) {
			this.contactName = contactName;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public long getMobileNumber() {
			return mobileNumber;
		}


		public void setMobileNumber(long mobileNumber) {
			this.mobileNumber = mobileNumber;
		}


		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}


		public LocalDateTime getCreatedDate() {
			return createdDate;
		}


		public void setCreatedDate(LocalDateTime createdDate) {
			this.createdDate = createdDate;
		}
	    
}
