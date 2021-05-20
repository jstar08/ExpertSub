package com.example.jetpacksub1.core.data

import com.example.jetpacksub1.core.data.local.LocalDataSource
import com.example.jetpacksub1.core.data.local.entity.FilmEntity
import com.example.jetpacksub1.core.data.local.entity.TvEntity
import com.example.jetpacksub1.core.data.remote.ApiResponse
import com.example.jetpacksub1.core.data.remote.RemoteDataSource
import com.example.jetpacksub1.core.data.remote.response.FilmDetail
import com.example.jetpacksub1.core.data.remote.response.FilmList
import com.example.jetpacksub1.core.data.remote.response.TvDetail
import com.example.jetpacksub1.core.data.remote.response.TvList
import com.example.jetpacksub1.core.domain.model.FilmModel
import com.example.jetpacksub1.core.domain.model.TvModel
import com.example.jetpacksub1.core.domain.repository.IMovieRepository
import com.example.jetpacksub1.core.utils.AppExecutors
import com.example.jetpacksub1.core.utils.DataMapper
import com.example.jetpacksub1.core.vo.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IMovieRepository {

    override fun getAllFilm(): Flow<Resource<List<FilmModel>>> {
        return object :
            com.example.jetpacksub1.core.data.NetworkBoundResource<List<FilmModel>, List<FilmList>>() {
            override fun loadFromDB(): Flow<List<FilmModel>> {
                return localDataSource.getAllFilm().map {
                    DataMapper.mapFilmEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<FilmModel>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<FilmList>>> =
                remoteDataSource.getListFilm()

            override suspend fun saveCallResult(data: List<FilmList>) {
                val filmList = ArrayList<FilmEntity>()
                for (response in data) {
                    val movie = FilmEntity(
                        id = response.id ?: 0,
                        title = response.title ?: "",
                        overview = response.overview ?: "",
                        genre = "",
                        duration = 0,
                        releaseDate = response.releaseDate ?: "",
                        score = response.score ?: 0.0,
                        moviePoster = response.moviePoster ?: "",
                    )
                    filmList.add(movie)
                }
                localDataSource.insertFilm(filmList)
            }
        }.asFlow()
    }

    override fun getAllTv(): Flow<Resource<List<TvModel>>> {

        return object :
            com.example.jetpacksub1.core.data.NetworkBoundResource<List<TvModel>, List<TvList>>() {
            override fun loadFromDB(): Flow<List<TvModel>> {
                return localDataSource.getAllTv().map {
                    DataMapper.mapTvEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<TvModel>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<TvList>>> =
                remoteDataSource.getListTv()

            override suspend fun saveCallResult(data: List<TvList>) {
                val tvList = ArrayList<TvEntity>()
                for (response in data) {
                    val tv = TvEntity(
                        id = response.id ?: 0,
                        title = response.title ?: "",
                        overview = response.overview ?: "",
                        genre = "",
                        duration = 0,
                        releaseDate = response.releaseDate ?: "",
                        score = response.score ?: 0.0,
                        seriesPoster = response.tvPoster ?: "",
                    )
                    tvList.add(tv)
                }
                localDataSource.insertTv(tvList)
            }
        }.asFlow()
    }

    override fun getFilmWithId(filmId: Int): Flow<Resource<FilmModel>> {

        return object :
            com.example.jetpacksub1.core.data.NetworkBoundResource<FilmModel, FilmDetail>() {
            override fun loadFromDB(): Flow<FilmModel> {
                return localDataSource.getDetailFilm(filmId).map {
                    DataMapper.mapDetailFilm(it)
                }
            }

            override fun shouldFetch(data: FilmModel?): Boolean =
                data?.genre == "" || data?.duration == 0

            override suspend fun createCall(): Flow<ApiResponse<FilmDetail>> =
                remoteDataSource.getFilmDetail(filmId)

            override suspend fun saveCallResult(data: FilmDetail) {
                val filmList = ArrayList<FilmEntity>()
                var genre = ""
                for (i in 0 until data.genres.size) {
                    if (i < 2) genre += data.genres[i].genreName
                    if (i < 1) genre += " | "
                }
                val film = FilmEntity(
                    id = data.id ?: 0,
                    title = data.title ?: "",
                    overview = data.overview ?: "",
                    genre = genre,
                    duration = data.duration ?: 0,
                    releaseDate = data.releaseDate ?: "",
                    score = data.score ?: 0.0,
                    moviePoster = data.moviePoster ?: ""
                )
                filmList.add(film)

                localDataSource.insertFilm(filmList)
            }
        }.asFlow()
    }

    override fun getTvWithId(tvId: Int): Flow<Resource<TvModel>> {

        return object :
            com.example.jetpacksub1.core.data.NetworkBoundResource<TvModel, TvDetail>() {
            override fun loadFromDB(): Flow<TvModel> {
                return localDataSource.getDetailTv(tvId).map {
                    DataMapper.mapDetailTv(it)
                }
            }

            override fun shouldFetch(data: TvModel?): Boolean =
                data?.genre == "" || data?.duration == 0

            override suspend fun createCall(): Flow<ApiResponse<TvDetail>> =
                remoteDataSource.getTvDetail(tvId)

            override suspend fun saveCallResult(data: TvDetail) {
                val tvList = ArrayList<TvEntity>()
                var genre = ""
                for (i in 0 until data.genres.size) {
                    if (i < 2) genre += data.genres[i].genreName
                    if (i < 1) genre += " | "
                }
                val tv = TvEntity(
                    id = data.id ?: 0,
                    title = data.title ?: "",
                    overview = data.overview ?: "",
                    genre = genre,
                    duration = data.duration ?: 0,
                    releaseDate = data.releaseDate ?: "",
                    score = data.score ?: 0.0,
                    seriesPoster = data.tvPoster ?: "",
                )
                tvList.add(tv)
                localDataSource.insertTv(tvList)
            }

        }.asFlow()
    }

    override fun setFavoriteFilm(film: FilmModel, state: Boolean) {
        val filmEntity = DataMapper.mapDomainToFilmEntities(film)
        appExecutors.diskIO().execute { localDataSource.setFavoriteFilm(filmEntity, state) }
    }

    override fun setFavoriteTv(tv: TvModel, state: Boolean) {
        val tvEntity = DataMapper.mapDomainToTvEntities(tv)
        appExecutors.diskIO().execute { localDataSource.setFavoriteTv(tvEntity, state) }
    }

    override fun getFavoriteFilm(): Flow<List<FilmModel>> {
        return localDataSource.getFavoriteFilm().map {
            DataMapper.mapFilmEntitiesToDomain(it)
        }
    }

    override fun getFavoriteTv(): Flow<List<TvModel>> {
        return localDataSource.getFavoriteTv().map {
            DataMapper.mapTvEntitiesToDomain(it)
        }
    }

    companion object {
        @Volatile
        private var instance: IMovieRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): IMovieRepository =
            com.example.jetpacksub1.core.data.MovieRepository.Companion.instance ?: synchronized(
                this
            ) {
                com.example.jetpacksub1.core.data.MovieRepository.Companion.instance
                    ?: com.example.jetpacksub1.core.data.MovieRepository(
                        remoteData,
                        localData,
                        appExecutors
                    ).apply {
                        com.example.jetpacksub1.core.data.MovieRepository.Companion.instance = this
                    }
            }
    }
}