package io.diljot.repository;

import javax.transaction.Transactional;

import io.diljot.modals.User;

@Transactional
public interface UserRepository extends UserBaseRepository<User> {

}
