package entity;

public class Books implements Comparable<Books> {

	private int bId;
	private String bName;
	private double bPrice;
	private String bAuthor;
	
	public Books() {
		super();
		
	}

	public Books(String bName, double bPrice, String bAuthor) {
		super();
		this.bName = bName;
		this.bPrice = bPrice;
		this.bAuthor = bAuthor;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public double getbPrice() {
		return bPrice;
	}

	public void setbPrice(double bPrice) {
		this.bPrice = bPrice;
	}

	public String getbAuthor() {
		return bAuthor;
	}

	public void setbAuthor(String bAuthor) {
		this.bAuthor = bAuthor;
	}

	@Override
	public String toString() {
		return "\n Books [bId=" + bId + ", bName=" + bName + ", bPrice=" + bPrice + ", bAuthor=" + bAuthor + "]";
	}

	@Override
	public int compareTo(Books books) {
		return Integer.compare(books.bId,this.bId);
	}
	
	
	
	
	
}
