package cn.pengyinzhuo.shop.api.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

	
	/* 
	  `userName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
	  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
	  `phone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
	  `email` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
	 */
	
	private String userName;
	private String password;
	private String phone;
	private String email;
}
