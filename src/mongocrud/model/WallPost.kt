package mongocrud.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "vkposts")
class WallPost{

    @Id
    private lateinit var name: String
    lateinit var comments: String
    lateinit var likes: String
    lateinit var text: String

}