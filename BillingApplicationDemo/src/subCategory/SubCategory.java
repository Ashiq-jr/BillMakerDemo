package subCategory;

public class SubCategory {
	
	String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public SubCategory(String id, String name)
	{
		this.id = id;
		this.name = name;
	}

}
