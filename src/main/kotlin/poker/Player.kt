package poker

import org.json.JSONArray
import org.json.JSONObject

class Player {
    fun betRequest(game_state: JSONObject): Int {
//        for (player in 1..(game_state.get("players") as JSONArray).length()) {
//            player.
//        }
        return 1000
    }

    fun showdown() {
    }

    fun version(): String {
        return "Kotlin Player 0.0.1"
    }
}
