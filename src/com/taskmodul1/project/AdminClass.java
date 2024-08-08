package com.taskmodul1.project;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class AdminClass {
	public static boolean checknamevalid(String name)
    { 
        String regexName = "[a-zA-Z]+[\\s]*[a-zA-Z]{0,50}";
        boolean a=name.matches(regexName);
        return a;
    }
	public static  boolean validemailcheck(String emai)
	{
	    String regx="[a-zA-Z0-9._%+-]+@[a-zA-z0-9.-]+\\.[a-zA-Z]{2,3}";  
	    boolean a=emai.matches(regx);
	    return a;
	}
public  static  boolean validMobileNumber(String number){
    String regx1="[6-9][0-9]{9}";
      boolean b=number.matches(regx1);
   return b;
}
    
	public static void main(String[] args) {
        ArrayList<UserProcess> l = new ArrayList<UserProcess>();
        Scanner s = new Scanner(System.in);//For Integer value
        Scanner s1 = new Scanner(System.in);//For String

        while (true) {
            System.out.println("Tab Number 1 For Create User");
            System.out.println("Tab Number 2 For Fetch All User");
            System.out.println("Tab Number 3 For Fetch any One By name User");
            System.out.println("Tab Number 4 For Delete any User");
            System.out.println("Tab Number 5 For Update User");
            System.out.println("Tab Number 6 For Delete All User");
            System.out.println("Number 7 For Exit");
            System.out.println("Tab Any Number for Operation Performing ");
            
            String ope = s.next();
             
            switch (ope) {
                case "1":
                	System.out.println("-------------------------------------------------------------");
                    System.out.println("Enter User Name : ");
                    String name = s1.nextLine();
                    if(AdminClass.checknamevalid(name))
                    {
                     System.out.print("");
                    }
                    else if(!AdminClass.checknamevalid(name)){
                        System.out.println("Invalid Name");
                      break;
                    }
                    System.out.println("Enter User Email : ");
                    String email = s1.nextLine();
                    if(!AdminClass.validemailcheck(email))
                    {
                        System.out.println("Invalid Email again Try:");
                        break;
                    }
                    System.out.println("Enetr Number of Phone Number User Have : ");
                    int num=s.nextInt();
                    String phonenum="";
                    int flag=0;
                    for(int i=0;i<num;i++) {
                        System.out.println("Enter User Phone Number : ");
                        String phone = s1.nextLine();
                        if(AdminClass.validMobileNumber(phone)) {
                            phonenum += phone + " ";
                            flag=0;
                        }
                        else{
                            System.out.println("Invalid Phone Number Try Again ");
                            flag=1;
                            break;
                        }
                    }
                    boolean found=false;
                    if(flag==0) {
                        for (UserProcess u : l) {
                            if (u.getEmail().equals(email)) {
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            l.add(new UserProcess(name, email, phonenum));
                            System.out.println("User Added Successfully");
                        } else {
                            System.out.println("User is Alerady Exist with this Email create new Email");
                        }
                    }
                    System.out.println("-------------------------------------------------------------");
                    break;
                case "2":
                	System.out.println("-------------------------------------------------------------");
                    for (UserProcess u : l) {
                        System.out.println(u.getName()+" : "+u.getEmail() + " : "+u.getPhone());
                    }
                    System.out.println("-------------------------------------------------------------");
                    break;

                case "3":
                	System.out.println("-------------------------------------------------------------");
                    System.out.println("Enter name For Search : ");
                    String name1 = s1.nextLine();
                    boolean found1 = false;
                    for (UserProcess u : l) {
                        if (u.getName().equalsIgnoreCase(name1)) {
                            System.out.println(u.getName() + " : "+u.getEmail() +" : "+u.getPhone());
                            found1 = true;
                        }
                    }
                    try {
                    if (!found1) {
                        throw new RuntimeException("UserNotFound Exception");
                    }
                    }
                    finally { 
                    System.out.println("-------------------------------------------------------------");
                    break;
                    }

                case "4":
                	System.out.println("-------------------------------------------------------------");
                    System.out.println("Enter name you want to delete : ");
                    String name2 = s1.nextLine();
                    boolean found2 = false;
                    ListIterator<UserProcess> lii=l.listIterator();
                    while(lii.hasNext())
                    {
                    	UserProcess u=lii.next();
                    	if(u.getName().equalsIgnoreCase(name2))
                        {
                   		 lii.remove();
                   		  System.out.println("User Deleted Successfully");
                   		 found2=true;
                        }
                    }
                    if (!found2) {
                        System.out.println("No User Found");
                    }
                    System.out.println("-------------------------------------------------------------");
                    break; 

                case "5":
                	System.out.println("-------------------------------------------------------------");
                    System.out.println("Enter name you want to Update All Details : ");
                    String name3 = s1.nextLine();
                    ListIterator<UserProcess> li = l.listIterator();
                    boolean found3 = false;
                    while (li.hasNext()) {
                            UserProcess u = li.next();
                            if (u.getName().equalsIgnoreCase(name3)) {
                            	System.out.println("-------------------------------------------------------------");
                                System.out.println("Enter what you want ti update : ");
                                System.out.println("press 1 to Update name : ");
                                System.out.println("press 2 to update email ");
                                System.out.println("press 3 to update phone number : ");
                                System.out.println("press 4 to update all :");
                                int m = s.nextInt();
                                switch (m) {
                                    case 1:
                                    	System.out.println("-------------------------------------------------------------");
                                        System.out.println("Enter new name ");
                                      String  nam = s1.nextLine();
                                      if(AdminClass.checknamevalid(nam))
                                      {
                                         u.setName(nam);
                                        found3 = true;
                                      } 
                                      System.out.println("-------------------------------------------------------------");
                                        break;
                                    case 2:
                                    	System.out.println("-------------------------------------------------------------");
                                        System.out.println("Enter new email ");
                                        String ema = s1.nextLine();

                                        if (AdminClass.validemailcheck(ema)) {
                                            u.setEmail(ema);
                                            found3 = true;
                                        }
                                        else{
                                            System.out.println("Invalid Email");
                                        }
                                        System.out.println("-------------------------------------------------------------");
                                        break;
                                    case 3:
                                    	System.out.println("-------------------------------------------------------------");
                                        System.out.println("your currentPhone number is : " + u.getPhone());
                                        String demo=u.getPhone();
                                        System.out.println("You have That Number in your List: "+demo);
                                        String st[]=demo.split(" ");
                                        String addphone="";
                                        ArrayList<String> ali=new ArrayList<>();
                                        for(int i=0;i<st.length;i++)
                                        {
                                            ali.add(st[i]);
                                        }
          
                                        System.out.println("Enetr a how many number you want to update: ");
                                        
                                        int ns=s.nextInt();
                                        for(int k=0;k<ns;k++) {
                                        System.out.println("Eneter a number you want to update : ");
                                        String ph = s1.nextLine();
                                        if (AdminClass.validMobileNumber(ph)) { 
                                        for(int i=0;i<ali.size();i++)
                                        {
                                            if(ali.get(i).equals(ph))
                                            {
                                                System.out.println("Eneter a New Phone Number : ");
                                                String newnumb=s1.nextLine();
                                                ali.set(i,newnumb);
                                            }
                                           
                                        }
                                        }
                                        else {
                                            System.out.println("Invalid Phone Number");
                                        }
                                        }
                                        System.out.println(ali);
                                        for(int i=0;i<ali.size();i++)
                                        {
                                            addphone+=ali.get(i)+" ";
                                        }
                                            u.setPhone(addphone);
                                            found3 = true;
                                            System.out.println("-------------------------------------------------------------");
                                        break;
                                    case 4:
                                    	System.out.println("-------------------------------------------------------------");
                                        System.out.println("Enter new name ");
                                        String nm = s1.nextLine();
                                        System.out.println("Enter new email ");
                                        String ema1 = s1.nextLine();
                                        if (AdminClass.validemailcheck(ema1)) {
                                        	 String demo1=u.getPhone();
                                             System.out.println("You have That Number in your List: "+demo1);
                                             String st1[]=demo1.split(" ");
                                             String addphone1="";
                                             ArrayList<String> ali1=new ArrayList<>();
                                             for(int i=0;i<st1.length;i++)
                                             {
                                                 ali1.add(st1[i]);
                                             }
               
                                             System.out.println("Enetr a how many number you want to update: ");
                                             
                                             int np=s.nextInt();
                                             for(int k=0;k<np;k++) {
                                             System.out.println("Eneter a number you want to update : ");
                                             String ph11 = s1.nextLine();
                                             if (AdminClass.validMobileNumber(ph11)) { 
                                             for(int i=0;i<ali1.size();i++)
                                             {
                                                 if(ali1.get(i).equals(ph11))
                                                 {
                                                     System.out.println("Eneter a New Number : ");
                                                     String newnumb=s1.nextLine();
                                                     ali1.set(i,newnumb);
                                                 }
                                                
                                             }
                                             }
                                             else {
                                                 System.out.println("Invalid Phone");
                                             }
                                             }
                                             System.out.println(ali1);
                                             for(int i=0;i<ali1.size();i++)
                                             {
                                                 addphone1+=ali1.get(i)+" ";
                                             }
                                            li.set(new UserProcess(nm, ema1, addphone1));
                                            
                                            found3 = true;
                                        } else {
                                            System.out.println("Invalid Email OR Phone number");
                                        }
                                        
                                        break;
                                }
                        }
                    }
                    if (!found3) {
                        System.out.println("Record Not found");
                    } else {
                        System.out.println("Record is Updated");
                    }
                    System.out.println("-------------------------------------------------------------");
                    break;
                case "6":
                	System.out.println("-------------------------------------------------------------");
                    l.clear();
                    System.out.println("Record is Deleted");
                    System.out.println("-------------------------------------------------------------");
                    break;
                case "7":
                	System.out.println("---------------------------Program is End----------------------------------");
                   System.exit(0);
                    
                default:
                	System.out.println("-----------------------------------------------------------------");
                	System.out.println("You Press Wrong Thing your program is out now again run it");
                	System.out.println("-----------------------------------------------------------------");
                    break;
                 
            }
         }  
    }
}