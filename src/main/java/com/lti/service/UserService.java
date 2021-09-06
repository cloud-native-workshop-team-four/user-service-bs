package com.lti.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.User;
import com.lti.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo repo;
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional(value = TxType.REQUIRED)
	public User saveUser(User user){
        return repo.save(user);
    }
	
	@Transactional(value = TxType.REQUIRED)
	public User searchByEmail(String email){
        return repo.findByEmail(email);
    }
	
	@Transactional(value = TxType.REQUIRED)
	public void updateScore(int userId, double score) {
		User u1 = em.find(User.class, userId);
		u1.setExamTaken("yes");
		u1.setPercentScore(score);
		em.merge(u1);
	}
	
}
