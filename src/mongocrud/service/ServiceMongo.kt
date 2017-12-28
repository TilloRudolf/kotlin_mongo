package mongocrud.service

import com.mongodb.MongoClient
import com.mongodb.client.MongoCollection
import com.vk.api.sdk.objects.wall.WallPostFull
import mongocrud.model.WallPost
import org.bson.Document

class ServiceMongo {

    private lateinit var collection: MongoCollection<Document>

    fun createDBCon(){
        val mongoClient = MongoClient()
        val db = mongoClient.getDatabase("mydb")
        collection = db.getCollection("vkposts")
    }

    fun putInDB(wallPostFull: WallPostFull){
        val document = Document()
        val wallPost = WallPost()
        wallPost.comments = wallPostFull.comments.toString()
        wallPost.likes = wallPostFull.likes.toString()
        wallPost.text = wallPostFull.text
        document.put("comments", wallPost.comments)
        document.put("likes", wallPost.likes)
        document.put("text", wallPost.text)
        collection.insertOne(document)
    }
}