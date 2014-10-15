import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import java.awt.List;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class SendMailTLS {
	//Integer static srno = 0; 
	static int srno = 1;
	public static void main(String[] args) throws Exception {
		
//		for(int i = 0 ;i<5;i++)
//		{
//			writeHtmlLogfile("F:\\New folder", "Test1", "filename"+i, "ExpectedData"+i, "ActualData"+i);
//		}
		irctc();
	}
	
	public void sendEmail()
	{
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
 
		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("email","password");
				}
			});
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("neeraj.l@moolya.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("neeraj.l@moolya.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler," +
					"\n\n No spam to my email, please!");
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public static void CreateLogger(String logpath, String ScenName) throws Exception
	{
	  //  string logfilepath = getAbsoluteLogPath(LogPath, ScenName);
		 Date date = new Date();
		 SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String dt;
		 dt = ft.format(date);
	//	File writer;
		try
		{
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(logpath, true)));
		//	writer = new StreamWriter(File.Open(logpath, FileMode.Append, FileAccess.Write));
			//writer.println("<hr>");
			writer.println("<A Name=" + (char)34 + "Head" + (char)34 + "><h1> iMentor Platform <br>Scenario Name: " + ScenName + " ;<br>Run Date: " + dt.toString() + "</h1></A>");
			writer.println("<style type=text/css>");
			writer.println("body {");
			writer.println("  font:normal 68% verdana,arial,helvetica;");
			writer.println("  color:#000000;");
			writer.println("}");
			writer.println("table tr td, table tr th {");
			writer.println("font-size: 68%;");
			writer.println("}");
			writer.println("table.details tr th{");
			writer.println("  font-weight: bold;");
			writer.println("  text-align:left;");
			writer.println("  background:#a6caf0;");
			writer.println("  white-space: nowrap;");
			writer.println("}");
			writer.println("table.details tr td{");
			writer.println("  background:#eeeee0;");
			writer.println("  white-space: nowrap;");
			writer.println("}");
			writer.println("h1 {");
			writer.println(" margin: 0px 0px 5px; font: 165% verdana,arial,helvetica");
			writer.println("}");
			writer.println("h2 {");
			writer.println(" margin-top: 1em; margin-bottom: 0.5em; font: bold 125% verdana,arial,helvetica");
			writer.println("}");
			writer.println("h3 {");
			writer.println(" margin-bottom: 0.5em; font: bold 115% verdana,arial,helvetica");
			writer.println("}");
			writer.println(".Failure {");
			writer.println(" font-weight:bold; color:red;");
			writer.println("}");
			writer.println("</style>");
			writer.println("<table class=details cellspacing=2 border=0 width=100% cellpadding=5>");
			writer.println("<tr>");
			writer.println("<th width=" + (char)34 + "4%" + (char)34 + " align=" + (char)34 + "left" + (char)34 + ">Sl No</th>");
			writer.println("<th width=" + (char)34 + "10%" + (char)34 + " align=" + (char)34 + "left" + (char)34 + ">Date & Time</th>");
			writer.println("<th width=" + (char)34 + "10%" + (char)34 + " align=" + (char)34 + "left" + (char)34 + ">Field Name</th>");
			writer.println("<th width=" + (char)34 + "14%" + (char)34 + " align=" + (char)34 + "left" + (char)34 + ">Expected Data</th>");
			writer.println("<th width=" + (char)34 + "34%" + (char)34 + " align=" + (char)34 + "left" + (char)34 + ">Actual Data</th>");
			writer.println("<th width=" + (char)34 + "5%" + (char)34 + " align=" + (char)34 + "left" + (char)34 + ">Status</th>");
			//writer.println("<th width=" + Convert.ToChar(34) + "5%" + Convert.ToChar(34) + " align=" + Convert.ToChar(34) + "left" + Convert.ToChar(34) + ">Comment</th>");
			writer.println("</tr>");
			writer.close();
			
		}
		catch (RuntimeException e)
		{
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
		//}
	}

	public static String getAbsoluteLogPath(String LogPath, String ScenName)
	{
		 Date date = new Date();
		 SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		 String dt;
		 dt = ft.format(date);
		 
		try
		{
			String logfilepath;
			logfilepath = LogPath + "\\" + ScenName + "_" + dt.toString() + ".html";
			return logfilepath;
		}
		catch (RuntimeException e)

		{
			JOptionPane.showConfirmDialog(null, e.getMessage());
			return null;
		}
	}
	
	public static void writeHtmlLogfile(String LogPath, String ScenName, String fieldName, String ExpectedData, String ActualData) throws Exception
	{

		PrintWriter writer;
		//PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(logpath, true)));
		String status;
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dt;
		dt = ft.format(date);
		try
		{
			String logfilename = getAbsoluteLogPath(LogPath, ScenName);

			if (!(new java.io.File(logfilename)).isFile())
			{
				CreateLogger(logfilename, ScenName);
			}

			//writer = new StreamWriter(File.Open(logfilename, FileMode.Append, FileAccess.Write));
			writer = new PrintWriter(new BufferedWriter(new FileWriter(logfilename, true)));
			writer.println();

			writer.println("<td width=" + (char)34 + "4%" + (char)34 + " align=" + (char)34 + "left" + (char)34 + ">" + srno + "</td>");
			writer.println("<td width=" + (char)34 + "10%" + (char)34 + " align=" + (char)34 + "left" + (char)34 + ">" + dt.toString() + "</td>");
			writer.println("<td width=" + (char)34 + "14%" + (char)34 + " align=" + (char)34 + "left" + (char)34 + ">" + fieldName + "</td>");
			writer.println("<td width=" + (char)34 + "33%" + (char)34 + " align=" + (char)34 + "left" + (char)34 + ">" + ExpectedData + "</td>");
			writer.println("<td width=" + (char)34 + "33%" + (char)34 + " align=" + (char)34 + "left" + (char)34 + ">" + ActualData + "</td>");

			if (ExpectedData.toString().equals(ActualData.toString()))
			{
				status = "Passed";
				writer.println("<td width=" + (char)34 + "5%" + (char)34 + " align=" + (char)34 + "left" + (char)34 + "><b><font color=blue>" + status + "</td>");
			}
			else
			{
				status = "Failed";
				writer.println("<td width=" + (char)34 + "5%" + (char)34 + " align=" + (char)34 + "left" + (char)34 + "><b><font color=red>" + status + "</td>");
			}
			writer.println();
			writer.println("</tr>");
			writer.close();
			srno = srno + 1;
		}
		catch (RuntimeException e)
		{
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
	}


	public static void irctc()
	{
		WebDriver driver=new FirefoxDriver();
		  driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		  //Thread.sleep(4000);
		  driver.findElement(By.xpath("//a[text()='Tourist Train']")).click();
		  try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  Set<String> set =driver.getWindowHandles();
		  
		  Iterator<String> it=set.iterator();
		  String parentWindow=it.next();
		  String childWindow=it.next();
		  
		  driver.switchTo().window(childWindow);
		  driver.findElement(By.xpath(".//*[@id='mainpannel']/div/div/ul/li[4]/div/div/span/a[1]")).click();
		  
		  Set<String> set1 =driver.getWindowHandles();
		  
		  Iterator<String> it1=set1.iterator();
		  String parentWindow1=it1.next();
		  String childWindow1=it1.next();
		  String childWindow2=it1.next();
		  
		  driver.switchTo().window(childWindow2);
		 
		 WebElement wbText=driver.findElement(By.xpath("//div[@class='txt']"));
		 String actText=wbText.getText();
		 System.out.println(actText);

		 driver.findElement(By.xpath("//a[text()='Close']")).click();
		        //driver.close();
		       driver.switchTo().window(parentWindow1);
		        
		        driver.findElement(By.id("usernameId")).sendKeys("Neeraj");
		
	}
}