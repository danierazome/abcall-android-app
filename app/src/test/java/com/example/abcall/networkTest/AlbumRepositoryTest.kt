package com.example.abcall.networkTest

//@RunWith(AndroidJUnit4::class)
//@SmallTest
//class AlbumRepositoryTest {
//
//    private lateinit var db: AppDatabase
//
//    @Before
//    fun createDb() {
//        val context = ApplicationProvider.getApplicationContext<Context>()
//        db = Room.inMemoryDatabaseBuilder(
//            context, AppDatabase::class.java).build()
//    }
//
//    @After
//    @Throws(IOException::class)
//    fun closeDb() {
//        db.close()
//    }
//
//    @Test
//    fun networkAlbumRepository_getAlbums() =
//        runTest {
//            val repository = AlbumRepository(
//                albumRemoteDataSource = AlbumRemoteDataSource(
//                    albumApiService = FakeAlbumApiService()
//                ),
//                albumDao = db.albumDao(),
//                trackDao = db.trackDao(),
//                commentDao = db.commentDao()
//            )
//            assertEquals(AlbumFakeData.albumsData, repository.getAlbums())
//        }
//}