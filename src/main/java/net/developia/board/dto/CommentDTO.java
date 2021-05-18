package net.developia.board.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentDTO implements Serializable {
	private long com_no;
	private String com_content;
	private Date com_regdate;
	private int com_like;
	private int com_dislike;
	private String com_ip;
	private long art_no;
	private UserDTO userDTO;
}
