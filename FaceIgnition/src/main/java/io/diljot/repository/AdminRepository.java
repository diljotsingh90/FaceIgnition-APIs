package io.diljot.repository;

import javax.transaction.Transactional;

import io.diljot.modals.Admin;

@Transactional
public interface AdminRepository extends UserBaseRepository<Admin> {

}
