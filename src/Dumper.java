

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Vector;



public class Dumper {
	
	public static final String dump(Object o) {
		
		StringBuffer buffer = new StringBuffer();
		Class klass = o.getClass();
		
		if( klass.getCanonicalName().equals("java.lang.Object")) return "";
		
		if (klass.isArray()) {
			
			buffer.append("[");
			
			buffer.append(getArrayValues(o));
			
			buffer.append("]");
			
		} else {
			
			while (klass != null) {

				buffer.append( "\nClass " + klass.getCanonicalName() );
				buffer.append("\n{\n" );
				Field[] fields = klass.getDeclaredFields();
				
				for (int i = 0; i < fields.length; i++) {
					
					buffer.append('\t');
					
					//if (buffer.length() > 1)
					//	buffer.append(",\n");
					
					//Make the field accessable to get the values.
					fields[i].setAccessible(true);
					
					buffer.append(fields[i].getName());
					buffer.append("=");
					buffer.append(getValueFromField(fields[i],o));
					buffer.append("\n");
				}
				
				buffer.append("}" );
				
				klass = klass.getSuperclass();
			}
			
			
		}
		return buffer.toString();
	}
	
	private static String getArrayValues(Object array)
	{
		StringBuffer buffer = new StringBuffer();
		
		for (int i = 0; i < Array.getLength(array); i++) {
			
			if (i > 0)
				buffer.append(",");
			
			Object value = Array.get(array, i);
			
			buffer.append(value.getClass().isArray() ? dump(value) : value);
		}
		return buffer.toString();
	}
	
	private static Object getValueFromField(Field f,Object name)
	{
		try {

			Object value = f.get(name);
			if (value != null) 
			{
				
				//return dump(value);
				return (value.getClass().isArray() || !isJavaType(value) ? dump(value)	: value);
			}
			else
			{
				return "null";
			}
			
		} catch (IllegalAccessException e) {
			return "null";
		}
	}
	
	private static boolean isJavaType(Object o)
	{
		return o.getClass().getPackage().getName().startsWith("java.");
	}
	
	public static void main(String[] args)
	{
		try
		{
			System.err.println("Inside");
			int x = 1 / 0;
			
		}
		catch(Exception e)
		{
			System.err.println("Catching");
			System.exit(0);
		}
		finally
		{
				System.err.println("Finally");
		}
		//System.err.println(Dumper.dump(new TestObject()  ));
	}
}
