package foo;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


public class MyLogger
{
	private static Logger logger = Logger.getLogger(MyLogger.class);
	
	public void callMyLoggerInfo()
	{
		logger.info("This is my first Info-logmsg");
	}
	
	public void callMyLoggerError()
	{
		logger.error("This is my first Error-logmsg");
	}
	
	public void callMyLoggerDebug()
	{
		logger.debug("This is my first Debug-logmsg");
	}
	
	
	public static void main(String[] args)
	{
		BasicConfigurator.configure();
		MyLogger myLogger = new MyLogger();

		logger.info("before");
		myLogger.callMyLoggerInfo();
		myLogger.callMyLoggerError();
		myLogger.callMyLoggerDebug();
		logger.info("after");
	}

}
