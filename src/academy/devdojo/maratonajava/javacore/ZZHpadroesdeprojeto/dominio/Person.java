package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio;

public class Person {
    private String firstName;
    private String lastName;
    private String username;
    private String email;

    private Person(String firstName, String lastName, String username, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static final class PersonBuilder {
        private String firstName;
        private String lastName;
        private String username;
        private String email;

        private PersonBuilder() {
        }

        public static PersonBuilder aPerson() {
            return new PersonBuilder();
        }

        public PersonBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder username(String username) {
            this.username = username;
            return this;
        }

        public PersonBuilder email(String email) {
            this.email = email;
            return this;
        }

        public Person build() {
            return new Person(firstName, lastName, username, email);
        }


    }
    public String getFirstName() {
        return firstName;
    }


//        public static class PersonBuilder {
//        private String firstName;
//        private String lastName;
//        private String username;
//        private String email;
//        // Não preciso fazer isso sempre, tem o plugin, procurar por "Builder"
//        // Os métodos retornam para o mesmo espeço de memória
//        // o firstName irá adicionar no mesmo objeto, porque eu estou retornando "this"
//        // Sempre estão trabalhando no mesmo espaço de memória
//        // Eu preciso retornar uma pessoa, quando eu chamo o método, então eu crio o "build"
//        // Uso o build quando eu quiser criar um objeto "Pessoa", então ele retorna a classe "Person", que é a mais externa, é o que eu quero
//        public PersonBuilder firstName(String firstName) {
//            this.firstName = firstName;
//            return this;
//        }
//
//        public PersonBuilder lastName(String lastName) {
//            this.firstName = lastName;
//            return this;
//        }
//
//        public PersonBuilder username(String username) {
//            this.firstName = username;
//            return this;
//        }
//
//        public PersonBuilder email(String email) {
//            this.firstName = email;
//            return this;
//        }
//        public Person build(){
//            return new Person(firstName, lastName, username, email);
//        }

}

