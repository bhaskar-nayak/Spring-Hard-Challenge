package com.Challange.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.Challange.model.Challanges;
import com.Challange.utils.Response;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Repository
public class ChallangeDAOImpl implements ChallangeDAO{
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public Response addChallange(Challanges challanges) {
		Response response = new Response();

        try {
            entityManager.persist(challanges);

            response.setMessage("Adding Challange Success");
            response.setOperation(true);
            response.setStatusCode(201);
        } catch (Exception e) {
            response.setMessage("Adding Challange failed");
            response.setOperation(false);
            response.setStatusCode(500);
            // Log the exception or handle it as needed
            e.printStackTrace();
        }

        return response;
}
	//this repo for listing all Challanges details
	@Override
	public List<Challanges> list() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("SELECT c FROM Challanges c", Challanges.class).getResultList();
	}
	@Override
	public Challanges getChallange(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Challanges.class, id);
	}
	
}
