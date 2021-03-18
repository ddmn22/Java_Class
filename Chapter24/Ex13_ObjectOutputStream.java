import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Ex13_ObjectOutputStream {

	public static void main(String[] args) {
		Ex12_Unit unit1 = new Ex12_Unit("Marine");
		Ex12_Unit unit2 = new Ex12_Unit("Medic");
		
		//Object.bin에 Ex12_Unit 오브젝트 저장
		try(ObjectOutputStream oos = 
				new ObjectOutputStream(new FileOutputStream("Object.bin")))  
		{
			oos.writeObject(unit1);
			oos.writeObject(unit2);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
