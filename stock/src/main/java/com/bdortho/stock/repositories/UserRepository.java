package com.bdortho.stock.repositories;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.bdortho.stock.model.UserModel;

@Repository
public interface UserRepository extends JpaRepositoryImplementation<UserModel, Long> {

}
