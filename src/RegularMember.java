import java.util.ArrayList;
import java.util.Iterator;

public class RegularMember implements LibraryData, Comparable<RegularMember>{
	protected String memberName;
	protected String Id;
	protected ArrayList<Book> checkedoutBook;
	protected ArrayList<OnlineArticle> accessedArticle;
	protected static ArrayList<RegularMember> regularMemberArray = new ArrayList<RegularMember>();
	public static int regularMemberCount;
	protected int checkedOutBookCount = 0;
	protected int accessibleOnlineArticleCount = 0;
	protected int arrayLimit;
	protected int overdueCharge;
	
	RegularMember(String memberName, String Id, int arrayLimit) {
		this.memberName = memberName;
		this.Id = Id;
		this.arrayLimit = arrayLimit;
		regularMemberCount++;
		checkedoutBook = new ArrayList<Book>();
		accessedArticle = new ArrayList<OnlineArticle>();
	}
	
	RegularMember(String memberName, String Id) {
		this.memberName = memberName;
		this.Id = Id;
		this.arrayLimit = 1;
		regularMemberCount++;
		checkedoutBook = new ArrayList<Book>();
		accessedArticle = new ArrayList<OnlineArticle>();
	}
	
	public String getMemberName() {
		return memberName;
	}
	
	public String getMemberId() {
		return Id;
	}
	
	public int getOverdueCharge() {
		return overdueCharge;
	}
	
	public boolean appendToBookArray(Book checkedBook) {
		if(checkedOutBookCount >= arrayLimit) {
			System.out.println("Book quota is reached");
			return false;
		}
		checkedoutBook.add(checkedBook);
		checkedOutBookCount++;
		return true;
	}
	
	public boolean appendAccessedArticle(OnlineArticle accesedArticle) {
		if(accessibleOnlineArticleCount >= arrayLimit) {
			System.out.println("Online article quota is reached");
			return false;
		}
		accessedArticle.add(accesedArticle);
		accessibleOnlineArticleCount++;
		return true;
	}
	
	protected void returnBook(String ISBN) {
		Book tempbook = null;
		Iterator<Book> iter = checkedoutBook.iterator();
		while(iter.hasNext()) {
			tempbook = iter.next();
			if(tempbook.getISBN().equals(ISBN)) {
				iter.remove();
				checkedOutBookCount--;
				return;
			}
		}
	}
	
	protected void returnOA(String DOI) {
		OnlineArticle tempArticle = null;
		Iterator<OnlineArticle> iter = accessedArticle.iterator();
		while(iter.hasNext()) {
			tempArticle = iter.next();
			if(tempArticle.DOI.equals(DOI)) {
				iter.remove();
				accessibleOnlineArticleCount--;
				return;
			}
		}
	}
	
	@Override
	public double calculateCost() {
		int sum = 0;
		for(Book book : checkedoutBook) {
			sum += calculateCost(book);
		}
		for(OnlineArticle article : accessedArticle) {
			sum += calculateCost(article);
		}
		overdueCharge = sum;
		return sum;
	}
	
	double calculateCost(Book temp) {
		int yeardiff = AssigmentMain.currentDate.year - temp.getdueDate().year;
		int monthdiff = AssigmentMain.currentDate.month - temp.getdueDate().month;
		int daydiff = AssigmentMain.currentDate.day - temp.getdueDate().day;
		int overdueDay = yeardiff * 365 + monthdiff * 30 + daydiff;
		if(overdueDay <= 0) {
			return 0;
		}
		return overdueDay * 50;
	}
	
	double calculateCost(OnlineArticle temp) {
		int yeardiff = AssigmentMain.currentDate.year - temp.getAccessDate().year;
		int monthdiff = AssigmentMain.currentDate.month - temp.getAccessDate().month;
		int daydiff = AssigmentMain.currentDate.day - temp.getAccessDate().day;
		int totalDaysofAccess = yeardiff * 365 + monthdiff * 30 + daydiff - 30;
		if(totalDaysofAccess <= 0) {
			return 0;
		}
		return totalDaysofAccess * 10;
	}

	@Override
	public int compareTo(RegularMember o) {
		// TODO Auto-generated method stub
		return this.overdueCharge - o.overdueCharge;
	}
}



































