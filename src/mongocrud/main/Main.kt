package mongocrud.main

import mongocrud.service.MainService

fun main(args: Array<String>){

    val app_id = 1 //your app id
    val token = "" //your access token
    val client = "" //your client secret
    val mainService = MainService(app_id, client, token)
    mainService.start()

}