/**
 * 
 */
package com.prodemy.coffeeshop.dao;

import java.util.List;

import com.prodemy.coffeeshop.model.Role;

/**
 * @author wyant
 *
 */
public interface RoleDao {
	public List<Role> findUserRoles(String userName);
}
