
public class Date {
	int day;
	int month;
	int year;
	
	Date(int day, int month, int year){
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public static boolean DateValidator(int day,int month,int year) throws NotValidDateException {
		if(year <= 2000 || year >= 2100) {
			throw new NotValidDateException(null);
		}
		if(month <= 0 || month >= 13 ) {
			throw new NotValidDateException(null);
		}
		if(day <= 0 || day >= extremeDetailDate(month, year)) {
			throw new NotValidDateException(null);
		}
		return true;
	}
	
	private static int extremeDetailDate(int month, int year) {
        if (month < 8) {
            if (month % 2 == 1) return 31;
            if (month == 2) {
            	if((year % 4 == 0 && year %	100 != 0) || (year % 400 == 0)) return 29;
            	else return 28;
            }
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


























