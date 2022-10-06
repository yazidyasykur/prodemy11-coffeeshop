/**
 * 
 */
package com.prodemy.coffeeshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prodemy.coffeeshop.dao.RoleDao;
import com.prodemy.coffeeshop.model.Role;

/**
 * @author wyant
 *
 */
@Repository
public class RoleDaoImpl implements RoleDao {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findUserRoles(String userName) {
		Session session = sessionFactory.getCurrentSession();
		List<Role> roles = (List<Role>) session.createQuery("select r from Role r, UserRole ur where r.id=ur.id.roleId and ur.id.userName=:user")
			.setParameter("user", userName).list();
		return roles;
	}

}
