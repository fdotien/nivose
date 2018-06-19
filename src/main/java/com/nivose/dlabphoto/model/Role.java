package com.nivose.dlabphoto.model;

import org.hibernate.annotations.NaturalId;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by dOTIEN jOEL
 */
@Entity
@Table(name = "roles")
public class Role implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	
    private Long id;
    private RoleName name;
    private String desc;

	public Role() {
		super();
	}

    public Role(RoleName name) {
        this.name = name;
    }

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Enumerated(EnumType.STRING)
    @NaturalId
	@Column(name = "role_name", unique = true, nullable = false, length = 20)
    public RoleName getName() {
        return name;
    }
	
    public void setName(RoleName name) {
        this.name = name;
    }

	@Column(name = "description", length = 200 )
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (name != other.name)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}


}
