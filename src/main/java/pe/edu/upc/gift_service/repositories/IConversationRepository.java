package pe.edu.upc.gift_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.gift_service.entities.Conversation;

import java.util.List;

@Repository
public interface IConversationRepository extends JpaRepository<Conversation,Integer> {
    @Query(value = "select\n" +
            "    date_conversation,\n" +
            "    text_conversation,\n" +
            "    entrepreneurship_id,\n" +
            "    user_id,\n" +
            "\tid_conversation\n" +
            "FROM\n" +
            "    conversation\n" +
            "WHERE\n" +
            "    entrepreneurship_id = ?1\n" +
            "    AND user_id =?2\n" +
            "ORDER BY\n" +
            "    date_conversation ASC",nativeQuery = true)
    public List<Conversation> findAllByUserEntrepre(int id_entre, int id_user);
}
