package com.upfpo.app.dao;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.upfpo.app.entity.DashBoardData;

@Repository
public class MasterDaoImpl implements MasterDao {
	
	@Resource 
	private SessionFactory sessionFactory;
	

	private Session session;
	
	private org.hibernate.Query query;

	@Override
	@Transactional
	public List<DashBoardData> homePageData() {
		
		List<DashBoardData> list= null;
		try
		{	
			session = sessionFactory.openSession();
			session.beginTransaction();
			query = session.createQuery("From DashBoardData");
			list = query.list();
			
			session.getTransaction().commit();

 		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
