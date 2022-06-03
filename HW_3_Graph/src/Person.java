import java.util.Objects;

public class Person implements Comparable<Person> {
	String id;
	String firstName;
	String lastName;

	public Person(String id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		return Objects.equals(id, person.id);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Person [" + id + " " + firstName + " " + lastName + "]";
	}


	@Override
	public int compareTo(Person o) {
		return id.compareTo(o.id);
	}
}
