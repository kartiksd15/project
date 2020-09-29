package com.xworkz.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.xworkz.spring.entity.MessageEntity;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface RepositoryMessage extends CrudRepository<MessageEntity, Integer> {

}
