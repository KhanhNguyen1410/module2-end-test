import model.PhoneBook;
import service.PhoneBookManagement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static void display(List list) {
        Iterator<PhoneBook> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        PhoneBookManagement phoneBookManagement = new PhoneBookManagement();
        List<PhoneBook> phoneBookList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int choose = -1;

        while (choose != 0) {
            System.out.println("Menu: ");
            System.out.println("1: xem danh sach");
            System.out.println("2: add new phoneNumber");
            System.out.println("3: update phoneNumber");
            System.out.println("4: delete a phoneNumber");
            System.out.println("5: find a Product by Name");
            System.out.println("6: read file");
            System.out.println("7: write file");
            System.out.println("0: exit");

            System.out.println("enter your choose: ");
            choose = input.nextInt();


            switch (choose){
                case 1:
                    phoneBookList = phoneBookManagement.show();
                    display(phoneBookList);
                    break;
                case 2:
                    System.out.println("enter number");
                    int sdt = input.nextInt();
                    input.nextLine();
                    System.out.println("enter group ");
                    String group = input.nextLine();
                    System.out.println("enter name");
                    String name = input.nextLine();
                    System.out.println("enter gender");
                    String gender = input.nextLine();
                    System.out.println("enter address");
                    String address = input.nextLine();

                    PhoneBook newPhoneBook = new PhoneBook(sdt,group,name,gender,address);
                    phoneBookManagement.add(newPhoneBook);
                    phoneBookList = phoneBookManagement.show();
                    display(phoneBookList);
                    break;
                case 3:
                    System.out.println("enter number");
                    int sdt2 = input.nextInt();
                    input.nextLine();
                    System.out.println("enter group ");
                    String group2 = input.nextLine();
                    System.out.println("enter name");
                    String name2 = input.nextLine();
                    System.out.println("enter gender");
                    String gender2 = input.nextLine();
                    System.out.println("enter address");
                    String address2 = input.nextLine();
                    PhoneBook updatePhone = new PhoneBook(sdt2,group2,name2,gender2,address2);
                    phoneBookManagement.update(updatePhone);
                    phoneBookList = phoneBookManagement.show();
                    display(phoneBookList);
                    break;
                case 4:
                    input.nextLine();
                    System.out.println("enter name");
                    String nameDel = input.nextLine();
                    phoneBookManagement.delete(nameDel);
                    phoneBookList = phoneBookManagement.show();
                    display(phoneBookList);
                    break;
                case 5:
                    input.nextLine();
                    System.out.println("enter name");
                    String nameFind = input.nextLine();
                    System.out.println(phoneBookManagement.findByName(nameFind));
                    break;
                case 6:
                    phoneBookManagement.readFile("phoneBook.csv");
                    break;
                case 7:
                    phoneBookManagement.writeFile("phoneBook.csv");
                    break;
                case 8:
                    System.exit(0);
            }
            System.out.println("________________________");
        }

    }
}
