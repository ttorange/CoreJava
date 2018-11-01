package map;
import java.util.*;


public class MapTest {
	public static void main(String[] args) {
		Map<String,Employee> staff=new HashMap<>();//构造hashmap
		staff.put("144-25-5464",new Employee("Amy Lee"));//添加键/值到映射
		staff.put("567-24-2546",new Employee("Harry Hacke"));
		staff.put("157-62-7935",new Employee("Nanny"));
		staff.put("456-62-5527",new Employee("Rose"));
		
		System.out.println(staff);
		
		staff.remove("567-24-2546");
		
		staff.put("456-62-5527", new Employee("Meust"));
		
		System.out.println(staff.get("157-62-7935"));
		
		//iterate through all entries
		for(Map.Entry<String,Employee>entry: staff.entrySet()) {
			
			String key=entry.getKey();
			Employee value=entry.getValue();
			System.out.println("key="+key+",value="+value);
		}
	}

}
