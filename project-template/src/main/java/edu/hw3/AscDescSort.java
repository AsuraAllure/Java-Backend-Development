package edu.hw3;

import java.util.ArrayList;
import java.util.List;

public class AscDescSort {
    record Contact(String name, String surname){}

    public static void main(String[] args){
    }

    public static Object[] parseContact(String[] rawContacts, String order){
        if (rawContacts == null)
            return new Object[0];

        List<Contact> contacts = new ArrayList<>(rawContacts.length);
        for(var rawContact: rawContacts){
            String[] fio = rawContact.split("\s");
            if (fio.length == 2)
                contacts.add(new Contact(fio[0], fio[1]));
            else
                contacts.add(new Contact(fio[0], ""));
        }

        if (order.equals("ASC"))
            return contacts.stream().sorted((s1, s2) ->
                s1.surname.compareTo(s2.surname) == 0
                    ? s1.name.compareTo(s2.name)
                    : s1.surname.compareTo(s2.surname)
            ).toArray();

        if (order.equals("DESC"))
            return contacts.stream().sorted((s1, s2) ->
            s1.surname.compareTo(s2.surname) == 0
                ? -s1.name.compareTo(s2.name)
                : -s1.surname.compareTo(s2.surname)
        ).toArray();
        return new Contact[0];
    }

}
