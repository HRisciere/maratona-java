package academy.devdojo.maratonajava.javacore.ZZIjdbc.repository;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ProducerRepository {


    public static void save(Producer producer) {
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ('%s');".formatted(producer.getName());
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Inserted producer '{}' in the database, rows affected '{}'", producer.getName(), rowsAffected);
            // Não se usa sout nos projetos, o correto é usar LOG, então eu instalei a dependencia log4j
//            System.out.println(rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to insert producer '{}'", producer.getName(), e);
        }
    }

    //    274 - JDBC pt 23 - Transação
    public static void saveTransaction(List<Producer> producers) {
        // Vamos enviar vários dados e queremos que todos os dados ou sejam todos inseridos no banco de dados ou
        // eles não sejam inseridos caso 1 dê problema
        try (Connection conn = ConnectionFactory.getConnection()) {
            conn.setAutoCommit(false);
            preparedStatementSaveTransaction(conn, producers);
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            log.error("Error while trying to save producers '{}'", producers, e);
        }
    }

    //    274 - JDBC pt 23 - Transação
    private static void preparedStatementSaveTransaction(Connection conn, List<Producer> producers) throws SQLException {
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ( ? );";
        boolean shouldRollBack = false;
        for (Producer p : producers) {
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                log.info("Saving producer '{}'", p.getName());
                ps.setString(1, p.getName());
//                if (p.getName().equals("White fox")) throw new SQLException("Can't save white fox");
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
                shouldRollBack = true;
            }
        }
        if (shouldRollBack){
            log.warn("Transaction is going be rollback");
            conn.rollback();
        }
    }

    public static void delete(int id) {
        String sql = "DELETE FROM `anime_store`.`producer` WHERE (`id` = '%d');".formatted(id);
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Deleted producer '{}' from the database, rows affected '{}'", id, rowsAffected);
            // Não se usa sout nos projetos, o correto é usar LOG, então eu instalei a dependencia log4j
//            System.out.println(rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to delete producer '{}'", id, e);
        }

    }

    public static void update(Producer producer) {
        String sql = "UPDATE `anime_store`.`producer` SET `name` = '%s' WHERE (`id` = '%d');"
                .formatted(producer.getName(), producer.getId());
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Updated producer '{}', rows affected '{}'", producer.getId(), rowsAffected);
            // Não se usa sout nos projetos, o correto é usar LOG, então eu instalei a dependencia log4j
//            System.out.println(rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to update producer '{}'", producer.getId(), e);
        }
    }

    public static void updatePreparedStatement(Producer producer) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = preparedStatementUpdate(conn, producer)) {
            int rowsAffected = ps.executeUpdate();
            log.info("Updated producer '{}', rows affected '{}'", producer.getId(), rowsAffected);
            // Não se usa sout nos projetos, o correto é usar LOG, então eu instalei a dependencia log4j
//            System.out.println(rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to update producer '{}'", producer.getId(), e);
        }
    }

    private static PreparedStatement preparedStatementUpdate(Connection conn, Producer producer) throws SQLException {
        String sql = "UPDATE `anime_store`.`producer` SET `name` = ? WHERE (`id` = ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, producer.getName());
        ps.setInt(2, producer.getId());
        return ps;
    }

    public static List<Producer> findAll() {
        log.info("Finding all Producers ");
        return findByName("");
//        String sql = "SELECT id, name FROM anime_store.producer;";
        // Geralmente quando trabalha com lista, você retorna a lista vazia
        // É melhor retornar a lista vazia do que retorna nulo, porque trabalhar com nulo é um SACO!
//        List<Producer> producers = new ArrayList<>();
//        try (Connection conn = ConnectionFactory.getConnection();
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(sql)) {
//            // Lembrando que o ArrayList aceita valores duplicados
//            while (rs.next()) {
//                // Abaixo é o tipo da coluna, Id é int
//                // Tenho 2 opções ou eu passo o índice da coluna ou o nome da coluna
//                // Aqui o índice da coluna sempre começa com  o número 1
//                // Se eu quiser posso colocar int no lugar de var e String no lugar de var
//
//                // Vou fazer usando apenas 1 linha
//
////                var id = rs.getInt("id");
////                var name = rs.getString("name");
////                Producer producer = Producer.builder().id(id).name(name).build();
////                producers.add(producer);
//                Producer producer = Producer
//                        .builder()
//                        .id(rs.getInt("id"))
//                        .name(rs.getString("name"))
//                        .build();
//                producers.add(producer);
//            }
//
//            // Não se usa sout nos projetos, o correto é usar LOG, então eu instalei a dependencia log4j
////            System.out.println(rowsAffected);
//        } catch (SQLException e) {
//            log.error("Error while trying to find all producers", e);
//        }
//        return producers;
    }

    public static List<Producer> findByName(String name) {
        log.info("Finding Producer by name");
        String sql = "SELECT * from anime_store.producer where name like '%%%s%%';"
                .formatted(name);
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Producer producer = Producer
                        .builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all producers", e);
        }
        return producers;
    }

    // 268 - JDBC pt 17 - PreparedStatement pt 01  <<< Nesse vídeo ele explicar o SQL Injection
    public static List<Producer> findByNamePreparedStatement(String name) {
        log.info("Finding Producer by name");
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = preparedStatementFindByName(conn, name);
             ResultSet rs = ps.executeQuery()

             // Quando utilizo o PreparedStatement, antes de executar a QUERY, eu quero primeiro começar a fazer a PROTEÇÃO, no caso a PRÉ-COMPILAÇÃO
             // do valor que eu tenho no SQL
             // Antes de exetuar a QUERY eu também preciso substituir o(s) Wildcard(s)
        ) {
            while (rs.next()) {
                Producer producer = Producer
                        .builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all producers", e);
        }
        return producers;
    }

    public static List<Producer> findByNameCallableStatement(String name) {
        log.info("Finding Producer by name");
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = callableStatementFindByName(conn, name);
             ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                Producer producer = Producer
                        .builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all producers", e);
        }
        return producers;
    }

    private static CallableStatement callableStatementFindByName(Connection conn, String name) throws SQLException {
        String sql = "CALL `anime_store`.`sp_get_producer_by_name`(?);";
        CallableStatement cs = conn.prepareCall(sql);
        cs.setString(1, String.format("%%%s%%", name));
        return cs;
    }

    private static PreparedStatement preparedStatementFindByName(Connection conn, String name) throws SQLException {
        String sql = "SELECT * from anime_store.producer where name like ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
//        ps.setString(1, "%" + name + "%");   <<< posso fazer assim também
        ps.setString(1, String.format("%%%s%%", name));
        return ps;
    }

    public static void showProducerMetaData() {
        log.info("Showing Producer Metadata");
        // Eu não sei a quantidade de colunas, não sei absolutamente nada, a query está vindo da maneira abaixo
        String sql = "SELECT * FROM anime_store.producer";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            ResultSetMetaData rsMetaData = rs.getMetaData();
            // só quero trabalhar com 1 coluna, eu poderia utilizar o while também
            // abaxo eu estou pedindo para andar 1 linha
            // rs.next();    << não preciso dele
            int columnCount = rsMetaData.getColumnCount();
            log.info("Columns count '{}'", columnCount);
            // lembrando que coluna começa do 1
            for (int i = 1; i <= columnCount; i++) {
                log.info("Table name '{}'", rsMetaData.getTableName(i));
                log.info("Column name '{}'", rsMetaData.getColumnName(i));
                log.info("Column size '{}'", rsMetaData.getColumnDisplaySize(i));
                log.info("Column type '{}'", rsMetaData.getColumnTypeName(i));
            }

        } catch (SQLException e) {
            log.error("Error while trying to find all producers", e);
        }
    }

    public static void showDriverMetaData() {
        log.info("Showing Driver Metadata");
        // Eu não sei a quantidade de colunas, não sei absolutamente nada, a query está vindo da maneira abaixo
        String sql = "SELECT * FROM anime_store.producer";
        try (Connection conn = ConnectionFactory.getConnection()) {
            DatabaseMetaData dbMetaData = conn.getMetaData();
            // verificando se suporta os 3 abaixo, se o mysql suporta, lembrando que estou utilizando ele no docker
            if (dbMetaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
                // de cima para baixo
                log.info("Supports TYPE_FORWARD_ONLY");
                // verificando se ele suporta alterar os dados, enquanto eu estou navegando nesse result set
                if (dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("Supports CONCUR_UPDATABLE");
                }
            }
            if (dbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                // de cima para baixo, de baixo para cima e uma posição específica, ele NÃO ATUALIZA os dados em tempo real
                log.info("Supports TYPE_SCROLL_INSENSITIVE");
                // verificando se ele suporta alterar os dados, enquanto eu estou navegando nesse result set
                if (dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("Supports CONCUR_UPDATABLE");
                }
            }
            if (dbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                // de cima para baixo, de baixo para cima e uma posição específica, ele ATUALIZA os dados em tempo real
                log.info("Supports TYPE_SCROLL_SENSITIVE");
                // verificando se ele suporta alterar os dados, enquanto eu estou navegando nesse result set
                if (dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("Supports CONCUR_UPDATABLE");
                }
            }

        } catch (SQLException e) {
            log.error("Error while trying to find all producers", e);
        }
    }

    public static void showTypeScrollWorking() {
        String sql = "SELECT * from anime_store.producer;";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
            // Ele funciona de acordo com a QUERY do SQL, não é de acordo com o estado do banco
            // Lembrando que isso é um cursos, eu estou apontando para algum lugar
            log.info("Last row? '{}'", rs.last());
            log.info("Row number '{}'", rs.getRow());
            log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());

            log.info("First row? '{}'", rs.first());
            log.info("Row number '{}'", rs.getRow());
            log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());

            log.info("Row absolute '{}'", rs.absolute(2));
            log.info("Row number '{}'", rs.getRow());
            log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());

            // Quero voltar 1 linha
            // Aceita número negativo
            log.info("Row relative '{}'", rs.relative(-1));
            log.info("Row number '{}'", rs.getRow());
            log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());

            // quero saber se é a última ou a primeira, por exemplo, eu quero saber onde estou
            // não move o cursor
            log.info("is last? '{}'", rs.isLast());
            log.info("Row number '{}'", rs.getRow());

            log.info("is first? '{}'", rs.isFirst());
            log.info("Row number '{}'", rs.getRow());

            // Vou para a última row e depois irei de baixo para cima
            log.info("Last row? '{}'", rs.last());
            log.info("----------------------");
//            rs.next();  <<<< Se eu quiser, eu posso usar o rs.next() depois de ir para o último, como eu fiz acima
//            Ou posso usar o rs.afterLast(), como eu fiz abaixo
            rs.afterLast();
            log.info("After last row? '{}'", rs.isAfterLast());
            while (rs.previous()) {
                log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all producers", e);
        }
    }

    public static List<Producer> findByNameAndUpdateToUpperCase(String name) {
        // vou procurar por um nome e colocar ele em UpperCase, vou fazer uma atualização, sem criar uma nova query
        log.info("Finding Producer by name");
        String sql = "SELECT * from anime_store.producer where name like '%%%s%%';"
                .formatted(name);
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             // tem que lembrar que sempre que eu irei criar um statement que vai fazer uma atualizaçao no banco de dados
             // eu preciso utilzar o result set
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             // o nome que eu tenho já está dentro da memória, o result set quando executo a query ele traz os dados para dentro da memória
             // e eu fico trabalhando com ele dentro da memória
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                // quando eu vou realizar uma atualização, não é necessáro criar uma nova "query"
                // eu quero atualizar o campo nome, entao eu uso o updateString
                rs.updateString("name", rs.getString("name").toUpperCase());

//                rs.cancelRowUpdates(); <<< Se eu quiser voltar a maneira que estava antes do toUpperCase()
//                sempre utilizar o de cima antes do updateRow()
//                nao usar toLowerCase() para voltar ao anterior, utilize o cancelRowUpdates()
//                uma vez utilizado o updateRow não tem como eu cancelar o uptate, cancelRowUpdates()

                // depois de fazer o update acima, eu preciso utilizar o rs.updateRow(), para realmente eu atualizar o conteúdo no banco de dados
                rs.updateRow();
                Producer producer = Producer
                        .builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all producers", e);
        }
        return producers;
    }

    public static List<Producer> findByNameAndInsertWhenNotFound(String name) {
        // vou procurar por um nome, se ele não existir eu vou INSERIR
        log.info("Finding Producer by name");
        String sql = "SELECT * from anime_store.producer where name like '%%%s%%';"
                .formatted(name);
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) return producers;

            insertNewProducer(name, rs);

            producers.add(getProducer(rs));
        } catch (SQLException e) {
            log.error("Error while trying to find all producers", e);
        }
        return producers;
    }

    public static void findByNameAndDelete(String name) {
        // vou procurar por um nome, se ele não existir eu vou INSERIR
        // Aqui eu vou deletar por nome, então se encontrar mais de 1, eu vou deletar todo mundo
        log.info("Finding Producer by name");
        String sql = "SELECT * from anime_store.producer where name like '%%%s%%';"
                .formatted(name);
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                log.info("Deleting '{}'", rs.getString("name"));
                rs.deleteRow();
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all producers", e);
        }
    }

    private static void insertNewProducer(String name, ResultSet rs) throws SQLException {
        // primeiro eu preciso mover o cursor para uma linha temporária
        rs.moveToInsertRow();
        rs.updateString("name", name);
        rs.insertRow();
    }

    private static Producer getProducer(ResultSet rs) throws SQLException {
        rs.beforeFirst();
        rs.next();
        return Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build();
    }
}
