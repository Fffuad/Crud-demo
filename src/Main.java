import java.util.Scanner;

public class Main {
    private static int say = 0;
    private static Person[] persons;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Massivin olcusunu daxil edin ");
        int n = sc.nextInt();
        persons = new Person[n];
        createPerson(1L, "Fuad", "Bayramov", (byte) 25);
        createPerson(2L, "Emin", "Memmedov", (byte) 27);
        System.out.println("----------------------------------------");
//        createPerson(sc.nextLong(),sc.next(),sc.next(),sc.nextByte());
        readPerson();
        System.out.println("----------------------------------------");
        System.out.println("Axtardigimiz id: ");
        long id = sc.nextLong();
        Person person = getPersonById(id);
        if (person == null) {
            System.out.println("id-si" + id + "olan Person yoxdur");
        } else {
            System.out.println(person);
        }
        System.out.println("----------------------------------------");
        System.out.println("Deyismek istediyiniz Personun id -sini, adini , soyadini , yasini daxil edin ");
        Person newPerson = new Person(sc.nextLong(),
                sc.next(),
                sc.next(),
                sc.nextByte());
        System.out.println("Upddate olunan Person ");
        Person updatePerson = updatePersonById(newPerson.getId(), newPerson);
        if (updatePerson == null) {
            System.out.println("Hec bir Person deyisdirilmedi");

        } else {
            System.out.println(updatePerson);
        }
        System.out.println("-----------------------------------");
        System.out.println("Silinecek shexsin id-si: ");
        long idDelete = sc.nextLong();
        boolean deleted = deleteById(idDelete);
        if (deleted) {
            System.out.println("Id-si " + idDelete + "olan Person silindi");
        } else {
            System.out.println("Id-si " + idDelete + " olan Person tapilmadi");
        }


    }

    public static Person createPerson(long id, String name, String surname, byte age) {
        Person p1 = new Person();
        p1.setId(id);
        p1.setName(name);
        p1.setSurname(surname);
        p1.setAge(age);
        persons[say] = p1;
        say++;
        return p1;
    }

    public static void readPerson() {
        for (int i = 0; i < say; i++) {
            System.out.println(persons[i]);

        }
    }

    public static Person getPersonById(long id) {
        for (int i = 0; i < say; i++) {
            if (persons[i].getId() == id) {
                return persons[i];

            }

        }
        return null;
    }

    public static Person updatePersonById(long id, Person newPerson) {
        Person person = getPersonById(id);
        if (person != null) {
            person.setName(newPerson.getName());
            person.setSurname(newPerson.getSurname());
            person.setAge(newPerson.getAge());
            return person;
        } else {
            return null;
        }
    }

    public static boolean deleteById(long id) {
        for (int i = 0; i < say; i++) {
            if (persons[i].getId() == id) {
                for (int j = i; j < say - 1; j++) {
                    persons[j] = persons[j + 1];
                }
                persons[--say] = null;
                return true;

            }
        }
        return false;

    }

}
