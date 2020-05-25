package io.diljot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import io.diljot.modals.User;

@NoRepositoryBean
public interface UserBaseRepository<T extends User> extends CrudRepository<T, String>{

}
