public class Test {
	public static void main(String[] args){
		Table table = new Table(null, "nRPG_accounts");
		
		SelectQuery selectQuery = table.select("*").where("name=gabe").where("money=100").where("gabe=yolo");
		
		System.out.println(selectQuery);
		
		UpdateQuery updateQuery = table.update().set("name=yolo").set("money=1230").set("gabe=nolo");
		
		System.out.println(updateQuery);
		
		InsertQuery insertQuery = table.insert().insert("name").insert("money").value("yolo").value("212");
		
		System.out.println(insertQuery);
	}
}
