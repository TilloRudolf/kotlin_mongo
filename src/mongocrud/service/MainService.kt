package mongocrud.service

import com.vk.api.sdk.objects.wall.WallPostFull

class MainService (private val APP_ID: Int, private val CLIENT_SECRET: String,  private val TOKEN: String) {

    fun start(){
        val serviceVK = ServiceVK()
        val listPosts: List<WallPostFull> = serviceVK.getConnection(APP_ID, CLIENT_SECRET, TOKEN)
        val serviceMongo = ServiceMongo()
        serviceMongo.createDBCon()
        for (w in listPosts) {
            serviceMongo.putInDB(w)
        }
    }

}