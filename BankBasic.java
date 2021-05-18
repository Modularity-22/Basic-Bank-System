import java.util.Scanner;
public class BankBasic {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        double a = Math.random()*5;
        System.out.print("How many customer data do you want to store: ");
        int n = sc.nextInt();
        Bank b[] = new Bank[n];
        for (int i = 0; i < b.length; i++) 
        {
            b[i] = new Bank();
            b[i].openAccount();
        }

        int ch;
        do 
        {
            System.out.println("Main Menu");
            System.out.println("1. Display All");
            System.out.println("2. Search your Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdrawal");
            System.out.println("5. Exit");
            ch = sc.nextInt();
                switch (ch) 
                {
                    case 1:
                        for (int i = 0; i < b.length; i++) 
                        {
                            b[i].showAccount();
                        }
                        break;

                    case 2:
                        System.out.println("Enter Account number you want to Search...: ");
                        String acn = sc.next();
                        boolean found = false;
                        for (int i = 0; i < b.length; i++) 
                        {
                            found = b[i].search(acn);
                            if (found) 
                            {
                                break;
                            }
                        }
                        if (!found) 
                        {
                            System.out.println("No such account Exist");
                            punerror();
                        }
                        break;

                    case 3:
                        System.out.print("Enter Account No : ");
                        acn = sc.next();
                        found = false;
                        for (int i = 0; i < b.length; i++) 
                        {
                            found = b[i].search(acn);
                            if (found) 
                            {
                                b[i].deposit();
                                break;
                            }
                        }
                        if (!found) 
                        {
                            System.out.println("No such account Exist");
                            punerror();
                        }
                        break;

                    case 4:
                        System.out.print("Enter Account No : ");
                        acn = sc.next();
                        found = false;
                        for (int i = 0; i < b.length; i++) 
                        {
                            found = b[i].search(acn);
                            if (found) 
                            {
                                b[i].withdrawal();
                                break;
                            }
                        }
                        if (!found) 
                        {
                            System.out.println("No such account Exist");
                            punerror();
                        }
                        break;

                    case 5:
                        System.exit(0);    
                        break;

                    default: System.out.println("ERROR");
                                 break;     
                }
            }
            while (true);
        }
    public static void punerror()
    {
        double a = Math.random()*10;
        if(a<=2)
            System.out.println("Seriously Why???");
        else if(a>2 && a<=4)
            System.out.println("I am fed up now");
        else if(a>4 && a<=6)
            System.out.println("Pls for god sake");
        else if(a>6 && a<=8)
            System.out.println("Typing is not for you go away!");
        else
            System.out.println("-_- |RIP your Typing|");

    }
    }


class Bank 
{
    private String accno;
    private String name;
    private long balance;

    Scanner sc = new Scanner(System.in);

    void openAccount() 
    {
        System.out.print("Enter Account No: ");
        accno = sc.next();
        System.out.print("Enter Name: ");
        name = sc.next();
        System.out.print("Enter Balance: ");
        balance = sc.nextLong();
    }

    void showAccount() 
    {
        System.out.println("\n Account Details \n");
        System.out.println("Account Number : "+accno);
        System.out.println("Account Holder Name : "+name);
        System.out.println("Balance left : "+balance);
    }

    void deposit() 
    {
        long amt;
        System.out.println("How much Amount do you want to deposit : ");
        amt = sc.nextLong();
        balance = balance + amt;
    }

    void withdrawal() 
    {
        long amt;
        System.out.println("How much Amount do you want to withdraw : ");
        amt = sc.nextLong();
        if (balance >= amt) 
        {
            balance = balance - amt;
        } 
        else 
        {
            System.out.println("Low Balance ... Don't try to rob bank");
        }
    }

    boolean search(String acn) 
    {
        if (accno.equals(acn)) 
        {
            showAccount();
            return (true);
        }
        return (false);
    }
}

