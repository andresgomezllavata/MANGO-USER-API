package com.mango.customer.service;

import com.mango.customer.dto.UserDTO;
import com.mango.customer.mapper.UserMapper;
import com.mango.customer.model.User;
import com.mango.customer.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	private UserRepository userRepository;

	private UserMapper userMapper;

	UserService(UserRepository userRepository, UserMapper userMapper) {
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}

	public Optional<UserDTO> getUser(String email) {
		UserDTO ret = null;
		User user = userRepository.findByEmail(email);

		if (user != null)
			ret = userMapper.toDTO(user);

		return Optional.ofNullable(ret);
	}

	public boolean validatePassword(String email, String password) {
		boolean flag = false;
		User user = userRepository.findByEmail(email);

		if (user != null)
			flag = user.validatePassword(password);

		return flag;
	}

	public boolean userExists(String email) {
		return userRepository.findByEmail(email) != null;
	}

	public void createUser(UserDTO userDTO, String password) {
		User user = userMapper.toEntity(userDTO);
		user.setPassword(password);
		userRepository.save(user);
	}

	public void updateUser(String email, UserDTO userDTO) {
		User user = userRepository.findByEmail(email);

		if (user != null) {
			user.setName(userDTO.getName());
			user.setLastName(userDTO.getLastName());
			user.setAddress(userDTO.getAddress());
			user.setCity(userDTO.getCity());
			user.setEmail(userDTO.getEmail());

			userRepository.save(user);
		}
	}


	public void updatePassword(String email, String password) {
		User user = userRepository.findByEmail(email);

		if (user != null) {
			user.setPassword(password);
			userRepository.save(user);
		}
	}

	public void deleteUser(String email) {
		User user = userRepository.findByEmail(email);
		if (user != null)
			userRepository.delete(user);
	}

	public void deleteAll() {
		userRepository.deleteAll();
	}

	public List<UserDTO> findAll() {
		return userMapper.toDTOList(userRepository.findAll());
	}
}
