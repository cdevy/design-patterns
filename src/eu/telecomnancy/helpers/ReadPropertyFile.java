package eu.telecomnancy.helpers;

import java.io.IOException;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: charoy
 * Date: 14/11/13
 * Time: 21:47
 */
public class ReadPropertyFile {
	
    public Properties readFile(String filename) throws IOException {
        Properties p= new Properties();
        p.load(getClass().getResourceAsStream(filename));
        return p;
    }

    public static void main(String[] args) throws IOException {
        ReadPropertyFile rp=new ReadPropertyFile();
        Properties p=rp.readFile("/eu/telecomnancy/commands/command.properties");
        for (String i: p.stringPropertyNames()) {
            System.out.println(p.getProperty(i));
        }


    }
}
