package com.mango.customer.mapper;

import com.mango.customer.dto.UserDTO;
import com.mango.customer.model.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserMapper {

	public User toEntity(UserDTO userDTO) {
		return new User(userDTO.getName(), userDTO.getLastName(), userDTO.getAddress(), userDTO.getCity(), userDTO.getEmail());
	}

	public UserDTO toDTO(User user) {
		return new UserDTO(user.getName(), user.getLastName(), user.getAddress(), user.getCity(), user.getEmail());
	}

	public List<UserDTO> toDTOList(List<User> list) {
		List<UserDTO> listDTO = new ArrayList<UserDTO>();

		for (User user : list) {
			UserDTO superheroDTO = new UserDTO(user.getName(), user.getLastName(), user.getAddress(), user.getCity(), user.getEmail());
			listDTO.add(superheroDTO);
		}

		return listDTO;
	}

	public List<User> toEntityList(List<UserDTO> listDTO) {
		List<User> list = new ArrayList<User>();

		for (UserDTO userDTO : listDTO) {
			User superhero = new User(userDTO.getName(), userDTO.getLastName(), userDTO.getAddress(), userDTO.getCity(), userDTO.getEmail());
			list.add(superhero);
		}

		return list;
	}
}
