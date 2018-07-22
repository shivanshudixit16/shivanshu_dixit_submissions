import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer 
{

	private String cname;
	@Id
	private String email;
	private String pass;
	private String dob;
	private String pno;
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "Customer [cname=" + cname + ", email=" + email + ", pass=" + pass + ", dob=" + dob + ", pno=" + pno
				+ "]";
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
}
