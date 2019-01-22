package cn.innosoft.en.releaseRecord.home.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DEMO_USER database table.
 * 
 */
@Entity
@Table(name="DEMO_USER")
@NamedQuery(name="DemoUser.findAll", query="SELECT d FROM DemoUser d")
public class DemoUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String name;

	public DemoUser() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}