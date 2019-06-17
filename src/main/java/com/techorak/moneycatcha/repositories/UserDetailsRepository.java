package com.techorak.moneycatcha.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techorak.moneycatcha.models.UserDetails;

@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetails, Long>   {


}
