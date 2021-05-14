package net.developia.board.service;

import net.developia.board.dto.UserDTO;

public interface UserService {

	UserDTO getUser(UserDTO userDTO) throws Exception;
}
