import java.util.ArrayList;

public class OnlineArticle extends LibraryMaterial {
	String nameOfArticle;
	String DOI;
	static int articleCount;
	static ArrayList<OnlineArticle> articleArray = new ArrayList<OnlineArticle>();
	private String publisher;
	private Date accessDate;
	private double articleCost;
	
	OnlineArticle(String nameOfArticle, String DOI, String publisher) {
		this.nameOfArticle = nameOfArticle;
		this.DOI = DOI;
		this.publisher = publisher;
		articleCount++;
	}
	
	public String getNameOfArticle() {
		return nameOfArticle;
	}
	
	public String getDOI() {
		return DOI;
	}
	
	public double getArticleCost() {
		return articleCost;
	}
	
	public Date getAccessDate() {
		return accessDate;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setAccessDate(Date date) {
		accessDate = date;
	}
	
	@Override
	public double calculateCost() {
		if(publisher.equals("ACM")) {
			articleCost = 150;
			return articleCost;
		}
		else if(publisher.equals("IEEE")) {
			articleCost = 200;
			return articleCost;
		}
		else {
			articleCost = 100;
			return articleCost;
		}
	}
}
