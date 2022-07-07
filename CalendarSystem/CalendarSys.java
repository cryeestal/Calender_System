package CalendarSystem;

import java.util.Scanner;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Date;
import java.text.*;


class CalendarSys{
	
		private Scanner sc = new Scanner(System.in);
		private boolean isUnitTesting;
		
		/** Construct the CalendarSys class
		 * Time estimate: O(1)
		 */
		CalendarSys() {
			isUnitTesting = false;
		}
		
		/** Construct the CalendarSys class
		 * 
		 * @param unitTesting whether it's called for unit testing
		 * Time estimate: O(1)
		 */
		CalendarSys(boolean unitTesting) {
			isUnitTesting = unitTesting;
		}
		
		/** Get the instruction and action until quit
		 * Assume that login() was called and finished successfully
		 * 
		 * @return true the end of instr. is not reached
		 * @return false the end of instr. is reached
		 * 
		 * Example: call it and it will ask the instruction
		 * Time estimate: O(nR), where n is # of instructions, and R is # of record.
		 */
		public boolean instr() {
			if(isUnitTesting) this.sc = new Scanner(System.in);
			String op;
			this.showinstr();
			op = sc.next().toUpperCase();
			if(this.handleop(op) == false) {
				sc.close();
				return false;
			}
			return true;
		}
		
		/** Show the instruction list
		 * Time estimate: O(1)
		 */
		private void showinstr() {
			System.out.println("");
			System.out.println("輸入指令號碼或 E(結束使用)?");
			System.out.println("1) A 顯示該月月曆");
			System.out.println("2) B 西元轉換干支、生肖");
			System.out.println("3) C 計算天數");
			System.out.println("4) D 計算日期");
			System.out.println("5) E 離開");
		}
		
		/** Handle the instruction fed by instr()
		 * 
		 * @param op instruction fed by instr()
		 * @return true if it's not going to exit
		 * @return false if it's going to exit
		 * 
		 * Example: handleop("E") will quit
		 * Time estimate: O(R), where R is the # of record.
		 */
		private boolean handleop(String op) {
			if(isUnitTesting) this.sc = new Scanner(System.in);
			if(op.equals("E")) {
				return false;
			} else if(op.equals("A")) {
				System.out.print("請輸入欲查詢日期(年/月/日): ");
//		        Scanner sc = new Scanner(System.in);
				parsedate(sc.next());
			} else if(op.equals("B")) {
				System.out.print("輸入欲查詢年: ");
//				Scanner sc = new Scanner(System.in);
				ChineseYear(sc.next());
			} else if(op.equals("C")) {
					System.out.print("請輸入欲查詢日期(年/月/日): ");
//					Scanner sc = new Scanner(System.in);
					this.CalculateDays(sc.next());
			} else if(op.equals("D")) {
					System.out.print("請輸入往後推算的天數: ");
//					Scanner sc = new Scanner(System.in);
					this.CalculateDate(sc.next());
			} else {
				System.out.println("請輸入有效指令或關閉系統");
			}
			return true;
		}
		
		/** print the sexagenary cycle of input year 
		 * 
		 * @param a. The string of input year.
		 * @throws Exception e.  If input year is not a nature number,
		 * throw "For function ChineseYear : Invalid input format"
		 * @return true if it's scan and print successfully
		 * @return false if the input is invalid
		 * 
		 * Time estimate: O(1)
		 */
		public static boolean ChineseYear(String a) {
			
			try {
			    int year = Integer.parseInt(a);
			    
			    String sTG[]={"癸","甲","乙","丙","丁","戊","己","庚","辛","壬"};
	
		        String sDZ[]={"亥","子","丑","寅","卯","辰","巳","午","未","申","酉","戌"};
		        String sSX[]={"豬","鼠","牛","虎","兔","龍","蛇","馬","羊","猴","雞","狗"};
		        int i=(year-3)%10;
		        int j=(year-3)%12;
		        System.out.println(year+"是"+sTG[i]+sDZ[j]+"年，屬"+sSX[j]);
		        System.out.println();
	         
			}
			catch (Exception e) {
		        
		        System.err.println("For function ChineseYear : Invalid input format");
		        System.err.println(e.getMessage());
		        return false;
		        
		    }
			return true;
			
		}
		/** call  printCalendarMonthYear(month, year) 
		 * 		  printCalendar(numberOfMonthDays, firstWeekdayOfMonth)
		 *  to print the month calendar according to year and month of input date
		 *  
		 * @param date. The string of input date.
		 * @throws Exception e.  If input date format is invalid,
		 * throw "For function parsedate : Invalid input format"
		 * @return true if it's scan and print successfully
		 * @return false if the input is invalid
		 * 
		 * Time estimate: O(1)
		 */
		public static boolean parsedate(String date){
	
	        
	        try {
	        	int year = Integer.parseInt(date.substring(0, 4));
	    		int month = Integer.parseInt(date.substring(5, 7));
	    		int day = Integer.parseInt(date.substring(8, 10));
	
	            if(month < 1 || month > 12 || day <1 || day > daysInMonth(year,month)) 
	                throw new Exception("For month or day: " + month + "/" + day);
	            //檢查月份日期
	           
	            printCalendarMonthYear(month, year);} 
	
	         catch (Exception e) {
	        	System.err.println("For function parsedate : Invalid input format ");
	            System.err.println(e.getMessage());
	            return false;
	        }
	        return true;
	    }
		/** get # of days of month and the first weekday of month 
		 *  and call printCalendar(numberOfMonthDays, firstWeekdayOfMonth)
		 *  to print the month calendar according to year and month of input date.
		 *  
		 * @param month, year. The integer of month and year of input date.
		 * 
		 * Time estimate: O(1)
		 */
	    private static void printCalendarMonthYear(int month, int year) {
	       Calendar cal = new GregorianCalendar();
	       cal.clear();
	       cal.set(year, month - 1, 1); 
	        int firstWeekdayOfMonth = cal.get(Calendar.DAY_OF_WEEK);
	        int numberOfMonthDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH); 
	        printCalendar(numberOfMonthDays, firstWeekdayOfMonth);
	    }
	    /** print the month calendar 
	     * with # of days of month and the first weekday of month 
	     * according to year and month of input date.
	     * 
		 * @param numberOfMonthDays, firstWeekdayOfMonth. 
		 * 
		 * The integer of # of days of month and the first weekday of month.
		 * Time estimate: O(1)
		 */
	    private static void printCalendar(int numberOfMonthDays, int firstWeekdayOfMonth) {
	    	
	        int weekdayIndex = 0; 
	        System.out.println("Sun Mon Tue Wen Thu Fri Sat"); //日曆格式
	
	        for (int day = 1; day < firstWeekdayOfMonth; day++) {
	            System.out.print("    "); 
	            weekdayIndex++;
	        }
	        for (int day = 1; day <= numberOfMonthDays; day++) {
	
	            if (day<10) //  visialising
	            System.out.print(day+" ");
	            else System.out.print(day); 
	            weekdayIndex++;
	            if (weekdayIndex == 7) {
	                weekdayIndex = 0;
	                System.out.println();
	            } else { 
	                System.out.print("  ");
	            }
	            }
	        System.out.println();
		     }
	    
	    /** check the year is leap year or not
		 * 
		 * @param year the integer going to be checked
		 * @return true if it is a leap year
		 * @return false if it is not a leap year
		 * 
		 * Example: isLeapYear(2024): return true, isLeapYear(2022): return false
		 * Time estimate: O(1)
		 */
	    public static boolean isLeapYear(int year) {
			return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
		}
	    
		/** return the # days in the given month
		 * 
		 * @param year the year going to be checked
		 * @param month the month going to be checked
		 * @return the # of days in the given month
		 * 
		 * Example: daysInMonth(2024, 2): return 29, daysInMonth(2022, 5): return 31
		 * Time estimate: O(1)
		 */
		public static int daysInMonth(int year, int month) {
			
			switch(month) {
			case 2:
				if(isLeapYear(year)) {
					return 29;
				} else {
					return 28;
				}
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return 31;
			default:
				return 30;
			}
		}
		/** call differentDays(Date date1,Date date2)
		 *  to calculate the different of days between input date and today.
		 *  
		 * @param lookup. The string of input date.
		 * @throws Exception e.  If input date format is invalid,
		 * throw "For function CalculateDays : Invalid input format"
		 * @return # of days between input date and today if it's scan and print successfully
		 * @return -1 if the input is invalid
		 * 
		 * Time estimate: O(1)
		 */
		public static int CalculateDays(String lookup){
			
			try{
				int year = Integer.parseInt(lookup.substring(0, 4));
				int month = Integer.parseInt(lookup.substring(5, 7));
				int day = Integer.parseInt(lookup.substring(8, 10));
				String dateStr2 = year+"-"+month+"-"+day;
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date date2 = format.parse(dateStr2);		
				Date today = new Date(); 
				Date date = format.parse(formatter.format(today));
				System.out.println(lookup+"距離今天還有"+differentDays(date,date2)+"天");
				return differentDays(date,date2);
				
				}catch (Exception e) {
				
					System.err.println("For function CalculateDays : Invalid input format");
					System.err.println(e.getMessage());
					return -1;
				}
			
			}
		/** calculate the different of day between two input dates
		 *  
		 * @param date1, date2. The date of input date.
		 * @return # of days between two input dates
		 * 
		 * Time estimate: O(1)
		 */
		public static int differentDays(Date date1,Date date2){
			
			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(date1);
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(date2);
			int day1= cal1.get(Calendar.DAY_OF_YEAR);
			int day2 = cal2.get(Calendar.DAY_OF_YEAR);
			int year1 = cal1.get(Calendar.YEAR);
			int year2 = cal2.get(Calendar.YEAR);
			if(year1 != year2) { //不同年
				int timeDistance = 0 ;
				for(int i = year1 ; i < year2 ; i ++  ){
					if(i%4==0 && i%100!=0 || i%400==0) //閏年  
						timeDistance  += 366;
					else //不是閏年
						timeDistance  += 365;
				}
				return timeDistance+(day2-day1);
			}
			else //同
				return day2-day1;
		}
		
		/**calculate the date of # of input day after today.
		 *  
		 * @param date, day. The date of input and the long integer of input day.
		 * @throws Exception ParseException if input date and day format is invalid.
		 * @return the date of # of second param after first param.
		 * 
		 * Time estimate: O(1)
		 */
		public static Date addDate(Date date, long day) throws ParseException {
			long time = date.getTime(); 
			day = day * 24 * 60 * 60 * 1000; //毫秒數
			time += day; 
			return new Date(time);
		}
		/** call addDate(Date date, long day)
		 *  to calculate the date of # of input days after today
		 *  and print the result
		 *  
		 * @param a. The string of input # of day.
		 * @throws Exception e.  If input string is invalid,
		 * throw "For function CalculateDate : Invalid input format"
		 * @return true if it's scan and print successfully
		 * @return false if the input is invalid
		 * 
		 * Time estimate: O(1)
		 */
	    public static boolean CalculateDate(String a){
			
		    try{
		    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat newform = new SimpleDateFormat("yyyy/MM/dd");
			    int cal = Integer.parseInt(a);
				Date today = new Date(); 
				Date date = format.parse(formatter.format(today)); 
				Date newDate = addDate(date, cal); 
				System.out.println(newform.format(newDate));
				return true;
				} catch (Exception e) {
					System.err.println("For function CalculateDate : Invalid input format");
			        System.err.println(e.getMessage());
			        return false;
			 }
		    
		}
	    
};

