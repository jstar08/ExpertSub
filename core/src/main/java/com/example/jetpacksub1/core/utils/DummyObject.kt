package com.example.jetpacksub1.core.utils

import com.example.jetpacksub1.core.data.local.entity.FilmEntity
import com.example.jetpacksub1.core.data.local.entity.TvEntity
import com.example.jetpacksub1.core.data.remote.response.*

object DummyObject {

    fun generateMovies(): List<FilmEntity> {

        val film = ArrayList<FilmEntity>()

        film.add(
            FilmEntity(
                1,
                "A Star Is Born",
                7.5,
                "Seasoned musician Jackson Maine discovers and falls in love with struggling artist Ally. " +
                        "She has just about given up on her dream to make it big as a singer until Jack coaxes her into the spotlight. " +
                        "But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "10/05/2018(US)",
                "Drama | Romance | Music",
                136,
                "https://upload.wikimedia.org/wikipedia/id/9/90/AStarIsBornBradleyCooperPoster2018.jpg"
            )
        )

        film.add(
            FilmEntity(
                2,
                "Alita : Battle Angle",
                7.2,
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "02/14/2019 (US)",
                "Action | Science Fiction | Adventure",
                122,
                "https://m.media-amazon.com/images/M/MV5BMTQzYWYwYjctY2JhZS00NTYzLTllM2UtZWY5ZTk0NmYwYzIyXkEyXkFqcGdeQXVyMzgxODM4NjM@._V1_.jpg"
            )
        )

        film.add(
            FilmEntity(
                3,
                "Aquaman",
                6.9,
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "12/21/2018(US)",
                "Action | Adventure | Fantasy",
                143,
                "https://m.media-amazon.com/images/M/MV5BOTk5ODg0OTU5M15BMl5BanBnXkFtZTgwMDQ3MDY3NjM@._V1_.jpg"
            )
        )

        film.add(
            FilmEntity(
                4,
                "Bohemian Rhapsody",
                8.0,
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "11/02/2018(US)",
                "Music | Drama | History",
                135,
                "https://m.media-amazon.com/images/M/MV5BMTA2NDc3Njg5NDVeQTJeQWpwZ15BbWU4MDc1NDcxNTUz._V1_.jpg"
            )
        )

        film.add(
            FilmEntity(
                5,
                "Cold Pursuit",
                5.7,
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "02/08/2019(US)",
                "Action | Crime | Thriler",
                119,
                "https://1.bp.blogspot.com/-uY07y8E8SPs/XGj9upc7xHI/AAAAAAAAZ9U/yAB61NoVejEXJo2bxc0zkMpmXgI9La0pACLcBGAs/s1600/cold_pursuit_ver3.jpg"
            )
        )

        return film
    }

    fun generateTv(): List<TvEntity> {

        val tv = ArrayList<TvEntity>()

        tv.add(
            TvEntity(
                1,
                "Arrow",
                6.6,
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "10/10/2012(US)",
                "Crime | Mystery | Action",
                42,
                "https://m.media-amazon.com/images/M/MV5BMTI0NTMwMDgtYTMzZC00YmJhLTg4NzMtMTc1NjI4MWY4NmQ4XkEyXkFqcGdeQXVyNTY3MTYzOTA@._V1_.jpg"
            )
        )

        tv.add(
            TvEntity(
                2,
                "Doom Patrol",
                7.6,
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "02/15/2019(US)",
                "Comedy | Drama | Scifi & Fantasy",
                49,
                "https://m.media-amazon.com/images/M/MV5BM2I1OWZiNTUtZGNmOS00NGNiLTlhZmItOTU3MGRlMWFkYWU3XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg"
            )
        )

        tv.add(
            TvEntity(
                3,
                "Dragon Ball",
                8.1,
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "04/26/1989",
                "Animation | Action | Fantasy",
                25,
                "https://upload.wikimedia.org/wikipedia/id/7/74/Dragon_Ball_Super_Key_visual.jpg"
            )
        )

        tv.add(
            TvEntity(
                4,
                "Fairy Tail",
                7.8,
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "10/12/2009",
                "Animation | Action | Comedy",
                25,
                "https://static.wikia.nocookie.net/fairytail/images/c/c5/FairyTail_rpg.png/revision/latest/top-crop/width/360/height/450?cb=20200508150847"
            )
        )

        tv.add(
            TvEntity(
                5,
                "Family Guy",
                7.0,
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "01/31/1999(US)",
                "Animation | Comedy",
                22,
                "https://m.media-amazon.com/images/M/MV5BODEwZjEzMjAtNjQxMy00Yjc4LWFlMDAtYjhjZTAxNDU3OTg3XkEyXkFqcGdeQXVyOTM2NTM4MjA@._V1_.jpg"
            )
        )

        return tv
    }

    fun generateRemoteMovies(): List<FilmList> {

        val film = ArrayList<FilmList>()

        film.add(
            FilmList(
                1,
                "A Star Is Born",
                7.5,
                "Seasoned musician Jackson Maine discovers and falls in love with struggling artist Ally. " +
                        "She has just about given up on her dream to make it big as a singer until Jack coaxes her into the spotlight. " +
                        "But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "10/05/2018(US)",
                "https://upload.wikimedia.org/wikipedia/id/9/90/AStarIsBornBradleyCooperPoster2018.jpg"
            )
        )

        film.add(
            FilmList(
                2,
                "Alita : Battle Angle",
                7.2,
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "02/14/2019 (US)",
                "https://m.media-amazon.com/images/M/MV5BMTQzYWYwYjctY2JhZS00NTYzLTllM2UtZWY5ZTk0NmYwYzIyXkEyXkFqcGdeQXVyMzgxODM4NjM@._V1_.jpg"
            )
        )

        film.add(
            FilmList(
                3,
                "Aquaman",
                6.9,
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "12/21/2018(US)",
                "https://m.media-amazon.com/images/M/MV5BOTk5ODg0OTU5M15BMl5BanBnXkFtZTgwMDQ3MDY3NjM@._V1_.jpg"
            )
        )

        film.add(
            FilmList(
                4,
                "Bohemian Rhapsody",
                8.0,
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "11/02/2018(US)",
                "https://m.media-amazon.com/images/M/MV5BMTA2NDc3Njg5NDVeQTJeQWpwZ15BbWU4MDc1NDcxNTUz._V1_.jpg"
            )
        )

        film.add(
            FilmList(
                5,
                "Cold Pursuit",
                5.7,
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "02/08/2019(US)",
                "https://1.bp.blogspot.com/-uY07y8E8SPs/XGj9upc7xHI/AAAAAAAAZ9U/yAB61NoVejEXJo2bxc0zkMpmXgI9La0pACLcBGAs/s1600/cold_pursuit_ver3.jpg"
            )
        )

        return film
    }

    fun generateRemoteTv(): List<TvList> {

        val tv = ArrayList<TvList>()

        tv.add(
            TvList(
                1,
                "Arrow",
                6.6,
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "10/10/2012(US)",
                "https://m.media-amazon.com/images/M/MV5BMTI0NTMwMDgtYTMzZC00YmJhLTg4NzMtMTc1NjI4MWY4NmQ4XkEyXkFqcGdeQXVyNTY3MTYzOTA@._V1_.jpg"
            )
        )

        tv.add(
            TvList(
                2,
                "Doom Patrol",
                7.6,
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "02/15/2019(US)",
                "https://m.media-amazon.com/images/M/MV5BM2I1OWZiNTUtZGNmOS00NGNiLTlhZmItOTU3MGRlMWFkYWU3XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_.jpg"
            )
        )

        tv.add(
            TvList(
                3,
                "Dragon Ball",
                8.1,
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "04/26/1989",
                "https://upload.wikimedia.org/wikipedia/id/7/74/Dragon_Ball_Super_Key_visual.jpg"
            )
        )

        tv.add(
            TvList(
                4,
                "Fairy Tail",
                7.8,
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "10/12/2009",
                "https://static.wikia.nocookie.net/fairytail/images/c/c5/FairyTail_rpg.png/revision/latest/top-crop/width/360/height/450?cb=20200508150847"
            )
        )

        tv.add(
            TvList(
                5,
                "Family Guy",
                7.0,
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "01/31/1999(US)",
                "https://m.media-amazon.com/images/M/MV5BODEwZjEzMjAtNjQxMy00Yjc4LWFlMDAtYjhjZTAxNDU3OTg3XkEyXkFqcGdeQXVyOTM2NTM4MjA@._V1_.jpg"
            )
        )

        return tv
    }

    fun getFakeDummyMovieDetail(): FilmDetail {
        val genre = ArrayList<Genre>()
        genre.add(
            Genre(
                1,
                "Action"
            )
        )
        genre.add(
            Genre(
                2,
                "Science Fiction"
            )
        )
        genre.add(
            Genre(
                3,
                "Adventure"
            )
        )
        return FilmDetail(
            2,
            "Alita : Battle Angle",
            7.2,
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
            "02/14/2019 (US)",
            "https://m.media-amazon.com/images/M/MV5BMTQzYWYwYjctY2JhZS00NTYzLTllM2UtZWY5ZTk0NmYwYzIyXkEyXkFqcGdeQXVyMzgxODM4NjM@._V1_.jpg",
            genre,
            122,

            )
    }

    fun getFakeDummyTvshowDetail(): TvDetail {
        val genre = ArrayList<Genre>()

        genre.add(
            Genre(
                4,
                "Animation"
            )
        )
        genre.add(
            Genre(
                5,
                "Comedy"
            )
        )

        return TvDetail(
            5,
            "Family Guy",
            7.0,
            "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
            "01/31/1999(US)",
            "https://m.media-amazon.com/images/M/MV5BODEwZjEzMjAtNjQxMy00Yjc4LWFlMDAtYjhjZTAxNDU3OTg3XkEyXkFqcGdeQXVyOTM2NTM4MjA@._V1_.jpg",
            genre,
            22,

            )
    }


}
