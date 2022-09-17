package com.bdortho.stock.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bdortho.stock.model.UserModel;
import com.bdortho.stock.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
		private final UserRepository userRepository;
		
		public UserModel save(UserModel userModel) {
			userRepository.save(userModel);
			return userModel;
		}
		
		public UserModel getById(Long id) {
			UserModel user = userRepository.getOne(id);
			return  user;
		}
		
		public List<UserModel> getAll() {
			List<UserModel> user = userRepository.findAll(Sort.by(Sort.Direction.DESC, "updatedAt"));
			return user;
		}
		
		public UserModel delete(UserModel user) {
			userRepository.delete(user);
			return user;
		}


}
