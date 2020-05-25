package io.diljot.repository;

import javax.transaction.Transactional;

import io.diljot.modals.Owner;

@Transactional
public interface OwnerRepository extends UserBaseRepository<Owner> {

}
