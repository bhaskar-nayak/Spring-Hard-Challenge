package com.Challange.dao;

import java.util.List;

import com.Challange.model.Challanges;
import com.Challange.utils.Response;

public interface ChallangeDAO {
	public Response addChallange(Challanges challanges);
	public List<Challanges> list();
	public Challanges getChallange(int id);
}
