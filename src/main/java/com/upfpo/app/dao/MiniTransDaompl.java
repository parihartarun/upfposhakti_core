package com.upfpo.app.dao;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.Circulars;

@Repository
public class MiniTransDaompl implements MiniTransDao {
	
	@Resource  
	private SessionFactory sessionFactory;

	private Session session;
	
	private org.hibernate.Query query;


	@Override
	@Transactional
	public List<Circulars> getCirculars() {
		
		List<Circulars> list = null;
		try {

			session = sessionFactory.openSession();
			session.beginTransaction();

			query = session.createQuery("From Circulars where filePath!=null");
			list = query.list();
			System.out.println(list.size()+"Circulars size");
			session.getTransaction().commit();

			// tx.commit();
		} catch (Exception e) {
			e.printStackTrace();

		}

		return list;

	}
}
