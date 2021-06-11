package com.example.moviecatalogue.utils

import com.example.moviecatalogue.data.source.local.entity.MovieEntity
import com.example.moviecatalogue.data.source.local.entity.TvShowEntity
import com.example.moviecatalogue.data.source.remote.response.MovieResponse
import com.example.moviecatalogue.data.source.remote.response.TvShowResponse

object DataDummy {
    fun generateDummyMovies(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                "m01",
                "Army of the Dead (2021)",
                "Following a zombie outbreak in Las Vegas, a group of mercenaries take the ultimate gamble: venturing into the quarantine zone to pull off the greatest heist ever attempted.",
                "Action, Horror, Thriller",
                67,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/x3taBaWfRzw1NIKhEPpKPwKBAOC.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "m02",
                "F9 (2021)",
                "Dominic Toretto is leading a quiet life off the grid with Letty and his son, little Brian, but they know that danger always lurks just over their peaceful horizon. This time, that threat will force Dom to confront the sins of his past if he’s going to save those he loves most. His crew joins together to stop a world-shattering plot led by the most skilled assassin and high-performance driver they’ve ever encountered: a man who also happens to be Dom’s forsaken brother, Jakob.",
                "Action, Thriller, Crime",
                80,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qIicLxr7B7gIt5hxZxo423BJLlK.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "m03",
                "Zack Snyder's Justice League (2021)",
                "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                "Action, Adventure, Fantasy, Science Fiction"  ,
                85,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "m04",
                "Eternals (2021)",
                "The Eternals are a team of ancient aliens who have been living on Earth in secret for thousands of years. When an unexpected tragedy forces them out of the shadows, they are forced to reunite against mankind’s most ancient enemy, the Deviants.",
                "Action, Adventure, Fantasy",
                0,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6AdXwFTRTAzggD2QUTt5B7JFGKL.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "m05",
                "Mortal Kombat (2021)",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "Action, Fantasy, Adventure",
                76,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "m06",
                "Raya and the Last Dragon (2021)",
                "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
                "Animation, Adventure, Fantasy, Family, Action",
                82,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "m07",
                "Godzilla vs. Kong (2021)",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "Action, Science Fiction",
                81,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "m08",
                "Cruella (2021)",
                "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
                "Comedy, Crime",
                77,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wToO8opxkGwKgSfJ1JK8tGvkG6U.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "m09",
                "Demon Slayer -Kimetsu no Yaiba- The Movie: Mugen Train (2020)",
                "Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!",
                "Animation, Action, Adventure, Fantasy, Drama",
                84,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/h8Rb9gBr48ODIwYUttZNYeMWeUU.jpg"
            )
        )
        movies.add(
            MovieEntity(
                "m10",
                "The Mitchells vs. The Machines (2021)",
                "A quirky, dysfunctional family's road trip is upended when they find themselves in the middle of the robot apocalypse and suddenly become humanity's unlikeliest last hope.",
                "Animation, Adventure, Comedy, Family, Science Fiction",
                80,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/mI2Di7HmskQQ34kz0iau6J1vr70.jpg"
            )
        )

        return movies
    }

    fun generateDummyTvShows() : List<TvShowEntity> {
        val tvShows = ArrayList<TvShowEntity>()

        tvShows.add(
            TvShowEntity(
            "s01",
            "The Falcon and the Winter Soldier (2021)",
            "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
            "Sci-Fi & Fantasy, Action & Adventure, Drama, War & Politics",
            79,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6kbAMLteGO8yyewYau6bJ683sw7.jpg"
            )
        )

        tvShows.add(
            TvShowEntity(
                "s02",
                "The Flash (2014)",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "Drama, Sci-Fi & Fantasy",
                77,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg"
            )
        )

        tvShows.add(
            TvShowEntity(
                "s03",
                "Grey's Anatomy",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "Drama",
                82,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg"
            )
        )

        tvShows.add(
            TvShowEntity(
                "s04",
                "Invincible (2021)",
                "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
                "Animation, Action & Adventure, Drama, Sci-Fi & Fantasy",
                89,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg"
            )
        )

        tvShows.add(
            TvShowEntity(
                "s05",
                "The Bad Batch (2021)",
                "Follow the elite and experimental Clones of the Bad Batch as they find their way in a rapidly changing galaxy in the aftermath of the Clone Wars.",
                "Sci-Fi & Fantasy, Action & Adventure, Animation",
                89,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/uggL9jiDi0CCfoPIfU2X6BnMaFy.jpg"
            )
        )

        tvShows.add(
            TvShowEntity(
                "s06",
                "Jupiter's Legacy (2021)",
                "As the world's first generation of superheroes (who received their powers in the 1930s) become the revered elder guard in the present, their superpowered children struggle to live up to the legendary feats of their parents.",
                "Sci-Fi & Fantasy, Action & Adventure, Drama, Mystery",
                74,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9yxep7oJdkj3Pla9TD9gKflRApY.jpg"
            )
        )

        tvShows.add(
            TvShowEntity(
                "s07",
                "Riverdale (2017)",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "Mystery, Drama, Crime",
                86,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg"
            )
        )

        tvShows.add(
            TvShowEntity(
                "s08",
                "Game of Thrones (2011)",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                "Sci-Fi & Fantasy, Drama, Action & Adventure",
                84,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg"
            )
        )

        tvShows.add(
            TvShowEntity(
                "s09",
                "WandaVision (2021)",
                "Wanda Maximoff and Vision—two super-powered beings living idealized suburban lives—begin to suspect that everything is not as it seems.",
                "Sci-Fi & Fantasy, Mystery, Drama",
                84,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/glKDfE6btIRcVB5zrjspRIs4r52.jpg"
            )
        )

        tvShows.add(
            TvShowEntity(
                "s10",
                "Adventure Time (2010)",
                "Hook up with Finn and Jake as they travel the Land of Ooo searching for adventure. But remember, adventure isn’t always easy. Sometimes you’ve got to battle fire gnomes that torture old ladies, save a smelly hot dog princess from the Ice King, and thaw out a bunch of frozen businessmen. What the cabbage?!",
                "Animation, Comedy, Sci-Fi & Fantasy",
                83,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qk3eQ8jW4opJ48gFWYUXWaMT4l.jpg"
            )
        )
        return tvShows
    }

    fun generateRemoteDummyMovies(): List<MovieResponse> {

        val movies = ArrayList<MovieResponse>()

        movies.add(
            MovieResponse(
                "m01",
                "Army of the Dead (2021)",
                "Following a zombie outbreak in Las Vegas, a group of mercenaries take the ultimate gamble: venturing into the quarantine zone to pull off the greatest heist ever attempted.",
                "Action, Horror, Thriller",
                67,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/x3taBaWfRzw1NIKhEPpKPwKBAOC.jpg"))
        movies.add(
            MovieResponse(
                "m02",
                "F9 (2021)",
                "Dominic Toretto is leading a quiet life off the grid with Letty and his son, little Brian, but they know that danger always lurks just over their peaceful horizon. This time, that threat will force Dom to confront the sins of his past if he’s going to save those he loves most. His crew joins together to stop a world-shattering plot led by the most skilled assassin and high-performance driver they’ve ever encountered: a man who also happens to be Dom’s forsaken brother, Jakob.",
                "Action, Thriller, Crime",
                80,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qIicLxr7B7gIt5hxZxo423BJLlK.jpg"))
        movies.add(
            MovieResponse(
                "m03",
                "Zack Snyder's Justice League (2021)",
                "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                "Action, Adventure, Fantasy, Science Fiction"  ,
                85,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg"))
        movies.add(
            MovieResponse(
                "m04",
                "Eternals (2021)",
                "The Eternals are a team of ancient aliens who have been living on Earth in secret for thousands of years. When an unexpected tragedy forces them out of the shadows, they are forced to reunite against mankind’s most ancient enemy, the Deviants.",
                "Action, Adventure, Fantasy",
                0,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6AdXwFTRTAzggD2QUTt5B7JFGKL.jpg"))
        movies.add(
            MovieResponse(
                "m05",
                "Mortal Kombat (2021)",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "Action, Fantasy, Adventure",
                76,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg"))
        movies.add(
            MovieResponse(
                "m06",
                "Raya and the Last Dragon (2021)",
                "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
                "Animation, Adventure, Fantasy, Family, Action",
                82,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg"))
        movies.add(
            MovieResponse(
                "m07",
                "Godzilla vs. Kong (2021)",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "Action, Science Fiction",
                81,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg"))
        movies.add(
            MovieResponse(
                "m08",
                "Cruella (2021)",
                "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
                "Comedy, Crime",
                77,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wToO8opxkGwKgSfJ1JK8tGvkG6U.jpg"))
        movies.add(
            MovieResponse(
                "m09",
                "Demon Slayer -Kimetsu no Yaiba- The Movie: Mugen Train (2020)",
                "Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!",
                "Animation, Action, Adventure, Fantasy, Drama",
                84,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/h8Rb9gBr48ODIwYUttZNYeMWeUU.jpg"))
        movies.add(
            MovieResponse(
                "m10",
                "The Mitchells vs. The Machines (2021)",
                "A quirky, dysfunctional family's road trip is upended when they find themselves in the middle of the robot apocalypse and suddenly become humanity's unlikeliest last hope.",
                "Animation, Adventure, Comedy, Family, Science Fiction",
                80,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/mI2Di7HmskQQ34kz0iau6J1vr70.jpg"))

        return movies
    }

    fun generateRemoteDummyTvShows(): List<TvShowResponse> {

        val tvShows = ArrayList<TvShowResponse>()

        tvShows.add(TvShowResponse(
            "s01",
            "The Falcon and the Winter Soldier (2021)",
            "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
            "Sci-Fi & Fantasy, Action & Adventure, Drama, War & Politics",
            79,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6kbAMLteGO8yyewYau6bJ683sw7.jpg"
        ))
        tvShows.add(TvShowResponse(
            "s02",
            "The Flash (2014)",
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            "Drama, Sci-Fi & Fantasy",
            77,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg"
        ))
        tvShows.add(TvShowResponse(
            "s03",
            "Grey's Anatomy",
            "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
            "Drama",
            82,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg"
        ))
        tvShows.add(TvShowResponse(
            "s04",
            "Invincible (2021)",
            "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
            "Animation, Action & Adventure, Drama, Sci-Fi & Fantasy",
            89,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg"
        ))
        tvShows.add(TvShowResponse(
            "s05",
            "The Bad Batch (2021)",
            "Follow the elite and experimental Clones of the Bad Batch as they find their way in a rapidly changing galaxy in the aftermath of the Clone Wars.",
            "Sci-Fi & Fantasy, Action & Adventure, Animation",
            89,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/uggL9jiDi0CCfoPIfU2X6BnMaFy.jpg"
        ))
        tvShows.add(TvShowResponse(
            "s06",
            "Jupiter's Legacy (2021)",
            "As the world's first generation of superheroes (who received their powers in the 1930s) become the revered elder guard in the present, their superpowered children struggle to live up to the legendary feats of their parents.",
            "Sci-Fi & Fantasy, Action & Adventure, Drama, Mystery",
            74,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9yxep7oJdkj3Pla9TD9gKflRApY.jpg"
        ))
        tvShows.add(TvShowResponse(
            "s07",
            "Riverdale (2017)",
            "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
            "Mystery, Drama, Crime",
            86,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg"
        ))
        tvShows.add(TvShowResponse(
            "s08",
            "Game of Thrones (2011)",
            "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
            "Sci-Fi & Fantasy, Drama, Action & Adventure",
            84,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg"
        ))
        tvShows.add(TvShowResponse(
            "s09",
            "WandaVision (2021)",
            "Wanda Maximoff and Vision—two super-powered beings living idealized suburban lives—begin to suspect that everything is not as it seems.",
            "Sci-Fi & Fantasy, Mystery, Drama",
            84,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/glKDfE6btIRcVB5zrjspRIs4r52.jpg"
        ))
        tvShows.add(TvShowResponse(
            "s10",
            "Adventure Time (2010)",
            "Hook up with Finn and Jake as they travel the Land of Ooo searching for adventure. But remember, adventure isn’t always easy. Sometimes you’ve got to battle fire gnomes that torture old ladies, save a smelly hot dog princess from the Ice King, and thaw out a bunch of frozen businessmen. What the cabbage?!",
            "Animation, Comedy, Sci-Fi & Fantasy",
            83,
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qk3eQ8jW4opJ48gFWYUXWaMT4l.jpg"
        ))

        return tvShows
    }
}