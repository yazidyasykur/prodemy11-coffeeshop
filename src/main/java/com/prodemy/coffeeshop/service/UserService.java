/**
 * 
 */
package com.prodemy.coffeeshop.service;

import java.util.List;

import com.prodemy.coffeeshop.model.Role;
import com.prodemy.coffeeshop.model.User;

/**
 * @author wyant
 *
 */
public interface UserService {
	public User findByName(String name);
	public User update(User user);
	public List<Role> findUserRoles(String userName);
}
