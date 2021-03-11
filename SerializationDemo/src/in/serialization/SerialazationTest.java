package in.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class TestDemo implements Serializable{
	private static final long serialVersionUID = 1L;
	int a= 10;
	 int b= 20;
	 transient String psw ="mahesh";
	 transient int pin=12345;
	 private void writeObject(ObjectOutputStream os) throws Exception {
		 os.defaultWriteObject();
		  String epsw="123"+psw;
		   int epin=555+pin;
		   os.writeObject(epsw);
		   os.writeInt(epin);
	 }
	 private void readObject(ObjectInputStream is) throws Exception{
		 is.defaultReadObject();
		  String epsw=(String)is.readObject();
		 psw= epsw.substring(3);
		  int epin=(int)is.readInt();
		  pin=epin-555;
	 }
}
public class SerialazationTest {

	public static void main(String[] args) throws Exception {
		TestDemo td =new TestDemo();
		System.out.println(td.a+" "+td.b+" "+td.psw+" "+td.pin);
		FileOutputStream fos =new FileOutputStream("abc.ser");
		ObjectOutputStream oos =new ObjectOutputStream(fos);
		oos.writeObject(td);
		FileInputStream fis =new FileInputStream("abc.ser");
		ObjectInputStream ois =new ObjectInputStream(fis);
		TestDemo td1=(TestDemo) ois.readObject();
		System.out.println(td1.a+" "+td1.b+" "+td1.psw+" "+td1.pin);	
	}
}

