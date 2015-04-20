package poker

import org.json.JSONObject
import org.wasabi.app.AppConfiguration
import org.wasabi.app.AppServer

fun main(args: Array<String>) {
    var server = AppServer(AppConfiguration(getPort()))
    val player = Player()

    server.post("/", {
        val action = request.bodyParams["action"]
        val result = when (action) {
            "bet_request" -> {
                val gameState = request.bodyParams["game_state"]

                if (gameState == null) {
                    "Missing game_state!"
                } else {
                    val json = JSONObject(gameState)
                    print(json)
                    player.betRequest(json).toString()
                }
            }
            "showdown" -> {
                player.showdown()
                "OK"
            }
            "version" -> player.version()
            else -> "Unknown action '$action'!"
        }

        response.send(result)
    })

    server.start()
}

private fun getPort(): Int {
    val port = System.getenv("PORT") ?: "2345"

    return Integer.parseInt(port)
}
