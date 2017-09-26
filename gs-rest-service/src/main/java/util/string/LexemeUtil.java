package util.string;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

public class LexemeUtil {
 public static List<String> getSegment(String keyValue){
     List<String> strList=new ArrayList<String>();
     StringReader reader=new StringReader(keyValue);
	IKSegmenter ik=new IKSegmenter(reader,true);
	Lexeme lex=null;
	try {
	    while((lex=ik.next())!=null){
	        System.out.println(lex.getLexemeText()+"|");
	        strList.add(lex.getLexemeText());
	        
	    }
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	reader.close();
	return strList;
 }
}
