package net.developia.board.service;

import org.springframework.beans.factory.annotation.Autowired;

import net.developia.board.dao.UserDAO;

//@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
}