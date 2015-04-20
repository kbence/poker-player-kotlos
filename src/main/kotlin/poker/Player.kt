package poker

import org.json.JSONArray
import org.json.JSONObject

class Player {
    fun betRequest(game_state: JSONObject): Int {
        return (Math.random() * 200).toInt()
    }

    private fun getPlayerCards(player: JSONObject) = player.get("hole_cards") as JSONArray

    private fun currentPlayer(game_state: JSONObject) =
            (game_state.get("players") as JSONArray)[game_state.get("in_action") as Int] as JSONObject

    fun showdown() {
    }

    fun version(): String {
        return "v0.0.4 - KOTLIK"
    }
}
