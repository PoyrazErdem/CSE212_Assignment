
public class Date {
	int day;
	int month;
	int year;
	
	Date(int day, int month, int year){
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public static boolean isValid(int day,int month,int year) {
		if(year <= 2000) {
			System.out.println("Invalid year");
			return false;
		}
		if(month <= 0 || month >= 13 ) {
			System.out.println("Invalid month");
			return false;
		}
		if(day <= 0 || day >= extremeDetailDate(month, year)) {
			System.out.println("Invalid day");
			return false;
		}
		return true;
	}
	
	private static int extremeDetailDate(int month, int year) {
        if (month < 8) {
            if (month % 2 == 1) return 31;
            if (month == 2) return (year % 4 == 0) ? 29 : 28; 
            return 30;

        }
        else {
            if (month % 2 == 1) return 30;
            return 31;
        }
    }
	@Override
	public String toString() {
		return day + "/" + month + "/" + year;
	}
}
