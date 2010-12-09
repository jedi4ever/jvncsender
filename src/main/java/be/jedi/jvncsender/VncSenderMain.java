package be.jedi.jvncsender;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;


public class VncSenderMain {

	/**
	 * @param args
	 */

	Options options=new Options();
	Options cmdoptions=new Options();

	CommandLine cmdLine;
	
	public static void main(String[] args) {
		try {

			VncSenderMain sender=new VncSenderMain();
			sender.setupOptions();	
			sender.validateArgs(args);
		
			String[] vncText=sender.cmdLine.getOptionValues("text");
			String vncHost=sender.cmdLine.getOptionValue("host");
			String vncPassword=sender.cmdLine.getOptionValue("password");
			Integer vncPort=Integer.parseInt(sender.cmdLine.getOptionValue("port"));
			
			
			VncSender vncSender=new VncSender(vncHost,vncPort,vncPassword); 
			
			if (sender.cmdLine.hasOption("wait")) {
				vncSender.setVncWaitTime(Integer.parseInt(sender.cmdLine.getOptionValue("wait")));	
			}
			
			vncSender.sendText(vncText);						

		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}

	void setupOptions() {

		Option host=OptionBuilder.withArgName( "hostname" ).hasArg().withDescription(  "hostname or ip-address to send it to" ).create( "host" );
		host.setRequired(true);
		options.addOption(host);
		
		Option port=OptionBuilder.withArgName( "port" ).hasArg().withDescription(  "port to connect to f.i. 5900" ).create( "port" );
		port.setRequired(true);
		options.addOption(port);
		
		options.addOption(OptionBuilder.withArgName( "password" ).hasArg().withDescription(  "password to use" ).create( "password" ));
		options.addOption(OptionBuilder.withArgName( "seconds" ).hasArg().withDescription(  "seconds to wait in between sending different texts (default=1s)" ).create( "wait" ));

		Option text=OptionBuilder.withArgName( "text" ).hasArgs().withDescription(  "text to send, (can be use multiple times)" ).create( "text" );
		text.setRequired(true);
		options.addOption(text);
		
		Option help = new Option( "help", "print this message" );
		options.addOption(help);
		cmdoptions.addOption(help);
		
		Option list = new Option( "list", "list keymappings" );
		options.addOption(list);
		cmdoptions.addOption(list);
		}

	public void printHelp() {
		// automatically generate the help statement
		HelpFormatter formatter = new HelpFormatter();
		formatter.setWidth(150);
		formatter.setOptionComparator(null);
		
		formatter.printHelp( "java -jar jvnckeysender.jar [-list] [-help] -host <hostname> -port <port> -text <text> [-password <password>] [-wait <seconds>]","", options,
				"\ntext can also take special keys f.i. like \"linux ks=ks.cfg<RETURN>\"\n use -list options to see all keymappings	\n" );	
	}
	
	void validateArgs(String[] args) {
		
		//Check the commands
		try {
			CommandLineParser parser = new GnuParser();
			// parse the command line arguments
			cmdLine = parser.parse( cmdoptions, args );

			if (cmdLine.hasOption("help")) {
				this.printHelp();
				System.exit(0);
			}

			if (cmdLine.hasOption("list")) {
				VncMappings.printMaps();
				System.exit(0);
			}

		}
		catch( ParseException exp ) {
			//We ignore this error as it's probably complaining about arguments missing

		}

		// now check the arguments
		try {
			CommandLineParser parser = new GnuParser();
			// parse the command line arguments
			cmdLine = parser.parse( options, args );
		}
		catch( ParseException exp ) {

			// oops, something went wrong		
			this.printHelp();
			
			System.err.println( "Parsing failed.  Reason: " + exp.getMessage()+"\n" );

			System.exit(-1);
		}
		
	}
}
