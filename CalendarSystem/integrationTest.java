package CalendarSystem;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import javax.sound.sampled.Line;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
class integrationTest {

	CalendarSystem test = null;
	int year1, year2, month1, month2;
	String sdate1, sdate2, smonth1, scost1, data1, data2, op1, op2;
	ByteArrayInputStream testIn;
	ByteArrayOutputStream testOut;
	String instrTable =  System.getProperty("line.separator")+"輸入指令號碼或 E(結束使用)?"+
			System.getProperty("line.separator")+"1) A 顯示該月月曆"+
			System.getProperty("line.separator")+"2) B 西元轉換干支、生肖"+
			System.getProperty("line.separator")+"3) C 計算天數"+
			System.getProperty("line.separator")+"4) D 計算日期"+
			System.getProperty("line.separator")+"5) E 離開";
			
	
	@BeforeEach
	void setUp() throws Exception {
		test = new CalendarSystem();
	}

	@AfterEach
	void tearDown() throws Exception {
		test = null;
	}
	
	/** Test method: CalendarSys.parsedate()
	 *  Test input is data2
	 *  Target: the normal input
	 */
	@DisplayName("mainExample")
	@Test
	void mainTestExample() {
		data2 = "A\n2022/04/03\nE";
		data1 = instrTable + System.getProperty("line.separator")
				+"請輸入欲查詢日期(年/月/日): "
				+"Sun Mon Tue Wen Thu Fri Sat"+ System.getProperty("line.separator")
				+"                    1   2 "
				+ System.getProperty("line.separator")
				+"3   4   5   6   7   8   9 "
				+ System.getProperty("line.separator")
				+"10  11  12  13  14  15  16"
				+ System.getProperty("line.separator")
				+"17  18  19  20  21  22  23"
				+ System.getProperty("line.separator")
				+"24  25  26  27  28  29  30"
				+ System.getProperty("line.separator")
				+ System.getProperty("line.separator")
				+instrTable+ System.getProperty("line.separator")
				+"Good Bye ! Have a nice day :)"
				;
		testIn = new ByteArrayInputStream(data2.getBytes());
		testOut = new ByteArrayOutputStream();
		System.setIn(testIn);
		System.setOut(new PrintStream(testOut));
		CalendarSystem.main(null);
		assertEquals(data1, testOut.toString());
	}
	
	/** Test method: CalendarSys.ChineseYear()
	 *  Test input is data2
	 *  Target: the normal input
	 */
	@DisplayName("mainExample2")
	@Test
	void mainTestExample2() {
		data2 = "B\n2022\nB\n2023\nE";
		data1 = instrTable+ System.getProperty("line.separator")
				+"輸入欲查詢年: 2022是壬寅年，屬虎"
				+ System.getProperty("line.separator")
				+System.getProperty("line.separator")
				+instrTable+ System.getProperty("line.separator")
				+"輸入欲查詢年: 2023是癸卯年，屬兔"
				+ System.getProperty("line.separator")
				+ System.getProperty("line.separator")
				+instrTable+ System.getProperty("line.separator")
				+"Good Bye ! Have a nice day :)"
				;
		testIn = new ByteArrayInputStream(data2.getBytes());
		testOut = new ByteArrayOutputStream();
		System.setIn(testIn);
		System.setOut(new PrintStream(testOut));
		CalendarSystem.main(null);
		assertEquals(data1, testOut.toString());
	}
	
	/** Test method: CalendarSys.CalculateDays()
	 *  Test input is data2
	 *  Target: the normal input
	 */
	@DisplayName("mainExample3")
	@Test
	void mainTestExample3() {
		data2 = "C\n2022/04/27\nE";
		data1 = instrTable+System.getProperty("line.separator")
				+"請輸入欲查詢日期(年/月/日): "
				+"2022/04/27距離今天還有23天"+ System.getProperty("line.separator")
				+instrTable+ System.getProperty("line.separator")
				+"Good Bye ! Have a nice day :)"
				;
		testIn = new ByteArrayInputStream(data2.getBytes());
		testOut = new ByteArrayOutputStream();
		System.setIn(testIn);
		System.setOut(new PrintStream(testOut));
		CalendarSystem.main(null);
		assertEquals(data1, testOut.toString());
	}
	
	/** Test method: CalendarSys.CalculateDate()
	 *  Test input is data2
	 *  Target: the normal input
	 */
	@DisplayName("mainExample4")
	@Test
	void mainTestExample4() {
		data2 = "D\n26\nE";
		data1 = instrTable+ System.getProperty("line.separator")
				+"請輸入往後推算的天數: "
				+"2022/04/30"+ System.getProperty("line.separator")
				+instrTable+ System.getProperty("line.separator")
				+"Good Bye ! Have a nice day :)"
				;
		testIn = new ByteArrayInputStream(data2.getBytes());
		testOut = new ByteArrayOutputStream();
		System.setIn(testIn);
		System.setOut(new PrintStream(testOut));
		CalendarSystem.main(null);
		assertEquals(data1, testOut.toString());
	}
}

