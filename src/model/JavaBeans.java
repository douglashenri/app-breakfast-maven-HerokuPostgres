package model;

// TODO: Auto-generated Javadoc
/**
 * The Class JavaBeans.
 */
public class JavaBeans {

	/** The idlist. */
	private Integer idlist;
	
	/** The persons name. */
	private String personsName;
	
	/** The cpf. */
	private String cpf;
	
	/** The food. */
	private String food;

	/**
	 * Instantiates a new java beans.
	 */
	public JavaBeans() {
		super();
	}

	/**
	 * Instantiates a new java beans.
	 *
	 * @param idlist the idlist
	 * @param personsName the persons name
	 * @param cpf the cpf
	 * @param food the food
	 */
	public JavaBeans(Integer idlist, String personsName, String cpf, String food) {
		super();
		this.idlist = idlist;
		this.personsName = personsName;
		this.cpf = cpf;
		this.food = food;
	}

	/**
	 * Gets the idlist.
	 *
	 * @return the idlist
	 */
	public Integer getIdlist() {
		return idlist;
	}

	/**
	 * Sets the idlist.
	 *
	 * @param idlist the new idlist
	 */
	public void setIdlist(Integer idlist) {
		this.idlist = idlist;
	}

	/**
	 * Gets the persons name.
	 *
	 * @return the persons name
	 */
	public String getPersonsName() {
		return personsName;
	}

	/**
	 * Sets the persons name.
	 *
	 * @param personsName the new persons name
	 */
	public void setPersonsName(String personsName) {
		this.personsName = personsName;
	}

	/**
	 * Gets the cpf.
	 *
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Sets the cpf.
	 *
	 * @param cpf the new cpf
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Gets the food.
	 *
	 * @return the food
	 */
	public String getFood() {
		return food;
	}

	/**
	 * Sets the food.
	 *
	 * @param food the new food
	 */
	public void setFood(String food) {
		this.food = food;
	}

}
