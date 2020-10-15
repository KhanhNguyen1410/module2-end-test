package service;

import model.PhoneBook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhoneBookManagement implements IService<PhoneBook>{

    static List<PhoneBook> phoneBookList;

    static {
        phoneBookList = new ArrayList<>();
        phoneBookList.add(new PhoneBook(1234,"gia dinh","khanh","nam","address"));
        phoneBookList.add(new PhoneBook(5647,"cong ty","tien","nam","address"));
        phoneBookList.add(new PhoneBook(8657,"cong ty","vuong","nam","address"));
    }

    @Override
    public List<PhoneBook> show() {
        List<PhoneBook> phoneBooks = new ArrayList<>();
        Iterator<PhoneBook> iterator = phoneBooks.iterator();
        while (iterator.hasNext()){
            phoneBooks.add(iterator.next());
        }
        return phoneBookList;
    }

    @Override
    public void add(PhoneBook phoneBook) {
        if (!checkName(phoneBook.getName())){
            phoneBookList.add(phoneBook);
        }
        System.out.println("name is existed");
    }

    @Override
    public void update(PhoneBook newpPhoneBook) {
        if (checkName(newpPhoneBook.getName())){
            for (int i = 0; i < phoneBookList.size(); i++) {
                if (phoneBookList.get(i).getName().equals(newpPhoneBook.getName())){
                    phoneBookList.set(i, newpPhoneBook);
                }
            }
        }
        else {
            System.out.println("no has name in phonebook");
        }
    }

    @Override
    public void delete(String name) {
        if (checkName(name)){
            for (int i = 0; i < phoneBookList.size(); i++) {
                if (phoneBookList.get(i).getName().equals(name)){
                    phoneBookList.remove(i);
                }
            }
        }
        else {
            System.out.println("no has phoneNumber in phonebook");
        }
    }

    @Override
    public PhoneBook findByName(String name) {
        if (checkName(name)){
            for (int i = 0; i < phoneBookList.size(); i++) {
                if (phoneBookList.get(i).getName().equals(name)){
                    return phoneBookList.get(i);
                }
            }
        }
        return null;
    }

    @Override
    public void readFile(String pathName) {
        try {
            FileReader fileReader = new FileReader(pathName);
            BufferedReader bf = new BufferedReader(fileReader);
            String[] strings;
            String line = "";
            while ((line = bf.readLine())!= null){
                strings = line.split(",");
                System.out.println(strings[0]+"," + strings[1]
                        +","+strings[2]+"," +strings[3]
                        +","+ strings[4]);
            }
            bf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeFile(String pathName) {
        try {
            FileWriter fw = new FileWriter(pathName);
            fw.append("sdt,group,name,gender,address");
            fw.append("\n");
            for (PhoneBook phoneBook: phoneBookList){
                fw.append(String.valueOf(phoneBook.getSdt()));
                fw.append(",");
                fw.append(phoneBook.getGroup());
                fw.append(",");
                fw.append(phoneBook.getName());
                fw.append(",");
                fw.append(phoneBook.getGender());
                fw.append(",");
                fw.append(phoneBook.getAddress());
                fw.append("\n");
            }
            fw.flush();
            fw.close();
            System.out.println("CSV file was created successfully !!!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkName(String name){
        for (int i = 0; i < phoneBookList.size(); i++) {
            if (phoneBookList.get(i).getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}
