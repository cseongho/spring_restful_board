package net.developia.board.dto;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ArticleDTO implements Serializable {
	
	private long art_no;
	
	@NotBlank
	private String art_title;
	
	@NotBlank
	private String art_content;
	
	private int art_like;
	private int art_dislike;
	private Date art_regdate;
	private int art_readcnt;
	private int art_com_cnt;
	private String art_ip;
	private int boa_no;
	private UserDTO userDTO;
}
