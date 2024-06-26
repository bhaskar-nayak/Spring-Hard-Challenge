package com.Challange.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Challange.dao.ChallangeDAO;
import com.Challange.model.Challanges;
import com.Challange.utils.Response;
@Service
public class ChallangeServiceImpl implements ChallangeService{
	@Autowired
	ChallangeDAO challangeDAO;
	@Override
	@Transactional
	public Response addChallange(Challanges challanges) {
		// TODO Auto-generated method stub
		return challangeDAO.addChallange(challanges);
	}
	@Override
	public List<Challanges> list() {
		// TODO Auto-generated method stub
		return challangeDAO.list();
	}
	@Override
	public Challanges getChallange(int id) {
		// TODO Auto-generated method stub
		return challangeDAO.getChallange(id);
	}

}
