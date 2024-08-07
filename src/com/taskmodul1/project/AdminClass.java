package com.taskmodul1.project;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class AdminClass {
	public static boolean checknamevalid(String name)
    { 
        String regexName = "[a-zA-Z]+[\\s]*{1,3}[a-zA-Z]+";
        boolean a=name.matches(regexName);
        return a;
    }
	public static  boolean validnamecheck(String emai)
	{
	    String regx="[a-zA-Z0-9._%+-]+@[a-zA-z0-9.-]+\\.[a-zA-Z]{2,3}";  
	    boolean a=emai.matches(regx);
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
            System.out.println("Tab Any Number for Operation Performing ");
            
            String n = s.nextLine();
             
            switch (n) {
                case "1":
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
                    break;
                case "2":
                    System.out.println("----------------------------");
                    for (UserProcess u : l) {
                        System.out.println(u.getName()+" : "+u.getEmail() + " : "+u.getPhone());
                    }
                    System.out.println("----------------------------");
                    break;

                case "3":
                    System.out.println("----------------------------");
                    System.out.println("Enter name For Search : ");
                    String name1 = s1.nextLine();
                    boolean found1 = false;
                    for (UserProcess u : l) {
                        if (u.getName().equalsIgnoreCase(name1)) {
                            System.out.println(u.getName() + " : "+u.getEmail() +" : "+u.getPhone());
                            found1 = true;
                        }
                    }
                    if (!found1) {
                        throw new RuntimeException("UserNotFound Exception");
                    }
                    System.out.println("----------------------------");
                    break;

                case "4":
                    System.out.println("----------------------------");
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
                    System.out.println("----------------------------");
                    break; 

                case "5":
                    System.out.println("----------------------------");
                    System.out.println("Enter name you want to Update All Details : ");
                    String name3 = s1.nextLine();
                    ListIterator<UserProcess> li = l.listIterator();
                    boolean found3 = false;
                    while (li.hasNext()) {
                            UserProcess u = li.next();
                            if (u.getName().equalsIgnoreCase(name3)) {
                                System.out.println("Enter what you want ti update : ");
                                System.out.println("press 1 to Update name : ");
                                System.out.println("press 2 to update email ");
                                System.out.println("press 3 to update phone number : ");
                                System.out.println("press 4 to update all :");
                                int m = s.nextInt();
                                switch (m) {
                                    case 1:
                                        System.out.println("enter name ");
                                      String  name4 = s1.nextLine();
                                      if(AdminClass.validnamecheck(name4))
                                      {
                                         u.setName(name4);
                                        found3 = true;
                                      }
                                        break;
                                    case 2:
                                        System.out.println("enter email ");
                                        String ema = s1.nextLine();

                                        if (AdminClass.validemailcheck(ema)) {
                                            u.setEmail(ema);
                                            found3 = true;
                                        }
                                        else{
                                            System.out.println("Invalid Email");
                                        }
                                        break;
                                    case 3:
                                        System.out.println("your currentPhone number is : " + u.getPhone());
                                        System.out.println("enter Phone  ");
                                        String ph = s1.nextLine();

                                        if (AdminClass.validMobileNumber(ph)) {
                                            u.setPhone(ph);
                                            found3 = true;
                                        }
                                        else {
                                            System.out.println("Invalid Phone");
                                        }
                                        break;
                                    case 4:
                                        System.out.println("enter name ");
                                        String nm = s1.nextLine();
                                        System.out.println("enter email ");
                                        String ema1 = s1.nextLine();
                                        System.out.println("enter Phone  ");
                                        String ph1 = s1.nextLine();
                                        if (AdminClass.validemailcheck(ema1) && AdminClass.validMobileNumber(ph1)) {
                                            li.set(new UserProcess(nm, ema1, ph1));
                                            System.out.println("Record Updated Successfully");
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
                    System.out.println("----------------------------");
                    break;
                case "6":
                    System.out.println("----------------------------");
                    l.clear();
                    System.out.println("Record is Deleted");
                    System.out.println("----------------------------");
                    break;
                default:
                    break;
            }
         }
       
    }
}