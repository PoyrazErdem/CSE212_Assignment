import java.util.Iterator;
import java.util.Scanner;
import java.util.Collections;

public class Menu {
	static Scanner scan = new Scanner(System.in);
	enum MAIN_MENU{
		
		ZERO,//0
		ADD_A_NEW_BOOK,//1
		ADD_A_NEW_ARTICLE,//2
		CREATE_A_NEW_MEMBER,//3
		CHECK_OUT_A_BOOK,//4
		RETURN_A_BOOK,//5
		GIVE_ACCESS_TO_AN_ONLINE_ARTICLE,//6
		END_AN_ONLINE_ARTICLE,//7
		DISPLAY_ALL_ACCOUNTS,//8
		DISPLAY_LIBRARY_DATABASE,//9
		MEMBERS_WITH_OVERDUE_PAYMENTS,//10
		EXIT;//11
		
	}
	enum SUB_MENU{
		
		ZERO,
		REGULAR_MEMBER,
		STUDENT_MEMBER,
		ACADEMIC_MEMBER;
	}
	
	private static void printer() {
		System.out.println("--------------------------------------");
		System.out.println("Library Management System Menu");
		System.out.println("1. Add a new book");
		System.out.println("2. Add a new online article");
		System.out.println("3. Create a member account");
		System.out.println("4. Check out a book");
		System.out.println("5. Return a book");
		System.out.println("6. Give access to an online article");
		System.out.println("7. End an online article access");
		System.out.println("8. Display all accounts");
		System.out.println("9. Display library database");
		System.out.println("10. Members with overdue payments");
		System.out.println("11. Exit");
		System.out.print("Your answer: ");
	}
	
	private static void printer2() {
		System.out.println();
		System.out.println("---------------------------------------------------------------");
		System.out.println("Please enter the type of membership you would like to create:");
		System.out.println("1. Regular Member");
		System.out.println("2. Student Member");
		System.out.println("3. Academic Member");
		System.out.print("Your answer: ");
	}
	private static void add_book() {
		System.out.println();
		System.out.print("Enter book name: ");
		scan.nextLine();
		String nameofBook = scan.nextLine();
		System.out.print("ISBN: ");
		String ISBN = scan.nextLine();
		System.out.print("price: ");
		int price = scan.nextInt();
		System.out.println();
		scan.nextLine();
		Book book1 = new Book(nameofBook, ISBN, price);
		Book.bookArray.add(book1);
		System.out.println("A new book is added to the library with name " + "'" + book1.getNameofBook() + "'" + " and ISBN# " + book1.getISBN());
		System.out.println("Total number of books in the library: " + Book.bookCount);
		System.out.println();
	}
	private static void add_article() {
		System.out.println();
		System.out.print("Enter article name: ");
		scan.nextLine();
		String nameOfArticle = scan.nextLine();
		System.out.print("DOI: ");
		String DOI = scan.nextLine();
		System.out.print("Publisher: ");
		String publisher = scan.nextLine();
		System.out.println();
		OnlineArticle article1 = new OnlineArticle(nameOfArticle, DOI, publisher);
		OnlineArticle.articleArray.add(article1);
		System.out.println("A new article is added to the library with name " + "'" + article1.getNameOfArticle() + "'" + " and DOI# " + article1.getDOI() + "with the publisher " + article1.getPublisher());
		System.out.println();
	}
	
	private static void regular_member() {
		System.out.println();
		System.out.print("Enter new member name: ");
		scan.nextLine();
		String memberName = scan.nextLine();
		System.out.print("Id: ");
		String Id = scan.nextLine();
		for(int index = 0; index < RegularMember.regularMemberCount; index++) {
			if(RegularMember.regularMemberArray.get(index).getMemberId().equals(Id)) {
				System.out.println("This Id is already in use, please try again");
				return;
			}
		}
		System.out.println();
		RegularMember regularMember1 = new RegularMember(memberName, Id);
		RegularMember.regularMemberArray.add(regularMember1);
		System.out.println("A new member is added to the library with name " + "'" + regularMember1.getMemberName() + "'" + " and Id: " + regularMember1.getMemberId());
		System.out.println();
	}
	
	private static void student_member() {
		System.out.println();
		System.out.print("Enter new student member name: ");
		scan.nextLine();
		String memberName = scan.nextLine();
		System.out.print("Id: ");
		String Id = scan.nextLine();
		for(int index = 0; index < RegularMember.regularMemberCount; index++) {
			if(RegularMember.regularMemberArray.get(index).getMemberId().equals(Id)) {
				System.out.println("This Id is already in use, please try again");
				return;
			}
		}
		System.out.println();
		StudentMember studentMember1 = new StudentMember(memberName, Id);
		RegularMember.regularMemberArray.add(studentMember1);
		System.out.println("A new student member is added to the library with name " + "'" + studentMember1.getMemberName() + "'" + " and Id: " + studentMember1.getMemberId());
		System.out.println();
	}
	
	private static void academic_member() {
		System.out.println();
		System.out.print("Enter new academic member name: ");
		scan.nextLine();
		String memberName = scan.nextLine();
		System.out.print("Id: ");
		String Id = scan.nextLine();
		for(int index = 0; index < RegularMember.regularMemberCount; index++) {
			if(RegularMember.regularMemberArray.get(index).getMemberId().equals(Id)) {
				System.out.println("This Id is already in use, please try again");
				return;
			}
		}
		System.out.println();
		AcademicMember academicMember1 = new AcademicMember(memberName, Id);
		RegularMember.regularMemberArray.add(academicMember1);
		System.out.println("A new academic member is added to the library with name " + "'" + academicMember1.getMemberName() + "'" + " and Id: " + academicMember1.getMemberId());
		System.out.println();
	}
	
	private static void checkOutBook() {
		boolean flag2 = true; // to check if the given ISBN match the ISBN's
		boolean flag3 = false; // to check if the given Id match the Id's
		System.out.println();
		System.out.print("Please enter a member Id number: ");
		scan.nextLine();
		String checkedId = scan.nextLine();
		if(RegularMember.regularMemberCount == 0) {
			System.out.println();
			System.out.println("The member list is empty");
			System.out.println();
			return;
		}
		RegularMember member;
		for(int index = 0; index < RegularMember.regularMemberCount; index++) {
			if(RegularMember.regularMemberArray.get(index).getMemberId().equals(checkedId)) {
				member = RegularMember.regularMemberArray.get(index);
				if(member.arrayLimit <= member.checkedOutBookCount) {
					System.out.println();
					System.out.println("Book quota has been reached for the member named " + member.getMemberName());
					return;
				}
				System.out.print("Search for a Book with ISBN: ");
				String checkedISBN = scan.nextLine();
				if(Book.bookArray.size() == 0) {
					System.out.println();
					System.out.println("The book list is empty");
					System.out.println();
					return;
				}
				for(int index2 = 0; index2 < Book.bookArray.size(); index2++ ) {
					if(Book.bookArray.get(index2).getISBN().equals(checkedISBN)) {
						System.out.println();
						System.out.print("Enter a due year (YYYY): ");
						int year = scan.nextInt();
						System.out.println();
						System.out.print("Enter a due month (MM): ");
						int month = scan.nextInt();
						System.out.println();
						System.out.print("Enter a due day (DD): ");
						int day = scan.nextInt();
						System.out.println();
						if(Date.isValid(day,month,year)) {
							if(member.appendToBookArray(Book.bookArray.get(index2))) {
								Date date1 = new Date(day,month,year);
								Book.bookArray.get(index2).setdueDate(date1);
								System.out.println("The book with name " + "'" + Book.bookArray.get(index2).getNameofBook() + "' " + "(ISBN: " + Book.bookArray.get(index2).getISBN() + ") is checked out by user " + RegularMember.regularMemberArray.get(index).getMemberName() + " is due " + date1.day + "/" + date1.month + "/" + date1.year);
								Book.bookArray.remove(Book.bookArray.get(index2)); // removes the book from the library
								return;
							}
							else {
								return;
							}
						}
						else {
							return;
						}
					}
					if(!Book.bookArray.get(index2).getISBN().equals(checkedISBN)) {
						flag2 = false;
					}
				}
				if(flag2 == false) {
					System.out.println();
					System.out.println("This ISBN# doesn't match any of the books ISBN#, please try a different ISBN#");
					return;
				}
			}
			if(index == RegularMember.regularMemberCount - 1) {
				flag3 = true;
			}
			if(!RegularMember.regularMemberArray.get(index).getMemberId().equals(checkedId)) {
				if(flag3 == true) {
					System.out.println();
					System.out.println("This Id doesn't match any of our members, please try a different Id");
					System.out.println();
					return;
				}
			}
		}
	}
	
	private static void returnABook() {
		System.out.println();
		System.out.print("Please enter your member ID number: ");
		scan.nextLine();
		String checkedId = scan.nextLine();
		if(RegularMember.regularMemberCount == 0) {
			System.out.println();
			System.out.println("The member list is empty");
			System.out.println();
			return;
		}
		int member_location = -1; //created to hold the given Id index
		for(int index = 0; index < RegularMember.regularMemberCount; index++) {
			if(RegularMember.regularMemberArray.get(index).getMemberId().equals(checkedId)) {
				member_location = index; //holds the given Id
				System.out.println();
				if(Book.bookCount == 0) {
					System.out.println("The book list is empty");
					System.out.println();
					return;
				}
				System.out.print("Enter the ISBN number of the book being returned: ");
				String checkedISBN = scan.nextLine();
				Book tempBook = null; // book to be returned to the book array
				for(int index2 = 0; index2 < RegularMember.regularMemberArray.get(member_location).checkedOutBookCount ; index2++ ) {
					if(RegularMember.regularMemberArray.get(member_location).checkedoutBook.get(index2).getISBN().equals(checkedISBN)) {
						tempBook = RegularMember.regularMemberArray.get(member_location).checkedoutBook.get(index2);
						RegularMember.regularMemberArray.get(member_location).returnBook(tempBook.getISBN());
						System.out.println();
						System.out.println("The book with the name " + tempBook.getNameofBook() + " (ISBN: " + tempBook.getISBN() + ") " + "is returned by user " + RegularMember.regularMemberArray.get(index).getMemberName() );
						Book.bookArray.add(tempBook);
						return;
					}
				}
				System.out.println();
				System.out.println("This ISBN# doesn't match any of the books ISBN#, please try a different ISBN#");
				return;
			}
		}
		System.out.println();
		System.out.println("This Id doesn't match any of our members, please try a different Id");
		System.out.println();
	}
	
	private static void checkOutArticle() {
		boolean flag2 = true; // to check if the given ISBN match the ISBN's
		boolean flag3 = false; // to check if the given Id match the Id's
		System.out.println();
		System.out.print("Please enter a member Id number: ");
		scan.nextLine();
		String checkedId = scan.nextLine();
		if(RegularMember.regularMemberCount == 0) {
			System.out.println();
			System.out.println("The member list is empty");
			System.out.println();
			return;
		}
		RegularMember member;
		for(int index = 0; index < RegularMember.regularMemberCount; index++) {
			if(RegularMember.regularMemberArray.get(index).getMemberId().equals(checkedId)) {
				member = RegularMember.regularMemberArray.get(index);
				if(member.arrayLimit <= member.accessibleOnlineArticleCount) {
					System.out.println();
					System.out.println("Article quota has been reached for the member named " + member.getMemberName());
					return;
				}
				System.out.print("Search for a Article with DOI: ");
				String checkedDOI = scan.nextLine();
				if(OnlineArticle.articleCount == 0) {
					System.out.println();
					System.out.println("The article list is empty");
					System.out.println();
					return;
				}
				for(int index2 = 0; index2 < OnlineArticle.articleArray.size(); index2++ ) {
					if(OnlineArticle.articleArray.get(index2).getDOI().equals(checkedDOI)) {
						System.out.println();
						System.out.print("Enter a access year (YYYY): ");
						int year = scan.nextInt();
						System.out.println();
						System.out.print("Enter a access month (MM): ");
						int month = scan.nextInt();
						System.out.println();
						System.out.print("Enter a access day (DD): ");
						int day = scan.nextInt();
						System.out.println();
						if(Date.isValid(day,month,year)) {
							if(member.appendAccessedArticle(OnlineArticle.articleArray.get(index2))) {
								Date date1 = new Date(day,month,year);
								OnlineArticle.articleArray.get(index2).setAccessDate(date1);
								System.out.println("The article with name " + "'" + OnlineArticle.articleArray.get(index2).getNameOfArticle() + "' " + "(ISBN: " + OnlineArticle.articleArray.get(index2).getDOI() + ") is checked out by user " + RegularMember.regularMemberArray.get(index).getMemberName() + " is due " + date1.day + "/" + date1.month + "/" + date1.year);
								OnlineArticle.articleArray.remove(OnlineArticle.articleArray.get(index2)); // removes the book from the library
								return;
							}
							else {
								return;
							}
						}
						else {
							return;
						}
					}
					if(OnlineArticle.articleArray.get(index2).getDOI().equals(checkedDOI)) {
						System.out.println();
						if(member.appendAccessedArticle(OnlineArticle.articleArray.get(index2))) {
							System.out.println("The article with name " + "'" + OnlineArticle.articleArray.get(index2).nameOfArticle + "' " + "(DOI: " + OnlineArticle.articleArray.get(index2).DOI + ") is checked out by user " + RegularMember.regularMemberArray.get(index).getMemberName());
							OnlineArticle.articleArray.remove(index2);
							return;
						}
						System.out.println("Online article quota is reached");
						return;
					}
					if(!OnlineArticle.articleArray.get(index2).getDOI().equals(checkedDOI)) {
						flag2 = false;
					}
				}
				if(flag2 == false) {
					System.out.println();
					System.out.println("This DOI# doesn't match any of the articles DOI#, please try a different DOI#");
					return;
				}
			}
			if(index == RegularMember.regularMemberCount - 1) {
				flag3 = true;
			}
			if(!RegularMember.regularMemberArray.get(index).getMemberId().equals(checkedId)) {
				if(flag3 == true) {
					System.out.println();
					System.out.println("This Id doesn't match any of our members, please try a different Id");
					System.out.println();
					return;
				}
			}
		}
	}
	
	private static void returnAnOnlineArticle() {
		System.out.println();
		System.out.print("Please enter your member ID number: ");
		scan.nextLine();
		String checkedId = scan.nextLine();
		if(RegularMember.regularMemberCount == 0) {
			System.out.println();
			System.out.println("The member list is empty");
			System.out.println();
			return;
		}
		int member_location = -1; //created to hold the given Id index
		for(int index = 0; index < RegularMember.regularMemberCount; index++) {
			if(RegularMember.regularMemberArray.get(index).getMemberId().equals(checkedId)) {
				member_location = index; //holds the given Id
				System.out.println();
				if(OnlineArticle.articleCount == 0) {
					System.out.println("The article list is empty");
					System.out.println();
					return;
				}
				System.out.print("Enter the DOI number of the article being returned: ");
				String checkedDOI = scan.nextLine();
				OnlineArticle tempArticle = null; //article to be returned to the article array
				for(int index2 = 0; index2 < RegularMember.regularMemberArray.get(member_location).accessibleOnlineArticleCount ; index2++ ) {
					if(RegularMember.regularMemberArray.get(member_location).accessedArticle.get(index2).getDOI().equals(checkedDOI)) {
						tempArticle = RegularMember.regularMemberArray.get(member_location).accessedArticle.get(index2);
						RegularMember.regularMemberArray.get(member_location).returnOA(RegularMember.regularMemberArray.get(member_location).accessedArticle.get(index2).getDOI());
						System.out.println();
						System.out.println("The article with the name " + tempArticle.getNameOfArticle() + " (DOI: " + tempArticle.getDOI() + ") " + "is returned by user " + RegularMember.regularMemberArray.get(index).getMemberName() );
						OnlineArticle.articleArray.add(tempArticle);
						return;
					}
				}
				System.out.println();
				System.out.println("This DOI# doesn't match any of the articles DOI#, please try a different DOI#");
				return;
			}
		}
		System.out.println();
		System.out.println("This Id doesn't match any of our members, please try a different Id");
		System.out.println();
	}
	
	private static void displayAllAccounts() {
		System.out.println();
		if(RegularMember.regularMemberCount < 1) {
			System.out.println("There is NO MEMBER who have checked out any books or articles");
			System.out.println();
			return;
		}
		boolean noBookArticle = true;
		Iterator<RegularMember> temp = RegularMember.regularMemberArray.iterator();
		while(temp.hasNext()) {
			RegularMember member = temp.next();
			if(member.checkedOutBookCount != 0 || member.accessibleOnlineArticleCount != 0) {
				System.out.println("User Name: "+ member.memberName);
				System.out.println("User ID: "+ member.Id);
				System.out.println();
			}
			if(member.checkedOutBookCount != 0) {
				noBookArticle = false;
				System.out.print("Checked Out Books: ");
				System.out.println();
				for(int index2 = 0; index2 < member.checkedOutBookCount; index2++) {
					System.out.println("Booked titled " + member.checkedoutBook.get(index2).getNameofBook()+ " till " + member.checkedoutBook.get(index2).getdueDate());
					if( member.calculateCost(member.checkedoutBook.get(index2))!= 0 ) {
						System.out.println("The book entitled '" + member.checkedoutBook.get(index2).getNameofBook() + "' has an overdue charge of " + member.calculateCost(member.checkedoutBook.get(index2)) + " TRL");
					}
					System.out.println();
				}
			}
			if(member.accessibleOnlineArticleCount != 0) {
				noBookArticle = false;
				System.out.print("Obtained Online Articles:");
				System.out.println();
				for(int index3 = 0; index3 < member.accessibleOnlineArticleCount; index3++) {
					System.out.println("Article entitled " + member.accessedArticle.get(index3).nameOfArticle + " with DOI " + member.accessedArticle.get(index3).DOI);
					if( member.calculateCost(member.accessedArticle.get(index3)) != 0 ) {
						System.out.println("The article entitled '" + member.accessedArticle.get(index3).nameOfArticle + "' has an overdue charge of " + member.calculateCost(member.accessedArticle.get(index3)) + " TRL");
					}
				}
			}
		}
		if(noBookArticle) {
			System.out.println("There are NO BOOKS or ARTICLES that have been checked out by any of our members");
		}
	}
	
	private static void displayLibraryDatabase() {
		System.out.println();
		Iterator<Book> iter = Book.bookArray.iterator();
		if(!iter.hasNext()) {
			System.out.println("no book to display");
			System.out.println();
		}
		while(iter.hasNext()) {
			Book temp = iter.next();
			System.out.println("Book Name: " + temp.getNameofBook());
			System.out.println("ISBN: " + temp.getISBN());
			System.out.println("The cost is " + temp.calculateCost() + "TRL");
			System.out.println();
		}
		Iterator<OnlineArticle> iter2 = OnlineArticle.articleArray.iterator();
		if(!iter2.hasNext()) {
			System.out.println("no article to display");
		}
		while(iter2.hasNext()) {
			OnlineArticle temp = iter2.next();
			System.out.println("Article Name: " + temp.getNameOfArticle());
			System.out.println("DOI: " + temp.getDOI());
			System.out.println("The cost is " + temp.calculateCost() + "TRL");
			System.out.println();
		}
	}
	
	private static void overduePayment() {
		if(RegularMember.regularMemberArray.isEmpty()) {
			System.out.println();
			System.out.println("No member to list");
		}
		for(RegularMember member : RegularMember.regularMemberArray) {
			member.calculateCost();
		}
		RegularMember.regularMemberArray.sort(null);
		Collections.reverse(RegularMember.regularMemberArray);
		for(RegularMember member : RegularMember.regularMemberArray) {
            System.out.println("Member " + member.getMemberName() + " with user id "+member.getMemberId() + " is due to pay " + member.getOverdueCharge() + " TRL");
        }
	}

	public static void menu() {
		int choice;
		int sub_choice;
		boolean flag = false;
		while(true) {
			printer();
			choice = scan.nextInt();
			if(choice < 1 || choice > 11) {
				System.out.println();
				System.out.println("Please select a valid option from menu (1-11)");
				System.out.println();
				continue;
			}
			MAIN_MENU menu_selection = MAIN_MENU.values()[choice];
			switch(menu_selection) {
			case ADD_A_NEW_BOOK:
				add_book();
				break;
				
			case ADD_A_NEW_ARTICLE:
				add_article();
				break;
				
			case CREATE_A_NEW_MEMBER:
				printer2();
				sub_choice = scan.nextInt();
				if(sub_choice < 1 || choice > 3) {
					System.out.println();
					System.out.println("Please select a valid option from sub-menu (1-3)");
					System.out.println();
					continue;
				}
				SUB_MENU subMenu_selection = SUB_MENU.values()[sub_choice];
				switch(subMenu_selection) {
				case REGULAR_MEMBER:
					regular_member();
					break;
				
				case STUDENT_MEMBER:
					student_member();
					break;
					
				case ACADEMIC_MEMBER:
					academic_member();
					break;
				}
				break;
				
			case CHECK_OUT_A_BOOK:
				checkOutBook();
				break;
				
			case RETURN_A_BOOK:
				returnABook();
				break;
				
			case GIVE_ACCESS_TO_AN_ONLINE_ARTICLE:
				checkOutArticle();
				break;
			
			case END_AN_ONLINE_ARTICLE:
				returnAnOnlineArticle();
				break;
				
			case DISPLAY_ALL_ACCOUNTS:
				displayAllAccounts();
				break;
			
			case DISPLAY_LIBRARY_DATABASE:
				displayLibraryDatabase();
				break;
				
			case MEMBERS_WITH_OVERDUE_PAYMENTS:
				overduePayment();
				break;
				
			case EXIT:
				System.out.println("Goodbye");
				flag = true;
			}
			if(flag == true) {
				break;
			}
		}
	}
}
