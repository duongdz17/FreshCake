package model;

public class Product {
	private int id;
	private String name;
	private String description;
	private double price;
	private double discount;
	private int quantity;
	private String thumbnail;
	private int is_featured;
	private int status;
	private int category_id;
	private String create_at;
	private String update_at;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public int getIs_featured() {
		return is_featured;
	}

	public void setIs_featured(int is_featured) {
		this.is_featured = is_featured;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getCreate_at() {
		return create_at;
	}

	public void setCreate_at(String create_at) {
		this.create_at = create_at;
	}

	public String getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(String update_at) {
		this.update_at = update_at;
	}

	public Product(int id, String name, String description, double price, double discount, int quantity,
			String thumbnail, int is_featured, int status, int category_id, String create_at, String update_at) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.discount = discount;
		this.quantity = quantity;
		this.thumbnail = thumbnail;
		this.is_featured = is_featured;
		this.status = status;
		this.category_id = category_id;
		this.create_at = create_at;
		this.update_at = update_at;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

}
