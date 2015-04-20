package poker

import org.json.JSONArray
import org.json.JSONObject

class Player {
    fun betRequest(game_state: JSONObject): Int {
        val player = currentPlayer(game_state)
        val min_raise = (game_state.get("current_buy_in") as Int) - (player.get("bet") as Int)
        val cards = getPlayerCards(player)

        return min_raise
    }

    private fun getPlayerCards(player: JSONObject) = player.get("hole_cards") as JSONArray

    private fun currentPlayer(game_state: JSONObject) =
            (game_state.get("players") as JSONArray)[game_state.get("in_action") as Int] as JSONObject

    fun showdown() {
    }

    fun version(): String {
        return "Bnc's Kotlin Player 0.0.2"
    }
}
