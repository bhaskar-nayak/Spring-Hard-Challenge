package com.Challange.service;

import java.util.List;

import com.Challange.model.Challanges;
import com.Challange.utils.Response;

public interface ChallangeService {
	public Response addChallange(Challanges challanges);
	public List<Challanges> list();
	public Challanges getChallange(int id);
}
