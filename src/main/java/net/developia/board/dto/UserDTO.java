package net.developia.board.dto;

import java.io.Serializable;

import org.apache.commons.codec.digest.DigestUtils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO implements Serializable {

	private long usr_no;
	private String usr_id;
	private String usr_pw;
	private String usr_name;
	private String usr_info;
	private int usr_level;
	private int usr_status;
	private String usr_regdate;
	private String usr_lastlogin;
	private int usr_logcnt;
	private String usr_ip;
	private String usr_zipcode;
	private String usr_address;
	private String usr_address_detail;
	
	public void setUsr_pw(String usr_pw) {
		this.usr_pw = DigestUtils.sha512Hex(usr_pw);
	}

}
