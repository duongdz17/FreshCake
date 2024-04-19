package model;


public class Feedback {
	private int id;
	private String fullname;
	private String email;
	private String subject;
	private String message;
	private String created_at;
	private int status;
	private int user_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Feedback(int id, String fullname, String email, String subject, String message, String created_at, int status,
			int user_id) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.subject = subject;
		this.message = message;
		this.created_at = created_at;
		this.status = status;
		this.user_id = user_id;
	}

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

}
