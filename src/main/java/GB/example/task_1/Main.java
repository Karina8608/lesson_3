package GB.example.task_1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersonRepository repository = new PersonRepository();

        // Добавление нового человека
        Person person = new Person("Anton", 25);
        repository.addPerson(person);

        // Получение объекта по ID
        Person retrievedPerson = repository.getPerson(person.getId());
        System.out.println("Retrieved: " + retrievedPerson);

        // Обновление данных
        retrievedPerson.setAge(26);
        repository.updatePerson(retrievedPerson);

        // Удаление объекта
        repository.deletePerson(retrievedPerson.getId());

        // Получение всех записей
        List<Person> allPersons = repository.getAllPersons();
        allPersons.forEach(System.out::println);
    }
}

