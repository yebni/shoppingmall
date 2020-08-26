package elecshopping;

public class ProductVO {

	int pnum;
	String pname;
	int price;
	int stack;
	int category;
	int password;
	
	

	@Override
	public String toString() {
		return "ProductVO [pnum=" + pnum + ", pname=" + pname + ", price=" + price + ", stack=" + stack + ", category="
				+ category + "]";
	}

	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStack() {
		return stack;
	}
	public void setStack(int stack) {
		this.stack = stack;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	
	
}
