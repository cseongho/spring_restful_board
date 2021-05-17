package net.developia.board.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardDTO implements Serializable{
	private int boa_no;
	private String boa_name;
	private int boa_status;
	private UserDTO userDTO;
}
