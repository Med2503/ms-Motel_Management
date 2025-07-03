package com.att.Guest;

import org.springframework.data.mongodb.repository.MongoRepository;



public interface GuestRepository extends MongoRepository<Guest,String> {
}
