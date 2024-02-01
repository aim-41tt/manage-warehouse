package ru.warehouse.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "Users")
public class UserEntitiy {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(name = "UserName")
        private String userName;
        
        @Column(name = "Password")
        private String password;

    	public UserEntitiy() {}
    	
		public UserEntitiy(long id, String userName, String password) {
			this.id = id;
			this.userName = userName;
			this.password = password;
		}

		public long getId() {
			return id;
		}

		public void setUserId(long id) {
			this.id = id;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
        
        
        
    
}
