package org.example.rbapi.repository;

import org.example.rbapi.domain.RbUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RbUserRepository extends JpaRepository<RbUser, String>  {
}
