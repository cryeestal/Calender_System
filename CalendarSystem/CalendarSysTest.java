package CalendarSystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalendarSysTest {

	CalendarSys calender = null;
	int month1, month2;
	int year3, year4;
	String year1,year2;
	String check1,check2,check3,check4;
	String sdate1, sdate2,sdate3,sdate4;
	
	/** Refresh the value of calendar before each @Test method
	 *  
	 * Time estimate: O(1)
	 */
	@BeforeEach
	void setUp() throws Exception {
		calender = new CalendarSys();

	}
	
	/** Destroy the value of calendar after each @Test method
	 * 
	 * Time estimate: O(1)
	 */
	@AfterEach
	void tearDown() throws Exception {
		calender = null;
	}
		
	/** Test method: CalendarSys.parsedate()
	 *  Test date: "2022/04/07","2044/05/07","9999/05/07"
	 */
	@DisplayName("parsedateTest1")
	@Test
	void parsedateTest1() {
		sdate1 = "2022/04/07";
        sdate2 = "2044/05/07";
        sdate3 = "9999/05/07";
		assertTrue(calender.parsedate(sdate1));
		assertTrue(calender.parsedate(sdate2));
		assertTrue(calender.parsedate(sdate3));
	}
	
	/** Test method: CalendarSys.parsedate()
	 *  Test date: "2022/13/07","2044/10/32","2053/02/29","a20441307"
	 */
	@DisplayName("parsedateTest2")
	@Test
	void parsedateTest2() {
		sdate1 = "2022/13/07";
		sdate2 = "2044/10/32";
		sdate3 = "2053/02/29";
		sdate4 = "a20441307";
		
		assertFalse(calender.parsedate(sdate1));
		assertFalse(calender.parsedate(sdate2));
		assertFalse(calender.parsedate(sdate3));
		assertFalse(calender.parsedate(sdate4));
	}
	
	/** Test method: CalendarSys.ChineseYear()
	 *  Test year: "2022","2025"
	 */
	@DisplayName("ChineseYearTest1")
	@Test
	void ChineseYearTest1() {
		year1 = "2022";
		year2 = "2025";
		assertTrue(calender.ChineseYear(year1));
		assertTrue(calender.ChineseYear(year2));
	}
	
	/** Test method: CalendarSys.ChineseYear()
	 *  Test year: "abc","20/25"
	 */
	@DisplayName("ChineseYearTest2")
	@Test
	void ChineseYearTest2() {
		year1 = "abc";
		year2 = "20/25";
		assertFalse(calender.ChineseYear(year1));
		assertFalse(calender.ChineseYear(year2));
	}
	
	/** Test method: CalendarSys.CalculateDays()
	 *  Test date: "abcde","10/199"
	 */
	@DisplayName("CalculateDaysTest1")
	@Test
	void CalculateDaysTest1() {
		sdate1 = "abcde";
		sdate2 = "10/199";
		assertEquals(-1 , calender.CalculateDays(sdate1));
		assertEquals(-1 , calender.CalculateDays(sdate2));
	}
	
	/** Test method: CalendarSys.CalculateDays()
	 *  Test date: "2022/3/40","1000abc"
	 */
	@DisplayName("CalculateDaysTest2")
	@Test
	void CalculateDaysTest2() {
		sdate1 = "2022/3/40";
		sdate2 = "1000abc";
		assertEquals(-1 , calender.CalculateDays(sdate1));
		assertEquals(-1 , calender.CalculateDays(sdate2));
	}
	
	
	/** Test method: CalendarSys.differentDays()
	 * check differentDays() because "today" changes everyday
	 *  Test date: "2022/04/09 , 2022/04/20"
	 */
	@DisplayName("differentDaysTest1")
	@Test
	void differentDaysTest1() throws ParseException {
		 
		sdate1 = "2022/04/09";
		sdate2 = "2022/04/20";
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date checkdate1 = format.parse(sdate1);
		Date checkdate2 = format.parse(sdate2);
		assertEquals(11 , calender.differentDays(checkdate1,checkdate2));
		
	}
	
	/** Test method: CalendarSys.differentDays()
	 * check differentDays() because "today" changes everyday
	 *  Test date: "2022/04/09 , 2022/05/31"
	 */
	@DisplayName("differentDaysTest2")
	@Test
	void differentDaysTest2() throws ParseException {
		
		sdate3 = "2022/04/09";
		sdate4 = "2022/05/31";
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date checkdate3 = format.parse(sdate3);
		Date checkdate4 = format.parse(sdate4);
		assertEquals(52 , calender.differentDays(checkdate3,checkdate4));
	}
	
	/** Test method: CalendarSys.CalculateDate()
	 *  Test # of day: "20","30"
	 */
	@DisplayName("CalculateDateTest1")
	@Test
	void CalculateDateTest1() {
		 
		check1 = "20";
		check2 = "30";
		assertTrue(calender.CalculateDate(check1));
		assertTrue(calender.CalculateDate(check2));
		
	}
	
	/** Test method: CalendarSys.CalculateDate()
	 *  Test # of day: "abc","2022/34/3"
	 */
	@DisplayName("CalculateDateTest2")
	@Test
	void CalculateDateTest2()  {
		
		check3 = "abc";
		check4 = "2022/34/3";
		assertFalse(calender.CalculateDate(check3));
		assertFalse(calender.CalculateDate(check4));
	}
	
	/** Test method: CalendarSys.addDate()
	 *  Test date and # of day: "2022/04/09 , 11" 
	 */
	@DisplayName("addDateTest1")
	@Test
	void addDateTest1() throws ParseException {
		 
		sdate1 = "2022/04/09";
		sdate2 = "2022/04/20";
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date checkdate1 = format.parse(sdate1);
		Date checkdate2 = format.parse(sdate2);
		assertEquals(checkdate2 , calender.addDate(checkdate1,11));
		
	}
	
	/** Test method: CalendarSys.addDate()
	 *  Test date and # of day: "2022/04/09 , 52" 
	 */
	@DisplayName("addDateTest2")
	@Test
	void addDateTest2() throws ParseException {
		
		sdate3 = "2022/04/09";
		sdate4 = "2022/05/31";
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date checkdate3 = format.parse(sdate3);
		Date checkdate4 = format.parse(sdate4);
		assertEquals(checkdate4 , calender.addDate(checkdate3,52));
	}
	
	/** Test method: CalendarSys.daysInMonth()
	 *  Test month: "2840/2","2022/2"
	 */
	@DisplayName("daysInMonthTest1")
	@Test
	void daysInMonthTest1() {
		year3 = 2840; year4 = 2022;
		month1 = 2;
		assertEquals(29, calender.daysInMonth(year3, month1));
		assertEquals(28, calender.daysInMonth(year4, month1));
	}
	
	/** Test method: CalendarSys.daysInMonth()
	 *  Test month: "2021/5","2031/6"
	 */
	@DisplayName("daysInMonthTest2")
	@Test
	void daysInMonthTest2() {
		year3 = 2021; year4 = 2031;
		month1 = 5; month2 = 6;
		assertEquals(31, calender.daysInMonth(year3, month1));
		assertEquals(30, calender.daysInMonth(year4, month2));
	}
	
	/** Test method: CalendarSys.isLeapYear()
	 *  Test year: "2313","2022"
	 */
	@DisplayName("isLeapYearTest1")
	@Test
	void isLeapYearTest1() {
		year3 = 2313;
		year4 = 2022;
		assertFalse(calender.isLeapYear(year3));
		assertFalse(calender.isLeapYear(year4));
	}

	/** Test method: CalendarSys.isLeapYear()
	 *  Test year: "2800","2024"
	 */
	@DisplayName("isLeapYearTest2")
	@Test
	void isLeapYearTest2() {
		year3 = 2800;
		year4 = 2024;
		assertTrue(calender.isLeapYear(year3));
		assertTrue(calender.isLeapYear(year4));
	}

}
