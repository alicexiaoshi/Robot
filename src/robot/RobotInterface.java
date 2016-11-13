package robot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class RobotInterface {
	private int totalMoney=0;
	/*getter for variable totalMoney*/
	public int getTotalMoney() {
		return totalMoney;
	}
	/** setter for variable totalMoney
	 *  @param totalMoney The parameter that passed in.
	 */
	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}
	/**  This method allows the program to return message
	 *   that randomly chose from the file that passed in.
	 *   @param filename The name of file that is used for reading.
	 *   @return  content The message that randomly chose from the file.
	 */
	public String displayMsg(String filename){
		int msgLine=6,line=0;
		File file = new File(filename);
		String temp="",content="";
		String[] msg = new String[msgLine];

		try{
	    	BufferedReader reader = new BufferedReader(new FileReader(file.getAbsolutePath()));		    	
		    while ((temp = reader.readLine()) != null) {	    	
		    	msg[line]=temp;	
		    	line++;
		    }		  		   
		    reader.close();
	    }catch(Exception ex){
	    	ex.printStackTrace();
	    }
		int random = (int)(Math.random()*msgLine);
		content=msg[random];
		return content;
	}
	/**  This method allows the program to return specific content
	 *   that read from the file that passed in.
	 *   If the file is about type of food, it will read number,dish name and 
	 *   money of the dish, and if the file is Order.txt, it
	 *   will read the whole line into array.
	 *   @param filename The name of file that is used for reading.
	 *   @return msg The name of dish or the name of type of food.
	 */	
	public String[] displayMenu(String filename){
		int line=0;
		File file = new File(filename);
		String temp="";
		String[] msg = new String[10];

		try{
	    	BufferedReader reader = new BufferedReader(new FileReader(file.getAbsolutePath()));	
	    	if(!filename.equals("Order.txt")){
	    		while ((temp = reader.readLine()) != null) {
			    	String[] split = temp.split("-");
			    	msg[line]=split[0]+" "+split[1]+" RMB:"+split[2];	
			    	line++;
			    }
	    	}
	    	else{
	    		while ((temp = reader.readLine()) != null) {
			    	msg[line]=temp;	
			    	line++;
			    }
	    	}
		    		  		   
		    reader.close();
	    }catch(Exception ex){
	    	ex.printStackTrace();
	    }
		
		return msg;
	}
	/**  This method allows the program to confirm whether the dish
	 *   that user ordered is available. If it is available, it will
	 *   return true, else return false.
	 *   @param filename The name of file that is used for reading.
	 *   @param dishNum  The number of dish that user ordered.
	 *   @return flag This means whether the order can be ordered.
	 */
	public boolean confirmOrder(String filename,String dishNum){
		boolean flag=false;
		File file = new File(filename);
		String temp="";
				
		try{
	    	BufferedReader reader = new BufferedReader(new FileReader(file.getAbsolutePath()));	
	    	
	    	while ((temp = reader.readLine()) != null) {
			    String[] split = temp.split("-");
			    if(split[0].equals(dishNum)){
			    	int remainNum = Integer.parseInt(split[3])-1;
			    	if(remainNum>=0){
			    		flag=true;			    					    		
			    		break;
			    	}
			    }
			}
	    	 reader.close();
		    
	    }catch(Exception ex){
	    	ex.printStackTrace();
	    }
		return flag;
	}
	/**  This method allows the program to decrease 
	 *   the number of dish that stored in the list.
	 *   @param filename The name of file that is used for reading.
	 *   @param dishNum The number of dish that user ordered.
	 */
	public void decreaseOrder(String filename,String dishNum){
		File file = new File(filename);
		String temp="",lineinfo="default";
				
		try{
			BufferedReader reader = new BufferedReader(new FileReader(file.getAbsolutePath()));		    	
	    	while ((temp = reader.readLine()) != null) {
			    String[] split = temp.split("-");
			    if(split[0].equals(dishNum)){
			    	int remainNum = Integer.parseInt(split[3])-1;
			    	lineinfo=split[0]+"-"+split[1]+"-"+split[2]+"-"+remainNum;
			    	totalMoney=getTotalMoney()+Integer.parseInt(split[2]);
			    	this.setTotalMoney(totalMoney);		    			    		
			    	System.out.println("total: "+totalMoney);			    					    		
			    	break;		    	
			    }
			}
	    	 reader.close();
			
			BufferedReader reader1 = new BufferedReader(new FileReader(file.getAbsolutePath()));	
    		StringBuffer bf = new StringBuffer();
    		while ((temp = reader1.readLine()) != null) {
			   temp=temp.trim(); 
			   String[] split = temp.split("-");	  			   
			   if(!split[0].equals(dishNum)){          	
 					bf.append(temp).append("\r\n");	
 				}
			}
    		reader1.close();
    		FileWriter fileWriter = new FileWriter(filename);
		    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);	        		  
		    bufferedWriter.write(bf.toString());
		    bufferedWriter.append(lineinfo);
		    bufferedWriter.close();
		    fileWriter.close();
   
	    }catch(Exception ex){
	    	ex.printStackTrace();
	    }
	}
}
