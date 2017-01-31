import java.io.*;
import java.net.*;
import java.util.*;

public class trans implements Serializable{
	String Doc;
	String Tim;
	String APM;
	
	public trans(String a, String b, String c)
	{
		Doc = a;
		Tim = b;
		APM = c;
	}
}