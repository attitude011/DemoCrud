package com.demo.bci.dao;

import com.demo.bci.entity.EntityUpdate;
import com.demo.bci.entity.EntityUser;
import com.demo.bci.entity.InsertEntity;

public interface CustomerRepository {
	
	public InsertEntity findById(long id);
	public InsertEntity insert(EntityUser payload);
	public boolean updateRecord(EntityUpdate records);

}
