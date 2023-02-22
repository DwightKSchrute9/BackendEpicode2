package model;

import java.util.List;

import javax.persistence.*;

@NamedQueries({
    @NamedQuery(name = "findDistributorByName", query = "SELECT d FROM DistributoreAutomatico d WHERE d.name = :name")
})
public class DistributoreAutomatico<EmissionPointType> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EmissionPointType type;

    private String name;

    private boolean isActive;

    public DistributoreAutomatico() {
        // default constructor
    }

    public DistributoreAutomatico(EmissionPointType type, String name, boolean isActive) {
        this.type = type;
        this.name = name;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmissionPointType getType() {
        return type;
    }

    public void setType(EmissionPointType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

	public void setIndirizzo(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setLatitudine(double d) {
		// TODO Auto-generated method stub
		
	}

	public void setLongitudine(double d) {
		// TODO Auto-generated method stub
		
	}

	public String getIndirizzo() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Object getDistributoreAutomatico(String string, List<DistributoreAutomatico> distributori) {
		// TODO Auto-generated method stub
		return null;
	}


}

