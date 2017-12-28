package mongocrud.service

import com.vk.api.sdk.client.VkApiClient
import com.vk.api.sdk.client.actors.ServiceActor
import com.vk.api.sdk.httpclient.HttpTransportClient
import com.vk.api.sdk.objects.wall.WallPostFull
import com.vk.api.sdk.queries.wall.WallGetFilter

class ServiceVK {

    fun getConnection(APP_ID: Int, CLIENT_SECRET: String, ACCESS_TOKEN: String) : List<WallPostFull>{
        val transportClient = HttpTransportClient.getInstance()
        val vk = VkApiClient(transportClient)
        val actor = ServiceActor(APP_ID, CLIENT_SECRET, ACCESS_TOKEN)

        val getResponse = vk.wall().get(actor)
                .ownerId(1) //your account id
                .count(10)
                .offset(5)
                .filter(WallGetFilter.OWNER)
                .execute()
        return getResponse.items
    }
}