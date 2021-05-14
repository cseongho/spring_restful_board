package net.developia.board.dao;

import net.developia.board.dto.UserDTO;

public interface UserDAO {

	UserDTO getUser(UserDTO userDTO) throws Exception;

}
