package com.demo.bci.services;


import com.demo.bci.entity.EntityUpdate;
import com.demo.bci.entity.EntityUser;
import com.demo.bci.entity.InsertEntity;
import com.demo.bci.to.Convert;

public interface CustomerServices {
	
	public InsertEntity getRecordById(long id);
	public Object insertRecord(EntityUser table);
	public Convert updateRecord(EntityUpdate records);
	

}
