import java.util.ArrayList;

public class Book extends LibraryMaterial{
	private String nameofBook;
	private String ISBN;
	private Date dueDate;
	static int bookCount;
	static ArrayList<Book> bookArray = new ArrayList<Book>();
	private double bookCost = 50;
	
	Book(String nameofBook, String ISBN, int bookCost) {
		this.nameofBook = nameofBook;
		this.ISBN = ISBN;		
		this.bookCost = bookCost;
		bookCount++;
	}
	Book(String nameofBook, String ISBN, Date dueDate) {
		this.nameofBook = nameofBook;
		this.ISBN = ISBN;
		this.dueDate = dueDate;
		bookCount++;
	}
	
	public void setdueDate(Date date) {
		dueDate = date;
	}
	
	public Date getdueDate() {
		return dueDate;
	}
	
	public String getNameofBook() {
		return nameofBook;
	}
	
	public String getISBN() {
		return ISBN;
	}
	
	@Override
	public double calculateCost() {
		return bookCost;
	}
}
