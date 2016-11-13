package robot;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.Timer;
import java.util.TimerTask;

/**
*Title  : RobotGUI.java
*This is my MiniProject.
*@author   xxx
*@version  1.0
*/
public class RobotGUI extends RobotInterface {
	//Declaration of instance variables
	JPanel pn,pc,ps;
	JLabel displayLabel,optionLabel;
	JButton order1,order2,order3,order4,order5,order6;
	JTextField option;
	JFrame robotguiFrame;
	Timer timer = new Timer();//timer is used to start timing
	/** This is the RobotGUI constructor. It constructs the 
	 *  basic frame of the GUI
	 */
	public RobotGUI(){
		robotguiFrame = new JFrame("Robot");
		welcomePane();
		robotguiFrame.setSize(800,400);
		robotguiFrame.setLocationRelativeTo(null);
		robotguiFrame.setResizable(false);//the frame cannot be resized
		robotguiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		robotguiFrame.setVisible(true);
		
		robotguiFrame.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			/**  This method is the event-handling method.
			 *   @param e The MouseEvent of mouse
			 */
			public void mouseEntered(MouseEvent e) {				
				timer.cancel();//cancel the timing

			}
			
			/**  This method is the event-handling method.
			 *   @param e The MouseEvent of mouse
			 */
			public void mouseExited(MouseEvent e) {				 
				 timer = new Timer();			        
			     timer.schedule(new TimerTask() {
			         @Override
			         public void run() {
			        	 System.out.println("Inactive!!");
			             JOptionPane.showMessageDialog(null, "Inactive", "STOP",JOptionPane.PLAIN_MESSAGE);			             
			         }
			      }, 5000);//30000 represents 30 seconds
			     
			}
		});
	}
	 /** This method allows the program to create the welcome panel.
	 *   This method creates the panel for welcoming, it will randomly display 
	 *   a welcome message from the WelcomeMessages.txt file.
	 */
	public void welcomePane(){
		JPanel welcomePane,buttonPane;
		JLabel welcomeLabel;
		JButton next;
		 /*welcomPane, buttonPane seperately means panel that add to the center and south of the frame*/		
		welcomePane = new JPanel();
		buttonPane = new JPanel();
		welcomeLabel = new JLabel("");
		welcomePane.setBackground(new Color(100,149,237));//color blue
		buttonPane.setBackground(new Color(100,149,237));
		welcomeLabel.setFont(new Font("Comic Sans MS",Font.BOLD,66));//set the style and font of words
		welcomeLabel.setText(displayMsg("WelcomeMessages.txt"));//set the return String to the JLabel
		next = new JButton("Next");//create button called next
		
		welcomePane.add(welcomeLabel);//add JLabel
		buttonPane.add(next);//add button to the panel
		robotguiFrame.add(welcomePane,BorderLayout.CENTER);//the default layout management is BorderLayout.
		robotguiFrame.add(buttonPane,BorderLayout.SOUTH);
		
		
		next.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						welcomePane.setVisible(false);
						buttonPane.setVisible(false);
						orderPane();									
					}
				}
		);
	}
	/** This method allows the program to create the goodbye panel.
	 *   This method creates the panel for saying goodbye, it will randomly display 
	 *   a goodbye message from the GoodbyeMessage.txt file.
	 */
	public void goodbyePane(){
		JPanel pc,ps;
		JLabel goodbyeLabel;
		JButton next;
				
		pc = new JPanel();
		ps = new JPanel();
		goodbyeLabel = new JLabel("");
		pc.setBackground(new Color(100,149,237));//blue
		ps.setBackground(new Color(100,149,237));
		goodbyeLabel.setFont(new Font("Comic Sans MS",Font.BOLD,66));
		goodbyeLabel.setText(displayMsg("GoodbyeMessage.txt"));//set the return value into label
		next = new JButton("Next");
		
		pc.add(goodbyeLabel);
		ps.add(next);
		robotguiFrame.add(pc,BorderLayout.CENTER);
		robotguiFrame.add(ps,BorderLayout.SOUTH);
		
		
		next.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						pc.setVisible(false);
						ps.setVisible(false);
						welcomePane();									
					}
				}
		);
	}
	/**  This method allows the program to create the grid panel.
	 *   This method creates the panel for creating gridlayout panel,
	 *   it sets the color and font for each grid.
	 *   @param filename The filename for display words on each grid.
	 */
	public void gridPane(String filename){
				
		displayLabel = new JLabel("Please select an option: ");
		displayLabel.setFont(new Font("Comic Sans MS",Font.BOLD,36));
		pn = new JPanel();
		pc = new JPanel(new GridLayout(2,3,5,10));
		ps = new JPanel();
		pn.add(displayLabel);
		pn.setBackground(new Color(100,149,237));
		order1 = new JButton();
		order2 = new JButton();
		order3 = new JButton();
		order4 = new JButton();
		order5 = new JButton();
		order6 = new JButton();
		String[] order = displayMenu(filename);//store the return results into String array
		order1.setText(order[0]);
		order2.setText(order[1]);
		order3.setText(order[2]);
		order4.setText(order[3]);
		order5.setText(order[4]);
		order6.setText(order[5]);
		
		order1.setBackground(new Color(135,206,250));
		order2.setBackground(new Color(255,215,0));
		order3.setBackground(new Color(127,255,212));
		order4.setBackground(new Color(255,192,203));
		order5.setBackground(new Color(186,58,211));
		order6.setBackground(new Color(0,255,127));

		order1.setFont(new Font("Comic Sans MS",Font.BOLD,15));
		order2.setFont(new Font("Comic Sans MS",Font.BOLD,15));
		order3.setFont(new Font("Comic Sans MS",Font.BOLD,15));
		order4.setFont(new Font("Comic Sans MS",Font.BOLD,15));
		order5.setFont(new Font("Comic Sans MS",Font.BOLD,15));
		order6.setFont(new Font("Comic Sans MS",Font.BOLD,15));
		pc.add(order1);
		pc.add(order2);
		pc.add(order3);
		pc.add(order4);
		pc.add(order5);
		pc.add(order6);
		pc.setBackground(new Color(100,149,237));
		optionLabel = new JLabel("Option Selected: ");
		optionLabel.setFont(new Font("Comic Sans MS",Font.BOLD,26));
		option = new JTextField(6);
		option.setText("");
		option.setBackground(new Color(100,149,237));
		ps.add(optionLabel);
		ps.add(option);
		ps.setBackground(new Color(100,149,237));		
		robotguiFrame.add(pn,BorderLayout.NORTH);
		robotguiFrame.add(pc,BorderLayout.CENTER);
		robotguiFrame.add(ps,BorderLayout.SOUTH);
		pn.setVisible(true);
		pc.setVisible(true);
		ps.setVisible(true);
	}
	/**  This method allows the program to create the order panel.
	 *   This method creates the panel for ordering the type of food,
	 *   and after choosing, it will turn into the spcecific panel.
	 *   If the chose is uncorrect, it will give a hint.
	 */
	public void orderPane(){
		JButton ok = new JButton("OK");		
		gridPane("Order.txt");	
		ps.add(ok);
		
		ok.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						
						pn.setVisible(false);
						pc.setVisible(false);
						ps.setVisible(false);
						String op = option.getText();
						switch(op){
						case "1":
							fishPane();
							break;
						case "2":
							meatPane();
							break;
						case "3":
							ricePane();
							break;
						case "4":
							noodlePane();
							break;
						case "5":
							drinkPane();
							break;		
						default:
							orderPane();
							displayLabel.setText("The choice is not available. Select again: ");							
							break;
						}
					}
				}
		);
		
		
	}
	/**  This method allows the program to create the fish panel.
	 *   This method creates the panel for ordering dish in fish type,
	 *   and after choosing, it will prompt a confirm panel.
	 */
	public void fishPane(){
		pn.setVisible(false);
		pc.setVisible(false);
		ps.setVisible(false);
		JButton ok = new JButton("OK");	
		
		gridPane("FishDishes.txt");
		ps.add(ok);
		ok.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						boolean flag = false;
						
						String op = option.getText();
						switch(op){						
						case "1":
							flag=confirmOrder("FishDishes.txt","1");
							if(flag){
								confirmPane("FishDishes.txt","1","q¨©ng zh¨¥ng l¨²y¨²");
							}
							break;
						case "2":
							flag=confirmOrder("FishDishes.txt","2");
							if(flag)
								confirmPane("FishDishes.txt","2","m¨¦n y¨²");
							break;
						case "3":
							flag=confirmOrder("FishDishes.txt","3");
							if(flag)
								confirmPane("FishDishes.txt","3","s¨¬ chu¨¡n m¨¢n");
							break;									
						default:
							flag=false;							
							break;
						}
						
						if(!flag){							
							fishPane();
							displayLabel.setText("The choice is not available. Select again: ");							
						}
					}
				}
		);
		
	}
	/**  This method allows the program to create the meat panel.
	 *   This method creates the panel for ordering dish in meat type,
	 *   and after choosing, it will prompt a confirm panel.
	 */	
	public void meatPane(){
		pn.setVisible(false);
		pc.setVisible(false);
		ps.setVisible(false);
		JButton ok = new JButton("OK");	
		
		gridPane("MeatDishes.txt");
		ps.add(ok);
		ok.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						boolean flag;
						
						String op = option.getText();
						switch(op){
						case "1":
							flag=confirmOrder("MeatDishes.txt","1");
							if(flag)
								confirmPane("MeatDishes.txt","1","g¨­ng b¨£o j¨© ding");
							break;
						case "2":
							flag=confirmOrder("MeatDishes.txt","2");
							if(flag)
								confirmPane("MeatDishes.txt","2","b¨­ lu¨® g¨± l¨£o r¨°u");
							break;
						case "3":
							flag=confirmOrder("MeatDishes.txt","3");
							if(flag)
								confirmPane("MeatDishes.txt","3","su¨¤n t¨¢i r¨°u s¨©");
							break;									
						default:
							flag=false;							
							break;
						}
						if(!flag){							
							meatPane();
							displayLabel.setText("The choice is not available. Select again: ");							
						}						
					}
				}
		);
	}
	/**  This method allows the program to create the rice panel.
	 *   This method creates the panel for ordering dish in rice type,
	 *   and after choosing, it will prompt a confirm panel.
	 */
	public void ricePane(){
		pn.setVisible(false);
		pc.setVisible(false);
		ps.setVisible(false);
		JButton ok = new JButton("OK");
		gridPane("RiceDishes.txt");
		ps.add(ok);
		
		ok.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						boolean flag;
						
						String op = option.getText();
						switch(op){
						case "1":
							flag=confirmOrder("RiceDishes.txt","1");
							if(flag)
								confirmPane("RiceDishes.txt","1","h¨®ng ch¨¢ng ch¨£o f¨¤n");
							break;
						case "2":
							flag=confirmOrder("RiceDishes.txt","2");
							if(flag)
								confirmPane("RiceDishes.txt","2","hu¨¢ng j¨©n d¨¤ p¨¢i f¨¤n");
							break;
						case "3":
							flag=confirmOrder("RiceDishes.txt","3");
							if(flag)
								confirmPane("RiceDishes.txt","3","hu¨¯ tu¨« ch¨£o f¨¤n");
							break;									
						default:
							flag=false;							
							break;
						}
						if(!flag){							
							ricePane();
							displayLabel.setText("The choice is not available. Select again: ");							
						}						
					}
				}
		);
		
	}
	/**  This method allows the program to create the noodle panel.
	 *   This method creates the panel for ordering dish in noodle type,
	 *   and after choosing, it will prompt a confirm panel.
	 */
	public void noodlePane(){
		pn.setVisible(false);
		pc.setVisible(false);
		ps.setVisible(false);
		JButton ok = new JButton("OK");	
		
		gridPane("NoodleDishes.txt");
		ps.add(ok);	
		ok.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						boolean flag;
						
						String op = option.getText();
						switch(op){
						case "1":
							flag=confirmOrder("NoodleDishes.txt","1");
							if(flag)
								confirmPane("NoodleDishes.txt","1","mi¨¤n ti¨¢o");
							break;
						case "2":
							flag=confirmOrder("NoodleDishes.txt","2");
							if(flag)
								confirmPane("NoodleDishes.txt","2","ch¨£o mi¨¤n");
							break;
						case "3":
							flag=confirmOrder("NoodleDishes.txt","3");
							if(flag)
								confirmPane("NoodleDishes.txt","3","t¨¡ng mi¨¤n");
							break;									
						default:
							flag=false;							
							break;
						}
						if(!flag){							
							noodlePane();
							displayLabel.setText("The choice is not available. Select again: ");							
						}						
					}
				}
		);
	}
	/**  This method allows the program to create the drink panel.
	 *   This method creates the panel for ordering dish in drink type,
	 *   and after choosing, it will prompt a confirm panel.
	 */
	public void drinkPane(){
		pn.setVisible(false);
		pc.setVisible(false);
		ps.setVisible(false);
		JButton ok = new JButton("OK");	
		
		gridPane("DrinkDishes.txt");
		ps.add(ok);
		ok.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						boolean flag;
						
						String op = option.getText();
						switch(op){
						case "1":
							flag=confirmOrder("DrinkDishes.txt","1");
							if(flag)
								confirmPane("DrinkDishes.txt","1","l¨¸ ch¨¢");
							break;
						case "2":
							flag=confirmOrder("DrinkDishes.txt","2");
							if(flag)
								confirmPane("DrinkDishes.txt","2","h¨®ng ch¨¢");
							break;
						case "3":
							flag=confirmOrder("DrinkDishes.txt","3");
							if(flag)
								confirmPane("DrinkDishes.txt","3","m¨° l¨¬ ch¨¢");
							break;									
						default:
							flag=false;							
							break;
						}
						if(!flag){							
							drinkPane();
							displayLabel.setText("The choice is not available. Select again: ");							
						}						
					}
				}
		);
		
	}
	/**  This method creates the panel for display the dish you ordered,
	 *   and creates buttons for another order, jokes speaking, 
	 *   stopping telling jokes and leaving.
	 *   @param dish This is used to show the dish that brings.
	 */
	public void bringDishPane(String dish){
		pn.setVisible(false);
		pc.setVisible(false);
		ps.setVisible(false);
		
		JLabel dishLabel;
		JButton orderAnother,tellJoke,stoptell,leave;
		
		pn = new JPanel();
		ps = new JPanel();
		pn.setBackground(new Color(100,149,237));
		ps.setBackground(new Color(100,149,237));
		dishLabel = new JLabel("Here's your dish: "+dish);
		dishLabel.setFont(new Font("Comic Sans MS",Font.BOLD,26));
		orderAnother = new JButton("Order Another");
		tellJoke = new JButton("Tell Jokes");
		stoptell = new JButton("Stop tell");
		leave = new JButton("Leave");
		
		pn.add(orderAnother);
		pn.add(tellJoke);
		pn.add(stoptell);
		pn.add(leave);
		ps.add(dishLabel);
		robotguiFrame.add(pn,BorderLayout.NORTH);
		robotguiFrame.add(ps,BorderLayout.CENTER);
		
		orderAnother.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						pn.setVisible(false);
						pc.setVisible(false);
						ps.setVisible(false);
						orderPane();									
					}
				}
		);
		tellJoke.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						dishLabel.setText(displayMsg("Jokes.txt"));
						dishLabel.setFont(new Font("Comic Sans MS",Font.BOLD,16));
					}
				}
		);
		stoptell.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						dishLabel.setText("");					
					}
				}
		);
		leave.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						dishLabel.setText("Total price: "+getTotalMoney()+" RMB");	
						JOptionPane.showMessageDialog(null, "You need to pay "+getTotalMoney()+" RMB", "Hi",JOptionPane.PLAIN_MESSAGE);
						pn.setVisible(false);
						pc.setVisible(false);
						ps.setVisible(false);
						setTotalMoney(0);
						goodbyePane();
					}
				}
		);
	}
	/**  This method allows the program to create a new JFrame.
	 *   This method creates a new frame to confirm the order.
	 *   @param filename The file name that used to search.
	 *   @param option The option that user chosen.
	 *   @param dish The dish user selected.
	 */
	public void confirmPane(String filename,String option,String dish){
		
		Frame confirmFrame = new Frame("Confirm??");
		JButton ok = new JButton("Order");
		JButton cancel = new JButton("Cancel");
		JPanel confirmPanel = new JPanel();
		
		confirmPanel.add(ok);
		confirmPanel.add(cancel);
		confirmPanel.setBackground(new Color(100,149,237));
		confirmFrame.add(confirmPanel);
		confirmFrame.setSize(200,100);
		confirmFrame.setLocationRelativeTo(null);
		confirmFrame.setResizable(false);
		confirmFrame.setVisible(true);
		
		ok.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						//setFlag(true);
						pn.setVisible(false);
						pc.setVisible(false);
						ps.setVisible(false);
						confirmFrame.dispose();
						decreaseOrder(filename,option);
						bringDishPane(dish);
					}
				}
		);
		cancel.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						//setFlag(false);
						pn.setVisible(false);
						pc.setVisible(false);
						ps.setVisible(false);
						confirmFrame.dispose();
						//System.out.println("not decrease");
						switch(filename){
						case "FishDishes.txt":fishPane();break;
						case "MeatDishes.txt":meatPane();break;
						case "NoodleDishes.txt":noodlePane();break;
						case "RiceDishes.txt":ricePane();break;
						case "DrinkDishes.txt":drinkPane();break;
						default: orderPane();break;
						}
						
					}
				}
		);
		
		
	}
	public static void main(String[] args){
		RobotGUI robot = new RobotGUI();
		
	}
}
