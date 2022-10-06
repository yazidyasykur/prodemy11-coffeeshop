/**
 * 
 */
package com.prodemy.coffeeshop.dao;

import com.prodemy.coffeeshop.model.User;

/**
 * @author wyant
 *
 */
public interface UserDao {
	public User findByName(String name);
	public User update(User user);
}
