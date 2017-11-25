import java.util.Arrays;
import java.util.LinkedList;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FsShell;
import org.apache.hadoop.fs.shell.Command;
import org.apache.hadoop.fs.shell.CommandFactory;
import org.apache.hadoop.fs.shell.FsCommand;

public class CommandFactoryTest extends FsShell{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String [] s ={"a","b","c","d"};
		
		LinkedList<String> slink = new LinkedList<String>(Arrays.asList(s));
		
		//LinkedList<String>  slink = 
		String pathString = slink.removeLast();
		
		System.out.println(pathString);
		
		for(String p : slink){
			System.out.println(p);
		}
		
		
		int kg = new Configuration().getInt("io.file.buffer.size", 4096);
		
		System.out.println(kg);
		
		FsShell  fs =  new FsShell();
		
		//fs.init
		
		
		CommandFactory commandFactory = new CommandFactory(new Configuration());
		
		commandFactory.registerCommands(FsCommand.class);//打印所有的注册命令
		
		String [] temp = commandFactory.getNames(); 
		
		//Command ob = commandFactory.getInstance("-putx", new Configuration());
		
		
		
		for(String i : temp){
			System.out.println(i);
		}
		System.out.println("-kg");
		
		String argv[] = {"-put","hhh","kkk"};
		test(Arrays.copyOfRange(argv, 1, argv.length));
		
	}

	public static void test(String ...argv ){
		
		LinkedList<String> args = new LinkedList<String>(Arrays.asList(argv));
		
		for(String s : args){
			System.out.println(s);
		}
	}
}
