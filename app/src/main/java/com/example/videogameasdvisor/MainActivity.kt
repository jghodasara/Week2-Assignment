package com.example.videogameasdvisor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val findGames = findViewById<Button>(R.id.find_game)

        findGames.setOnClickListener {
            val gameGeneres = findViewById<Spinner>(R.id.spinner)
            val descriptionTextView = findViewById<TextView>(R.id.gameDescription)
            val gamesTextView = findViewById<TextView>(R.id.gamesTxt)
            val genre = gameGeneres.selectedItem // Here we get the selected item from the spinner
            val (gamesList, description) =
                getGames(genre.toString())  //This will get the list of genre specific games with description and is assigned to gamesList parameter and description parameter.
            val reducedGamesList =
                gamesList.reduce { str, item -> str + '\n' + item } //This line adds next line after each item so that every items are shown one by one.
            gamesTextView.text =
                reducedGamesList // Here the list of games that we get from the getGames function is populated to the textView.
            descriptionTextView.text =
                description // Here the description that we get from the getGames function is assigned to the description text box.
        }
    }


    // This function gives a Pair of list of games for each genre and a description of that genre. It works like a switch statement.
    fun getGames(genre: String): Pair<List<String>, String> {
        return when (genre) {
            "Action" -> Pair(
                listOf<String>("GTA5", "Call Of Duty"),
                "Action games contains physical challenges such as fighting games, shooter games etc."
            )
            "Adventure" -> Pair(
                listOf<String>("Tomb Raider", "Final Fantasy"),
                "Adventure games are based on some sort of story where the player is having the role of a character from that story."
            )
            "Strategy" -> Pair(
                listOf<String>("Age Of Empires", "StarCraft"),
                "Strategy games focuses on the decision making skill of the player and according to the strategies the game proceeds"
            )
            "Quiz" -> Pair(
                listOf<String>("Multiple choice answers", "Fill in the blanks"),
                "Quizzes are games that challenge the knowledge of the player and are very good for learning purposes."
            )
            "Mathematical" -> Pair(
                listOf<String>("Sudoku", "Mathematical Quiz"),
                "Mathematical games challenges the calculation and are more focused towards computation."
            )
            else -> Pair(listOf("Nothing selected"), "Please select a type from the dropdown")
        }
    }
}