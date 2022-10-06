/**
 * 
 */
package com.prodemy.coffeeshop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author wyant
 *
 */
@Embeddable
public class UserRoleId implements Serializable {
	private static final long serialVersionUID = 8873015071621580930L;
	
	@Column(name = "rlid", nullable = false, length = 50)
	private String roleId;
	
	@Column(name = "usrnm", nullable = false, length = 50)
	private String userName;
}
